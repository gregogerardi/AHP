package model;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class Escala {
	private Hashtable<Double,List<Double>> escala;
	
	
	public Escala(){
		escala = new Hashtable<>();
		Double d1 = 0.0;
		Double d2 = 0.2;
		List<Double> l1 = new ArrayList<>();
		l1.add(d1);
		l1.add(d2);
		escala.put(1.0, l1);
		
		Double d3 = 0.2;
		Double d4 = 0.4;
		List<Double> l2 = new ArrayList<>();
		l2.add(d3);
		l2.add(d4);
		escala.put(3.0, l2);
		
		Double d5 = 0.4;
		Double d6 = 0.6;
		List<Double> l3 = new ArrayList<>();
		l3.add(d5);
		l3.add(d6);
		escala.put(5.0, l3);
		
		Double d7 = 0.6;
		Double d8 = 0.8;
		List<Double> l4 = new ArrayList<>();
		l4.add(d7);
		l4.add(d8);
		escala.put(7.0, l4);
		
		Double d9 = 0.8;
		Double d10 = 1.0;
		List<Double> l5 = new ArrayList<>();
		l4.add(d9);
		l4.add(d10);
		escala.put(9.0, l5);
	}
	
	public Double get(Double puntaje){
		if (puntaje.equals(0.0))   //NO HAY DIFERENCIA ENTRE LAS DOS OPCIONES DE PC POR LO TANTO DEVUELVE 1.0 
			return 1.0;
		else{
			for (double i=1.0; i<=9.0; i++){
				if ((puntaje>(escala.get(i).get(0)) && (puntaje<=escala.get(i).get(1))))
					return (double) i;
				i++;
			}
		return 9.0;    //SE ASUME QUE SON MUY DISTINTOS COMO PARA DEVOLVER ALGO, SINO DA ERROR
		}
	}
}
