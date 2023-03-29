package com.mockExam.model;

public enum Valoraciones {
	
	SUPERBUENA(3),
	MUY_BUENA(2),
	BUENA(1),
	REGULAR(-1),
	MUY_MALA(-2);
	
	private int valoracion;
	
	Valoraciones(int valoracion){
		this.valoracion=valoracion;
	}
	
	int getValoracion(){
		return valoracion;
	}
}
