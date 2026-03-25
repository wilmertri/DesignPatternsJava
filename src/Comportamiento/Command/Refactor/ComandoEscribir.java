package Comportamiento.Command.Refactor;

// PASO 2: Comandos concretos — cada uno sabe cómo revertirse
public class ComandoEscribir implements Comando{
    private final EditorTexto editor;
    private final String      texto;

    public ComandoEscribir(EditorTexto editor, String texto) {
        this.editor = editor;
        this.texto  = texto;
    }

    @Override
    public void ejecutar() {
        editor.escribir(texto);
    }

    @Override
    public void deshacer() {
        // Revertir: eliminar exactamente lo que escribió
        editor.eliminar(texto.length());
    }
}
