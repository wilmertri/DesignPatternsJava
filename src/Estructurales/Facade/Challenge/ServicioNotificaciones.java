package Estructurales.Facade.Challenge;

public class ServicioNotificaciones {
    public void notificar(String email, String mensaje) {
        System.out.println("📧 [Notificaciones] Enviando confirmación...");
        System.out.println("   Email: " + email);
        System.out.println("   ✅ Notificación enviada: " + mensaje);
    }
}
