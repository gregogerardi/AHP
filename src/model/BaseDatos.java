package model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import model.filtros.Filtro;

public class BaseDatos {
	private List<Pc> computadoras;
	
	public BaseDatos(){
		computadoras = new ArrayList<>();
	}
	
	@SuppressWarnings("unchecked")
	public List<Pc> getComputadoras(){
		try {
			@SuppressWarnings("resource")
			ObjectInputStream entrada=new ObjectInputStream(new FileInputStream("DataBase.obj"));
			try {
				computadoras = (List<Pc>)entrada.readObject();
				entrada.close();
				return computadoras;
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;	
	}
	
	
	
	public void addComputadora(Pc nueva){
	       try {
	    	computadoras =this.getComputadoras();
			ObjectOutputStream salida=new ObjectOutputStream(new FileOutputStream("DataBase.obj"));
			computadoras.add(nueva);
			salida.writeObject(computadoras);
			salida.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	
}
