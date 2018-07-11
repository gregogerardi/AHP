package model;

import java.util.Hashtable;

public class Pc implements java.io.Serializable {
    private Hashtable<String, Object> atributos;

    @Override
    public boolean equals(Object obj) {
        return this.get(Globals.modelo).equals(((Pc) obj).get(Globals.modelo));
    }

    public Pc() {
        atributos = new Hashtable<>();
    }

    public void set(String a, Object o) {
        atributos.put(a, o);
    }

    public Object get(String a) {
        if (atributos.containsKey(a))
            return atributos.get(a);
        return null;
    }
    //TODO NUNCA USADO
    /*
    public String[] getAtts() {
        Set<String> atri = atributos.keySet();
        String[] resultado = new String[atri.size()];
        int i = 0;
        for (String s : atri) {
            resultado[i] = new String(s);
            i++;
        }
        return resultado;
    }*/
}
