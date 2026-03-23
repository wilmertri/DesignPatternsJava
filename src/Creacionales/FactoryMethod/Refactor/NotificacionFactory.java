package Creacionales.FactoryMethod.Refactor;
// ══════════════════════════════════════════════════════════════════════
// PASO 3: La Factory — el corazón del patrón.
//
// Esta clase tiene UNA sola responsabilidad:
// saber cómo crear cada tipo de Notificacion.
//
// Todo el if/else que estaba contaminando ServicioMatricula
// se mudó aquí. Ahora vive en un solo lugar.
// Si mañana agregan WhatsApp, solo se toca este archivo.
// ServicioMatricula, ServicioCalificaciones, etc. no se tocan.

public class NotificacionFactory {
    // El método crear() es el "Factory Method".
    // Recibe un tipo y devuelve el objeto correcto.
    // El caller solo sabe que recibe una Notificacion — no le importa cuál.
    public Notificacion crear(String tipo) {
        return switch (tipo.toUpperCase()) {
            case "EMAIL"    -> new NotificacionEmail();
            case "SMS"      -> new NotificacionSMS();
            case "PUSH"     -> new NotificacionPush();
            case "WHATSAPP" -> new NotificacionWhatsApp(); // ✅ Nuevo canal: solo aquí
            default -> throw new IllegalArgumentException(
                    "Tipo de notificación no soportado: " + tipo
            );
        };
    }
}
