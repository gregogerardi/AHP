package controller;

import model.*;
import model.filtros.Filtro;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Controller {
	private BaseDatos baseDatos;
	private Decisor decisor;
	private List<Filtro> filtros;
	private Object[] valoresBuscados;
	private List<Object> datosIngresados;
	private List<Criterio> criterios;
	private List<Pc> alternativas;

	private Pc generarPc(Object[] valores) {
		Pc pc = new Pc();
		for (int i = 0; i < Globals.atributos.length; i++) {
			pc.set(Globals.atributos[i], valores[i]);
		}
		return pc;
	}

	public boolean agregarPc(Object[] valores) {//devuelve false si la pc ya esta cargada en la base, queda horrible TODO CAMBIARLO POR UNA EXCEPCION
		Pc pc = generarPc(valores);
		try {
			if (baseDatos.contains(pc)) {
				return false;
			} else {
				try {
					baseDatos.addComputadora(pc);
				} catch (IOException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return true;
	}

	public boolean deletePc(Object[] valores) {
		Pc pc = generarPc(valores);
		try {
			if (!baseDatos.contains(pc)) {
				return false;
			} else {
				baseDatos.deleteComputadora(pc);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return true;
	}

	public void vaciarBase() {
		try {
			baseDatos.deleteAll();
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
	}

	public List<Pc> recuperarPcsBase() {
		List<Pc> pcs = new ArrayList<>();
		try {
			pcs = baseDatos.getComputadoras();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return pcs;
	}
	
	public void setAlternativas(List<Pc> a){
		alternativas =a;
	}

	public Controller(){
		baseDatos = new BaseDatos();
		filtros = new ArrayList<>();
		datosIngresados = new ArrayList<>();
	}
	
	public void setBaseDatos(BaseDatos bd){
		this.baseDatos = bd;
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

	public void setValoresBuscados(Object[] valoresBuscados) {
		this.valoresBuscados = valoresBuscados;
	}

	public List<Object> getDatos(){
		return datosIngresados;
	}

	private List<Pc> getFiltradas() throws IOException, ClassNotFoundException {
		List<Pc> computadoras = baseDatos.getComputadoras();
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
