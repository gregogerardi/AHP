package view;

import controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Ayuda extends Visible {
    private JPanel AyudaMarco;
    private JScrollPane OpcionesMarco;
    private JPanel agregarEquipoContenido;
    private JLabel titulo;
    private JButton atrasButton;
    private JTextArea textAyuda;

    public Ayuda(Visible ventanaAnterior, Controller controlador) {
        this.controlador = controlador;
        setVentanaAnterior(ventanaAnterior);
        textAyuda.append("A continuacion el usuario debe valorar los distintos criterios de evaluacion\n");
        textAyuda.append("de las alternativas. Cada computadora sera valorada en base a estos criterios\n");
        textAyuda.append("global sera determinada por la importancia que el usuario le da a cada uno.\n");
        textAyuda.append("A partir de esa valoracion se ordenaran las alternativas de mayor a menor, \n");
        textAyuda.append("por ejemplo las computadoras con menor precio y mayor capacidad de \n");
        textAyuda.append("almacenamiento se ubicaran al principio del ranking.\n");
        textAyuda.append("\n");
        textAyuda.append("===================Criterios===================\n");
        textAyuda.append("\n");
        textAyuda.append("CAE (Costo Anual Equivalente): Es el costo por año de poseer\n");
        textAyuda.append("y operar un activo durante su vida entera (Anualidad)\n");
        textAyuda.append("Las computadoras con un CAE menor seran las que hagan\n");
        textAyuda.append("un uso eficiente del dinero invertido.\n");
        textAyuda.append("Procesador: Asociada a la velocidad del mismo(Ciclos por segundo)\n");
        textAyuda.append("RAM: Cantidad de memoria primaria disponible.\n");
        textAyuda.append("Disco: Capacidad o almacenamiento de archivos.\n");
        textAyuda.append("Autonomia: Duracion de la bateria.\n");
        textAyuda.append("Pantalla: Asociado al tamaño de la pantalla.\n");
        textAyuda.append("Conectividad: Un balance entre los criterios mencionados a continuacion:\n");
        textAyuda.append("*Wifi: Capacidad de conectarse a una red de Wifi.\n");
        textAyuda.append("*Ethernet: Capacidad de conectarse al cable de red\n");
        textAyuda.append("*HDMI: Capacidad de conectar por HDMI(High Definition Multimedia Interface)\n");
        textAyuda.append("*CD/DVD: Capacidad de leer discos de formato CD/DVD\n");
        textAyuda.append("*USB: Cantidad de entradas con formato 'USB' para transferencias de datos\n");
        textAyuda.append("*Bluetooth: Capacidad de conectarse a una red por Bluetooth\n");
        textAyuda.append("*VGA: Capacidad de conectar un por VGA (Video Graphics Array)\n");
        atrasButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                cambiarAAnterior();
            }
        });
    }

    @Override
    public void setContent() {
        frame.setContentPane(AyudaMarco);

    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
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
        AyudaMarco = new JPanel();
        AyudaMarco.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        OpcionesMarco = new JScrollPane();
        AyudaMarco.add(OpcionesMarco, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(500, 520), null, 0, false));
        agregarEquipoContenido = new JPanel();
        agregarEquipoContenido.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(3, 17, new Insets(0, 0, 0, 0), -1, -1));
        agregarEquipoContenido.setAutoscrolls(true);
        agregarEquipoContenido.setBackground(new Color(-1192521));
        agregarEquipoContenido.setForeground(new Color(-1192521));
        OpcionesMarco.setViewportView(agregarEquipoContenido);
        titulo = new JLabel();
        Font tituloFont = this.$$$getFont$$$(null, -1, 36, titulo.getFont());
        if (tituloFont != null) titulo.setFont(tituloFont);
        titulo.setText("¿Que debo hacer?");
        agregarEquipoContenido.add(titulo, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 15, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_NORTH, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 3, new Insets(0, 0, 0, 0), -1, -1));
        panel1.setBackground(new Color(-1192521));
        panel1.setForeground(new Color(-1192521));
        agregarEquipoContenido.add(panel1, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 17, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer1 = new com.intellij.uiDesigner.core.Spacer();
        panel1.add(spacer1, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer2 = new com.intellij.uiDesigner.core.Spacer();
        panel1.add(spacer2, new com.intellij.uiDesigner.core.GridConstraints(0, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        atrasButton = new JButton();
        atrasButton.setText("Atras");
        panel1.add(atrasButton, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        textAyuda = new JTextArea();
        textAyuda.setBackground(new Color(-1181953));
        textAyuda.setForeground(new Color(-16777216));
        textAyuda.setText("");
        textAyuda.putClientProperty("html.disable", Boolean.FALSE);
        agregarEquipoContenido.add(textAyuda, new com.intellij.uiDesigner.core.GridConstraints(1, 4, 1, 9, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(150, 50), null, 0, false));
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
        return AyudaMarco;
    }
}
