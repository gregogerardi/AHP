package view;

import controller.Controller;
import model.CAE;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Opciones extends Visible {

    private JPanel OpcionesPanel;
    private JScrollPane OpcionesMarco;
    private JPanel agregarEquipoContenido;
    private JLabel titulo;
    private JTextField interesField;
    private JButton atrasButton;
    private JLabel textoTasa;
    private JLabel textoDepreciacion;
    private JButton ModificarButton;
    private JLabel interesActualText;
    private JLabel depreciacionActualText;
    private JTextField depreciacionField;
    private JButton depreciacionButton;

    @Override
    public void setContent() {
        frame.setContentPane(OpcionesPanel);
    }

    public Opciones(Visible ventanaAnterior, Controller controlador) {
        this.controlador = controlador;
        setVentanaAnterior(ventanaAnterior);
        interesActualText.setText(new Double(CAE.INTERES).toString());
        depreciacionActualText.setText(new Double(CAE.DEPRECIACION).toString());
        atrasButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cambiarAAnterior();
            }
        });

        ModificarButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Double tasa = 0d;
                boolean esValido = true;
                String tasaString = interesField.getText();
                try {
                    tasa = Double.parseDouble(tasaString);
                } catch (NumberFormatException n) {
                    JOptionPane.showMessageDialog(null,
                            "Error: El campo debe ser numerico, double y debe estar entre 0 y 1", "Error Massage",
                            JOptionPane.ERROR_MESSAGE);
                    interesActualText.setText("0");
                    tasa = 0d;
                    esValido = false;
                }
                if (esValido) {
                    interesActualText.setText(tasaString);
                    CAE.setINTERES(tasa);
                }
            }
        });
        depreciacionButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Double depre = 0d;
                boolean esValido = true;
                String depreString = depreciacionField.getText();
                try {
                    depre = Double.parseDouble(depreString);
                } catch (NumberFormatException n) {
                    JOptionPane.showMessageDialog(null,
                            "Error: El campo debe ser numerico, double y debe estar entre 0 y 1", "Error Massage",
                            JOptionPane.ERROR_MESSAGE);
                    depreciacionActualText.setText("0");
                    depre = 0d;
                    esValido = false;
                }
                if (esValido) {
                    depreciacionActualText.setText(depreString);
                    CAE.setDEPRECIACION(depre);
                }
            }
        });
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
        OpcionesPanel = new JPanel();
        OpcionesPanel.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        OpcionesMarco = new JScrollPane();
        OpcionesPanel.add(OpcionesMarco, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(1100, 900), null, 0, false));
        agregarEquipoContenido = new JPanel();
        agregarEquipoContenido.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(23, 15, new Insets(0, 0, 0, 0), -1, -1));
        agregarEquipoContenido.setAutoscrolls(true);
        agregarEquipoContenido.setBackground(new Color(-1192521));
        agregarEquipoContenido.setForeground(new Color(-1192521));
        OpcionesMarco.setViewportView(agregarEquipoContenido);
        titulo = new JLabel();
        Font tituloFont = this.$$$getFont$$$(null, -1, 36, titulo.getFont());
        if (tituloFont != null) titulo.setFont(tituloFont);
        titulo.setText("Opciones");
        agregarEquipoContenido.add(titulo, new com.intellij.uiDesigner.core.GridConstraints(1, 1, 1, 13, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_NORTH, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer1 = new com.intellij.uiDesigner.core.Spacer();
        agregarEquipoContenido.add(spacer1, new com.intellij.uiDesigner.core.GridConstraints(0, 14, 21, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer2 = new com.intellij.uiDesigner.core.Spacer();
        agregarEquipoContenido.add(spacer2, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 13, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer3 = new com.intellij.uiDesigner.core.Spacer();
        agregarEquipoContenido.add(spacer3, new com.intellij.uiDesigner.core.GridConstraints(4, 4, 1, 10, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final JLabel label1 = new JLabel();
        Font label1Font = this.$$$getFont$$$(null, -1, 18, label1.getFont());
        if (label1Font != null) label1.setFont(label1Font);
        label1.setHorizontalAlignment(0);
        label1.setText("");
        agregarEquipoContenido.add(label1, new com.intellij.uiDesigner.core.GridConstraints(5, 12, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(0, 33), null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer4 = new com.intellij.uiDesigner.core.Spacer();
        agregarEquipoContenido.add(spacer4, new com.intellij.uiDesigner.core.GridConstraints(12, 11, 8, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, new Dimension(50, -1), 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer5 = new com.intellij.uiDesigner.core.Spacer();
        agregarEquipoContenido.add(spacer5, new com.intellij.uiDesigner.core.GridConstraints(9, 8, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, 1, null, new Dimension(5, -1), new Dimension(5, -1), 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer6 = new com.intellij.uiDesigner.core.Spacer();
        agregarEquipoContenido.add(spacer6, new com.intellij.uiDesigner.core.GridConstraints(6, 9, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer7 = new com.intellij.uiDesigner.core.Spacer();
        agregarEquipoContenido.add(spacer7, new com.intellij.uiDesigner.core.GridConstraints(8, 1, 1, 10, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer8 = new com.intellij.uiDesigner.core.Spacer();
        agregarEquipoContenido.add(spacer8, new com.intellij.uiDesigner.core.GridConstraints(12, 6, 1, 5, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer9 = new com.intellij.uiDesigner.core.Spacer();
        agregarEquipoContenido.add(spacer9, new com.intellij.uiDesigner.core.GridConstraints(13, 8, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, 1, null, new Dimension(5, -1), new Dimension(5, -1), 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer10 = new com.intellij.uiDesigner.core.Spacer();
        agregarEquipoContenido.add(spacer10, new com.intellij.uiDesigner.core.GridConstraints(14, 1, 1, 10, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer11 = new com.intellij.uiDesigner.core.Spacer();
        agregarEquipoContenido.add(spacer11, new com.intellij.uiDesigner.core.GridConstraints(15, 8, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, 1, null, new Dimension(5, 42), new Dimension(5, -1), 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer12 = new com.intellij.uiDesigner.core.Spacer();
        agregarEquipoContenido.add(spacer12, new com.intellij.uiDesigner.core.GridConstraints(16, 5, 1, 6, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer13 = new com.intellij.uiDesigner.core.Spacer();
        agregarEquipoContenido.add(spacer13, new com.intellij.uiDesigner.core.GridConstraints(19, 8, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, 1, null, new Dimension(5, -1), new Dimension(5, -1), 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer14 = new com.intellij.uiDesigner.core.Spacer();
        agregarEquipoContenido.add(spacer14, new com.intellij.uiDesigner.core.GridConstraints(20, 1, 1, 13, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer15 = new com.intellij.uiDesigner.core.Spacer();
        agregarEquipoContenido.add(spacer15, new com.intellij.uiDesigner.core.GridConstraints(18, 1, 1, 10, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer16 = new com.intellij.uiDesigner.core.Spacer();
        agregarEquipoContenido.add(spacer16, new com.intellij.uiDesigner.core.GridConstraints(6, 12, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer17 = new com.intellij.uiDesigner.core.Spacer();
        agregarEquipoContenido.add(spacer17, new com.intellij.uiDesigner.core.GridConstraints(8, 12, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer18 = new com.intellij.uiDesigner.core.Spacer();
        agregarEquipoContenido.add(spacer18, new com.intellij.uiDesigner.core.GridConstraints(10, 12, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer19 = new com.intellij.uiDesigner.core.Spacer();
        agregarEquipoContenido.add(spacer19, new com.intellij.uiDesigner.core.GridConstraints(12, 12, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer20 = new com.intellij.uiDesigner.core.Spacer();
        agregarEquipoContenido.add(spacer20, new com.intellij.uiDesigner.core.GridConstraints(14, 12, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer21 = new com.intellij.uiDesigner.core.Spacer();
        agregarEquipoContenido.add(spacer21, new com.intellij.uiDesigner.core.GridConstraints(16, 12, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer22 = new com.intellij.uiDesigner.core.Spacer();
        agregarEquipoContenido.add(spacer22, new com.intellij.uiDesigner.core.GridConstraints(18, 12, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer23 = new com.intellij.uiDesigner.core.Spacer();
        agregarEquipoContenido.add(spacer23, new com.intellij.uiDesigner.core.GridConstraints(22, 1, 1, 13, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 3, new Insets(0, 0, 0, 0), -1, -1));
        panel1.setBackground(new Color(-1192521));
        panel1.setForeground(new Color(-1192521));
        agregarEquipoContenido.add(panel1, new com.intellij.uiDesigner.core.GridConstraints(21, 0, 1, 15, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer24 = new com.intellij.uiDesigner.core.Spacer();
        panel1.add(spacer24, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer25 = new com.intellij.uiDesigner.core.Spacer();
        panel1.add(spacer25, new com.intellij.uiDesigner.core.GridConstraints(0, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        atrasButton = new JButton();
        atrasButton.setText("Atras");
        panel1.add(atrasButton, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JPanel panel2 = new JPanel();
        panel2.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 3, new Insets(0, 0, 0, 0), -1, -1));
        panel2.setBackground(new Color(-1192521));
        panel2.setForeground(new Color(-1192521));
        agregarEquipoContenido.add(panel2, new com.intellij.uiDesigner.core.GridConstraints(3, 1, 1, 13, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer26 = new com.intellij.uiDesigner.core.Spacer();
        panel2.add(spacer26, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, 1, null, new Dimension(5, -1), new Dimension(5, -1), 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer27 = new com.intellij.uiDesigner.core.Spacer();
        panel2.add(spacer27, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer28 = new com.intellij.uiDesigner.core.Spacer();
        panel2.add(spacer28, new com.intellij.uiDesigner.core.GridConstraints(0, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer29 = new com.intellij.uiDesigner.core.Spacer();
        agregarEquipoContenido.add(spacer29, new com.intellij.uiDesigner.core.GridConstraints(2, 1, 1, 13, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        ModificarButton = new JButton();
        ModificarButton.setText("Modificar");
        agregarEquipoContenido.add(ModificarButton, new com.intellij.uiDesigner.core.GridConstraints(5, 11, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(91, 33), null, 0, false));
        final JPanel panel3 = new JPanel();
        panel3.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        panel3.setAutoscrolls(true);
        panel3.setBackground(new Color(-1192521));
        panel3.setForeground(new Color(-1192521));
        agregarEquipoContenido.add(panel3, new com.intellij.uiDesigner.core.GridConstraints(12, 1, 1, 5, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        textoTasa = new JLabel();
        Font textoTasaFont = this.$$$getFont$$$(null, -1, 18, textoTasa.getFont());
        if (textoTasaFont != null) textoTasa.setFont(textoTasaFont);
        textoTasa.setHorizontalAlignment(0);
        textoTasa.setText("Tasa de interes");
        agregarEquipoContenido.add(textoTasa, new com.intellij.uiDesigner.core.GridConstraints(5, 1, 1, 6, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(129, 33), null, 0, false));
        interesField = new JTextField();
        Font interesFieldFont = this.$$$getFont$$$(null, -1, 18, interesField.getFont());
        if (interesFieldFont != null) interesField.setFont(interesFieldFont);
        interesField.setHorizontalAlignment(0);
        interesField.setText("0.");
        agregarEquipoContenido.add(interesField, new com.intellij.uiDesigner.core.GridConstraints(5, 9, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(50, 33), null, 0, false));
        depreciacionField = new JTextField();
        Font depreciacionFieldFont = this.$$$getFont$$$(null, -1, 18, depreciacionField.getFont());
        if (depreciacionFieldFont != null) depreciacionField.setFont(depreciacionFieldFont);
        depreciacionField.setHorizontalAlignment(0);
        depreciacionField.setText("0.");
        agregarEquipoContenido.add(depreciacionField, new com.intellij.uiDesigner.core.GridConstraints(9, 9, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(50, -1), null, 0, false));
        depreciacionButton = new JButton();
        depreciacionButton.setText("Modificar");
        agregarEquipoContenido.add(depreciacionButton, new com.intellij.uiDesigner.core.GridConstraints(9, 11, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(91, 33), null, 0, false));
        interesActualText = new JLabel();
        Font interesActualTextFont = this.$$$getFont$$$(null, -1, 18, interesActualText.getFont());
        if (interesActualTextFont != null) interesActualText.setFont(interesActualTextFont);
        interesActualText.setHorizontalAlignment(0);
        interesActualText.setText("");
        agregarEquipoContenido.add(interesActualText, new com.intellij.uiDesigner.core.GridConstraints(5, 7, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(129, 33), null, 0, false));
        depreciacionActualText = new JLabel();
        Font depreciacionActualTextFont = this.$$$getFont$$$(null, -1, 18, depreciacionActualText.getFont());
        if (depreciacionActualTextFont != null) depreciacionActualText.setFont(depreciacionActualTextFont);
        depreciacionActualText.setHorizontalAlignment(0);
        depreciacionActualText.setText("");
        agregarEquipoContenido.add(depreciacionActualText, new com.intellij.uiDesigner.core.GridConstraints(9, 7, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(129, 33), null, 0, false));
        textoDepreciacion = new JLabel();
        Font textoDepreciacionFont = this.$$$getFont$$$(null, -1, 18, textoDepreciacion.getFont());
        if (textoDepreciacionFont != null) textoDepreciacion.setFont(textoDepreciacionFont);
        textoDepreciacion.setHorizontalAlignment(0);
        textoDepreciacion.setText("Depreciacion por periodo promedio");
        agregarEquipoContenido.add(textoDepreciacion, new com.intellij.uiDesigner.core.GridConstraints(9, 0, 1, 6, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
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
        return OpcionesPanel;
    }
}
