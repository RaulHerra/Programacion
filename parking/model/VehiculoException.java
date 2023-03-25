package com.parking.model;

public class VehiculoException extends Exception {

	public VehiculoException() {
	}

	public VehiculoException(String message) {
		super(message);
	}

	public VehiculoException(Throwable cause) {
		super(cause);
	}

	public VehiculoException(String message, Throwable cause) {
		super(message, cause);
	}

	public VehiculoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
