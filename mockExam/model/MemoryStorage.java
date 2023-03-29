package com.mockExam.model;

import java.util.Arrays;

public class MemoryStorage {

	private static final int NUM_MAXIMO_USUARIOS=15;
	private static final int NUM_MAXIMO_PUBLICACIONES=50;
	private int numUsuariosActuales;
	private int numPublicacionesActuales;
	private Usuario[] usuarios = new Usuario[NUM_MAXIMO_USUARIOS];
	private Publicacion[] publicaciones = new Publicacion[NUM_MAXIMO_PUBLICACIONES];
	
	public MemoryStorage() {
		super();
	}


	//Estos getters son para las pruebas aunque no vengan en el UML
	public int getNumUsuariosActuales() {
		return numUsuariosActuales;
	}
	public int getNumPublicacionesActuales() {
		return numPublicacionesActuales;
	}
	public Publicacion[] getPublicaciones() {
		return publicaciones;
	}



	//Método auxilar para recuperar si hay espacio libre en alguna de las listas
	private int espacioEnLista(Object[] lista) {
		int posicion=-1;
		
		//Comprueba que la lista no sea null
		if(lista != null) {
			for(short i=0;i<lista.length && posicion==-1;i++) {
				//Busca un hueco libre en la lista
				if(lista[i]==null) {
					posicion=i;
				}
			}
		}
		return posicion;
	}
	
	//Método para comprobar cual es la publicacion más antigua
	private int publicacionMasAntigua() {
		int posicionMasAntigua=0;
		for (short i=0;i<publicaciones.length;i++) {
			if(publicaciones[i]!=null && 
					publicaciones[i].isAnterior(publicaciones[posicionMasAntigua])) {
				posicionMasAntigua=i;
			}
		}
		return posicionMasAntigua;
	}
	
	private int posicionUsuario(String login) {
		int posicion=-1;
		for(short i=0;i<NUM_MAXIMO_USUARIOS && posicion==-1;i++) {
			if(usuarios[i]!=null && usuarios[i].getLogin().equals(login)) {
				posicion=i;
			}
		}
		return posicion;
	}
	
	public void addUsuario(String login, String pass) {
		if(posicionUsuario(login)==-1 && espacioEnLista(usuarios)!=-1) {
			usuarios[espacioEnLista(usuarios)] = new Usuario(login, pass);
			numUsuariosActuales++;
		}
	}
	
	/*Veo bien hacer la sobrecarga de este metodo porque es posible que el usuario ya haya
	 * sido creado con el constructor de Usuario
	 * */
	public void addUsuario(Usuario user) {
		if(posicionUsuario(user.getLogin())==-1 && espacioEnLista(usuarios)!=-1) {
			usuarios[espacioEnLista(usuarios)] = user;
			numUsuariosActuales++;
		}
	}
	
	//Añadir tweet
	public void addPublicacion(String texto, String login) throws MemoryStorageException {
		Publicacion twe;
		try{
			twe = new Tweet("", usuarios[posicionUsuario(login)]);
		}catch (Exception e) {
			throw new MemoryStorageException("El usuario no existe");
		}
		twe.setTexto(texto);
		if (!(twe.getTexto().isBlank()) && espacioEnLista(publicaciones)!=-1) {
			publicaciones[espacioEnLista(publicaciones)]=twe;

			numPublicacionesActuales += (numPublicacionesActuales<NUM_MAXIMO_PUBLICACIONES) ? 
					1 : 0;
		}else {
			if (!(twe.getTexto().isBlank())) {
				publicaciones[publicacionMasAntigua()]=twe;

				numPublicacionesActuales += (numPublicacionesActuales<NUM_MAXIMO_PUBLICACIONES) ? 
						1 : 0;
			}else {
				throw new MemoryStorageException("El Tweet no cumple con el texto necesario");	
			}
		}
		
	}
	
	//Añadir post
	public void addPublicacion(String texto, String login, String tema) throws MemoryStorageException {
		Publicacion pos = new Post("", usuarios[posicionUsuario(login)], tema);
		pos.setTexto(texto);
		if (!(pos.getTexto().isBlank()) && espacioEnLista(publicaciones)!=-1) {
			publicaciones[espacioEnLista(publicaciones)]=pos;

			numPublicacionesActuales += (numPublicacionesActuales<NUM_MAXIMO_PUBLICACIONES) ? 
					1 : 0;
		}else {
			if (!(pos.getTexto().isBlank())) {
				publicaciones[publicacionMasAntigua()]=pos;

				numPublicacionesActuales += (numPublicacionesActuales<NUM_MAXIMO_PUBLICACIONES) ? 
						1 : 0;
			}else {
				throw new MemoryStorageException("El Post no cumple con el texto necesario");	
			}
		}
	}
	
	//Añadir Recomendacion
	public void addPublicacion(String texto, String login, int estrellas) throws MemoryStorageException {
		Publicacion reco = new Recomendacion("", usuarios[posicionUsuario(login)], estrellas);
		reco.setTexto(texto);
		if (!(reco.getTexto().isBlank()) && espacioEnLista(publicaciones)!=-1) {
			publicaciones[espacioEnLista(publicaciones)]=reco;

			numPublicacionesActuales += (numPublicacionesActuales<NUM_MAXIMO_PUBLICACIONES) ? 
					1 : 0;
		}else {
			if (!(reco.getTexto().isBlank())) {
				publicaciones[publicacionMasAntigua()]=reco;

				numPublicacionesActuales += (numPublicacionesActuales<NUM_MAXIMO_PUBLICACIONES) ? 
						1 : 0;
			}else {
				throw new MemoryStorageException("La Recomendación no cumple con el texto necesario");	
			}
		}
	}
	
	
	public String mostrarListaPublicaciones() {
		Publicacion[] tmp = eliminarNulls();
		return Arrays.toString(tmp);
	}


	public String mostrarTweets() {
		Publicacion[] tmp = eliminarNulls();
		Tweet[] tweets = new Tweet[tmp.length];
		for(Publicacion p : tmp) {
			if(p!=null && p instanceof Tweet) {
				tweets[espacioEnLista(tweets)]=(Tweet)p;
			}
		}
		return Arrays.toString(tweets);
	}
	
	public String mostrarPosts() {
		Publicacion[] tmp = eliminarNulls();
		Post[] posts = new Post[tmp.length];
		for(Publicacion p : tmp) {
			if(p!=null && p instanceof Post) {
				posts[espacioEnLista(posts)]=(Post)p;
			}
		}
		return Arrays.toString(posts);
	}
	
	public String mostrarRecomendaciones() {
		Publicacion[] tmp = eliminarNulls();
		Recomendacion[] recos = new Recomendacion[tmp.length];
		for(Publicacion p : tmp) {
			if(p!=null && p instanceof Recomendacion) {
				recos[espacioEnLista(recos)]=(Recomendacion)p;
			}
		}
		return Arrays.toString(recos);
	}
	
	private Publicacion[] eliminarNulls() {
		int noNulos=0;
		for(Publicacion p: publicaciones) {
			if(p!=null) {
				noNulos++;
			}
		}
		int pos=0;
		Publicacion[] aux = new Publicacion[noNulos];
		for(Publicacion p: publicaciones) {
			if(p!=null) {
				aux[pos++]=p;
			}
		}
		return aux;
	}
}
