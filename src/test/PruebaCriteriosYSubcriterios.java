package test;

import java.util.ArrayList;
import java.util.List;

import controller.Controller;
import model.BaseDatos;
import model.Criterio;
import model.CriterioCompuesto;
import model.CriterioSimple;
import model.Decisor;
import model.Pc;

public class PruebaCriteriosYSubcriterios {

	public static void main(String[] args) {
		CriterioSimple garantia = new CriterioSimple("garantia");
		CriterioCompuesto financiacion = new CriterioCompuesto("financiacion");
		CriterioSimple precio = new CriterioSimple("precio");
		CriterioSimple cuotas = new CriterioSimple("cuotas");
		financiacion.addSubcriterio(precio);
		financiacion.addSubcriterio(cuotas);
		Pc a1 = new Pc();
		a1.set("modelo", "pc1");
		a1.set("precio", 10.50);
		a1.set("cuotas", 3.8);
		a1.set("garantia", 1.5);
		Pc a2 = new Pc();
		a2.set("modelo", "pc2");
		a2.set("precio", 15.0);
		a2.set("cuotas", 2.4);
		a2.set("garantia", 3.5);
		List<Pc> alternativas = new ArrayList<>();
		alternativas.add(a1);
		alternativas.add(a2);
		Controller c = new Controller();
		c.setAlternativas(alternativas);
		garantia.setValor(2.0);
		cuotas.setValor(3.0);
		precio.setValor(13.0);
		List<Criterio> criterios = new ArrayList<>();
		garantia.setComparacion(financiacion, 7.0);
		precio.setComparacion(cuotas, 5.0);
		criterios.add(garantia);
		criterios.add(financiacion);
		c.setCriterios(criterios);
		c.buscar();
		

	}

}
