package Comportamiento.Observer.Challenge;

public class ServicioFactura {
    public void generar(String pedidoId, String nuevoEstado) {
        System.out.println("Factura: Pedido " + pedidoId + " → " + nuevoEstado);
    }
}
