package com.euromillon;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Combinacion {

	private static final int VALOR_MINIMO=1;
	public static final int VALOR_MAXIMO_NUMEROS=50;
	public static final int VALOR_MAXIMO_ESTRELLAS=12;
	private static final int TOTAL_NUMEROS=5;
	private static final int TOTAL_ESTRELLAS=2;
	private List<Integer> numeros;
	private Set<Integer> estrellas;
	
	public Combinacion(List<Integer> numeros, Set<Integer> estrellas) throws CombinacionException {
		super();
		if(numeros.size()==TOTAL_NUMEROS && estrellas.size()==TOTAL_ESTRELLAS && 
				comprobarNumeros(numeros, estrellas)) {
			this.numeros = numeros;
			this.estrellas = estrellas;	
		}else {
			throw new CombinacionException("Cantidad o números incorrectos");
		}
	}
	
	public Combinacion(Integer num1, Integer num2, Integer num3, Integer num4, Integer num5,
			Integer estrella1, Integer estrella2) throws CombinacionException {
		this(List.of(num1, num2, num3, num4, num5), Set.of(estrella1, estrella2));
	}

	public int comprobarCombinacion(Combinacion otra) {
		Set<Integer> numerosTemporal = new HashSet<>(numeros);
		Set<Integer> estrellasTemporal = new HashSet<>(estrellas);
		numerosTemporal.retainAll(otra.getNumeros());
		estrellasTemporal.retainAll(otra.getEstrellas());

		return numerosTemporal.size()+estrellasTemporal.size();
		}
	
	public List<Integer> getNumeros() {
		return numeros;
	}

	public Set<Integer> getEstrellas() {
		return estrellas;
	}

	@Override
	public int hashCode() {
		return Objects.hash(estrellas, numeros);
	}

	@Override
	public boolean equals(Object obj) {
		boolean sonIguales = this==obj;
		
		if(!sonIguales && obj != null && obj instanceof Combinacion) {
			Combinacion casteado = (Combinacion)obj;
			
			sonIguales = casteado.hashCode()==this.hashCode();
		}
		return sonIguales;
	}
	
	@Override
	public String toString() {
		return String.format("Numeros: %s \n Estrellas: %s", this.getNumeros(), 
				this.getEstrellas());
	}
	
	//Método para comprobar que los números dados son correctos
	public boolean comprobarNumeros(List<Integer> numeros, Set<Integer> estrellas) {
		Iterator<Integer> itNum = numeros.iterator();
		Iterator<Integer> itEst = estrellas.iterator();
		boolean esCorrecto = true;
		
		while (itNum.hasNext() && esCorrecto) {
			Integer num = itNum.next();
			if (num > VALOR_MAXIMO_NUMEROS || num < VALOR_MINIMO) {
				esCorrecto=false;
			}
		}
		while (itEst.hasNext() && esCorrecto) {
			Integer est = itEst.next();
			if (est > VALOR_MAXIMO_ESTRELLAS || est < VALOR_MINIMO) {
				esCorrecto=false;
			}
		}
		return esCorrecto;
	}
}