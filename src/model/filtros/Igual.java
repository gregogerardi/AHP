package model.filtros;

import model.Pc;

public class Igual extends Filtro {

	
	public Igual(String a, Comparable o){
		super (a,o);
	}
	public boolean cumple (Pc pc){
		return this.objeto.compareTo(pc.get(atributo))==0;
	}

}
