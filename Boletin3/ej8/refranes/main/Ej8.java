package Boletin3.ej8.refranes.main;

import java.util.Scanner;
import Boletin3.ej8.refranes.model.Refranes;
import Boletin3.ej8.refranes.model.Refran;

public class Ej8 {
    
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
        Refranes refranes = new Refranes();
        String menu="Menú:\n1.Guardan un refrán\n2.Buscar un refrán que contenga una palabra\n3.Listar refranes\n4.Salir";
        
        int opcion = 0;
        do {
            System.out.println(menu);
            System.out.print("Elige una opción: ");
            do {
    			try {
    	            opcion = Integer.valueOf(sc.nextLine());
    	            }catch(Exception e) {
    				System.out.print("Debe ser un valor numerico superior a 0: ");
    			}
    		}while(opcion<=0);

            switch(opcion) {
                case 1:
                    System.out.print("Introduce el refrán: ");
                    String refran = sc.nextLine();
                    if(refranes.agregarRefran(refran)) {
                        System.out.println("Refrán guardado correctamente.");
                    } else {
                        System.out.println("Error: el refrán ya estaba guardado o se alcanzó el máximo posible.");
                    }
                    break;
                case 2:
                    System.out.print("Introduce la palabra a buscar: ");
                    String palabra = sc.nextLine();
                    String refranEncontrado=null;
                    try {
                    	refranEncontrado = refranes.buscarRefran(palabra).toString();
                    }catch(Exception e) {
                    	System.out.println(e.getMessage());
                    }
                    if(refranEncontrado!=null) {
                    	System.out.println("Refrán encontrado: " + refranEncontrado);
                    }
                    break;
                case 3:
                    System.out.println("Listado de refranes:");
                    Refran[] listaRefranes = refranes.listarRefranes();
                    if(listaRefranes.length == 0) {
                        System.out.println("No hay refranes guardados.");
                    } else {
                        for(Refran r : listaRefranes) {
                            System.out.println(r.toString());
                        }
                    }
                    break;
                case 4:
                    System.out.println("Cerrando programa...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while(opcion != 4);
    }
}