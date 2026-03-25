package Comportamiento.Command.Refactor;

public class ComandoEliminar implements Comando{
    private final EditorTexto editor;
    private final int         cantidad;
    private String            textoEliminado; // guardado para poder restaurar

    public ComandoEliminar(EditorTexto editor, int cantidad) {
        this.editor   = editor;
        this.cantidad = cantidad;
    }

    @Override
    public void ejecutar() {
        String contenido = editor.getContenido();
        int inicio = Math.max(0, contenido.length() - cantidad);
        // Guardar lo que se va a eliminar ANTES de eliminarlo
        textoEliminado = contenido.substring(inicio);
        editor.eliminar(cantidad);
    }

    @Override
    public void deshacer() {
        // Restaurar exactamente lo que se eliminó
        editor.escribir(textoEliminado);
    }
}
