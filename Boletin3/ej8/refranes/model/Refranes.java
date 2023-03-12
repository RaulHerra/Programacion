package Boletin3.ej8.refranes.model;
import java.util.Arrays;
import java.lang.Exception;

public class Refranes {
    private Refran[] refranes;
    private int numRefranes;
    
    public Refranes() {
        refranes = new Refran[50];
        numRefranes = 0;
    }
    
    public String buscarRefran(String palabra) throws Exception{
    	String refran = "no encontrado";
    	for (int i = 0; i < this.refranes.length; i++) {
            if (refranes[i]!=null && refranes[i].contienePalabra(palabra)) {
                refran = refranes[i].toString();
            }
        }
    	if(refran.equals("no encontrado")) {
    		throw new Exception("No se ha encontrado ningún refrán que contenga la palabra " + palabra);
    	}
    	return refran;
    }
    
    public Refran[] listarRefranes() {
        Refran[] copia = Arrays.copyOf(refranes, numRefranes);
        Arrays.sort(copia, (r1, r2) -> r1.getFrase().compareTo(r2.getFrase()));
        
        return copia;
    }
    
    public boolean agregarRefran(String refran) {
        boolean agregado=false;
        int posAgregado=0;
    	if(this.cantidadRefranes() < 50) {
            for(int i=0;i<this.refranes.length;i++) {
            	if(refranes[i]==null) {
            		this.refranes[i]=new Refran(refran);
            		agregado=true;
            		posAgregado=i;
            		this.numRefranes++;
            		break;
            	}
            }
            //Si lo ha agregado en un hueco que era null, tendremos que comprobar que no se repite
            if(agregado) {
            	for(int i=0;i<posAgregado;i++) {
                	if(refranes[i].toString().equals(refran)) {
                		this.refranes[posAgregado]=null;
                		agregado=false;
                		this.numRefranes--;
                	}
                }
            }
        }
    	return agregado;
    }
    
    public int cantidadRefranes() {
    	return this.numRefranes;
    }
}