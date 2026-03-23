package Estructurales.Adapter.Refactor;

// ══════════════════════════════════════════════════════════════════════
// PASO 1: La interfaz del sistema NO cambia.
//         El resto del sistema NO cambia.
//         Solo se crea el Adapter — una clase que traduce
//         entre la interfaz que el sistema espera
//         y la API que el proveedor externo ofrece.
// ══════════════════════════════════════════════════════════════════════

// SendGridClient y SendGridMessage quedan exactamente igual.
// NotificadorEmail queda exactamente igual.
// ServicioMatricula queda exactamente igual.
// Solo se agrega esta clase nueva:

public class SendGridAdapter implements NotificadorEmail{
    // ── Contiene el objeto incompatible ──────────────────────────────
    // El Adapter TIENE el objeto externo que no puede modificar.
    private final SendGridClient sendGrid;
    private final String         apiKey;

    public SendGridAdapter(SendGridClient sendGrid, String apiKey) {
        this.sendGrid = sendGrid;
        this.apiKey   = apiKey;
    }

    // ── Implementa la interfaz que el sistema YA conoce ──────────────
    // El sistema llama enviarEmail() como siempre.
    // El Adapter traduce esa llamada al formato que SendGrid entiende.
    @Override
    public void enviarEmail(String destinatario, String asunto, String cuerpo) {

        System.out.println("🔄 [ADAPTER] Traduciendo llamada para SendGrid...");

        // Traducción: convierte los parámetros simples
        // al objeto SendGridMessage que la API externa necesita
        String htmlBody = "<p>" + cuerpo + "</p>";

        SendGridMessage mensaje = new SendGridMessage(
                destinatario,   // to
                asunto,         // subject
                htmlBody,       // html_body (SendGrid usa HTML)
                apiKey          // api_key   (SendGrid necesita autenticación)
        );

        // Delega al objeto externo con SU propia API
        sendGrid.transmitir(mensaje);
    }
}
