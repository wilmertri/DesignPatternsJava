package Comportamiento.Observer.Challenge;

public class ServicioInventario {
    public void actualizar(String pedidoId, String nuevoEstado) {
        System.out.println("Inventario: Pedido " + pedidoId + " → " + nuevoEstado);
    }
}
