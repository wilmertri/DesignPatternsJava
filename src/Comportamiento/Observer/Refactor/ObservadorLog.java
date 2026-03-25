package Comportamiento.Observer.Refactor;

public class ObservadorLog implements PedidoObserver{
    @Override
    public void onCambioEstado(String pedidoId, String estado) {
        System.out.println("📋 [Log] " + java.time.LocalDateTime.now()
                + " | Pedido: " + pedidoId + " | Estado: " + estado);
    }
}
