package Creacionales.FactoryMethod.Refactor;
// ══════════════════════════════════════════════════════════════════════
// PASO 5: ServicioMatricula — limpio, sin if/else, sin new.
//
// ANTES: ServicioMatricula sabía cómo CREAR cada notificación.
// AHORA: ServicioMatricula solo sabe cómo USAR una notificación.
//
// La lógica de creación se delegó a la Factory.
// Este servicio ya no necesita cambiar cuando llega un nuevo canal.
// ══════════════════════════════════════════════════════════════════════
public class ServicioMatricula {
    // La factory se inyecta o se instancia una vez.
    // ServicioMatricula no sabe nada de Email, SMS, Push ni WhatsApp.
    private final NotificacionFactory factory = new NotificacionFactory();

    public void matricular(String estudiante, String tipoNotificacion) {

        System.out.println("\n── Procesando matrícula de: " + estudiante + " ──");

        // ✅ Una sola línea reemplaza todo el if/else.
        //    factory.crear() devuelve la Notificacion correcta.
        //    Este método no sabe ni le importa cuál es.
        Notificacion notificacion = factory.crear(tipoNotificacion);

        // ✅ Siempre la misma llamada, sin importar el tipo.
        notificacion.enviar(estudiante, "Tu matrícula fue exitosa.");

        System.out.println("✅ Matrícula registrada.");
    }
}
