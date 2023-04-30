package colecciones.com.colecciones.boletin1.almacen;

public class CajaException extends Exception {

	public CajaException() {
	}

	public CajaException(String message) {
		super(message);
	}

	public CajaException(Throwable cause) {
		super(cause);
	}

	public CajaException(String message, Throwable cause) {
		super(message, cause);
	}

	public CajaException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}