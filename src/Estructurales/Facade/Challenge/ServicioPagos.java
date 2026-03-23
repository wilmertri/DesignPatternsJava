package Estructurales.Facade.Challenge;

public class ServicioPagos {
    public String procesarPago(String estudianteId, double monto) {
        System.out.println("💳 [Pagos] Procesando pago...");
        System.out.println("   Estudiante: " + estudianteId
                + " | Monto: $" + monto);
        String referencia = "PAY-" + System.currentTimeMillis();
        System.out.println("   ✅ Pago aprobado. Ref: " + referencia);
        return referencia;
    }
}
