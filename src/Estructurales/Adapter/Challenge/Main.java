package Estructurales.Adapter.Challenge;

// ══════════════════════════════════════════════════════════════════════
// CONTEXTO: El sistema universitario envía notificaciones por email.
// Actualmente usa una clase interna NotificadorInterno que funciona.
//
// El problema: la universidad contrata un proveedor externo (SendGrid)
// para el envío de emails. SendGrid tiene su propia API con métodos
// y firma completamente distintos a los que el sistema ya usa.
//
// No se puede modificar SendGrid (es código de terceros).
// No se quiere modificar todo el sistema existente.
// ══════════════════════════════════════════════════════════════════════

// ── Lo que el sistema universitario ya usa y funciona ─────────────────
public class Main {
    public static void main(String[] args) {
        ServicioMatricula servicio = new ServicioMatricula();
        servicio.matricular("Ana García",   "ana@universidad.edu");
        servicio.matricular("Carlos López", "carlos@universidad.edu");

        // El sistema está atrapado con el notificador interno.
        // No puede usar SendGrid sin modificar todo el código existente.
    }
}
