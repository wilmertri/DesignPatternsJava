package Comportamiento.Command.Challenge;

// ══════════════════════════════════════════════════════════════════════
// CONTEXTO: Editor de texto para una empresa (como un Google Docs básico).
// El usuario puede escribir, eliminar y cambiar formato.
// El sistema debe soportar Deshacer (Ctrl+Z) y Rehacer (Ctrl+Y).
//
// Sin Command: implementar Undo es casi imposible porque el invocador
// tiene que recordar qué hizo y cómo revertirlo. Pesadilla.
// ══════════════════════════════════════════════════════════════════════

// ❌ SIN PATRÓN — el editor no puede deshacer
public class EditorTexto {
    private StringBuilder contenido = new StringBuilder();

    public void escribir(String texto) {
        contenido.append(texto);
        System.out.println("Contenido: " + contenido);
    }

    public void eliminarUltimos(int n) {
        int inicio = Math.max(0, contenido.length() - n);
        contenido.delete(inicio, contenido.length());
        System.out.println("Contenido: " + contenido);
    }

    // ❌ ¿Cómo implemento undo aquí?
    // El editor tendría que saber qué operación fue la última
    // y cómo revertirla. Para cada operación, lógica distinta.
    // Con 10 tipos de operaciones, el código se vuelve inmanejable.
}
