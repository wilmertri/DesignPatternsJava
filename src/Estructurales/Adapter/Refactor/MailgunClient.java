package Estructurales.Adapter.Refactor;

// ── Adapter para otro proveedor: Mailgun ──────────────────────────────
// Agregar un proveedor nuevo = crear un Adapter nuevo.
// Nada más cambia.

public class MailgunClient {
    public void post(String apiKey, String domain,
                     String from, String to,
                     String subject, String text) {
        System.out.println("📮 [MAILGUN API] Posting message...");
        System.out.println("   domain  : " + domain);
        System.out.println("   to      : " + to);
        System.out.println("   subject : " + subject);
        System.out.println("   text    : " + text);
    }
}
