package Comportamiento.Strategy.Refactor;

public class PagoPSE implements EstrategiaPago{

    private String banco;

    public PagoPSE(String banco) {
        this.banco = banco;
    }

    @Override
    public void pagar(double monto, String usuario) {
        System.out.println("🏦 [PSE] Redirigiendo al banco " + this.banco + "...");
        System.out.println("🏦 [PSE] Débito de $" + monto
                + " procesado para: " + usuario);
        System.out.println("🏦 [PSE] CUS: PSE-" + System.currentTimeMillis());
    }
}
