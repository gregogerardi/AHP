package test;

import java.util.List;

import model.BaseDatos;
import model.Pc;

public class MainPrueba {

	public static void main(String[] args) {
		Pc nueva1 = new Pc();
		nueva1.set("modelo", "pc1");
		Pc nueva2 = new Pc();
		nueva2.set("modelo", "pc2");
		BaseDatos bd = new BaseDatos();
		bd.addComputadora(nueva1);
		System.out.println("agrego nueva1");
		bd.addComputadora(nueva2);
		System.out.println("agrego nueva2");
		
		List<Pc> pcs = bd.getComputadoras();
		System.out.println(pcs.size());
		for (Pc pc:pcs){
			System.out.println(pc.get("modelo"));
		}
	}

}
