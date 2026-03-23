package Creacionales.FactoryMethod.Refactor;
// ══════════════════════════════════════════════════════════════════════
// PASO 2: Las clases concretas implementan la interfaz.
//
// Cada clase sabe CÓMO enviar su tipo de notificación.
// Ese conocimiento está encapsulado aquí, no en el servicio.
// ══════════════════════════════════════════════════════════════════════
public class NotificacionPush implements Notificacion{
    public void enviar(String destinatario, String mensaje) {
        System.out.println("🔔 [PUSH] Para: " + destinatario);
        System.out.println("   Mensaje: " + mensaje);
        System.out.println("   (Enviando por Firebase...)");
    }
}
