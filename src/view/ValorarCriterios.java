package view;

import controller.Controller;
import model.Criterio;
import model.Escala;
import model.Globals;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class ValorarCriterios extends Visible {
    private JScrollPane valorarCriteriosScroll;
    private JPanel valorarCriteriosContenido;
    private JLabel titulo;
    private JPanel valorarCriterios;
    private JPanel criteriosContenedor;
    private JScrollPane criteriosContenedorScroll;
    private JPanel criteriosDatos;
    private JButton atrasButton;
    private JButton buscarButton;
    private JButton predeterminadoButton;
    private JButton ayudaButton;
    //TODO NUNCA USADO
    //private List<Criterio> criterios;

    public ValorarCriterios(Visible ventanaAnterior, Controller controlador) {
        this.controlador = controlador;
        setVentanaAnterior(ventanaAnterior);
        $$$setupUI$$$();
        atrasButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                cambiarAAnterior();
            }
        });
        buscarButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {

                cambiarAResultados();
            }
        });
        predeterminadoButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                descargar();
                new ValorarCriterios(ventanaAnterior, controlador).cargar();
            }
        });
        ayudaButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }
        });
        ayudaButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                cambiarAAyuda();
            }
        });
    }

    private void cambiarAAyuda() {
        new Ayuda(this, controlador).cargar();
        this.descargar();
    }

    private void cambiarAResultados() {
        this.descargar();
        new Resultados(this, controlador).cargar();
    }

    @Override
    public void cargar() {
        super.cargar();
        List<Criterio> criterios = controlador.getCriterios();
    }

    private void generarComparadores(List<Criterio> criterios) {
        Escala escala = new Escala();
        for (int i = 0; i < criterios.size() - 1; i++) {
            for (int j = i + 1; j < criterios.size(); j++) {
                Criterio c1 = criterios.get(i);
                Criterio c2 = criterios.get(j);
                String crit1 = c1.getNombre();
                String crit2 = c2.getNombre();
                JLabel titulo = new JLabel(crit1 + " vs " + crit2);
                titulo.setFont(new Font("Tahoma", Font.PLAIN, 18));
                JSlider s = new JSlider();
                //c1.setComparacion(c2, s);  //CADA CRITERIO TIENE UNA REFERENCIA AL SLIDER QUE LE CORRESPONDE CON OTRO CRITERIO
                //sliders.add(s); // Faltaba agregarlo a la lista de sliders
                s.setMaximum(9);
                s.setMinimum(-9);
                s.setValue(0);
                s.setSize(10, 10);
                criteriosDatos.add(titulo);
                JLabel descripcion = new JLabel(crit1 + " y " + crit2 + " son igual de importantes");
                descripcion.setFont(new Font("Tahoma", Font.PLAIN, 17));
                s.addChangeListener(new ChangeListener() {
                    @Override
                    public void stateChanged(ChangeEvent e) {
                        String texto;
                        int valor = s.getValue();
                        if (valor == 0) {
                            texto = crit1 + " y " + crit2 + " son igual de importantes";
                            controlador.setComparacion(c1, c2, (escala.get((double) valor)));
                        } else {
                            if (valor >= 1) {
                                texto = crit1 + " es " + Globals.escala[valor] + " que " + crit2;
                                controlador.setComparacion(c1, c2, (escala.get(valor / 10.0)));
                            } else {
                                texto = crit2 + " es " + Globals.escala[-valor] + " que " + crit1;
                                controlador.setComparacion(c1, c2, (1 / (escala.get(valor / 10.0))));
                            }
                        }
                        descripcion.setText(texto);
                    }
                });
                criteriosDatos.add(descripcion);
                criteriosDatos.add(s);
                controlador.setComparacion(c1, c2, (escala.get(0.0)));
            }
            List<Criterio> subcriterios = criterios.get(i).getSubcriterios();
            if (subcriterios.size() != 0) {
                this.generarComparadores(subcriterios);
            }
        }
        List<Criterio> subcriterios = criterios.get(criterios.size() - 1).getSubcriterios();
        if (subcriterios.size() != 0) {
            this.generarComparadores(subcriterios);
        }
    }

    @Override
    public void setContent() {
        frame.setContentPane(valorarCriterios);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        criteriosDatos = new JPanel();
        criteriosDatos.setLayout(new BoxLayout(criteriosDatos, BoxLayout.Y_AXIS));
        generarComparadores(controlador.getCriterios());
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
        valorarCriterios = new JPanel();
        valorarCriterios.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        valorarCriteriosScroll = new JScrollPane();
        valorarCriterios.add(valorarCriteriosScroll, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(800, 800), null, 0, false));
        valorarCriteriosContenido = new JPanel();
        valorarCriteriosContenido.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(7, 4, new Insets(0, 0, 0, 0), -1, -1));
        valorarCriteriosContenido.setAutoscrolls(true);
        valorarCriteriosContenido.setBackground(new Color(-1192521));
        valorarCriteriosContenido.setForeground(new Color(-1192521));
        valorarCriteriosScroll.setViewportView(valorarCriteriosContenido);
        titulo = new JLabel();
        Font tituloFont = this.$$$getFont$$$(null, -1, 36, titulo.getFont());
        if (tituloFont != null) titulo.setFont(tituloFont);
        titulo.setText("Comparacion de criterios");
        valorarCriteriosContenido.add(titulo, new com.intellij.uiDesigner.core.GridConstraints(1, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_NORTH, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer1 = new com.intellij.uiDesigner.core.Spacer();
        valorarCriteriosContenido.add(spacer1, new com.intellij.uiDesigner.core.GridConstraints(2, 1, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer2 = new com.intellij.uiDesigner.core.Spacer();
        valorarCriteriosContenido.add(spacer2, new com.intellij.uiDesigner.core.GridConstraints(0, 3, 3, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer3 = new com.intellij.uiDesigner.core.Spacer();
        valorarCriteriosContenido.add(spacer3, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 3, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer4 = new com.intellij.uiDesigner.core.Spacer();
        valorarCriteriosContenido.add(spacer4, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        criteriosContenedor = new JPanel();
        criteriosContenedor.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        valorarCriteriosContenido.add(criteriosContenedor, new com.intellij.uiDesigner.core.GridConstraints(3, 1, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        criteriosContenedorScroll = new JScrollPane();
        criteriosContenedor.add(criteriosContenedorScroll, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(700, 400), null, 0, false));
        criteriosContenedorScroll.setViewportView(criteriosDatos);
        final com.intellij.uiDesigner.core.Spacer spacer5 = new com.intellij.uiDesigner.core.Spacer();
        valorarCriteriosContenido.add(spacer5, new com.intellij.uiDesigner.core.GridConstraints(6, 0, 1, 4, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 7, new Insets(0, 0, 0, 0), -1, -1));
        panel1.setBackground(new Color(-1192521));
        panel1.setForeground(new Color(-1192521));
        valorarCriteriosContenido.add(panel1, new com.intellij.uiDesigner.core.GridConstraints(5, 1, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        atrasButton = new JButton();
        atrasButton.setHorizontalAlignment(0);
        atrasButton.setText("Atras");
        panel1.add(atrasButton, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_EAST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(50, -1), null, 0, false));
        buscarButton = new JButton();
        buscarButton.setText("Buscar");
        panel1.add(buscarButton, new com.intellij.uiDesigner.core.GridConstraints(0, 5, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer6 = new com.intellij.uiDesigner.core.Spacer();
        panel1.add(spacer6, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer7 = new com.intellij.uiDesigner.core.Spacer();
        panel1.add(spacer7, new com.intellij.uiDesigner.core.GridConstraints(0, 6, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        predeterminadoButton = new JButton();
        predeterminadoButton.setHorizontalAlignment(0);
        predeterminadoButton.setText("Predeterminados");
        panel1.add(predeterminadoButton, new com.intellij.uiDesigner.core.GridConstraints(0, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_EAST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(50, -1), null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer8 = new com.intellij.uiDesigner.core.Spacer();
        panel1.add(spacer8, new com.intellij.uiDesigner.core.GridConstraints(0, 4, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer9 = new com.intellij.uiDesigner.core.Spacer();
        panel1.add(spacer9, new com.intellij.uiDesigner.core.GridConstraints(0, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer10 = new com.intellij.uiDesigner.core.Spacer();
        valorarCriteriosContenido.add(spacer10, new com.intellij.uiDesigner.core.GridConstraints(4, 0, 1, 4, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        ayudaButton = new JButton();
        ayudaButton.setHorizontalAlignment(0);
        ayudaButton.setText("Ayuda");
        valorarCriteriosContenido.add(ayudaButton, new com.intellij.uiDesigner.core.GridConstraints(1, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_EAST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(50, -1), null, 0, false));
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
        return valorarCriterios;
    }
}
