package Comportamiento.Observer.Refactor;

// PASO 2: Los observadores concretos — uno por responsabilidad
public class ObservadorEmail implements PedidoObserver{
    @Override
    public void onCambioEstado(String pedidoId, String estado) {
        System.out.println("📧 [Email] Notificando cambio de " + pedidoId + " a: " + estado);
    }
}
