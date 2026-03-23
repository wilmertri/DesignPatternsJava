package Estructurales.Adapter.Challenge;

public class ServicioMatricula {
    public void matricular(String estudiante, String email) {

        System.out.println("\n── Procesando matrícula: " + estudiante + " ──");

        // ❌ PROBLEMA 1: El sistema no puede usar SendGridClient
        //    directamente porque su API es incompatible con
        //    NotificadorEmail. Son dos "enchufes" de forma diferente.

        // Esto NO compila — métodos y parámetros distintos:
        // SendGridClient sendGrid = new SendGridClient();
        // sendGrid.enviarEmail(email, "Matrícula", "Texto"); ← no existe

        // ❌ PROBLEMA 2: Para usar SendGrid, habría que modificar
        //    ServicioMatricula, ServicioCalificaciones, ServicioPagos
        //    y todo servicio que envíe emails. Decenas de archivos.

        // ❌ PROBLEMA 3: Si mañana cambian a otro proveedor (Mailgun,
        //    Amazon SES), hay que volver a modificar todos esos archivos.

        // Por ahora, solo puede usar el notificador interno:
        NotificadorEmail notificador = new NotificadorInterno();
        notificador.enviarEmail(
                email,
                "Matrícula exitosa",
                "Estimado " + estudiante + ", tu matrícula fue procesada."
        );
    }
}
