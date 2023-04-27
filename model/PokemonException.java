package pokemon.com.model;

public class PokemonException extends Exception {

	public PokemonException() {
	}

	public PokemonException(String message) {
		super(message);
	}

	public PokemonException(String message, Throwable cause) {
		super(message, cause);
	}

}
