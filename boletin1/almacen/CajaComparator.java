package colecciones.com.colecciones.boletin1.almacen;

import java.util.Comparator;

public class CajaComparator implements Comparator<Caja> {

	@Override
	public int compare(Caja o1, Caja o2) {
		int resultado=0;
		if(o1!=null && o2!=null) {
				resultado = o1.getClientes()-o2.getClientes();
		} else if (o1==null) {
			resultado=-1;
		} else if (o2==null) {
			resultado=1;
		}
		return resultado;
	}
}