package FactoryMethod.Refactor;
// ══════════════════════════════════════════════════════════════════════
// PASO 6: Otros servicios reutilizan la misma factory.
//
// ServicioCalificaciones también necesita notificar.
// Antes, cada servicio tenía su propio if/else duplicado.
// Ahora todos usan la misma factory — un solo punto de verdad.
// ══════════════════════════════════════════════════════════════════════
public class ServicioCalificaciones {
    // La misma factory, reutilizada sin duplicar lógica.
    private final NotificacionFactory factory = new NotificacionFactory();

    public void publicarCalificacion(String estudiante,
                                     String materia,
                                     double nota,
                                     String tipoNotificacion) {

        System.out.println("\n── Publicando calificación de: " + estudiante + " ──");

        Notificacion notificacion = factory.crear(tipoNotificacion);
        notificacion.enviar(
                estudiante,
                "Tu nota en " + materia + " es: " + nota
        );
    }
}
