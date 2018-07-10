package controller;

import model.*;
import model.filtros.Filtro;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Controller {
    private BaseDatos baseDatos;
    private Decisor decisor;
    private List<Filtro> filtros;
    private Object[] valoresBuscados;
    private List<Object> datosIngresados;
    private List<Criterio> criterios;
    private List<Pc> alternativas;

    private Pc generarPc(Object[] valores) {
        Pc pc = new Pc();
        for (int i = 0; i < Globals.atributos.length; i++) {
            pc.set(Globals.atributos[i], valores[i]);
        }
        return pc;
    }

    public boolean agregarPc(Object[] valores) {//devuelve false si la pc ya esta cargada en la base, queda horrible TODO CAMBIARLO POR UNA EXCEPCION
        Pc pc = generarPc(valores);
        try {
            if (baseDatos.contains(pc)) {
                return false;
            } else {
                try {
                    baseDatos.addComputadora(pc);
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return true;
    }

    public boolean deletePc(Object[] valores) {
        Pc pc = generarPc(valores);
        try {
            if (!baseDatos.contains(pc)) {
                return false;
            } else {
                baseDatos.deleteComputadora(pc);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return true;
    }

    public void vaciarBase() {
        try {
            baseDatos.deleteAll();
        } catch (IOException e1) {
            e1.printStackTrace();
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        }
    }

    public List<Pc> recuperarPcsBase() {
        List<Pc> pcs = new ArrayList<>();
        try {
            pcs = baseDatos.getComputadoras();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return pcs;
    }

    public void setAlternativas(List<Pc> a) {
        alternativas = a;
    }

    public Controller() {
        baseDatos = new BaseDatos();
        filtros = new ArrayList<>();
        datosIngresados = new ArrayList<>();
    }

    public void setBaseDatos(BaseDatos bd) {
        this.baseDatos = bd;
    }

    public void setCriterios(List<Criterio> criterios2) {
        this.criterios = criterios2;
    }

    public void setFiltros(List<Filtro> filtros) {
        this.filtros = filtros;
    }

    public void setDatos(List<Object> datos) {
        datosIngresados = datos;
    }

    public void setValoresBuscados(Object[] valoresBuscados) {
        this.valoresBuscados = valoresBuscados;
        genCriterios();
    }

    public List<Object> getDatos() {
        return datosIngresados;
    }

    private List<Pc> getFiltradas() throws IOException, ClassNotFoundException {
        List<Pc> computadoras = baseDatos.getComputadoras();
        List<Pc> filtradas = new ArrayList<>();
        if (filtros.size() > 0) {
            for (Pc pc : computadoras) {
                for (Filtro f : filtros) {
                    if (f.cumple(pc)) {
                        filtradas.add(pc);
                    }
                }
            }
        } else filtradas = computadoras;
        return filtradas;
    }


    public void buscar() {
        //List<Pc> opciones = this.getFiltradas(); ESTO VA
        decisor = new Decisor(recuperarPcsBase());  //CAMBIAR ALTERNATIVAS POR OPCIONES
        decisor.setCriterios(criterios);
        //ARMA LA MATRIZ DE COMPARACION DE CRITERIOS PADRES Y DE SUBCRITERIOS PONIENDOLOS EN LOS CRITERIOS COMPUESTOS
        Matriz comparacionDeCriterios = decisor.getMatrizComparacionCriterios();//SEGUIR CON ESTA MATRIZ
        //ARMA LAS MATRICES DE COMPARACIONES ENTRE ALTERNATIVAS PARA CADA CRITERIO HOJA
        decisor.compararAlternativas();

        Vector<Score> resultados = decisor.calcular(comparacionDeCriterios);
        for (Score s : resultados) {
            System.out.println(s.getNombre() + " " + s.getScore());
        }
    }

    public void genCriterios() {
        criterios = new ArrayList<>();
        //criterios simples para busqueda avanzada
        Criterio criterioPrecio = new CriterioSimple(Globals.precio);
        criterios.add(criterioPrecio);
        criterioPrecio.setValor((Double) valoresBuscados[0]);

        Criterio criterioMarca = new CriterioSimple(Globals.marca);
        criterios.add(criterioMarca);
        criterioPrecio.setValor(valoresBuscados[1]);

        Criterio criterioProcesador = new CriterioSimple(Globals.procesador);
        criterios.add(criterioProcesador);
        criterioPrecio.setValor((Double) valoresBuscados[2]);

        Criterio criterioPeso = new CriterioSimple(Globals.peso);
        criterios.add(criterioPeso);
        criterioPrecio.setValor((Double) valoresBuscados[3]);

        Criterio criterioRam = new CriterioSimple(Globals.ram);
        criterios.add(criterioRam);
        criterioPrecio.setValor((Double) valoresBuscados[4]);

        Criterio criterioDisco = new CriterioSimple(Globals.disco);
        criterios.add(criterioDisco);
        criterioPrecio.setValor((Double) valoresBuscados[5]);

        Criterio criterioAutonomia = new CriterioSimple(Globals.autonomia);
        criterios.add(criterioAutonomia);
        criterioPrecio.setValor((Double) valoresBuscados[6]);

        Criterio criterioPantalla = new CriterioSimple(Globals.pantalla);
        criterios.add(criterioPantalla);
        criterioPrecio.setValor((Double) valoresBuscados[7]);

        Criterio criterioWifi = new CriterioSimple(Globals.wifi);
        if ((Boolean) valoresBuscados[8]) {
            criterioPrecio.setValor(1.0);
        } else {
            criterioPrecio.setValor(0.0);
        }

        Criterio criterioEthernet = new CriterioSimple(Globals.ethernet);
        if ((Boolean) valoresBuscados[9]) {
            criterioEthernet.setValor(1.0);
        } else {
            criterioEthernet.setValor(0.0);
        }

        Criterio criterioHdmi = new CriterioSimple(Globals.hdmi);
        if ((Boolean) valoresBuscados[10]) {
            criterioHdmi.setValor(1.0);
        } else {
            criterioHdmi.setValor(0.0);
        }

        Criterio criterioCddvd = new CriterioSimple(Globals.cddvd);
        if ((Boolean) valoresBuscados[11]) {
            criterioCddvd.setValor(1.0);
        } else {
            criterioCddvd.setValor(0.0);
        }

        Criterio criterioUsb = new CriterioSimple(Globals.usb);
        criterioUsb.setValor((Double) valoresBuscados[12]);

        Criterio criterioBluethoot = new CriterioSimple(Globals.bluethoot);
        if ((Boolean) valoresBuscados[13]) {
            criterioBluethoot.setValor(1.0);
        } else {
            criterioBluethoot.setValor(0.0);
        }

        Criterio criterioVga = new CriterioSimple(Globals.vga);
        if ((Boolean) valoresBuscados[14]) {
            criterioVga.setValor(1.0);
        } else {
            criterioVga.setValor(0.0);
        }

        CriterioCompuesto criterioConectividad = new CriterioCompuesto(Globals.conectividad);
        criterioConectividad.addSubcriterio(criterioWifi);
        criterioConectividad.addSubcriterio(criterioEthernet);
        criterioConectividad.addSubcriterio(criterioHdmi);
        criterioConectividad.addSubcriterio(criterioCddvd);
        criterioConectividad.addSubcriterio(criterioUsb);
        criterioConectividad.addSubcriterio(criterioBluethoot);
        criterioConectividad.addSubcriterio(criterioVga);
        criterios.add(criterioConectividad);
    }

    public List<Criterio> getCriterios() {
        return criterios;
    }

    public void setComparacion(Criterio c1, Criterio c2, Double aDouble) {
        c1.setComparacion(c2, aDouble);
    }
}
