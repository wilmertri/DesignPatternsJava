package Comportamiento.Command.Refactor;

// ══════════════════════════════════════════════════════════════════════
// ✅ CON COMMAND
// Cada acción se encapsula en un objeto Command con execute() y undo().
// El Invoker mantiene un historial de Commands ejecutados.
// Deshacer = llamar undo() en orden inverso. Simple y extensible.
// ══════════════════════════════════════════════════════════════════════

// El receptor — solo sabe operar sobre el texto
public class EditorTexto {
    private StringBuilder contenido = new StringBuilder();

    public void escribir(String texto) {
        contenido.append(texto);
    }

    public void eliminar(int cantidad) {
        int inicio = Math.max(0, contenido.length() - cantidad);
        contenido.delete(inicio, contenido.length());
    }

    public String getContenido() {
        return contenido.toString();
    }
}
