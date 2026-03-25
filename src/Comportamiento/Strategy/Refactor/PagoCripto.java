package Comportamiento.Strategy.Refactor;

// ✅ Nuevo método de pago sin tocar nada existente

public class PagoCripto implements EstrategiaPago{
    private String criptomoneda;

    public PagoCripto(String criptomoneda) {
        this.criptomoneda = criptomoneda;
    }

    @Override
    public void pagar(double monto, String usuario) {
        System.out.println("🪙 [Cripto] Convirtiendo $" + monto
                + " a " + criptomoneda + "...");
        System.out.println("🪙 [Cripto] Transferencia a wallet de: " + usuario);
        System.out.println("🪙 [Cripto] TX Hash: 0x"
                + Integer.toHexString((int)(Math.random() * 999999)));
    }
}
