package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import model.BaseDatos;
import model.Criterio;
import model.Decisor;
import model.Matriz;
import model.Pc;
import model.Score;
import model.filtros.Filtro;
import view.VentanaResultados;

public class Controller {
	private BaseDatos bd;
	private Decisor decisor;
	private List<Filtro> filtros;
	private List<Object> datosIngresados;
	private List<Criterio> criterios;
	
	private List<Pc> alternativas;
	
	public void setAlternativas(List<Pc> a){
		alternativas =a;
	}

	public Controller(){
		bd = new BaseDatos();
		filtros = new ArrayList<>();
		datosIngresados = new ArrayList<>();
	}
	
	public void setBaseDatos(BaseDatos bd){
		this.bd = bd;
	}

	
	public void setCriterios(List<Criterio> criterios2){
		this.criterios = criterios2;
	}
	public void setFiltros(List<Filtro> filtros){
		this.filtros = filtros;
	}
	
	public void setDatos(List<Object> datos){
		datosIngresados=datos;
	}
	
	public List<Object> getDatos(){
		return datosIngresados;
	}
		
	private List<Pc> getFiltradas(){
		List<Pc> computadoras = bd.getComputadoras();
		List<Pc> filtradas = new ArrayList<>();
		if (filtros.size()>0){
			for (Pc pc: computadoras){
				for (Filtro f:filtros){
					if (f.cumple(pc)){
						filtradas.add(pc);
					}
				}
			}
		}
		else filtradas = computadoras;
		return filtradas;
	}
	
	
	
	
	public void buscar (){
		//List<Pc> opciones = this.getFiltradas(); ESTO VA
		decisor = new Decisor(alternativas);  //CAMBIAR ALTERNATIVAS POR OPCIONES
		decisor.setCriterios(criterios);
		//ARMA LA MATRIZ DE COMPARACION DE CRITERIOS PADRES Y DE SUBCRITERIOS PONIENDOLOS EN LOS CRITERIOS COMPUESTOS
		Matriz comparacionDeCriterios = decisor.getMatrizComparacionCriterios(criterios);//SEGUIR CON ESTA MATRIZ
		//ARMA LAS MATRICES DE COMPARACIONES ENTRE ALTERNATIVAS PARA CADA CRITERIO HOJA
		decisor.compararAlternativas();

		Vector<Score> resultados = decisor.calcular(comparacionDeCriterios);
		for (Score s:resultados){
			System.out.println(s.getNombre()+" "+s.getScore());
		}
	}
	
	
}
