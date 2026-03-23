package Creacionales.FactoryMethod.Challenge;

public class ServicioMatricula {
    public void matricular(String estudiante, String tipoNotificacion) {

        System.out.println("\n── Procesando matrícula de: " + estudiante + " ──");

        // ❌ PROBLEMA 1: La lógica de CREACIÓN está mezclada
        //    con la lógica de NEGOCIO.
        //    Este if/else no tiene nada que ver con matricular;
        //    solo existe para decidir qué objeto instanciar.
        //    Cada vez que hay un cambio en los tipos de notificación,
        //    hay que venir a tocar este método de negocio.

        if (tipoNotificacion.equals("EMAIL")) {

            NotificacionEmail notificacion = new NotificacionEmail();
            notificacion.enviar(estudiante, "Tu matrícula fue exitosa.");

        } else if (tipoNotificacion.equals("SMS")) {

            NotificacionSMS notificacion = new NotificacionSMS();
            notificacion.enviar(estudiante, "Tu matrícula fue exitosa.");

        } else if (tipoNotificacion.equals("PUSH")) {

            NotificacionPush notificacion = new NotificacionPush();
            notificacion.enviar(estudiante, "Tu matrícula fue exitosa.");

        } else {
            System.out.println("❌ Tipo de notificación desconocido: " + tipoNotificacion);
        }

        // ❌ PROBLEMA 2: Si mañana agregan "WHATSAPP" como nuevo canal,
        //    hay que abrir este archivo y añadir otro else if.
        //    Eso viola el principio OCP (Open/Closed):
        //    "Abierto para extensión, cerrado para modificación".

        // ❌ PROBLEMA 3: Imagina que ServicioCalificaciones,
        //    ServicioInscripcion y ServicioPagos también necesitan
        //    enviar notificaciones. Cada uno tendría su propio
        //    if/else idéntico. El mismo código duplicado en 4 lugares.
        //    Cambiar un canal = modificar 4 archivos.

        System.out.println("✅ Matrícula registrada.");
    }
}
