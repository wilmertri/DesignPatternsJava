package Comportamiento.Strategy.Refactor;

public class PagoPayPal implements EstrategiaPago{

    private String APIKey;

    public PagoPayPal(String APIKey) {
        this.APIKey = APIKey;
    }

    @Override
    public void pagar(double monto, String usuario) {
        System.out.println("🅿 [PayPal] Conectando con PayPal API " + this.APIKey + "...");
        System.out.println("🅿 [PayPal] Débito de $" + monto
                + " de cuenta: " + usuario);
        System.out.println("🅿 [PayPal] Transaction ID: PP-"
                + (int)(Math.random() * 99999));
    }
}
