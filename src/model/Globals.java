package model;

public class Globals {
    public static String modelo = "modelo";
    public static String precio = "precio";
    public static String marca = "marca";
    public static String procesador = "procesador";
    public static String peso = "peso";
    public static String ram = "ram";
    public static String disco = "disco";
    public static String autonomia = "autonomia";
    public static String pantalla = "pantalla";
    public static String conectividad = "conectividad";
    public static String wifi = "wifi";
    public static String ethernet = "ethernet";
    public static String hdmi = "hdmi";
    public static String cddvd = "CD/DVD";
    public static String usb = "USB";
    public static String bluethoot = "bluethoot";
    public static String vga = "VGA";
    public static String[] atributos = {modelo, precio, marca, procesador, peso, ram, disco, autonomia,
            pantalla, wifi, ethernet, hdmi, cddvd, usb, bluethoot, vga};
    public static String[] escala = {
            "levemente mas importante"
            , "levemente mas importante"
            , "un poco mas importante"
            , "un poco mas importante"
            , "mas importante"
            , "mas importante"
            , "mucho mas importante"
            , "mucho mas importante"
            , "extremadamente mas importante"
    };

    public static int getRango(String criterio) {
        switch (criterio) {
            case ("precio"):
                return 50000;
            case ("procesador"):
                return 4000;
            case ("peso"):
                return 5000;
            case ("ram"):
                return 32;
            case ("disco"):
                return 4096;
            case ("autonomia"):
                return 24;
            case ("pantalla"):
                return 17 - 13;
            default:
                return 1;
        }
    }
}
