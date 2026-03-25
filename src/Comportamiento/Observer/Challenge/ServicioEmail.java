package Comportamiento.Observer.Challenge;

public class ServicioEmail {
    public void notificar(String pedidoId, String nuevoEstado) {
        System.out.println("Email: Pedido " + pedidoId + " → " + nuevoEstado);
    }
}
