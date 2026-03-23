package Estructurales.Facade.Challenge;

// ══════════════════════════════════════════════════════════════════════
// ARCHIVO: ControladorMatricula.java — ❌ SIN PATRÓN (el problema)
//
// Este controlador representa cualquier "cliente" del sistema:
// un endpoint REST, una vista, un test, otro servicio.
// ══════════════════════════════════════════════════════════════════════
public class ControladorMatricula {
    // ❌ PROBLEMA 1: El controlador conoce y depende de TODOS
    //    los subsistemas. Si cambia cualquiera de ellos,
    //    este controlador también cambia.
    private final ServicioRequisitos    requisitos    = new ServicioRequisitos();
    private final ServicioPagos         pagos         = new ServicioPagos();
    private final ServicioCupos         cupos         = new ServicioCupos();
    private final ServicioNotificaciones notificaciones = new ServicioNotificaciones();
    private final ServicioRecibos       recibos       = new ServicioRecibos();

    public void matricular(String estudianteId, String cursoId,
                           String email,        double monto) {

        System.out.println("\n══ INICIANDO MATRÍCULA ══");

        // ❌ PROBLEMA 2: El controlador orquesta manualmente
        //    cada paso del proceso. Conoce el ORDEN correcto,
        //    maneja los errores de cada subsistema,
        //    pasa los resultados intermedios entre pasos.
        //    Toda esa lógica de orquestación está expuesta aquí,
        //    no encapsulada en ningún lado.

        // Paso 1
        boolean requisitosOk = requisitos.validarRequisitos(
                estudianteId, cursoId);
        if (!requisitosOk) {
            System.out.println("❌ No cumple requisitos.");
            return;
        }

        // Paso 2
        String refPago = pagos.procesarPago(estudianteId, monto);
        if (refPago == null) {
            System.out.println("❌ Pago rechazado.");
            return;
        }

        // Paso 3
        boolean cupoOk = cupos.asignarCupo(estudianteId, cursoId);
        if (!cupoOk) {
            System.out.println("❌ Sin cupos disponibles.");
            return;
        }

        // Paso 4
        notificaciones.notificar(email,
                "Tu matrícula en " + cursoId + " fue exitosa.");

        // Paso 5
        String recibo = recibos.generarRecibo(
                estudianteId, cursoId, refPago);

        System.out.println("\n✅ Matrícula completada. Recibo: " + recibo);

        // ❌ PROBLEMA 3: Si otro controlador también necesita
        //    matricular (un proceso batch, una API externa, un test),
        //    copia y pega toda esta orquestación.
        //    Lógica duplicada en múltiples lugares.
    }
}
