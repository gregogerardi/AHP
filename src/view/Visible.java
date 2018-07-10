package view;

import controller.Controller;

import javax.swing.*;

public abstract class Visible {
    protected JFrame frame;
    private Visible ventanaAnterior;
    protected Controller controlador;

    public void descargar() {
        this.frame.setVisible(false);
        this.frame.dispose();
    }

    public void cargar() {
        frame = new JFrame("FRAME");
        setContent();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public abstract void setContent();

    public void setVentanaAnterior(Visible ventanaAnterior) {
        this.ventanaAnterior = ventanaAnterior;
    }

    public void cambiarAAnterior() {
        ventanaAnterior.cargar();
        this.descargar();
    }
}
