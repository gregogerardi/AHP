package view;

import controller.Controller;
import model.CAE;
import model.Globals;
import model.Pc;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Inventario extends Visible {
    private JScrollPane inventarioScroll;
    private JPanel inventarioContenido;
    private JLabel titulo;
    private JButton botonInventario;
    private JPanel inventarioMarco;
    private JPanel listado;
    private JScrollPane scrollListado;
    private JTable table1;
    private JButton botonClearDB;
    private JButton atrasButton;
    private JButton borrasSeleccionadoButton;
    //TODO NUNCA USADO
    //private JPanel listadoContenido;

    private DefaultTableModel defaultTableModel;

    public Inventario(Visible ventanaAnterior, Controller controlador) {
        this.controlador = controlador;
        setVentanaAnterior(ventanaAnterior);
        $$$setupUI$$$();
        botonClearDB.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                int rpta = JOptionPane.showConfirmDialog(null, "Desea confirmar? esto vaciara toda la base de computadoras irreversiblemente", "Confirmar borrado", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                if (rpta == 0) {
                    controlador.vaciarBase();
                    cargarTablaModel();
                    borrasSeleccionadoButton.setEnabled(false);
                    JOptionPane.showMessageDialog(null, "Vaciada Toda la Base", "Correcto", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        atrasButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cambiarAAnterior();
            }
        });
        botonInventario.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cambiarAAgregarEquipo();
            }
        });
        borrasSeleccionadoButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (borrasSeleccionadoButton.isEnabled()) {
                    int row = table1.getSelectedRow();
                    Object[] pcDatos = ((Vector) defaultTableModel.getDataVector().elementAt(row)).toArray();
                    if (controlador.deletePc(pcDatos)) {
                        JOptionPane.showMessageDialog(null, "Borrado " + pcDatos[0] + " correctamente", "Correcto", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "El modelo " + pcDatos[0] + " no se encuentra cargado", "Incorrecto", JOptionPane.ERROR_MESSAGE);
                    }
                    cargarTablaModel();
                    borrasSeleccionadoButton.setEnabled(false);
                }
            }
        });

        table1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (table1.getSelectedRow() > -1) {
                    borrasSeleccionadoButton.setEnabled(true);
                } else {
                    borrasSeleccionadoButton.setEnabled(false);
                }
            }
        });
    }

    private void cambiarAAgregarEquipo() {
        new AgregarEquipo(this, controlador).cargar();
        this.descargar();
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        defaultTableModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                //all cells false
                return false;
            }
        };
        cargarTablaModel();
        table1 = new JTable(defaultTableModel);
    }

    @Override
    public void cargar() {
        super.cargar();
        cargarTablaModel();
    }

    private void cargarTablaModel() {
        List<Pc> pcs = controlador.recuperarPcsBase();
        Object[][] data = new Object[pcs.size()][Globals.atributos.length];
        double suma = 0d;
        ArrayList<CAE> dependientes = new ArrayList<>();//PARA GUARDAR LOS QUE SE CALCULAN ULTIMOS
        for (int j = 0; j < pcs.size(); j++) {//UPDATEO LOS VALORES
            CAE caeValor = (CAE) pcs.get(j).get(Globals.cae);
            if (caeValor.isTengoDatos()) {
                //caeValor.toString();
                caeValor.calcularCae();
                suma += caeValor.getCAE();
            } else
                dependientes.add(caeValor);
        }
        int cantidad = pcs.size() - dependientes.size();
        double promedio = -1;
        if (cantidad != 0) {
            promedio = suma / cantidad;
        }
        for (CAE unCae : dependientes) {
            unCae.setCaeCalculado(promedio);
        }
        if (CAE.INTERES == 0d) {
            for (int j = 0; j < pcs.size(); j++) {//UPDATEO LOS VALORES
                CAE caeValor = (CAE) pcs.get(j).get(Globals.cae);
                caeValor.setCaeCalculado(1);
            }
        }
        System.out.println("En el inventario el promedio me dio: " + promedio);
        for (int i = 0; i < pcs.size(); i++) {
            for (int j = 0; j < Globals.atributos.length; j++) {
                data[i][j] = pcs.get(i).get(Globals.atributos[j]);
            }
        }
        defaultTableModel.setDataVector(data, Globals.atributos);
    }

    @Override
    public void setContent() {
        frame.setContentPane(inventarioMarco);
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        createUIComponents();
        inventarioMarco = new JPanel();
        inventarioMarco.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        inventarioMarco.setBackground(new Color(-3424865));
        inventarioScroll = new JScrollPane();
        inventarioMarco.add(inventarioScroll, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(800, 800), null, 1, false));
        inventarioContenido = new JPanel();
        inventarioContenido.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(11, 4, new Insets(0, 0, 0, 0), -1, -1));
        inventarioContenido.setAutoscrolls(true);
        inventarioContenido.setBackground(new Color(-1192521));
        inventarioContenido.setForeground(new Color(-1192521));
        inventarioScroll.setViewportView(inventarioContenido);
        titulo = new JLabel();
        Font tituloFont = this.$$$getFont$$$(null, -1, 36, titulo.getFont());
        if (tituloFont != null) titulo.setFont(tituloFont);
        titulo.setText("Gestionar Inventario");
        inventarioContenido.add(titulo, new com.intellij.uiDesigner.core.GridConstraints(1, 1, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_NORTH, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer1 = new com.intellij.uiDesigner.core.Spacer();
        inventarioContenido.add(spacer1, new com.intellij.uiDesigner.core.GridConstraints(0, 3, 11, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer2 = new com.intellij.uiDesigner.core.Spacer();
        inventarioContenido.add(spacer2, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 11, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        botonInventario = new JButton();
        Font botonInventarioFont = this.$$$getFont$$$(null, -1, 24, botonInventario.getFont());
        if (botonInventarioFont != null) botonInventario.setFont(botonInventarioFont);
        botonInventario.setText("Agregar equipo");
        inventarioContenido.add(botonInventario, new com.intellij.uiDesigner.core.GridConstraints(7, 1, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer3 = new com.intellij.uiDesigner.core.Spacer();
        inventarioContenido.add(spacer3, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        listado = new JPanel();
        listado.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        inventarioContenido.add(listado, new com.intellij.uiDesigner.core.GridConstraints(3, 1, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        scrollListado = new JScrollPane();
        listado.add(scrollListado, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        table1.setAutoCreateRowSorter(true);
        table1.setAutoResizeMode(0);
        table1.setEnabled(true);
        table1.setShowHorizontalLines(true);
        scrollListado.setViewportView(table1);
        final com.intellij.uiDesigner.core.Spacer spacer4 = new com.intellij.uiDesigner.core.Spacer();
        inventarioContenido.add(spacer4, new com.intellij.uiDesigner.core.GridConstraints(2, 1, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        botonClearDB = new JButton();
        Font botonClearDBFont = this.$$$getFont$$$(null, -1, 24, botonClearDB.getFont());
        if (botonClearDBFont != null) botonClearDB.setFont(botonClearDBFont);
        botonClearDB.setText("Vaciar Base De Datos");
        inventarioContenido.add(botonClearDB, new com.intellij.uiDesigner.core.GridConstraints(5, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer5 = new com.intellij.uiDesigner.core.Spacer();
        inventarioContenido.add(spacer5, new com.intellij.uiDesigner.core.GridConstraints(4, 1, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer6 = new com.intellij.uiDesigner.core.Spacer();
        inventarioContenido.add(spacer6, new com.intellij.uiDesigner.core.GridConstraints(6, 1, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        atrasButton = new JButton();
        Font atrasButtonFont = this.$$$getFont$$$(null, -1, 24, atrasButton.getFont());
        if (atrasButtonFont != null) atrasButton.setFont(atrasButtonFont);
        atrasButton.setText("Atras");
        inventarioContenido.add(atrasButton, new com.intellij.uiDesigner.core.GridConstraints(9, 1, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer7 = new com.intellij.uiDesigner.core.Spacer();
        inventarioContenido.add(spacer7, new com.intellij.uiDesigner.core.GridConstraints(8, 1, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer8 = new com.intellij.uiDesigner.core.Spacer();
        inventarioContenido.add(spacer8, new com.intellij.uiDesigner.core.GridConstraints(10, 1, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        borrasSeleccionadoButton = new JButton();
        borrasSeleccionadoButton.setEnabled(false);
        Font borrasSeleccionadoButtonFont = this.$$$getFont$$$(null, -1, 24, borrasSeleccionadoButton.getFont());
        if (borrasSeleccionadoButtonFont != null) borrasSeleccionadoButton.setFont(borrasSeleccionadoButtonFont);
        borrasSeleccionadoButton.setText("Borrar seleccionado");
        inventarioContenido.add(borrasSeleccionadoButton, new com.intellij.uiDesigner.core.GridConstraints(5, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    private Font $$$getFont$$$(String fontName, int style, int size, Font currentFont) {
        if (currentFont == null) return null;
        String resultName;
        if (fontName == null) {
            resultName = currentFont.getName();
        } else {
            Font testFont = new Font(fontName, Font.PLAIN, 10);
            if (testFont.canDisplay('a') && testFont.canDisplay('1')) {
                resultName = fontName;
            } else {
                resultName = currentFont.getName();
            }
        }
        return new Font(resultName, style >= 0 ? style : currentFont.getStyle(), size >= 0 ? size : currentFont.getSize());
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return inventarioMarco;
    }
}

