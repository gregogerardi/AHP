package model;

import java.io.Serializable;
import java.util.ArrayList;

public class CAE implements Serializable {
    private static final long serialVersionUID=1234678901234567890L;
    public static double INTERES=0.08;
    public static double DEPRECIACION=0.95;
    public static double caePromedio;
    private ArrayList<Double> costos;
    private double costeCompra;
    private double depreciacion;
    private double caeCalculado;
    private boolean tengoDatos;
    private static ArrayList<CAE> instancias=new ArrayList<>();
    private static int cantInstancias=0;

    public static void setINTERES(double INTERES) {
        CAE.INTERES = INTERES;
        for (CAE c : instancias)
            c.calcularCae();
        double suma = 0d;
        for (CAE c : instancias) {
            suma += c.getCAE();
        }
        caePromedio = suma / cantInstancias;


    }

    public static void setDEPRECIACION(double DEPRECIACION) {
        CAE.DEPRECIACION = DEPRECIACION;
        for (CAE c : instancias)
            c.calcularCae();
        double suma = 0d;
        for (CAE c : instancias) {
            suma += c.getCAE();
        }
        caePromedio = suma / cantInstancias;

    }

    public CAE(ArrayList<Double> costos, Double costeCompra, Double depreciacion) {
        instancias.add(this);
        if(!costos.isEmpty()) {
            this.tengoDatos=true;
            this.costos = costos;
            this.costeCompra = costeCompra;
            this.depreciacion = depreciacion;
            this.calcularCae();
            cantInstancias++;
            double suma = 0d;
            for (CAE c : instancias) {
                suma += c.getCAE();
            }
            caePromedio = suma / cantInstancias;
        }
        else{
            this.tengoDatos=false;
        }
    }
    public double getCAE(){
        if(tengoDatos)
            return caeCalculado;
        else
            return caePromedio;
    }
    @Override
    public String toString(){
        if(tengoDatos){
            this.calcularCae();
            String caeString=String.valueOf(caeCalculado);
            return caeString;
        }
        else {
            String caeString=String.valueOf(caePromedio);
            return caeString;
        }
    }

    public void calcularCae(){
        if(tengoDatos) {
            double caeMin = Double.MAX_VALUE;
            boolean empeoro = false;
            for (int n = 1; n < costos.size() + 1 && !empeoro; n++) {
                double sumaCosto = 0;
                double valorReventa = Math.pow(this.depreciacion, n) * (this.costeCompra);
                for (int j = 0; j < n; j++) {
                    double sumaParcial = 0;
                    sumaParcial += costos.get(j);
                    double divisor = Math.pow(1 + INTERES, j);
                    sumaCosto += sumaParcial / divisor;
                }
                double divisor = (Math.pow(1 + INTERES, n)) - 1;
                double factor = INTERES * Math.pow(1 + INTERES, n);
                factor = factor / divisor;
                divisor = Math.pow(1 + INTERES, n);
                //System.out.println("divisor"+n+"  : "+ divisor);
                double caeParcial = this.costeCompra - ((valorReventa) / divisor) + sumaCosto;
                caeParcial = caeParcial * factor;
                if (caeParcial < caeMin)
                    caeMin = caeParcial;
                else
                    empeoro = true;
                System.out.println("parcial" + n + "  : " + caeParcial);
            }

            this.caeCalculado = caeMin;
        }
        else
            System.out.println("Estoy queriendo calcular el cae sin datos");
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


        CAE unCae=new CAE(costos,500d,0.95d);
        System.out.println("El mejor cae fue: "+unCae.toString());


    }
}
