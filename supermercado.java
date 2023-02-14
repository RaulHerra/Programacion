package ejercicios;
import java.util.Scanner;

public class supermercado {
	
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		String seccion="", observacion="", observacionesHogar="", observacionesElec="", 
				observacionesAlimentacion="";
		int calificacion=0, calificacionHogar=0, calificacionElec=0, calificacionAlimentacion=0,
				contadorHogar=0, contadorElec=0, contadorAlimentacion=0;
		
		System.out.println("Bienvenido a El Corte Jacarandés:");
		//Se piden los datos y se validan
		do{
			System.out.print("¿Qué sección quiere valorar (Hogar, Electronica, Alimentacion)?: ");
			seccion=sc.nextLine().toUpperCase(); //Se convierte a mayusculas
		}while(!(seccion.equals("HOGAR")) && !(seccion.equals("ELECTRONICA")) && !(seccion.equals("ALIMENTACION")));
		
		
		//Este bloque de código no se ejecutará si seccion es nulo o blanco
		while(seccion!="" || !(seccion.isBlank())){ 
			do {
				System.out.print("Como calificaria la atención recibida (1-5): ");
				calificacion=Integer.valueOf(sc.nextLine());
			}while(calificacion<1 || calificacion>5);
			
			//Esto no es validado ya que el comentario puede cambiar según el usuario
			System.out.print("Observaciones (Campo opcional): "); observacion=sc.nextLine();
			
			switch(seccion) {
				case "HOGAR":
					calificacionHogar+=calificacion;
					contadorHogar++;
					observacionesHogar+= (observacion.equals("")) ? observacion : observacion+"\n";
					break;
				case "ELECTRONICA":
					calificacionElec+=calificacion;
					contadorElec++;
					observacionesElec+= (observacion.equals("")) ? observacion : observacion+"\n";
					break;
				case "ALIMENTACION":
					calificacionAlimentacion+=calificacion;
					contadorAlimentacion++;
					observacionesAlimentacion+= (observacion.equals("")) ? observacion : observacion+"\n";
					break;
			}
			System.out.println("-----------------------------");
			do{
				System.out.print("¿Qué sección quiere valorar (Hogar, Electronica, Alimentacion)?: ");
				seccion=sc.nextLine().toUpperCase(); //Se convierte a mayusculas
			}while("HOGAR;ELECTRONICA;ALIMENTACION".indexOf(seccion)==-1);
		}
		
		/*En caso de que las sumas de los contadores de las valoraciones sean 0, no se podría
		 * ejecutar la sección del else ya que daría el error de dividir entre 0*/
		
		if ((contadorHogar+contadorElec+contadorAlimentacion)==0) {
			System.out.println("No se han recogido opiniones");
		}else {
			System.out.println("La puntuación media del supermercado es "
			+(double)(calificacionHogar+calificacionElec+calificacionAlimentacion)/(contadorHogar+contadorElec+contadorAlimentacion)
			+" y han dado su opinion "+(contadorHogar+contadorElec+contadorAlimentacion)+" clientes\n");
			
			if(contadorHogar==0) {
				System.out.println("No se han recogido valoraciones de la sección Hogar");
			}else {
				System.out.println("La puntuación media de la seccion Hogar es: "+(double)calificacionHogar/contadorHogar
						+" y las observaciones recogidas:\n"+observacionesHogar);
			}
			if(contadorElec==0) {
				System.out.println("No se han recogido valoraciones de la sección Electronica");
			}else {
				System.out.println("La puntuación media de la seccion Electronica es: "+(double)calificacionElec/contadorElec
						+" y las observaciones recogidas:\n"+observacionesElec);
			}
			if(contadorAlimentacion==0) {
				System.out.println("No se han recogido valoraciones de la sección Alimentacion");
			}else {
				System.out.println("La puntuación media de la seccion Alimentación es: "+(double)calificacionAlimentacion/contadorAlimentacion
						+" y las observaciones recogidas:\n"+observacionesAlimentacion);
			}
		}
	}
}
