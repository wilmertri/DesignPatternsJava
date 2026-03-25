package Comportamiento.Strategy.Refactor;

// PASO 2: Los algoritmos concretos — cada uno en su clase
public class PagoTarjeta implements EstrategiaPago{

    private String numeroTarjeta;
    private String fechaExpiracion;
    private String cvv;

    public PagoTarjeta(String numeroTarjeta, String cvv) {
        this.numeroTarjeta = numeroTarjeta;
        this.cvv = cvv;
    }

    @Override
    public void pagar(double monto, String usuario) {
        System.out.println("💳 [Tarjeta] Validando número de tarjeta "+ this.numeroTarjeta +"...");
        System.out.println("💳 [Tarjeta] Cargo de $" + monto
                + " aplicado a: " + usuario);
        System.out.println("💳 [Tarjeta] Código de autorización: AUTH-"
                + (int)(Math.random() * 99999));
    }
}
