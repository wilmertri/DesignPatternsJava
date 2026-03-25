package Comportamiento.Observer.Challenge;

public class ServicioLog {
    public void registrar(String pedidoId, String nuevoEstado) {
        System.out.println("Log: Pedido " + pedidoId + " → " + nuevoEstado);
    }
}
