package model;

import java.util.ArrayList;
import java.util.List;

public class CriterioSimple extends Criterio {
    //TODO NUNCA USADO
    //private Criterio padre;

    //public CriterioSimple(String nombre,int maxormin,int objetivo){
    //	super(nombre,maxormin,objetivo);
    //}

    public CriterioSimple(String nombre, int optimisable) {
        super(nombre, optimisable);
    }

    public CriterioSimple(String nombre) {
        super(nombre, 0);
    }// el segundo argumento del constructor es al pedo, es para criterios no numericos,
    //TODO para evitarlo hacer una subclase de criterio simple para los numericos, otra para los objetivos,
    // y otra para los subjetivos, y en el metodo de getMatrizComparacionAlternativas en los if
    // preguntar por instanceOf en vez de los booleanos.

    public List<Criterio> getSubcriterios() {
        return new ArrayList<>();
    }

    public List<Criterio> getHojas() {
        List<Criterio> salida = new ArrayList<>();
        salida.add(this);
        return salida;
    }
    //TODO NUNCA USADO
	/*public boolean esSubcriterio(){
		return padre != null;
	}*/

    public List<Double> getPonderaciones() {
        List<Double> salida = new ArrayList<>();
        salida.add(this.ponderacion);
        return salida;
    }

    public Matriz getMatrizComparacionAlternativas(List<Pc> alternativas, Escala escala) {
        Matriz m = new Matriz(alternativas.size(), alternativas.size());
        for (int j = 0; j < alternativas.size(); j++) {
            for (int k = j; k < alternativas.size(); k++) {
                if (k == j) {
                    m.set(j, k, 1.0d);
                } else {
                    Double valorFinal1 = 1.0d;
                    Double valorFinal2 = 1.0d;
                    if (this.isNumerico()) {
                        //TODO BUSCAR OTRA FORMA MENOS HORRIBLE DE CASTEAR A DOUBLE LOS VALORES QUE SEAN TIPO INTEGER QUE NO ME DEJA SIN PASAR POR EL MEDIO POR STRING
                        Double v1 = (Double.parseDouble(alternativas.get(j).get(this.nombre).toString()));
                        Double v2 = (Double.parseDouble(alternativas.get(k).get(this.nombre).toString()));
                        Double rangoValor = this.getMax(this.nombre, alternativas);
                        Double valorBuscado;
                        if (!(this.optimisable == Criterio.SUBJETIVO))
                            valorBuscado = rangoValor; // se asume maximisable, entonces se busca el maximo valor posible
                        else
                            valorBuscado = (Double) this.valor;
                        //if (this.optimisable==Criterio.SUBJETIVO) { //innesesario
                        Double dif1;
                        Double dif2;
                        if (rangoValor != 0) {
                            dif1 = Math.abs(valorBuscado - v1) / rangoValor;
                            dif2 = Math.abs(valorBuscado - v2) / rangoValor;
                        } else {
                            dif1 = dif2 = valorBuscado;
                        }
                        if (dif1 <= dif2) {
                            valorFinal1 = escala.get(dif2 - dif1);
                            valorFinal2 = (1 / valorFinal1);
                        } else {
                            valorFinal2 = escala.get(dif1 - dif2);
                            valorFinal1 = (1 / valorFinal2);
                        }
                    } else {//para criterios por comparacion como la marca no cuantificados O los truefalse
                        Object v1 = alternativas.get(j).get(this.nombre);
                        Object v2 = alternativas.get(k).get(this.nombre);
                        Object valorBuscado = this.valor;
                        //SI AMBAS PCS TIENEN LA MISMA MARCA, O AMBAS MARCAS SON DISTINTAS DE LA BUSCADA, EL VALOR COMPARATIVO ES 1
                        if ((v1.equals(v2)) || ((!v1.equals(valorBuscado)) && (!v2.equals(valorBuscado)))) {
                            valorFinal1 = valorFinal2 = 1.0;
                        } else { //una de las pcs coincide pero la otra no, se pone la maxima diferencia 9
                            if (v1.equals(valorBuscado)) {
                                valorFinal1 = 9.0;
                            } else {
                                valorFinal1 = 1.0 / 9;
                            }
                            valorFinal2 = 1 / valorFinal1;
                        }
                    }
                    m.set(j, k, valorFinal1);
                    m.set(k, j, valorFinal2);
                }
            }
        }
        if (this.optimisable == Criterio.MINIMIZABLE && this.isNumerico()) {
            //
            //System.out.println(m);
            m.invertir();// Este metodo maria m[i][j]=m[j][i] logrando asi que se califique mejor los valores minimos
            //System.out.println(" ");
            //System.out.println(m);
        }
        return m;
    }

    public Matriz getMatriz() {
        return null;
    }

    @Override
    public void setMatriz(Matriz m) {

    }
}

