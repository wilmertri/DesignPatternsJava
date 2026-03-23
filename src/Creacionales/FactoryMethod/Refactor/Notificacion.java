package Creacionales.FactoryMethod.Refactor;

// ══════════════════════════════════════════════════════════════════════
// PASO 1: Crear una interfaz común para todos los tipos.
//
// Antes, cada clase (NotificacionEmail, NotificacionSMS, NotificacionPush)
// era independiente. No tenían nada en común formalmente.
// El if/else era necesario porque el código no podía tratarlas igual.
//
// La interfaz resuelve eso: todas las notificaciones "hablan
// el mismo idioma". El código que las usa no necesita saber
// cuál es cuál — solo sabe que todas tienen enviar().
// ══════════════════════════════════════════════════════════════════════
public interface Notificacion {
    void enviar(String destinatario, String mensaje);
}
