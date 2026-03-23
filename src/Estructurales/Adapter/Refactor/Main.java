package Estructurales.Adapter.Refactor;

public class Main {
    public static void main(String[] args) {

        // ── Usando el notificador interno (sin cambios) ───────────────
        System.out.println("=== Con notificador interno ===");
        ServicioMatricula servicioInterno = new ServicioMatricula(
                new NotificadorInterno()
        );
        servicioInterno.matricular("Ana García", "ana@universidad.edu");

        // ── Usando SendGrid a través del Adapter ──────────────────────
        // ✅ ServicioMatricula no cambió ni una línea.
        //    Solo se le inyecta el Adapter en lugar del interno.
        System.out.println("\n=== Con SendGrid via Adapter ===");
        SendGridClient sendGrid    = new SendGridClient();
        NotificadorEmail adapter   = new SendGridAdapter(sendGrid, "SG.KEY-123");
        ServicioMatricula servicioSendGrid = new ServicioMatricula(adapter);
        servicioSendGrid.matricular("Carlos López", "carlos@universidad.edu");

        // ── Cambiar de proveedor mañana ───────────────────────────────
        // ✅ Si mañana contratan Mailgun, solo se crea MailgunAdapter.
        //    ServicioMatricula, ServicioCalificaciones, ServicioPagos
        //    no se tocan. Cero cambios en el sistema existente.
        System.out.println("\n=== Cambiando a Mailgun (simulado) ===");
        NotificadorEmail mailgunAdapter = new MailgunAdapter(
                new MailgunClient(), "key-mailgun-456", "uni.edu"
        );
        ServicioMatricula servicioMailgun = new ServicioMatricula(mailgunAdapter);
        servicioMailgun.matricular("María Ruiz", "maria@universidad.edu");
    }
}
