package view;

import controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MenuInicial extends Visible {
    private JPanel menuInicialContenido;
    private JLabel titulo;
    private JButton botonInventario;
    private JPanel menuInicialMarco;
    private JScrollPane menuInicialScroll;
    private JButton botonBuscar;
    private JButton opcionesButton;

    public MenuInicial(Controller controlador) {
        this.controlador = controlador;
        titulo.setSize(50, 50);
        botonInventario.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                cambiarAInventario();
            }
        });
        botonBuscar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cambiarABusqueda();
            }
        });
        opcionesButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cambiarAOpciones();
            }
        });
        ImageIcon imgThisImg = new ImageIcon("images/logo PcBROWSER.png");
        titulo.setIcon(imgThisImg);

    }

    private void cambiarAOpciones() {
        new Opciones(this, controlador).cargar();
        this.descargar();
    }

    private void cambiarAInventario() {
        new Inventario(this, controlador).cargar();
        this.descargar();
    }

    private void cambiarABusqueda() {
        new BuscquedaAvanzada(this, controlador).cargar();
        this.descargar();
    }

    @Override
    public void setContent() {
        frame.setContentPane(menuInicialMarco);
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
        menuInicialMarco = new JPanel();
        menuInicialMarco.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        menuInicialScroll = new JScrollPane();
        menuInicialMarco.add(menuInicialScroll, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(600, 400), null, 0, false));
        menuInicialContenido = new JPanel();
        menuInicialContenido.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(8, 3, new Insets(0, 0, 0, 0), -1, -1));
        menuInicialContenido.setAutoscrolls(true);
        menuInicialContenido.setBackground(new Color(-1192521));
        menuInicialContenido.setForeground(new Color(-1192521));
        menuInicialScroll.setViewportView(menuInicialContenido);
        titulo = new JLabel();
        titulo.setEnabled(true);
        Font tituloFont = this.$$$getFont$$$(null, -1, 36, titulo.getFont());
        if (tituloFont != null) titulo.setFont(tituloFont);
        titulo.setText("");
        menuInicialContenido.add(titulo, new com.intellij.uiDesigner.core.GridConstraints(2, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_NORTH, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer1 = new com.intellij.uiDesigner.core.Spacer();
        menuInicialContenido.add(spacer1, new com.intellij.uiDesigner.core.GridConstraints(3, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer2 = new com.intellij.uiDesigner.core.Spacer();
        menuInicialContenido.add(spacer2, new com.intellij.uiDesigner.core.GridConstraints(7, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        botonBuscar = new JButton();
        Font botonBuscarFont = this.$$$getFont$$$(null, -1, 24, botonBuscar.getFont());
        if (botonBuscarFont != null) botonBuscar.setFont(botonBuscarFont);
        botonBuscar.setText("Realizar Busqueda");
        menuInicialContenido.add(botonBuscar, new com.intellij.uiDesigner.core.GridConstraints(6, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer3 = new com.intellij.uiDesigner.core.Spacer();
        menuInicialContenido.add(spacer3, new com.intellij.uiDesigner.core.GridConstraints(0, 2, 8, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer4 = new com.intellij.uiDesigner.core.Spacer();
        menuInicialContenido.add(spacer4, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 8, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        botonInventario = new JButton();
        Font botonInventarioFont = this.$$$getFont$$$(null, -1, 24, botonInventario.getFont());
        if (botonInventarioFont != null) botonInventario.setFont(botonInventarioFont);
        botonInventario.setText("Gestionar Inventario");
        menuInicialContenido.add(botonInventario, new com.intellij.uiDesigner.core.GridConstraints(4, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer5 = new com.intellij.uiDesigner.core.Spacer();
        menuInicialContenido.add(spacer5, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_NORTH, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 2, false));
        opcionesButton = new JButton();
        Font opcionesButtonFont = this.$$$getFont$$$(null, -1, 24, opcionesButton.getFont());
        if (opcionesButtonFont != null) opcionesButton.setFont(opcionesButtonFont);
        opcionesButton.setText("Opciones");
        menuInicialContenido.add(opcionesButton, new com.intellij.uiDesigner.core.GridConstraints(5, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer6 = new com.intellij.uiDesigner.core.Spacer();
        menuInicialContenido.add(spacer6, new com.intellij.uiDesigner.core.GridConstraints(1, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
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
        return menuInicialMarco;
    }
}
