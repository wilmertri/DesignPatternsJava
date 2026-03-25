package Comportamiento.Observer.Refactor;

// ══════════════════════════════════════════════════════════════════════
// ✅ CON OBSERVER
// El sujeto no conoce a sus observadores. Solo notifica.
// Agregar un nuevo componente = crear una clase e inscribirla.
// ServicioPedido no se toca.
// ══════════════════════════════════════════════════════════════════════

// PASO 1: La interfaz que todos los observadores implementan
public interface PedidoObserver {
    void onCambioEstado(String pedidoId, String nuevoEstado);
}
