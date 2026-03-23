package Estructurales.Adapter.Refactor;

// ══════════════════════════════════════════════════════════════════════
// PASO 2: ServicioMatricula no cambia absolutamente nada.
//         Solo recibe un NotificadorEmail distinto desde afuera.
//         No sabe si es el interno, SendGrid, Mailgun o cualquier otro.
// ══════════════════════════════════════════════════════════════════════
public class ServicioMatricula {
    // Depende de la INTERFAZ, no de una implementación concreta.
    // Eso es lo que hace posible el Adapter.
    private final NotificadorEmail notificador;

    public ServicioMatricula(NotificadorEmail notificador) {
        this.notificador = notificador;
    }

    public void matricular(String estudiante, String email) {

        System.out.println("\n── Procesando matrícula: " + estudiante + " ──");

        // Siempre la misma llamada — no importa quién está del otro lado
        notificador.enviarEmail(
                email,
                "Matrícula exitosa",
                "Estimado " + estudiante + ", tu matrícula fue procesada."
        );

        System.out.println("✅ Matrícula registrada.");
    }
}
