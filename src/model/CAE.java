package model;

import java.util.ArrayList;

public class CAE {
    public static double INTERES=0.21;
    public static double DEPRECIACION=0.95;
    public static int count=0;
    public static double caeDesconocido=0;
    private ArrayList<Double> costos;
    private double costeCompra;
    private double depreciacion;
    private double caeCalculado;


    public CAE(ArrayList<Double> costos, Double costeCompra,Double depreciacion) {
        this.costos = costos;
        this.costeCompra = costeCompra;
        this.depreciacion=depreciacion;
        this.calcularCae();
    }

    @Override
    public String toString(){
        /*if(!seCalculo)
            this.calcularCae();*/
        String caeString=String.valueOf(caeCalculado);
        return caeString;
    }
    public void calcularCae(){
        double caeMin=Double.MAX_VALUE;
        boolean empeoro=false;
        for(int n=1;n<costos.size()+1&&!empeoro;n++) {
            double sumaCosto = 0;
            double valorReventa=Math.pow(this.depreciacion,n)*(this.costeCompra);
            for (int j = 0; j < n; j++) {
                double sumaParcial=0;
                sumaParcial += costos.get(j);
                double divisor = Math.pow(1 + INTERES, j);
                sumaCosto += sumaParcial / divisor;
            }
            double divisor=(Math.pow(1+INTERES,n))-1;
            double factor=INTERES*Math.pow(1+INTERES,n);
            factor=factor/divisor;
            divisor=Math.pow(1 + INTERES, n);
            //System.out.println("divisor"+n+"  : "+ divisor);
            double caeParcial=this.costeCompra-((valorReventa)/divisor)+sumaCosto;
            caeParcial=caeParcial*factor;
            if(caeParcial<caeMin)
                caeMin=caeParcial;
            else
                empeoro=true;
            System.out.println("parcial"+n+"  : "+ caeParcial);
        }

        this.caeCalculado=caeMin;
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
