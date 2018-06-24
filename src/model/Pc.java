package model;

import java.util.Hashtable;

public class Pc implements java.io.Serializable {
	private Hashtable<String, Object> atributos;
	
	public Pc(){
		atributos = new Hashtable<>();
	}
	public void set(String a, Object o){
		atributos.put(a, o);
	}
	public Object get(String a){
		if (atributos.containsKey(a))
			return atributos.get(a);
		return null;
	}
}
