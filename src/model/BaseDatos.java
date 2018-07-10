package model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BaseDatos {

    public List<Pc> getComputadoras() throws IOException, ClassNotFoundException {
        ObjectInputStream entrada = new ObjectInputStream(new FileInputStream("DataBase.obj"));
        List<Pc> computadoras;
        try {
            computadoras = (List<Pc>) entrada.readObject();
        } catch (EOFException e) {
            return new ArrayList<Pc>();
        }
        entrada.close();
        return computadoras;
    }


    public void addComputadora(Pc nueva) throws IOException, ClassNotFoundException {
        List<Pc> computadoras = this.getComputadoras();
        ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream("DataBase.obj", false));
        if (!computadoras.contains(nueva)) {
            computadoras.add(nueva);
        }
        salida.writeObject(computadoras);
        salida.close();
    }

    public void deleteComputadora(Pc pc) throws IOException, ClassNotFoundException {
        List<Pc> computadoras = this.getComputadoras();
        computadoras.remove(pc);
        ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream("DataBase.obj", false));
        salida.writeObject(computadoras);
        salida.close();
    }

    public void deleteAll() throws IOException, ClassNotFoundException {
        List<Pc> computadoras = new ArrayList<>();
        ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream("DataBase.obj", false));
        salida.writeObject(computadoras);
        salida.close();
    }

    public boolean contains(Pc pc) throws IOException, ClassNotFoundException {
        List<Pc> computadoras = this.getComputadoras();
        return computadoras.contains(pc);
    }
}
