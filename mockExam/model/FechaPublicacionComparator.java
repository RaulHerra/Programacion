package com.mockExam.model;

import java.util.Comparator;

public class FechaPublicacionComparator implements Comparator<Publicacion> {


	@Override
	public int compare(Publicacion o1, Publicacion o2) {
		int resultado=0;
				
		if(o1!=null && o2!=null) {
			resultado = (o1.valoracion-o2.valoracion)!=0 ? 
					o1.valoracion-o2.valoracion:
					o1.getFechaCreacion().hashCode()-o2.getFechaCreacion().hashCode();
		}else{
			if(o1==null) {
				resultado=1;
			}else {
					resultado=-1;
				}
			}
		return resultado;
	}

}
