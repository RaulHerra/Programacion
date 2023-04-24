package mockExam;

import java.time.LocalDate;

public class Main {

	public static void main(String[] args) {
		Historial h = new Historial();
		Combinacion b;
		try {
			 b = new Boleto(12,21,34,45,32,4,5);
		} catch (CombinacionException e) {
			e.printStackTrace();
			
		}
		
		try {
			//Este dia cae en martes
			h.addSorteo(2023, 5, 9, (Combinacion)new Boleto(5,22,35,41,32,4,5));
			//Este dia cae en jueves
			h.addSorteo(2023, 5, 26, (Combinacion)new Boleto(5,22,35,41,32,4,5));
		} catch (HistorialException | CombinacionException e) {
			e.printStackTrace();
		}
		
		try {
			//Este dia cae en jueves
			h.addSorteo(2023, 5, 25, (Combinacion)new Boleto(5,22,35,41,32,4,5));
		} catch (HistorialException | CombinacionException e1) {
			e1.printStackTrace();
		}
		
		try {
			h.actualizarSorteo(2023, 5, 9, (Combinacion)new Boleto(5,22,35,41,32,4,5));
		} catch (HistorialException | CombinacionException e) {
			e.printStackTrace();
		}
		
		System.out.println(h.listarSorteosDesdeFecha(LocalDate.of(2023, 5, 12)));
		System.out.println(h.mostrarHistorico());
		
		//Da error
		try {
			System.out.println(h.comprobarAciertos(LocalDate.of(2023, 5, 12)));
		} catch (HistorialException e) {
			e.printStackTrace();
		} 
		//No da error
		try {
			System.out.println(h.comprobarAciertos(LocalDate.of(2023, 5, 9)));
		} catch (HistorialException e) {
			e.printStackTrace();
		}
		
		//Borra el sorteo
		try {
			h.borrarSorteo();
		} catch (HistorialException e) {
			e.printStackTrace();
		}
	}
}
