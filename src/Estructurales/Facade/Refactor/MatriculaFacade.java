package Estructurales.Facade.Refactor;

import Estructurales.Facade.Challenge.*;

// ══════════════════════════════════════════════════════════════════════
// PASO 1: Los subsistemas NO cambian absolutamente nada.
//         ServicioRequisitos, ServicioPagos, ServicioCupos,
//         ServicioNotificaciones, ServicioRecibos quedan igual.
//
// PASO 2: Se crea la Facade — una clase que encapsula
//         toda la orquestación en un único lugar.
//         Ofrece una interfaz simple hacia afuera
//         y esconde la complejidad hacia adentro.
// ══════════════════════════════════════════════════════════════════════
public class MatriculaFacade {
    // La Facade conoce los subsistemas — nadie más necesita conocerlos
    private final ServicioRequisitos requisitos     = new ServicioRequisitos();
    private final ServicioPagos pagos          = new ServicioPagos();
    private final ServicioCupos cupos          = new ServicioCupos();
    private final ServicioNotificaciones notificaciones = new ServicioNotificaciones();
    private final ServicioRecibos recibos        = new ServicioRecibos();

    // ── La interfaz simplificada hacia el exterior ────────────────────
    // Un solo método reemplaza toda la orquestación manual.
    // El cliente no sabe cuántos subsistemas hay detrás.
    public String matricular(String estudianteId, String cursoId,
                             String email,        double monto) {

        System.out.println("\n══ [FACADE] Iniciando proceso de matrícula ══");

        // La orquestación vive aquí, en un solo lugar
        if (!requisitos.validarRequisitos(estudianteId, cursoId)) {
            throw new IllegalStateException(
                    "El estudiante no cumple los requisitos para el curso.");
        }

        String refPago = pagos.procesarPago(estudianteId, monto);
        if (refPago == null) {
            throw new IllegalStateException("El pago fue rechazado.");
        }

        if (!cupos.asignarCupo(estudianteId, cursoId)) {
            throw new IllegalStateException(
                    "No hay cupos disponibles para el curso.");
        }

        notificaciones.notificar(email,
                "Tu matrícula en " + cursoId + " fue exitosa.");

        String recibo = recibos.generarRecibo(estudianteId, cursoId, refPago);

        System.out.println("\n✅ [FACADE] Matrícula completada. Recibo: " + recibo);
        return recibo;
    }

    // ── La Facade también puede ofrecer otras operaciones ─────────────
    // Cada una encapsula su propio subconjunto de subsistemas.
    // El cliente solo ve métodos de alto nivel.

    public boolean verificarEstado(String estudianteId, String cursoId) {
        System.out.println("\n── [FACADE] Verificando estado de matrícula ──");
        return requisitos.validarRequisitos(estudianteId, cursoId)
                && cupos.asignarCupo(estudianteId, cursoId);
    }

    public void cancelarMatricula(String estudianteId,
                                  String cursoId, String email) {
        System.out.println("\n── [FACADE] Procesando cancelación ──");
        // En un sistema real: revertir cupo, iniciar reembolso, notificar
        notificaciones.notificar(email,
                "Tu matrícula en " + cursoId + " fue cancelada.");
        System.out.println("✅ [FACADE] Cancelación completada.");
    }
}
