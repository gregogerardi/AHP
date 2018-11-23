package model;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.Serializable;
import java.util.ArrayList;

public class CAE implements java.io.Serializable{
    private static final long serialVersionUID=1234678901234567890L;
    public static double INTERES=0.6;
    public static double DEPRECIACION=0.95;
    public static double caePromedio=1;
    private static ArrayList<CAE> instanciasAct=new ArrayList<>();
    private static ArrayList<CAE> instanciasNonAct=new ArrayList<>();

    private ArrayList<Double> costos;
    private double costeCompra;
    //private double depreciacion;
    private double caeCalculado;
    private boolean tengoDatos;



    public static int cantInstancias=0;

    public static void setINTERES(double INTERES) {
        CAE.INTERES = INTERES;
        /*
        cantInstancias=0;
        for (CAE c : instanciasAct) {
            c.calcularCae();
            System.out.println("Soy act y me calcule de nuevo");
            cantInstancias++;
        }
        double suma = 0d;
        for (CAE c : instanciasAct) {
            suma += c.getCAE();
        }
        if(cantInstancias!=0)
            caePromedio = suma / cantInstancias;
        else
            caePromedio=1;
        for (CAE c : instanciasNonAct)
            c.setCae(caePromedio);*/
    }
    private void setCae(double value){
        this.caeCalculado=value;
    }
    public static void setDEPRECIACION(double DEPRECIACION) {
        CAE.DEPRECIACION = DEPRECIACION;
        /*
        cantInstancias=0;
        for (CAE c : instanciasAct)
            c.calcularCae();
        double suma = 0d;
        for (CAE c : instanciasAct) {
            cantInstancias++;
            suma += c.getCAE();
        }
        if(cantInstancias!=0)
            caePromedio = suma / cantInstancias;
        else
            caePromedio=1;
        for (CAE c : instanciasNonAct)
            c.setCae(caePromedio);
        */

    }

    public CAE(ArrayList<Double> costos, Double costeCompra) {

        if(!costos.isEmpty()) {
            //System.out.println("Se creo un nuevo cae");
            this.tengoDatos=true;
            this.costos = costos;
            this.costeCompra = costeCompra;
            //this.depreciacion = depreciacion;
            this.calcularCae();
            cantInstancias++;
            instanciasAct.add(this);
            double suma = 0d;
            for (CAE c : instanciasAct) {
                suma += c.getCAE();
            }
            caePromedio = suma / cantInstancias;
            for (CAE c : instanciasNonAct)
                c.setCae(caePromedio);
        }
        else{
            /*
            for (CAE c : instanciasAct)
                c.calcularCae();
            double suma = 0d;
            for (CAE c : instanciasAct) {
                suma += c.getCAE();
            }
            if(cantInstancias!=0)
                CAE.caePromedio = suma / cantInstancias;
            else
                CAE.caePromedio=1; */
            //System.out.println("Cae promedio '"+caePromedio+"' y la cantde instancias: "+cantInstancias);
            this.caeCalculado=CAE.caePromedio;
            //System.out.println("Yo NO SOY un act!!");
            instanciasNonAct.add(this);
            this.tengoDatos=false;
        }
    }
    public double getCAE(){
        //if(tengoDatos)
        return caeCalculado;
       /* else {
            this.caeCalculado=caePromedio;
            return caePromedio;
        }*/
    }

    @Override
    public String toString() {
        if(INTERES==0d)
            return "OFF";
        if(this.tengoDatos) {
            String caeString = String.valueOf(caeCalculado);
            return caeString;
        }
        else
            return "Faltan datos";
    }


    /* to string viejo
    @Override
    public String toString(){

        if(CAE.INTERES==0)
            return "Interes invalido";

        if(tengoDatos) {
            if(!CAE.instanciasAct.contains(this)){
                //System.out.println("me agrego a activas soy: "+this.getCAE());
                //instanciasAct.add(this);
                //cantInstancias++;
            }
            else
                System.out.println("SI EXISTO en ACTIVAS");
            this.calcularCae();
            String caeString = String.valueOf(caeCalculado);
            return caeString;
        }
        else {
            caeCalculado=caePromedio;
            if(!CAE.instanciasNonAct.contains(this)){
                //System.out.println("me agrego a no activas soy: "+this.getCAE());
                //instanciasNonAct.add(this);
            }
            else
                System.out.println("SI EXISTO en las NONACT!! el cae promedio es: "+caePromedio);
            System.out.println("El cae"+this.getCAE());
            return "Faltan datos";

        }
    }
*/

    public void calcularCae(){
        if(tengoDatos) {
            double caeMin = Double.MAX_VALUE;
            boolean empeoro = false;
            for (int n = 1; n < costos.size() + 1 && !empeoro; n++) {
                double sumaCosto = 0;
                double valorReventa = Math.pow(CAE.DEPRECIACION, n) * (this.costeCompra);

                for (int j = 0; j < n; j++) {
                    double sumaParcial = 0;
                    sumaParcial = costos.get(j);
                    double divisor = Math.pow(1 + INTERES, j+1);
                    sumaCosto += sumaParcial / divisor;
                }
                double divisor = (Math.pow(1 + INTERES, n)) - 1;
                double factor = INTERES * Math.pow(1 + INTERES, n);
                if(divisor!=0)
                    factor = factor / divisor;
                else
                    factor=1;
                divisor = Math.pow(1 + INTERES, n);
                valorReventa=(valorReventa/divisor);
                //System.out.println("divisor"+n+"  : "+ divisor);
                double caeParcial = this.costeCompra - (valorReventa)   + sumaCosto;
                caeParcial = caeParcial * factor;
                if (caeParcial < caeMin)
                    caeMin = caeParcial;
                else
                    empeoro = true;
                //System.out.println("caeparcial "+caeParcial);
                //System.out.println(" CAE SUB"+n+" es: "+caeMin);
            }

            this.caeCalculado = caeMin;
        }
        else {
            this.caeCalculado=CAE.caePromedio;
        }
    }

    public static void main(String []args){
        ArrayList<Double> costos= new ArrayList<>();
        costos.add(100d);
        costos.add(100d);
        costos.add(100d);
        costos.add(100d);
        costos.add(100d);
        costos.add(100d);
        costos.add(100d);
        costos.add(200d);
        costos.add(400d);
        costos.add(800d);
        costos.add(1600d);
        costos.add(3200d);



        System.out.println(costos);


        CAE unCae=new CAE(costos,500d);
        System.out.println("El mejor cae fue: "+unCae.toString());


    }
    /*
    public static void update(){
        if(CAE.changed){

        }
        else{
            System.out.println("Nada que actualizar");
        }
    }*/
    public ArrayList<Double> getCostos() {
        //System.out.println(costos);
        return costos;
    }

    public void setCostos(ArrayList<Double> costos) {
        //System.out.println(costos);
        this.costos = costos;
    }

    public double getCosteCompra() {
        //System.out.println(costeCompra);
        return costeCompra;
    }

    public void setCosteCompra(double costeCompra) {
        //System.out.println(costeCompra);
        this.costeCompra = costeCompra;
    }

    public double getCaeCalculado() {
        //System.out.println(caeCalculado);
        return caeCalculado;
    }

    public void setCaeCalculado(double caeCalculado) {
        //System.out.println(caeCalculado);
        this.caeCalculado = caeCalculado;
    }

    public boolean isTengoDatos() {
        //System.out.println(tengoDatos);
        return tengoDatos;
    }

    public void setTengoDatos(boolean tengoDatos) {
        //System.out.println(tengoDatos);
        this.tengoDatos = tengoDatos;
    }


}
