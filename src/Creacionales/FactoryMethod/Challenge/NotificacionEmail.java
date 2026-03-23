package Creacionales.FactoryMethod.Challenge;

public class NotificacionEmail {
    public void enviar(String destinatario, String mensaje) {
        System.out.println("📧 [EMAIL] Para: " + destinatario);
        System.out.println("   Mensaje: " + mensaje);
        System.out.println("   (Conectando con servidor SMTP...)");
    }
}
