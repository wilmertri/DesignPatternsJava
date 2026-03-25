package Comportamiento.Observer.Refactor;

public class ObservadorInventario implements PedidoObserver{
    @Override
    public void onCambioEstado(String pedidoId, String estado) {
        if (estado.equals("CONFIRMADO")) {
            System.out.println("📦 [Inventario] Reservando stock para pedido: " + pedidoId);
        } else if (estado.equals("CANCELADO")) {
            System.out.println("📦 [Inventario] Liberando stock de pedido: " + pedidoId);
        }
    }
}
