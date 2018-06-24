package model;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Set;

import javax.swing.JSlider;

public abstract class Criterio {
	protected String nombre;
	protected Double valor;
	protected Criterio padre;
	protected Hashtable<Criterio, JSlider> comparaciones;
	protected Double ponderacion;
	protected Hashtable<Criterio, Double> comps;

	public Criterio(String n) {
		this.nombre = n;
		padre = null;
		comparaciones = new Hashtable<>();
		valor = new Double(0.0);
		ponderacion = new Double(0.0);
		comps = new Hashtable<>();
	}

	public void setPadre(Criterio padre) {
		this.padre = padre;
	}

	public boolean esSubcriterio() {
		return padre != null;
	}

	public void setValor(Double v) {
		this.valor = v;
	}

	public Double getValor() {
		return valor;
	}

	public String getNombre() {
		return nombre;
	}

	public void setComparacion(Criterio c, JSlider s) {
		comparaciones.put(c, s);
	}

	public void setComparacion(Criterio c, Double d) {
		comps.put(c, d);
	}

	public Double getComparacion(Criterio c) {
		JSlider slider = comparaciones.get(c);
		if (slider != null) {
			Integer valor = slider.getValue();
			if (valor % 2 == 0) {
				valor++;
			}
			return 1.0 * valor + 1;
		}
		return comps.get(c);
	}

	public List<Criterio> getComparados() {
		List<Criterio> salida = new ArrayList<>();
		if (comparaciones.isEmpty()){
			salida.addAll(comps.keySet());
			return salida;
		}
		salida.addAll(comparaciones.keySet());
		return salida;
	}

	public Hashtable<Criterio, JSlider> getComparaciones() {
		return comparaciones;
	}

	public void setPonderacion(Double d) {
		ponderacion = d;
	}

	public abstract Matriz getMatriz();

	public abstract List<Criterio> getSubcriterios();

	public abstract List<Criterio> getHojas();

	public abstract void setMatriz(Matriz m);

	public abstract List<Double> getPonderaciones();
}
