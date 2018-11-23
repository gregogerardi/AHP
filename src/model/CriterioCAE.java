package model;

import java.util.ArrayList;
import java.util.List;

public class CriterioCAE extends CriterioSimple {
    public CriterioCAE(String nombre, int optimisable) {
        super(nombre, optimisable);
    }
    public Matriz getMatrizComparacionAlternativas(List<Pc> alternativas, Escala escala) {
        Matriz m = new Matriz(alternativas.size(), alternativas.size());
        double suma=0d;
        ArrayList<CAE> dependientes = new ArrayList<>();//PARA GUARDAR LOS QUE SE CALCULAN ULTIMOS
        for (int j = 0; j < alternativas.size(); j++) {//UPDATEO LOS VALORES
            CAE caeValor = (CAE) alternativas.get(j).get(Globals.cae);
            if (caeValor.isTengoDatos()){
                //caeValor.toString();
                caeValor.calcularCae();
                suma+=caeValor.getCAE();
            }
            else
                dependientes.add(caeValor);
        }
        int cantidad=alternativas.size()-dependientes.size();
        double promedio=-1;
        if(cantidad!=0){
            promedio=suma/cantidad;
        }
        for (CAE unCae : dependientes) {
            unCae.setCaeCalculado(promedio);
        }
        System.out.println("En el calculo el promedio quedo: "+promedio);
        for (int j = 0; j < alternativas.size(); j++) {
            for (int k = j; k < alternativas.size(); k++) {
                if (k == j) {
                    m.set(j, k, 1.0d);
                } else {
                    Double valorFinal1 = 1.0d;
                    Double valorFinal2 = 1.0d;
                    if (this.isNumerico()) {
                        //TODO BUSCAR OTRA FORMA MENOS HORRIBLE DE CASTEAR A DOUBLE LOS VALORES QUE SEAN TIPO INTEGER QUE NO ME DEJA SIN PASAR POR EL MEDIO POR STRING
                        CAE unCae1=(CAE) alternativas.get(j).get(this.nombre);
                        Double v1 = unCae1.getCAE();
                        CAE unCae2=(CAE) alternativas.get(k).get(this.nombre);
                        Double v2 = unCae2.getCAE();
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

    protected Double getMax(String atributo,List<Pc> alternativas){
        Double max = -1.0;
        for (Pc pc: alternativas){
            CAE unCae= (CAE )pc.get(atributo);
            if (unCae.getCAE() > max)
                max = unCae.getCAE();
        }
        return max;
    }
}
