package pokemon.com.main;

import pokemon.com.model.*;

public class MainPokemon {

	public static void main(String[] args) {
		Entrenador ash = new Entrenador("Ash Ketchum");
		Entrenador gold = new Entrenador("Oro");
		Entrenador rubi = new Entrenador("Rubí");
		Entrenador x = new Entrenador("Entrenador X");
		Entrenador scarlet = new Entrenador("Escarlata");
		
		Pokemon p1 = new Pokemon("Pikachu",Elemento.ELECTRICO);
		Pokemon p3 = new Pokemon("Bulbasur",Elemento.PLANTA);
		Pokemon p6 = new Pokemon("Geodude",Elemento.ROCA);
		Pokemon p7 = new Pokemon("Greninja",Elemento.AGUA);
		Pokemon p8 = new Pokemon("Mewtwo",Elemento.PSIQUICO);
		
		//No debe de dar error en todos estos add
		try {
			ash.addPokemon(p1);
			gold.addPokemon(p8);
			gold.addPokemon(p6);
			gold.addPokemon(new Pokemon("Greninja",Elemento.AGUA));
			rubi.addPokemon(p3);
			x.addPokemon(p7);
			//Los entrenador sword y scarlet aún no tienen pokemon
		} catch (PokemonException e) {
			assert(false);
		}
		
		//Antes de que ash y x compitan, vamos a comparar sus pokemon
		System.out.println(p1.compareTo(p7));
		//Compiten
		try {
			ash.competir(x);
		} catch (PokemonException e) {
			e.printStackTrace();
		}
		System.out.println(p1.compareTo(p7));
		
		System.out.println(ash.mostrarPokemons());
		
		//Si Ash derrotó a X en la linea 42, podrá eliminar a Greninja, si no, da error;
		try {
			ash.eliminarPokemon(p1);
		} catch (PokemonException e) {
			e.printStackTrace();
		}
		
		//Escarlata aún no tiene pokemon, con lo cual dará error de que no tiene 
		try {
			rubi.competir(scarlet);
		} catch (PokemonException e) {
			e.printStackTrace();
		}
		
		/*Le quitamos el pokemon a Rubi, no debe de saltar error ya que 
		 * tiene a p3 (bulbasur planta)*/
		try {
			rubi.eliminarPokemon("Bulbasur",Elemento.PLANTA);
		} catch (PokemonException e) {
			e.printStackTrace();
		}
		
		//El entrenador gold decide donar todos sus pokemons a ash
		/*Si ash ganó antes, dará error ya que ambos tendrían un greninja elemento agua, 
		si no, los donará sin problema*/
		
		System.out.println("Antes de la donación (Ash): "+ash.mostrarPokemons());
		System.out.println("Antes de la donación (Gold): "+gold.mostrarPokemons());
		try {
			gold.donar(ash);
		} catch (PokemonException e) {
			e.printStackTrace();
		}
		System.out.println("Despues del intento de donación (Ash): "+ash.mostrarPokemons());
		System.out.println("Despues del intento de donación (Gold): "+gold.mostrarPokemons());
		
	}

}
