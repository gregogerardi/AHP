package model;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public abstract class Criterio {
    //TODO !!!
    //TODO LOS CRITERIOS OBJETIVOS AL PEDO TIENEN EL VALOR valor. DEBERIA HABER UNA HERENCIA MAS DE CLASES ENTRE CRITERIO, LOS NUMERICOS Y BOOLEANOS, Y DENTRO DE LOS NUMERICOS LOS OBJETIVOS MAXIMISABLES/MINIMISABLES Y LOS SUBJETIVOS, Y NO HACER TODO A LO CROTO CON BOOLEANOS
    //TODO !!!

	protected String nombre;
    protected Object valor;
    public static int MAXIMISABLE = 1;
    public static int MINIMIZABLE = -1;
    //TODO NUNCA USADO REDUNDANTE
    //protected int maxormin;
	public static int SUBJETIVO = 0;
    //TODO NUNCA USADO SON REDUNDANTES, CON MAXIMISABLE MINIMISABLE Y SUBJETIVO ALCANZA
    //public static int OBJETIVO = 1;
    //public static int SUBJETIVO = 0;
    protected Hashtable<Criterio, Double> comps;
	protected boolean numerico = true;
    protected int optimisable = 0;
    //TODO NUNCA USADO TAMBIEN REDUNDANTE
    //protected int objetivo;
	//TODO NUNCA USADO
	//protected Criterio padre;
	//TODO NUNCA USADO
//	protected Hashtable<Criterio, JSlider> comparaciones;
	protected Double ponderacion;

    //TODO INNESESARIO AL PASAR EL COMPARAR MATRIZ A LA SUBCLASE CRITERIO SIMPLE, SE PREGUNTA DIRECTO POR EL INT PROTECTED
	/*
    public int getOptimisable() {
        return optimisable;
    }
*/

    //	public Criterio(String n,int maxormin,int objetivo) {
    public Criterio(String n, int optimisable) {
		this.nombre = n;
		//TODO NUNCA USADO
		//	padre = null;
		//TODO NUNCA USADO
		//	comparaciones = new Hashtable<>();
        valor = new Object();
		ponderacion = new Double(0.0);
		comps = new Hashtable<>();
        this.optimisable = optimisable;
        //TODO INNESESARIOS
/*		this.maxormin=maxormin;
		this.objetivo=objetivo;*/
	}
	
	public void setNumerico(boolean numerico) {
		this.numerico = numerico;
	}

	//TODO NUNCA USADO
	/*
    public void setOptimisable(int optimisable) {
        this.optimisable = optimisable;
	}
*/
	public boolean isNumerico() {
		return numerico;
	}
/*
    //TODO NUNCA USADO
	public void setPadre(Criterio padre) {
		this.padre = padre;
	}
*/
	//TODO NUNCA USADO
	/*public boolean esSubcriterio() {
		return padre != null;
	}*/

    public void setValor(Double v) {
        this.valor = v;
        this.numerico = true;
    }

    public void setValor(Object o) {
        this.valor = o;
        this.numerico = false;
    }

    public Object getValor() {
		return valor;
	}

	public String getNombre() {
		return nombre;
	}

	//TODO NUNCA USADO
	/*public void setComparacion(Criterio c, JSlider s) {
		comparaciones.put(c, s);
	}*/

	public void setComparacion(Criterio c, Double d) {
		comps.put(c, d);
	}

	public Double getComparacion(Criterio c) {
		//TODO NUNCA USADO
/*		JSlider slider = comparaciones.get(c);
		if (slider != null) {*//*
			Integer valor = slider.getValue();
			if (valor % 2 == 0) {
				valor++;
			}
			return 1.0 * valor + 1;
		}*/
		return comps.get(c);
	}

	public List<Criterio> getComparados() {
		List<Criterio> salida = new ArrayList<>();
		//if (comparaciones.isEmpty()){
			salida.addAll(comps.keySet());
			return salida;
		//}
		//salida.addAll(comparaciones.keySet());
		//return salida;
	}

	//TODO NUNCA USADO
/*
	public Hashtable<Criterio, JSlider> getComparaciones() {
		return comparaciones;
	}*/

	public void setPonderacion(Double d) {
		ponderacion = d;
	}

	public abstract Matriz getMatriz();

	public abstract List<Criterio> getSubcriterios();

	public abstract List<Criterio> getHojas();

	public abstract void setMatriz(Matriz m);

	public abstract List<Double> getPonderaciones();
	
	protected Double getMax(String atributo,List<Pc> alternativas){
		Double max = -1.0;
		for (Pc pc: alternativas){
			if (Double.parseDouble(pc.get(atributo).toString()) > max)
				max = Double.parseDouble(pc.get(atributo).toString());
			}
		return max;
	}
	
}
