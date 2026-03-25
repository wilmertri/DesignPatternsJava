package Comportamiento.Strategy.Refactor;

// ══════════════════════════════════════════════════════════════════════
// ✅ CON STRATEGY
// Cada algoritmo de pago vive en su propia clase.
// ServicioCobro solo ejecuta la estrategia que recibe.
// Cambiar el método de pago = cambiar la estrategia en runtime.
// ══════════════════════════════════════════════════════════════════════

// PASO 1: La interfaz Strategy — el contrato de todos los algoritmos
public interface EstrategiaPago {
    void pagar(double monto, String usuario);
}
