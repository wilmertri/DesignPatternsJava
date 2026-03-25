package Comportamiento.ChainOfResponsibility.Challenge;

// ══════════════════════════════════════════════════════════════════════
// CONTEXTO: Sistema de soporte técnico de tecnología.
// Un ticket de soporte se resuelve según su nivel de complejidad:
// Nivel 1 → Soporte básico (reseteo de clave, acceso a plataforma)
// Nivel 2 → Soporte técnico (bugs, configuraciones)
// Nivel 3 → Desarrollo (errores críticos, cambios de base de datos)
//
// Sin el patrón: un solo método con if/else anidados que crece
// sin control y es imposible de mantener.
// ══════════════════════════════════════════════════════════════════════

// ❌ SIN PATRÓN — toda la lógica de enrutamiento en un solo lugar
public class SoporteTecnico {
    public void procesarTicket(int nivel, String descripcion) {

        // ❌ Cada vez que se agrega un nivel nuevo o cambia
        // quién atiende qué, hay que modificar este método.
        if (nivel == 1) {
            System.out.println("[Nivel 1] Resolviendo: " + descripcion);
        } else if (nivel == 2) {
            System.out.println("[Nivel 2] Analizando bug: " + descripcion);
        } else if (nivel == 3) {
            System.out.println("[Nivel 3] Escalando a desarrollo: " + descripcion);
        } else {
            System.out.println("[Sin resolver] Nivel desconocido: " + nivel);
        }
        // ¿Nivel 4? Modificar aquí.
        // ¿Cambiar quién atiende nivel 2? Modificar aquí.
        // ¿Agregar lógica de log en nivel 3? Modificar aquí.
    }
}
