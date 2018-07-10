package test;

import controller.Controller;
import view.MenuInicial;

public class Main {
    public static void main(String[] args) {
        new MenuInicial(new Controller()).cargar();
    }
}
