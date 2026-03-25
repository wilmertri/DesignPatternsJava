package Comportamiento.Observer.Refactor;

import java.util.ArrayList;
import java.util.List;

// PASO 3: El servicio que gestiona la lista de observadores
public class ServicioPedido {
    // La lista de observadores. No sabe quiénes son.
    private final List<PedidoObserver> observadores = new ArrayList<>();

    public void suscribir(PedidoObserver observer) {
        observadores.add(observer);
    }

    public void desuscribir(PedidoObserver observer) {
        observadores.remove(observer);
    }

    public void cambiarEstado(String pedidoId, String nuevoEstado) {
        System.out.println("\n── Pedido " + pedidoId + " → " + nuevoEstado + " ──");

        // Notifica a TODOS sin saber quiénes son ni cuántos hay
        for (PedidoObserver observer : observadores) {
            observer.onCambioEstado(pedidoId, nuevoEstado);
        }
    }
}
