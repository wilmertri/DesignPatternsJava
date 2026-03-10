package FactoryMethod.Challenge;

public class NotificacionPush {
    public void enviar(String destinatario, String mensaje) {
        System.out.println("🔔 [PUSH] Para: " + destinatario);
        System.out.println("   Mensaje: " + mensaje);
        System.out.println("   (Enviando por Firebase...)");
    }
}
