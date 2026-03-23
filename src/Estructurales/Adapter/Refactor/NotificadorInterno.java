package Estructurales.Adapter.Refactor;

public class NotificadorInterno implements NotificadorEmail {
    @Override
    public void enviarEmail(String destinatario, String asunto, String cuerpo) {
        System.out.println("📧 [INTERNO] Enviando email...");
        System.out.println("   Para   : " + destinatario);
        System.out.println("   Asunto : " + asunto);
        System.out.println("   Cuerpo : " + cuerpo);
    }
}
