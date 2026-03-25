package Comportamiento.Command.Refactor;

public class Main {
    public static void main(String[] args) {

        EditorTexto    editor  = new EditorTexto();
        GestorComandos gestor  = new GestorComandos();

        gestor.ejecutar(new ComandoEscribir(editor, "Hola "));
        System.out.println("✏  " + editor.getContenido());  // "Hola "

        gestor.ejecutar(new ComandoEscribir(editor, "mundo"));
        System.out.println("✏  " + editor.getContenido());  // "Hola mundo"

        gestor.ejecutar(new ComandoEliminar(editor, 5));
        System.out.println("🗑  " + editor.getContenido());  // "Hola "

        System.out.println("\n--- Ctrl+Z ---");
        gestor.deshacer();
        System.out.println("↩  " + editor.getContenido());  // "Hola mundo"

        gestor.deshacer();
        System.out.println("↩  " + editor.getContenido());  // "Hola "

        System.out.println("\n--- Ctrl+Y ---");
        gestor.rehacer();
        System.out.println("↪  " + editor.getContenido());  // "Hola mundo"
    }
}
