package Estructurales.Adapter.Refactor;

class MailgunAdapter implements NotificadorEmail {

    private final MailgunClient client;
    private final String        apiKey;
    private final String        domain;

    public MailgunAdapter(MailgunClient client,
                          String apiKey, String domain) {
        this.client = client;
        this.apiKey = apiKey;
        this.domain = domain;
    }

    @Override
    public void enviarEmail(String destinatario, String asunto, String cuerpo) {
        System.out.println("🔄 [ADAPTER] Traduciendo llamada para Mailgun...");
        // Traducción al formato específico de Mailgun
        client.post(
                apiKey,
                domain,
                "no-reply@" + domain,  // Mailgun requiere remitente explícito
                destinatario,
                asunto,
                cuerpo
        );
    }
}
