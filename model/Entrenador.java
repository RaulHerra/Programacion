package pokemon.com.model;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

public class Entrenador {
	
	private String nombre;
	private int batallasGanadas;
	private Set<Pokemon> conjuntoPokemon;
	
	public Entrenador(String nombre) {
		super();
		this.nombre = nombre;
		this.batallasGanadas=0;
		this.conjuntoPokemon = new HashSet<Pokemon>();
	}
	
	public void competir(Entrenador otro) throws PokemonException {
		
		Pokemon perdedor=this.obtenerMasFuerte().luchar(otro.obtenerMasFuerte());
		
		//Si el pokemon de this es el perdedor, otro ha ganado la batalla
		if(this.conjuntoPokemon.contains(perdedor)) {
			otro.batallasGanadas++;
		}else {
			this.batallasGanadas++;
		}
		//Si el conjunto de this contiene al pokemon perdedor y el oponente no lo tiene
		if(this.conjuntoPokemon.contains(perdedor) && !(otro.conjuntoPokemon.contains(perdedor))) {
			otro.conjuntoPokemon.add(perdedor);
			this.conjuntoPokemon.remove(perdedor);
		}else {
			//Si el conjunto de otro contiene al pokemon perdedor y this no lo tiene
			if(otro.conjuntoPokemon.contains(perdedor) && !(this.conjuntoPokemon.contains(perdedor))) {
				this.conjuntoPokemon.add(perdedor);
				otro.conjuntoPokemon.remove(perdedor);
			}
		}
	}
	
	public boolean addPokemon(Pokemon nuevo) throws PokemonException {
		Iterator<Pokemon> it = conjuntoPokemon.iterator();
		boolean ocurrencia=false;
		
		while(it.hasNext() && !ocurrencia) {
			if(it.next().equals(nuevo)) {
				ocurrencia=true;
			}
		}
		//Si no se ha encontrado la ocurrencia del pokemon lo añade, si se ha encontrado, salta la exception
		if(!ocurrencia) {
			conjuntoPokemon.add(nuevo);
		}else {
			throw new PokemonException("Ya tiene en su equipo un "+nuevo.getNombre()+
					" de tipo "+nuevo.getElemento());
		}
		//Si se ha añadido devuelve true
		return !ocurrencia;
	}
	
	public boolean eliminarPokemon(Pokemon eliminar) throws PokemonException {
		Iterator<Pokemon> it = conjuntoPokemon.iterator();
		boolean eliminado=false;
		
		while(it.hasNext() && !eliminado) {
			if(it.next().equals(eliminar)) {
				eliminado=true;
				it.remove();
			}
		}
		//Si no ha sido eliminado salta la exception
		if(!eliminado){
			throw new PokemonException("No está en la lista");
		}
		return eliminado;
	}
	
	public boolean eliminarPokemon(String nombre, Elemento elemento) throws PokemonException {
		return eliminarPokemon(new Pokemon(nombre, elemento));
	}
	
	public void vaciar() {
		this.conjuntoPokemon.clear();
	}
	
	protected Pokemon obtenerMasFuerte() throws PokemonException {
		if(this.conjuntoPokemon.isEmpty()) {
			throw new PokemonException(this.nombre+" no puede competir si no tiene pokemons");
		}
		Iterator<Pokemon> it = conjuntoPokemon.iterator();
		int maxFuerza=0;
		Pokemon masFuerte=null, tmp;
		while(it.hasNext()) {
			tmp=it.next();
			if(tmp.fuerza>maxFuerza) {
				masFuerte=tmp;
			}
		}
		return masFuerte;
	}
	
	public boolean donar(Entrenador donado) throws PokemonException {
		boolean contieneUno=false;
		Iterator<Pokemon> it = this.conjuntoPokemon.iterator();
		while(it.hasNext() && !contieneUno) {
			Pokemon tmp=it.next();
			if(donado.conjuntoPokemon.contains(tmp)) {
				contieneUno=true;
				throw new PokemonException("No puede donar a este entrenador ya que ambos tienen un "
						+tmp.getNombre()+" del elemento "+tmp.getElemento());
			}
		}
		//Si no contiene a ninguno, le damos los pokemon y se los quitamos al donante
		if(!contieneUno) {
			donado.conjuntoPokemon.addAll(this.conjuntoPokemon);
			this.vaciar();
		}
		//Devuelve lo contrario de contieneUno ya que si contiene uno, no los puede donar
		return !contieneUno;
	}
	
	public String mostrarPokemons() {
		StringBuilder sb = new StringBuilder("");

		if(this.conjuntoPokemon.isEmpty()) {
			sb.append("No tiene pokemons");
		}
		for(Elemento e : Elemento.values()) {
			//Lo construimos aquí dentro para resetearlo
			Iterator<Pokemon> it = this.conjuntoPokemon.iterator();
			while(it.hasNext()) {
				Pokemon tmp = it.next();
				if(tmp.getElemento().equals(e)) {
					sb.append(tmp.toString()).append("\n");
				}
			}
		}
		return sb.toString();
	}

	@Override
	public int hashCode() {
		return Objects.hash(batallasGanadas, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		boolean sonIguales= this==obj;
		
		if(!sonIguales && obj instanceof Entrenador) {
			Entrenador casteado = (Entrenador) obj;
			
			sonIguales=casteado.batallasGanadas==this.batallasGanadas &&
					casteado.nombre.equals(this.nombre);
		}
		return sonIguales;
	}
	
	@Override
	public String toString() {
		return String.format("Entrenador: %s\n Batallas ganadas: %s", this.nombre, this.batallasGanadas);
	}
}