package model;

import java.util.ArrayList;
import java.util.List;

public class CriterioCompuesto extends Criterio {
	
	private List<Criterio> subcriterios;
	private Matriz comparacionPareadaSubcriterios;
	
	public CriterioCompuesto(String nombre) {
		super(nombre);
		subcriterios = new ArrayList<>();
	}
	
	public void addSubcriterio(Criterio c){
		subcriterios.add(c);
	}
	
	public List<Criterio> getHojas(){
		List<Criterio> salida = new ArrayList<>();
		for (Criterio c:subcriterios){
			salida.addAll(c.getHojas());
		}
		return salida;
	}

	@Override
	public List<Criterio> getSubcriterios() {
		return subcriterios;
	}

	@Override
	public void setMatriz(Matriz m) {
		comparacionPareadaSubcriterios = m;
	}
	
	public Matriz getMatriz(){
		return comparacionPareadaSubcriterios;
	}
	
	public List<Double> getPonderaciones (){
		List<Double> salida = new ArrayList<>();
		for (Criterio c:subcriterios){
			List<Double> ponderacionesCriterio = c.getPonderaciones();
			for (Double val: ponderacionesCriterio){
				Double nuevo = this.ponderacion * val;
				salida.add(nuevo);
			};
		}
		return salida;
	}


}
