package pokemon.com.model;

import java.util.Objects;
import java.util.Random;

public class Pokemon<T> implements Comparable<T>{

	private String nombre;
	private Elemento elemento;
	protected int fuerza;
	private int nivel;
	private static final int BAJAFUERZA=5;
	private static final int SUBEFUERZA=10;
	
	
	public Pokemon(String nombre, Elemento elemento) {
		super();
		this.nombre = nombre;
		this.elemento = elemento;
		this.nivel=3;
		this.fuerza=obtenerFuerzaInicial();
	}
	
	public Pokemon luchar(Pokemon oponente) {
		//Devuelve al pokemon perdedor para que se pueda añadir al conjunto del oponente
		Pokemon perdedor = null;
		if(this.fuerza>=oponente.fuerza) {
			this.evolucionarTrasBatalla(true);
			oponente.evolucionarTrasBatalla(false);
			perdedor = oponente;
		}else {
			this.evolucionarTrasBatalla(false);
			oponente.evolucionarTrasBatalla(true);
			perdedor = this;
		}
		return perdedor;
	}
	
	public boolean evolucionarTrasBatalla(boolean ganador) {
		if(this.nivel!=1 && !ganador) {
			this.nivel--;
			this.fuerza-=BAJAFUERZA;
		}else {
			if(ganador) {
				this.nivel++;
				this.fuerza+=SUBEFUERZA;
			}
		}
		return true;
	}
	
	private int obtenerFuerzaInicial() {
		return new Random().nextInt(80);	
	}

	public String getNombre() {
		return nombre;
	}

	public Elemento getElemento() {
		return elemento;
	}

	@Override
	public int compareTo(T o) {
		return this.nivel-((Pokemon)o).nivel;
	}

	@Override
	public int hashCode() {
		return Objects.hash(elemento, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		boolean sonIguales= this==obj;
		
		if(!sonIguales && obj instanceof Pokemon) {
			Pokemon casteado = (Pokemon) obj;
			
			sonIguales=casteado.nombre.equals(this.nombre) &&
					casteado.elemento.equals(this.elemento);
		}
		return sonIguales;
	}
	
	//Aunque no lo pide el UML, añado un toString para mostrar los pokemon
	@Override
	public String toString() {
		return String.format("Pokemon: %s Elemento: %s Nivel: %s Fuerza: %s ", this.nombre, 
				this.elemento, this.nivel, this.fuerza);
	}
	
}
