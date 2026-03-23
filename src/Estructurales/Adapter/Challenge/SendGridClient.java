package Estructurales.Adapter.Challenge;

public class SendGridClient {
    // ❌ Método con firma INCOMPATIBLE con NotificadorEmail.
    //    - Se llama "transmitir" en lugar de "enviarEmail"
    //    - Los parámetros van en orden diferente
    //    - Usa un objeto SendGridMessage en lugar de Strings simples
    public void transmitir(SendGridMessage mensaje) {
        System.out.println("🚀 [SENDGRID API] Transmitiendo mensaje...");
        System.out.println("   recipient : " + mensaje.getTo());
        System.out.println("   subject   : " + mensaje.getSubject());
        System.out.println("   html_body : " + mensaje.getHtmlBody());
        System.out.println("   api_key   : " + mensaje.getApiKey());
    }
}
