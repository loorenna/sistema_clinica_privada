package util;

public class Validador {

    public static boolean textoVacio(String texto) {
        return texto == null || texto.trim().isEmpty();
    }

    public static boolean correoValido(String correo) {
        return correo.contains("@") && correo.contains(".");
    }

    public static boolean telefonoValido(String telefono) {
        return telefono.matches("[0-9]+");
    }

    public static boolean edadValida(int edad) {
        return edad > 0 && edad < 150;
    }

    public static boolean numeroMayorCero(double numero) {
        return numero > 0;
    }
}