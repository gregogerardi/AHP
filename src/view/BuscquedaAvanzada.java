package view;

import controller.Controller;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BuscquedaAvanzada extends Visible {
    private JScrollPane busquedaAvanzadaMarco;
    private JPanel busquedaAvanzadoContenido;
    private JLabel titulo;
    private JLabel lblPrecio;
    private JTextField textPrecio;
    private JLabel lblMarca;
    private JComboBox comboMarca;
    private JLabel lblVelocidad;
    private JSlider sliderVelocidad;
    private JLabel lblVelocidadActual;
    private JLabel lblPeso;
    private JSlider sliderPeso;
    private JLabel lblPesoActual;
    private JLabel lblCapacidad;
    private JSlider sliderRam;
    private JLabel lblRamActual;
    private JLabel lblDisco;
    private JSlider sliderDisco;
    private JLabel lblDiscoActual;
    private JLabel lblPantalla;
    private JComboBox comboPantalla;
    private JLabel lblAutonomia;
    private JSlider sliderAutonomia;
    private JLabel lblAutonomiaActual;
    private JRadioButton radioWifi;
    private JRadioButton radioEthernet;
    private JRadioButton radioHdmi;
    private JRadioButton radioUsb;
    private JRadioButton radioBluethoot;
    private JRadioButton radioVGA;
    private JComboBox comboUsb;
    private JRadioButton radioCDDVD;
    private JButton atrasButton;
    private JButton siguienteButton;
    private JPanel busquedaAvanzada;

    public BuscquedaAvanzada(Visible ventanaAnterior, Controller controlador) {
        this.controlador = controlador;
        setVentanaAnterior(ventanaAnterior);

        sliderVelocidad.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                lblVelocidadActual.setText(sliderVelocidad.getValue() + " Mhz");
            }
        });
        sliderPeso.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                lblPesoActual.setText(sliderPeso.getValue() + " gr");
            }
        });
        sliderRam.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int valor = sliderRam.getValue();
                String numero = "";
                if (valor <= 0) {
                    numero = "0";
                } else if (valor <= 1) {
                    numero = "1";
                } else if (valor <= 3) {
                    numero = "2";
                } else if (valor <= 6) {
                    numero = "4";
                } else if (valor <= 12) {
                    numero = "8";
                } else if (valor <= 20) {
                    numero = "16";
                } else if (valor <= 32) {
                    numero = "32";
                }
                lblRamActual.setText(numero + " Gb");
            }
        });
        sliderDisco.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int valor = sliderDisco.getValue();
                String numero = "";
                if (valor <= 0) {
                    numero = "0";
                } else if (valor <= 200) {
                    numero = "128";
                } else if (valor <= 350) {
                    numero = "256";
                } else if (valor <= 750) {
                    numero = "512";
                } else if (valor <= 1500) {
                    numero = "1024";
                } else if (valor <= 3000) {
                    numero = "2048";
                } else if (valor <= 4096) {
                    numero = "4096";
                }
                lblDiscoActual.setText(numero + " Gb");
            }
        });
        sliderAutonomia.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                lblAutonomiaActual.setText(sliderAutonomia.getValue() + " Hs");
            }
        });
        radioUsb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (radioUsb.isSelected()) {
                    comboUsb.setEnabled(true);
                    comboUsb.setSelectedIndex(0);
                } else {
                    comboUsb.setSelectedIndex(0);
                    comboUsb.setEnabled(false);
                }
            }
        });
        atrasButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                cambiarAAnterior();
            }
        });
        siguienteButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                Object[] valores = {
                        Double.valueOf(textPrecio.getText()),//precio
                        comboMarca.getSelectedItem(),//marca
                        sliderVelocidad.getValue(),//procesador
                        sliderPeso.getValue(),//peso
                        sliderRam.getValue(),//ram
                        sliderDisco.getValue(),//disco
                        sliderAutonomia.getValue(),//autonomia
                        comboPantalla.getSelectedItem(),//pantalla
                        radioWifi.isSelected(),//wifi
                        radioEthernet.isSelected(),
                        radioHdmi.isSelected(),
                        radioCDDVD.isSelected(),
                        comboUsb.getSelectedItem(),
                        radioBluethoot.isSelected(),
                        radioVGA.isSelected(),
                };
                controlador.setValoresBuscados(valores);
                cambiarAValorarCriterios();
            }
        });
    }

    private void cambiarAValorarCriterios() {

    }

    @Override
    public void setContent() {
        frame.setContentPane(busquedaAvanzada);
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        busquedaAvanzada = new JPanel();
        busquedaAvanzada.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        busquedaAvanzadaMarco = new JScrollPane();
        busquedaAvanzada.add(busquedaAvanzadaMarco, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(1100, 900), null, 0, false));
        busquedaAvanzadoContenido = new JPanel();
        busquedaAvanzadoContenido.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(21, 9, new Insets(0, 0, 0, 0), -1, -1));
        busquedaAvanzadoContenido.setAutoscrolls(true);
        busquedaAvanzadoContenido.setBackground(new Color(-1192521));
        busquedaAvanzadoContenido.setForeground(new Color(-1192521));
        busquedaAvanzadaMarco.setViewportView(busquedaAvanzadoContenido);
        titulo = new JLabel();
        Font tituloFont = this.$$$getFont$$$(null, -1, 36, titulo.getFont());
        if (tituloFont != null) titulo.setFont(tituloFont);
        titulo.setText("Busqueda Avanzada");
        busquedaAvanzadoContenido.add(titulo, new com.intellij.uiDesigner.core.GridConstraints(1, 1, 1, 7, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_NORTH, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer1 = new com.intellij.uiDesigner.core.Spacer();
        busquedaAvanzadoContenido.add(spacer1, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 7, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        lblPrecio = new JLabel();
        Font lblPrecioFont = this.$$$getFont$$$(null, -1, 18, lblPrecio.getFont());
        if (lblPrecioFont != null) lblPrecio.setFont(lblPrecioFont);
        lblPrecio.setHorizontalAlignment(0);
        lblPrecio.setText("Precio:");
        busquedaAvanzadoContenido.add(lblPrecio, new com.intellij.uiDesigner.core.GridConstraints(3, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        textPrecio = new JTextField();
        Font textPrecioFont = this.$$$getFont$$$(null, -1, 18, textPrecio.getFont());
        if (textPrecioFont != null) textPrecio.setFont(textPrecioFont);
        textPrecio.setHorizontalAlignment(0);
        textPrecio.setText("0.0");
        busquedaAvanzadoContenido.add(textPrecio, new com.intellij.uiDesigner.core.GridConstraints(3, 3, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(100, -1), null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer2 = new com.intellij.uiDesigner.core.Spacer();
        busquedaAvanzadoContenido.add(spacer2, new com.intellij.uiDesigner.core.GridConstraints(3, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, 1, null, new Dimension(5, -1), new Dimension(5, -1), 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer3 = new com.intellij.uiDesigner.core.Spacer();
        busquedaAvanzadoContenido.add(spacer3, new com.intellij.uiDesigner.core.GridConstraints(2, 1, 1, 7, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final JLabel label1 = new JLabel();
        Font label1Font = this.$$$getFont$$$(null, -1, 18, label1.getFont());
        if (label1Font != null) label1.setFont(label1Font);
        label1.setHorizontalAlignment(0);
        label1.setText("Conectividad:");
        busquedaAvanzadoContenido.add(label1, new com.intellij.uiDesigner.core.GridConstraints(3, 6, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        lblMarca = new JLabel();
        Font lblMarcaFont = this.$$$getFont$$$(null, -1, 18, lblMarca.getFont());
        if (lblMarcaFont != null) lblMarca.setFont(lblMarcaFont);
        lblMarca.setHorizontalAlignment(0);
        lblMarca.setText("Marca:");
        busquedaAvanzadoContenido.add(lblMarca, new com.intellij.uiDesigner.core.GridConstraints(5, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        comboMarca = new JComboBox();
        Font comboMarcaFont = this.$$$getFont$$$(null, -1, 18, comboMarca.getFont());
        if (comboMarcaFont != null) comboMarca.setFont(comboMarcaFont);
        final DefaultComboBoxModel defaultComboBoxModel1 = new DefaultComboBoxModel();
        defaultComboBoxModel1.addElement("Cualquiera");
        defaultComboBoxModel1.addElement("Acer");
        defaultComboBoxModel1.addElement("Compaq");
        defaultComboBoxModel1.addElement("Dell");
        defaultComboBoxModel1.addElement("HP");
        defaultComboBoxModel1.addElement("Lenovo");
        defaultComboBoxModel1.addElement("Mac");
        defaultComboBoxModel1.addElement("Samsung");
        defaultComboBoxModel1.addElement("Asus");
        comboMarca.setModel(defaultComboBoxModel1);
        busquedaAvanzadoContenido.add(comboMarca, new com.intellij.uiDesigner.core.GridConstraints(5, 3, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(100, -1), null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer4 = new com.intellij.uiDesigner.core.Spacer();
        busquedaAvanzadoContenido.add(spacer4, new com.intellij.uiDesigner.core.GridConstraints(5, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, 1, null, new Dimension(5, -1), new Dimension(5, -1), 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer5 = new com.intellij.uiDesigner.core.Spacer();
        busquedaAvanzadoContenido.add(spacer5, new com.intellij.uiDesigner.core.GridConstraints(10, 5, 8, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, new Dimension(50, -1), 0, false));
        lblVelocidad = new JLabel();
        Font lblVelocidadFont = this.$$$getFont$$$(null, -1, 18, lblVelocidad.getFont());
        if (lblVelocidadFont != null) lblVelocidad.setFont(lblVelocidadFont);
        lblVelocidad.setHorizontalAlignment(0);
        lblVelocidad.setText("Procesador");
        busquedaAvanzadoContenido.add(lblVelocidad, new com.intellij.uiDesigner.core.GridConstraints(7, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        sliderVelocidad = new JSlider();
        Font sliderVelocidadFont = this.$$$getFont$$$(null, -1, 10, sliderVelocidad.getFont());
        if (sliderVelocidadFont != null) sliderVelocidad.setFont(sliderVelocidadFont);
        sliderVelocidad.setMajorTickSpacing(2000);
        sliderVelocidad.setMaximum(4000);
        sliderVelocidad.setMinorTickSpacing(1000);
        sliderVelocidad.setPaintLabels(true);
        sliderVelocidad.setPaintTicks(true);
        busquedaAvanzadoContenido.add(sliderVelocidad, new com.intellij.uiDesigner.core.GridConstraints(7, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(100, -1), null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer6 = new com.intellij.uiDesigner.core.Spacer();
        busquedaAvanzadoContenido.add(spacer6, new com.intellij.uiDesigner.core.GridConstraints(7, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, 1, null, new Dimension(5, -1), new Dimension(5, -1), 0, false));
        lblVelocidadActual = new JLabel();
        Font lblVelocidadActualFont = this.$$$getFont$$$(null, -1, 18, lblVelocidadActual.getFont());
        if (lblVelocidadActualFont != null) lblVelocidadActual.setFont(lblVelocidadActualFont);
        lblVelocidadActual.setHorizontalAlignment(0);
        lblVelocidadActual.setText("0 Mhz");
        busquedaAvanzadoContenido.add(lblVelocidadActual, new com.intellij.uiDesigner.core.GridConstraints(7, 4, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(120, -1), null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer7 = new com.intellij.uiDesigner.core.Spacer();
        busquedaAvanzadoContenido.add(spacer7, new com.intellij.uiDesigner.core.GridConstraints(4, 3, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer8 = new com.intellij.uiDesigner.core.Spacer();
        busquedaAvanzadoContenido.add(spacer8, new com.intellij.uiDesigner.core.GridConstraints(6, 1, 1, 4, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        lblPeso = new JLabel();
        Font lblPesoFont = this.$$$getFont$$$(null, -1, 18, lblPeso.getFont());
        if (lblPesoFont != null) lblPeso.setFont(lblPesoFont);
        lblPeso.setHorizontalAlignment(0);
        lblPeso.setText("Peso:");
        busquedaAvanzadoContenido.add(lblPeso, new com.intellij.uiDesigner.core.GridConstraints(9, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 1, false));
        sliderPeso = new JSlider();
        Font sliderPesoFont = this.$$$getFont$$$(null, -1, 10, sliderPeso.getFont());
        if (sliderPesoFont != null) sliderPeso.setFont(sliderPesoFont);
        sliderPeso.setMajorTickSpacing(2500);
        sliderPeso.setMaximum(5000);
        sliderPeso.setMinorTickSpacing(500);
        sliderPeso.setPaintLabels(true);
        sliderPeso.setPaintTicks(true);
        busquedaAvanzadoContenido.add(sliderPeso, new com.intellij.uiDesigner.core.GridConstraints(9, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(100, -1), null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer9 = new com.intellij.uiDesigner.core.Spacer();
        busquedaAvanzadoContenido.add(spacer9, new com.intellij.uiDesigner.core.GridConstraints(9, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, 1, null, new Dimension(5, -1), new Dimension(5, -1), 0, false));
        lblPesoActual = new JLabel();
        Font lblPesoActualFont = this.$$$getFont$$$(null, -1, 18, lblPesoActual.getFont());
        if (lblPesoActualFont != null) lblPesoActual.setFont(lblPesoActualFont);
        lblPesoActual.setHorizontalAlignment(0);
        lblPesoActual.setText("0 gr");
        busquedaAvanzadoContenido.add(lblPesoActual, new com.intellij.uiDesigner.core.GridConstraints(9, 4, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(120, -1), null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer10 = new com.intellij.uiDesigner.core.Spacer();
        busquedaAvanzadoContenido.add(spacer10, new com.intellij.uiDesigner.core.GridConstraints(10, 1, 1, 4, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer11 = new com.intellij.uiDesigner.core.Spacer();
        busquedaAvanzadoContenido.add(spacer11, new com.intellij.uiDesigner.core.GridConstraints(8, 1, 1, 4, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        lblCapacidad = new JLabel();
        Font lblCapacidadFont = this.$$$getFont$$$(null, -1, 18, lblCapacidad.getFont());
        if (lblCapacidadFont != null) lblCapacidad.setFont(lblCapacidadFont);
        lblCapacidad.setHorizontalAlignment(0);
        lblCapacidad.setText("Ram:");
        busquedaAvanzadoContenido.add(lblCapacidad, new com.intellij.uiDesigner.core.GridConstraints(11, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        sliderRam = new JSlider();
        Font sliderRamFont = this.$$$getFont$$$(null, -1, 10, sliderRam.getFont());
        if (sliderRamFont != null) sliderRam.setFont(sliderRamFont);
        sliderRam.setMajorTickSpacing(8);
        sliderRam.setMaximum(32);
        sliderRam.setMinimum(0);
        sliderRam.setMinorTickSpacing(4);
        sliderRam.setPaintLabels(true);
        sliderRam.setPaintTicks(true);
        sliderRam.setValue(0);
        busquedaAvanzadoContenido.add(sliderRam, new com.intellij.uiDesigner.core.GridConstraints(11, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(100, -1), null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer12 = new com.intellij.uiDesigner.core.Spacer();
        busquedaAvanzadoContenido.add(spacer12, new com.intellij.uiDesigner.core.GridConstraints(11, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, 1, null, new Dimension(5, -1), new Dimension(5, -1), 0, false));
        lblRamActual = new JLabel();
        Font lblRamActualFont = this.$$$getFont$$$(null, -1, 18, lblRamActual.getFont());
        if (lblRamActualFont != null) lblRamActual.setFont(lblRamActualFont);
        lblRamActual.setHorizontalAlignment(0);
        lblRamActual.setText("0 Gb");
        busquedaAvanzadoContenido.add(lblRamActual, new com.intellij.uiDesigner.core.GridConstraints(11, 4, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(120, -1), null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer13 = new com.intellij.uiDesigner.core.Spacer();
        busquedaAvanzadoContenido.add(spacer13, new com.intellij.uiDesigner.core.GridConstraints(12, 1, 1, 4, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        lblDisco = new JLabel();
        Font lblDiscoFont = this.$$$getFont$$$(null, -1, 18, lblDisco.getFont());
        if (lblDiscoFont != null) lblDisco.setFont(lblDiscoFont);
        lblDisco.setHorizontalAlignment(0);
        lblDisco.setText("Disco:");
        busquedaAvanzadoContenido.add(lblDisco, new com.intellij.uiDesigner.core.GridConstraints(13, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(38, 42), null, 0, false));
        sliderDisco = new JSlider();
        Font sliderDiscoFont = this.$$$getFont$$$(null, -1, 10, sliderDisco.getFont());
        if (sliderDiscoFont != null) sliderDisco.setFont(sliderDiscoFont);
        sliderDisco.setMajorTickSpacing(2048);
        sliderDisco.setMaximum(4096);
        sliderDisco.setMinimum(0);
        sliderDisco.setMinorTickSpacing(256);
        sliderDisco.setPaintLabels(true);
        sliderDisco.setPaintTicks(true);
        sliderDisco.setValue(0);
        busquedaAvanzadoContenido.add(sliderDisco, new com.intellij.uiDesigner.core.GridConstraints(13, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(100, 42), null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer14 = new com.intellij.uiDesigner.core.Spacer();
        busquedaAvanzadoContenido.add(spacer14, new com.intellij.uiDesigner.core.GridConstraints(13, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, 1, null, new Dimension(5, 42), new Dimension(5, -1), 0, false));
        lblDiscoActual = new JLabel();
        Font lblDiscoActualFont = this.$$$getFont$$$(null, -1, 18, lblDiscoActual.getFont());
        if (lblDiscoActualFont != null) lblDiscoActual.setFont(lblDiscoActualFont);
        lblDiscoActual.setHorizontalAlignment(0);
        lblDiscoActual.setText("0 Gb");
        busquedaAvanzadoContenido.add(lblDiscoActual, new com.intellij.uiDesigner.core.GridConstraints(13, 4, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(120, 42), null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer15 = new com.intellij.uiDesigner.core.Spacer();
        busquedaAvanzadoContenido.add(spacer15, new com.intellij.uiDesigner.core.GridConstraints(14, 1, 1, 4, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        lblPantalla = new JLabel();
        Font lblPantallaFont = this.$$$getFont$$$(null, -1, 18, lblPantalla.getFont());
        if (lblPantallaFont != null) lblPantalla.setFont(lblPantallaFont);
        lblPantalla.setHorizontalAlignment(0);
        lblPantalla.setText("Pantalla: ");
        busquedaAvanzadoContenido.add(lblPantalla, new com.intellij.uiDesigner.core.GridConstraints(17, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        comboPantalla = new JComboBox();
        Font comboPantallaFont = this.$$$getFont$$$(null, -1, 18, comboPantalla.getFont());
        if (comboPantallaFont != null) comboPantalla.setFont(comboPantallaFont);
        final DefaultComboBoxModel defaultComboBoxModel2 = new DefaultComboBoxModel();
        defaultComboBoxModel2.addElement("13");
        defaultComboBoxModel2.addElement("13.5");
        defaultComboBoxModel2.addElement("14");
        defaultComboBoxModel2.addElement("14.5");
        defaultComboBoxModel2.addElement("15");
        defaultComboBoxModel2.addElement("15.5");
        defaultComboBoxModel2.addElement("16");
        defaultComboBoxModel2.addElement("16.5");
        defaultComboBoxModel2.addElement("17");
        comboPantalla.setModel(defaultComboBoxModel2);
        busquedaAvanzadoContenido.add(comboPantalla, new com.intellij.uiDesigner.core.GridConstraints(17, 3, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(100, -1), null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer16 = new com.intellij.uiDesigner.core.Spacer();
        busquedaAvanzadoContenido.add(spacer16, new com.intellij.uiDesigner.core.GridConstraints(17, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, 1, null, new Dimension(5, -1), new Dimension(5, -1), 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer17 = new com.intellij.uiDesigner.core.Spacer();
        busquedaAvanzadoContenido.add(spacer17, new com.intellij.uiDesigner.core.GridConstraints(18, 1, 1, 7, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        lblAutonomia = new JLabel();
        Font lblAutonomiaFont = this.$$$getFont$$$(null, -1, 18, lblAutonomia.getFont());
        if (lblAutonomiaFont != null) lblAutonomia.setFont(lblAutonomiaFont);
        lblAutonomia.setHorizontalAlignment(0);
        lblAutonomia.setText("Autonomía:");
        busquedaAvanzadoContenido.add(lblAutonomia, new com.intellij.uiDesigner.core.GridConstraints(15, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(38, 42), null, 0, false));
        sliderAutonomia = new JSlider();
        Font sliderAutonomiaFont = this.$$$getFont$$$(null, -1, 10, sliderAutonomia.getFont());
        if (sliderAutonomiaFont != null) sliderAutonomia.setFont(sliderAutonomiaFont);
        sliderAutonomia.setMajorTickSpacing(6);
        sliderAutonomia.setMaximum(24);
        sliderAutonomia.setMinimum(0);
        sliderAutonomia.setMinorTickSpacing(0);
        sliderAutonomia.setPaintLabels(true);
        sliderAutonomia.setPaintTicks(true);
        sliderAutonomia.setValue(0);
        busquedaAvanzadoContenido.add(sliderAutonomia, new com.intellij.uiDesigner.core.GridConstraints(15, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(100, 42), null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer18 = new com.intellij.uiDesigner.core.Spacer();
        busquedaAvanzadoContenido.add(spacer18, new com.intellij.uiDesigner.core.GridConstraints(15, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, 1, null, new Dimension(5, 42), new Dimension(5, -1), 0, false));
        lblAutonomiaActual = new JLabel();
        Font lblAutonomiaActualFont = this.$$$getFont$$$(null, -1, 18, lblAutonomiaActual.getFont());
        if (lblAutonomiaActualFont != null) lblAutonomiaActual.setFont(lblAutonomiaActualFont);
        lblAutonomiaActual.setHorizontalAlignment(0);
        lblAutonomiaActual.setText("0 Hs");
        busquedaAvanzadoContenido.add(lblAutonomiaActual, new com.intellij.uiDesigner.core.GridConstraints(15, 4, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(120, 42), null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer19 = new com.intellij.uiDesigner.core.Spacer();
        busquedaAvanzadoContenido.add(spacer19, new com.intellij.uiDesigner.core.GridConstraints(16, 1, 1, 4, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        radioWifi = new JRadioButton();
        radioWifi.setText("WiFi");
        busquedaAvanzadoContenido.add(radioWifi, new com.intellij.uiDesigner.core.GridConstraints(5, 6, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer20 = new com.intellij.uiDesigner.core.Spacer();
        busquedaAvanzadoContenido.add(spacer20, new com.intellij.uiDesigner.core.GridConstraints(4, 6, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        radioEthernet = new JRadioButton();
        radioEthernet.setText("Ethernet");
        busquedaAvanzadoContenido.add(radioEthernet, new com.intellij.uiDesigner.core.GridConstraints(7, 6, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer21 = new com.intellij.uiDesigner.core.Spacer();
        busquedaAvanzadoContenido.add(spacer21, new com.intellij.uiDesigner.core.GridConstraints(6, 6, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        radioHdmi = new JRadioButton();
        radioHdmi.setText("Hdmi");
        busquedaAvanzadoContenido.add(radioHdmi, new com.intellij.uiDesigner.core.GridConstraints(9, 6, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer22 = new com.intellij.uiDesigner.core.Spacer();
        busquedaAvanzadoContenido.add(spacer22, new com.intellij.uiDesigner.core.GridConstraints(8, 6, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer23 = new com.intellij.uiDesigner.core.Spacer();
        busquedaAvanzadoContenido.add(spacer23, new com.intellij.uiDesigner.core.GridConstraints(10, 6, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        radioUsb = new JRadioButton();
        radioUsb.setText("USB");
        busquedaAvanzadoContenido.add(radioUsb, new com.intellij.uiDesigner.core.GridConstraints(13, 6, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer24 = new com.intellij.uiDesigner.core.Spacer();
        busquedaAvanzadoContenido.add(spacer24, new com.intellij.uiDesigner.core.GridConstraints(12, 6, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        radioBluethoot = new JRadioButton();
        radioBluethoot.setText("Bluethoot");
        busquedaAvanzadoContenido.add(radioBluethoot, new com.intellij.uiDesigner.core.GridConstraints(15, 6, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer25 = new com.intellij.uiDesigner.core.Spacer();
        busquedaAvanzadoContenido.add(spacer25, new com.intellij.uiDesigner.core.GridConstraints(14, 6, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        radioVGA = new JRadioButton();
        radioVGA.setText("VGA");
        busquedaAvanzadoContenido.add(radioVGA, new com.intellij.uiDesigner.core.GridConstraints(17, 6, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer26 = new com.intellij.uiDesigner.core.Spacer();
        busquedaAvanzadoContenido.add(spacer26, new com.intellij.uiDesigner.core.GridConstraints(16, 6, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        comboUsb = new JComboBox();
        comboUsb.setEnabled(false);
        Font comboUsbFont = this.$$$getFont$$$(null, -1, 18, comboUsb.getFont());
        if (comboUsbFont != null) comboUsb.setFont(comboUsbFont);
        final DefaultComboBoxModel defaultComboBoxModel3 = new DefaultComboBoxModel();
        defaultComboBoxModel3.addElement("0");
        defaultComboBoxModel3.addElement("1");
        defaultComboBoxModel3.addElement("2");
        defaultComboBoxModel3.addElement("3");
        defaultComboBoxModel3.addElement("4");
        defaultComboBoxModel3.addElement("5");
        defaultComboBoxModel3.addElement("6");
        comboUsb.setModel(defaultComboBoxModel3);
        busquedaAvanzadoContenido.add(comboUsb, new com.intellij.uiDesigner.core.GridConstraints(13, 7, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(100, -1), null, 0, false));
        radioCDDVD = new JRadioButton();
        radioCDDVD.setText("CD/DVD");
        busquedaAvanzadoContenido.add(radioCDDVD, new com.intellij.uiDesigner.core.GridConstraints(11, 6, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer27 = new com.intellij.uiDesigner.core.Spacer();
        busquedaAvanzadoContenido.add(spacer27, new com.intellij.uiDesigner.core.GridConstraints(20, 1, 1, 7, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 5, new Insets(0, 0, 0, 0), -1, -1));
        panel1.setBackground(new Color(-1192521));
        panel1.setForeground(new Color(-1192521));
        busquedaAvanzadoContenido.add(panel1, new com.intellij.uiDesigner.core.GridConstraints(19, 0, 1, 9, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        atrasButton = new JButton();
        atrasButton.setHorizontalAlignment(0);
        atrasButton.setText("Atras");
        panel1.add(atrasButton, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_EAST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(50, -1), null, 0, false));
        siguienteButton = new JButton();
        siguienteButton.setText("Siguiente");
        panel1.add(siguienteButton, new com.intellij.uiDesigner.core.GridConstraints(0, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer28 = new com.intellij.uiDesigner.core.Spacer();
        panel1.add(spacer28, new com.intellij.uiDesigner.core.GridConstraints(0, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer29 = new com.intellij.uiDesigner.core.Spacer();
        panel1.add(spacer29, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer30 = new com.intellij.uiDesigner.core.Spacer();
        panel1.add(spacer30, new com.intellij.uiDesigner.core.GridConstraints(0, 4, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer31 = new com.intellij.uiDesigner.core.Spacer();
        busquedaAvanzadoContenido.add(spacer31, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 19, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer32 = new com.intellij.uiDesigner.core.Spacer();
        busquedaAvanzadoContenido.add(spacer32, new com.intellij.uiDesigner.core.GridConstraints(0, 8, 19, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
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
        return busquedaAvanzada;
    }
}
