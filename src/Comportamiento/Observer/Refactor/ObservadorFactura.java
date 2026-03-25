package Comportamiento.Observer.Refactor;

public class ObservadorFactura implements PedidoObserver{
    @Override
    public void onCambioEstado(String pedidoId, String estado) {
        if (estado.equals("CONFIRMADO")) {
            System.out.println("📄 [Factura] Generando factura para pedido: " + pedidoId);
        } else if (estado.equals("CANCELADO")) {
            System.out.println("📄 [Factura] Anulando factura de pedido: " + pedidoId);
        }
    }
}
