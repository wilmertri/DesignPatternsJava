package Comportamiento.Observer.Challenge;
// ══════════════════════════════════════════════════════════════════════
// CONTEXTO: Sistema de pedidos de un e-commerce.
// Cuando un pedido cambia de estado, múltiples componentes deben
// reaccionar: el email, el inventario, la facturación, el log.
// ══════════════════════════════════════════════════════════════════════

// ❌ SIN PATRÓN — el servicio conoce y llama a cada componente
public class ServicioPedido {
    private ServicioEmail      email      = new ServicioEmail();
    private ServicioInventario inventario = new ServicioInventario();
    private ServicioFactura    factura    = new ServicioFactura();
    private ServicioLog        log        = new ServicioLog();

    public void cambiarEstado(String pedidoId, String nuevoEstado) {
        System.out.println("Pedido " + pedidoId + " → " + nuevoEstado);

        // ❌ Acoplado a cada componente.
        // Si llega un nuevo componente (SMS, Analytics),
        // hay que modificar este método. Viola OCP.
        email.notificar(pedidoId, nuevoEstado);
        inventario.actualizar(pedidoId, nuevoEstado);
        factura.generar(pedidoId, nuevoEstado);
        log.registrar(pedidoId, nuevoEstado);
    }
}
