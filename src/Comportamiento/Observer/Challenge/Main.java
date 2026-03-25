package Comportamiento.Observer.Challenge;

public class Main {
    public static void main(String[] args) {
        ServicioPedido servicioPedido = new ServicioPedido();
        servicioPedido.cambiarEstado("12345", "Enviado");
    }
}
