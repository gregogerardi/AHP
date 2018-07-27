package controller;

import model.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Controller {
    private BaseDatos baseDatos;
    private Decisor decisor;
    //TODO NUNCA USADO
    //private List<Filtro> filtros;
    private Object[] valoresBuscados;
    //TODO NUNCA USADO
    // private List<Object> datosIngresados;
    private List<Criterio> criterios;
    private List<Pc> alternativas;
    public final static boolean IGNORAR_INCONSISTENCIA = true;

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
    //TODO NUNCA USADO
/*
    public void setAlternativas(List<Pc> a) {
        alternativas = a;
    }
*/

    public Controller() {
        baseDatos = new BaseDatos();
        //    filtros = new ArrayList<>();
        //    datosIngresados = new ArrayList<>();
    }

    //TODO NUNCA USADO
    //public void setBaseDatos(BaseDatos bd) {
    //    this.baseDatos = bd;
    //}

    //TODO NUNCA USADO
    /*
    public void setCriterios(List<Criterio> criterios2) {
        this.criterios = criterios2;
    }
*/
    //TODO NUNCA USADO
    //public void setFiltros(List<Filtro> filtros) {
    //    this.filtros = filtros;
    //}
    //TODO NUNCA USADO
    //public void setDatos(List<Object> datos) {
    //    datosIngresados = datos;
    //}

    public void setValoresBuscados(Object[] valoresBuscados) {
        this.valoresBuscados = valoresBuscados;
        genCriterios();
    }

    //TODO NUNCA USADO
    //public List<Object> getDatos() {
    //   return datosIngresados;
    //}

    //TODO NUNCA USADO
    /*private List<Pc> getFiltradas() throws IOException, ClassNotFoundException {
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
    }*/

    public List<Score> buscar() throws InconsistenteException {
        return buscar(false);
    }

    public List<Score> buscar(Boolean ingorarInconsistencia) throws InconsistenteException {
        //List<Pc> opciones = this.getFiltradas(); ESTO VA
        decisor = new Decisor(recuperarPcsBase());  //CAMBIAR ALTERNATIVAS POR OPCIONES
        decisor.setCriterios(criterios);
        //ARMA LA MATRIZ DE COMPARACION DE CRITERIOS PADRES Y DE SUBCRITERIOS PONIENDOLOS EN LOS CRITERIOS COMPUESTOS
        Matriz comparacionDeCriterios = decisor.getMatrizComparacionCriterios();//SEGUIR CON ESTA MATRIZ
        if ((!comparacionDeCriterios.esConsistente()) && (!ingorarInconsistencia)) {
            throw new InconsistenteException();
        }
        //ARMA LAS MATRICES DE COMPARACIONES ENTRE ALTERNATIVAS PARA CADA CRITERIO HOJA
        decisor.compararAlternativas();
        return decisor.calcular(comparacionDeCriterios);
    }

    public void genCriterios() {
        criterios = new ArrayList<>();

        //criterios simples para busqueda avanzada
        Criterio criterioPrecio = new CriterioSimple(Globals.precio, Criterio.MINIMIZABLE);
        criterios.add(criterioPrecio);
        //criterioPrecio.setValor((Double) valoresBuscados[0]);

        Criterio criterioMarca = new CriterioSimple(Globals.marca);
        criterioMarca.setNumerico(false);
        criterios.add(criterioMarca);
        criterioMarca.setValor(valoresBuscados[0]);

        Criterio criterioProcesador = new CriterioSimple(Globals.procesador, Criterio.MAXIMISABLE);
        criterios.add(criterioProcesador);
        //criterioProcesador.setValor(((Integer) valoresBuscados[2]).doubleValue());

        Criterio criterioPeso = new CriterioSimple(Globals.peso, Criterio.MINIMIZABLE);
        criterios.add(criterioPeso);
        //criterioPeso.setValor(((Integer) valoresBuscados[3]).doubleValue());

        Criterio criterioRam = new CriterioSimple(Globals.ram, Criterio.MAXIMISABLE);
        criterios.add(criterioRam);
        //criterioRam.setValor(((Integer) valoresBuscados[4]).doubleValue());

        Criterio criterioDisco = new CriterioSimple(Globals.disco, Criterio.MAXIMISABLE);
        criterios.add(criterioDisco);
        //criterioDisco.setValor(((Integer) valoresBuscados[5]).doubleValue());

        Criterio criterioAutonomia = new CriterioSimple(Globals.autonomia, Criterio.MAXIMISABLE);
        criterios.add(criterioAutonomia);
        //criterioAutonomia.setValor(((Integer) valoresBuscados[6]).doubleValue());

        Criterio criterioPantalla = new CriterioSimple(Globals.pantalla, Criterio.SUBJETIVO);
        criterios.add(criterioPantalla);
        criterioPantalla.setValor((Double.parseDouble((String) valoresBuscados[1])));

        Criterio criterioWifi = new CriterioSimple(Globals.wifi);
        criterioWifi.setValor(valoresBuscados[2]);
        criterioWifi.setNumerico(false);

        Criterio criterioEthernet = new CriterioSimple(Globals.ethernet);
        criterioEthernet.setValor(valoresBuscados[3]);
        criterioEthernet.setNumerico(false);

        Criterio criterioHdmi = new CriterioSimple(Globals.hdmi);
        criterioHdmi.setValor(valoresBuscados[4]);
        criterioHdmi.setNumerico(false);

        Criterio criterioCddvd = new CriterioSimple(Globals.cddvd);
        criterioCddvd.setValor(valoresBuscados[5]);
        criterioCddvd.setNumerico(false);

        Criterio criterioUsb = new CriterioSimple(Globals.usb, Criterio.MAXIMISABLE);
        //criterioUsb.setValor(Double.parseDouble((String) valoresBuscados[12]));

        Criterio criterioBluethoot = new CriterioSimple(Globals.bluethoot);
        criterioBluethoot.setValor(valoresBuscados[6]);
        criterioBluethoot.setNumerico(false);

        Criterio criterioVga = new CriterioSimple(Globals.vga);
        criterioVga.setValor(valoresBuscados[7]);
        criterioVga.setNumerico(false);

        //conectividad como criterio compuesto
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

    public class InconsistenteException extends Exception {
    }

    public List<Criterio> getCriterios() {
        return criterios;
    }

    public void setComparacion(Criterio c1, Criterio c2, Double aDouble) {
        c1.setComparacion(c2, aDouble);
    }
}
