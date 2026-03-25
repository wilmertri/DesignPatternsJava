package Comportamiento.Command.Challenge;

public class Main {
    public static void main(String[] args) {
        EditorTexto editor = new EditorTexto();
        editor.escribir("Hola! Soy el patrón de diseño de software Command.");
        editor.eliminarUltimos(5);
    }
}
