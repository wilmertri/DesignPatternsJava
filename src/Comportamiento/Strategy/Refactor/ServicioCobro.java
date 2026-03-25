package Comportamiento.Strategy.Refactor;

// PASO 3: El Contexto — usa la estrategia sin saber cuál es
public class ServicioCobro {
    // La estrategia se puede cambiar en cualquier momento
    private EstrategiaPago estrategia;

    public ServicioCobro(EstrategiaPago estrategia) {
        this.estrategia = estrategia;
    }

    // Permite cambiar la estrategia en tiempo de ejecución
    public void setEstrategia(EstrategiaPago estrategia) {
        this.estrategia = estrategia;
    }

    public void cobrar(double monto, String usuario) {
        System.out.println("\n── Procesando cobro de $" + monto
                + " para: " + usuario + " ──");
        // Una sola línea — no sabe cuál estrategia está ejecutando
        estrategia.pagar(monto, usuario);
        System.out.println("✅ Cobro completado.");
    }
}
