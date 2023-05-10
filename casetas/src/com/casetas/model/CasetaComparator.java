package com.casetas.model;

import java.util.Comparator;

public class CasetaComparator<T> implements Comparator<T> {

	public CasetaComparator() {
		
	}

	@Override
	public int compare(T o1, T o2) {
		return ((Caseta)o1).getNumero()-((Caseta)o2).getNumero();
	}
}