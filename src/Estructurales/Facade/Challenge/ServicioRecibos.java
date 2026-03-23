package Estructurales.Facade.Challenge;

public class ServicioRecibos {
    public String generarRecibo(String estudianteId,
                                String cursoId,
                                String referenciaPago) {
        System.out.println("🧾 [Recibos] Generando recibo...");
        String recibo = "REC-" + estudianteId + "-" + cursoId;
        System.out.println("   ✅ Recibo generado: " + recibo);
        return recibo;
    }
}
