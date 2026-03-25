package Comportamiento.Strategy.Refactor;

// PASO 4: Implementación y uso
public class Main {
    public static void main(String[] args) {

        // La estrategia se inyecta desde afuera
        ServicioCobro cobro = new ServicioCobro(new PagoTarjeta("4123-5678-9012-3456", "123"));
        cobro.cobrar(150000, "ana@uni.edu");

        // Cambio de estrategia en runtime — el servicio no cambia
        cobro.setEstrategia(new PagoPSE("Bancolombia"));
        cobro.cobrar(280000, "carlos@uni.edu");

        cobro.setEstrategia(new PagoCripto("BTC"));
        cobro.cobrar(500000, "maria@uni.edu");
    }
}
