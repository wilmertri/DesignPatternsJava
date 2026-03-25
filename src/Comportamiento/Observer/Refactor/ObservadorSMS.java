package Comportamiento.Observer.Refactor;

// ✅ Nuevo componente sin tocar nada existente
public class ObservadorSMS implements PedidoObserver{
    @Override
    public void onCambioEstado(String pedidoId, String estado) {
        System.out.println("📱 [SMS] Enviando alerta de " + estado
                + " para pedido: " + pedidoId);
    }
}
