package FactoryMethod.Challenge;

public class NotificacionSMS {
    public void enviar(String destinatario, String mensaje) {
        System.out.println("📱 [SMS] Para: " + destinatario);
        System.out.println("   Mensaje: " + mensaje);
        System.out.println("   (Enviando por Twilio...)");
    }
}
