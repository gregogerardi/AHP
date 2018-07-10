package test;

import model.BaseDatos;
import model.Pc;

import java.io.IOException;
import java.util.List;

public class MainPrueba {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
	/*	Pc nueva1 = new Pc();
		nueva1.set("modelo", "pc1");
		Pc nueva2 = new Pc();
		nueva2.set("modelo", "pc3");
		bd.addComputadora(nueva1);
		System.out.println("agrego nueva1");
		bd.addComputadora(nueva2);
		System.out.println("agrego nueva2");
		bd.deleteComputadora((String)nueva1.get("modelo"));*/
        BaseDatos bd = new BaseDatos();
        bd.deleteAll();
		List<Pc> pcs = bd.getComputadoras();
		System.out.println(pcs.size());
		for (Pc pc:pcs){
			System.out.println(pc.get("modelo"));
		}
	}

}
