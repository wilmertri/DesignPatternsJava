package Comportamiento.Strategy.Challenge;

// ══════════════════════════════════════════════════════════════════════
// CONTEXTO: Sistema de pagos con múltiples métodos:
// tarjeta de crédito, PSE, PayPal, criptomoneda.
// El algoritmo de cada método es diferente pero intercambiable.
// ══════════════════════════════════════════════════════════════════════

// ❌ SIN PATRÓN — if/else mezclado con lógica de cobro
public class ServicioCobro {
    public void cobrar(String metodo, double monto, String usuario) {

        // ❌ Agregar un nuevo método de pago = modificar este método.
        // Cada if conoce detalles internos del método de pago.
        if (metodo.equals("TARJETA")) {
            System.out.println("💳 Validando número de tarjeta...");
            System.out.println("💳 Aplicando cargo de $" + monto
                    + " a tarjeta de: " + usuario);

        } else if (metodo.equals("PSE")) {
            System.out.println("🏦 Redirigiendo al banco de: " + usuario);
            System.out.println("🏦 Procesando débito de $" + monto);

        } else if (metodo.equals("PAYPAL")) {
            System.out.println("🅿 Conectando con PayPal API...");
            System.out.println("🅿 Debitando $" + monto
                    + " de cuenta PayPal de: " + usuario);
        }
        // ¿Crypto? Otro else if. ¿Nequi? Otro else if.
    }
}
