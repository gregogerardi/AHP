package view;

import controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BuscquedaAvanzada extends Visible {
    private JScrollPane busquedaAvanzadaMarco;
    private JPanel busquedaAvanzadoContenido;
    private JLabel titulo;
    //private JTextField textPrecio;
    private JLabel lblMarca;
    private JComboBox comboMarca;
    /* private JSlider sliderVelocidad;
     private JLabel lblVelocidadActual;
     private JSlider sliderPeso;
     private JLabel lblPesoActual;
     private JSlider sliderRam;
     private JLabel lblRamActual;
     private JSlider sliderDisco;
     private JLabel lblDiscoActual;*/
    private JLabel lblPantalla;
    private JComboBox comboPantalla;
    private JButton atrasButton;
    private JButton siguienteButton;
    private JPanel busquedaAvanzada;

    public BuscquedaAvanzada(Visible ventanaAnterior, Controller controlador) {
        this.controlador = controlador;
        setVentanaAnterior(ventanaAnterior);

     /*   sliderVelocidad.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if (sliderVelocidad.getValue() == 0) {
                    sliderVelocidad.setValue(1);
                }
                lblVelocidadActual.setText(sliderVelocidad.getValue() + " Mhz");
            }
        });
        sliderPeso.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if (sliderPeso.getValue() == 0) {
                    sliderPeso.setValue(1);
                }
                lblPesoActual.setText(sliderPeso.getValue() + " gr");
            }
        });
        sliderRam.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if (sliderRam.getValue() == 0) {
                    sliderRam.setValue(1);
                }
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
                sliderRam.setValue(Integer.parseInt(numero));
            }
        });
        sliderDisco.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if (sliderDisco.getValue() == 0) {
                    sliderDisco.setValue(1);
                }
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
                sliderDisco.setValue(Integer.parseInt(numero));
            }
        });
        sliderAutonomia.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if (sliderAutonomia.getValue() == 0) {
                    sliderAutonomia.setValue(1);
                }
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
        });*/
        atrasButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cambiarAAnterior();
            }
        });
        siguienteButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //int precio = 0;
                //boolean valido = true;
                /*try {
                    precio = Integer.parseInt(textPrecio.getText());
                } catch (NumberFormatException n) {
                    JOptionPane.showMessageDialog(null,
                            "Error: El campo debe ser numerico y entero", "Error Massage",
                            JOptionPane.ERROR_MESSAGE);
                    textPrecio.setText("0");
                    precio = 0;
                    valido = false;
                }*/
                /*if (precio < 0) {
                    textPrecio.setText("0");
                    precio = 0;
                }
                if (precio > 50000) {
                    textPrecio.setText("50000");
                    precio = 50000;
                }*/
                //if (valido) {
                Object marca = comboMarca.getSelectedItem();
                Object[] valores = {
                        //Double.valueOf(textPrecio.getText()),//precio
                        //comboMarca.getSelectedItem(),//marca
                        marca,
                        /*sliderVelocidad.getValue(),//procesador
                        sliderPeso.getValue(),//peso
                        sliderRam.getValue(),//ram
                        sliderDisco.getValue(),//disco
                        sliderAutonomia.getValue(),//autonomia
                        */
                        comboPantalla.getSelectedItem(),//pantalla
                        true,//wifi
                        true,//ethernet
                        true,//hdmi
                        true,//cddvd
                        //comboUsb.getSelectedItem(),
                        true,//bluetooth
                        true,//vga
                };
                controlador.setValoresBuscados(valores);
                cambiarAValorarCriterios();
            }
        });
    }

    private void cambiarAValorarCriterios() {
        new ValorarCriterios(this, controlador).cargar();
        this.descargar();
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
        busquedaAvanzada.add(busquedaAvanzadaMarco, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(500, 300), null, 1, false));
        busquedaAvanzadoContenido = new JPanel();
        busquedaAvanzadoContenido.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(17, 5, new Insets(0, 0, 0, 0), -1, -1));
        busquedaAvanzadoContenido.setAutoscrolls(true);
        busquedaAvanzadoContenido.setBackground(new Color(-1192521));
        busquedaAvanzadoContenido.setForeground(new Color(-1192521));
        busquedaAvanzadaMarco.setViewportView(busquedaAvanzadoContenido);
        titulo = new JLabel();
        Font tituloFont = this.$$$getFont$$$(null, -1, 36, titulo.getFont());
        if (tituloFont != null) titulo.setFont(tituloFont);
        titulo.setText("Criterios subjetivos");
        busquedaAvanzadoContenido.add(titulo, new com.intellij.uiDesigner.core.GridConstraints(1, 1, 1, 3, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_NORTH, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer1 = new com.intellij.uiDesigner.core.Spacer();
        busquedaAvanzadoContenido.add(spacer1, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 3, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer2 = new com.intellij.uiDesigner.core.Spacer();
        busquedaAvanzadoContenido.add(spacer2, new com.intellij.uiDesigner.core.GridConstraints(2, 1, 1, 3, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
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
        busquedaAvanzadoContenido.add(comboMarca, new com.intellij.uiDesigner.core.GridConstraints(5, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(100, -1), null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer3 = new com.intellij.uiDesigner.core.Spacer();
        busquedaAvanzadoContenido.add(spacer3, new com.intellij.uiDesigner.core.GridConstraints(5, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, 1, null, new Dimension(5, -1), new Dimension(5, -1), 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer4 = new com.intellij.uiDesigner.core.Spacer();
        busquedaAvanzadoContenido.add(spacer4, new com.intellij.uiDesigner.core.GridConstraints(4, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer5 = new com.intellij.uiDesigner.core.Spacer();
        busquedaAvanzadoContenido.add(spacer5, new com.intellij.uiDesigner.core.GridConstraints(16, 1, 1, 3, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 5, new Insets(0, 0, 0, 0), -1, -1));
        panel1.setBackground(new Color(-1192521));
        panel1.setForeground(new Color(-1192521));
        busquedaAvanzadoContenido.add(panel1, new com.intellij.uiDesigner.core.GridConstraints(15, 0, 1, 5, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        atrasButton = new JButton();
        atrasButton.setHorizontalAlignment(0);
        atrasButton.setText("Atras");
        panel1.add(atrasButton, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_EAST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(50, -1), null, 0, false));
        siguienteButton = new JButton();
        siguienteButton.setText("Siguiente");
        panel1.add(siguienteButton, new com.intellij.uiDesigner.core.GridConstraints(0, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer6 = new com.intellij.uiDesigner.core.Spacer();
        panel1.add(spacer6, new com.intellij.uiDesigner.core.GridConstraints(0, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer7 = new com.intellij.uiDesigner.core.Spacer();
        panel1.add(spacer7, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer8 = new com.intellij.uiDesigner.core.Spacer();
        panel1.add(spacer8, new com.intellij.uiDesigner.core.GridConstraints(0, 4, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer9 = new com.intellij.uiDesigner.core.Spacer();
        busquedaAvanzadoContenido.add(spacer9, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 15, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer10 = new com.intellij.uiDesigner.core.Spacer();
        busquedaAvanzadoContenido.add(spacer10, new com.intellij.uiDesigner.core.GridConstraints(0, 4, 15, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        lblPantalla = new JLabel();
        Font lblPantallaFont = this.$$$getFont$$$(null, -1, 18, lblPantalla.getFont());
        if (lblPantallaFont != null) lblPantalla.setFont(lblPantallaFont);
        lblPantalla.setHorizontalAlignment(0);
        lblPantalla.setText("Pantalla: ");
        busquedaAvanzadoContenido.add(lblPantalla, new com.intellij.uiDesigner.core.GridConstraints(3, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
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
        busquedaAvanzadoContenido.add(comboPantalla, new com.intellij.uiDesigner.core.GridConstraints(3, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(100, -1), null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer11 = new com.intellij.uiDesigner.core.Spacer();
        busquedaAvanzadoContenido.add(spacer11, new com.intellij.uiDesigner.core.GridConstraints(9, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
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
