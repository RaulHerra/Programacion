package com.mockExam.main;

import java.util.Arrays;

import com.mockExam.model.*;

public class PruebasJacaIT {

	public static void main(String[] args) {
		Usuario manuel = new Usuario("Manolito23","1234");
		Usuario manolo = new Usuario("Manolito23","7654");
		/*Ambos usuarios se pueden crear por separado 
		sin problemas, que pasa si los añadimos a un MemoryStorage?*/
		
		MemoryStorage principal = new MemoryStorage();
		principal.addUsuario("Manolito23","1234");
		principal.addUsuario(manolo);
		
		//Podemos ver que solo hay un usuario en el array
		System.out.println(principal.getNumUsuariosActuales()); //Debe devolver 1
		
		
		//Un usuario puede cambiar su contraseña?
		System.out.println(manuel.checkPass("1234")); //debe devolver true
		System.out.println(manuel.setPass("1234","2345")); //debe devolver true
		System.out.println(manuel.checkPass("1234")); //debe devolver false
		
		//Pepe va a crear un tweet, un post y una recomendación para principal
		
		//El usuario para el tweet no existe
		try {
			principal.addPublicacion("Que buen día hace para irse a tomar por ", "Manoli");
		} catch (MemoryStorageException e) {
			e.printStackTrace();
		}
		//Ahora si, ponemos el usuario correcto
		try {
			principal.addPublicacion("Que buen día hace para irse a tomar por ", "Manolito23");
		} catch (MemoryStorageException e) {
			e.printStackTrace();
		}
		
		//No debe dar problemas el post
		try {
			principal.addPublicacion("Recomiendo peliculas del lejano oeste", "Manolito23", "Peliculas");
		} catch (MemoryStorageException e) {
			e.printStackTrace();
		}
		
		//Debe de dar problemas ya que el texto es muy corto para una recomendacion
		try {
			principal.addPublicacion("Bar: el paco. No se come mal, "
					+ "y el ambiente es curioso", "Manolito23", 4);
		} catch (MemoryStorageException e) {
			e.printStackTrace();
		}

		//Manuel se ha dado cuenta del error y va a crear el post de nuevo
		try {
			principal.addPublicacion("\"Bar: el paco\" ofrece música en vivo, "
					+ "bebidas y bocadillos deliciosos en un ambiente auténtico y "
					+ "acogedor. ¡Una experiencia única! ", "Manolito23", 4);
		} catch (MemoryStorageException e) {
			e.printStackTrace();
		}
		
		
		//Ahora queremos ver mostrar todos los posts
		System.out.println(principal.mostrarPosts());
		System.out.println("\n\n\n\n");
		//Ahora queremos ver mostrar todos los Tweets
		System.out.println(principal.mostrarTweets());
		System.out.println("\n\n\n\n");
		
		principal.getPublicaciones()[0].valorar("REGULAR");
		principal.getPublicaciones()[1].valorar("SUPERBUENA");
		principal.getPublicaciones()[2].valorar("BUENA");
		
		//Vamos a ordenar la lista de publicaciones
		Arrays.sort(principal.getPublicaciones(), new FechaPublicacionComparator());
		System.out.println(principal.mostrarListaPublicaciones());
		
	}
}
