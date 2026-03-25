package Comportamiento.Strategy.Challenge;

public class Main {
    public static void main(String[] args) {
        ServicioCobro servicioCobro = new ServicioCobro();
        servicioCobro.cobrar("TARJETA", 100.0, "Pedro Perez");
    }
}
