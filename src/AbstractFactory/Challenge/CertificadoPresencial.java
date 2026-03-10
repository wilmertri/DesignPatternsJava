package AbstractFactory.Challenge;

public class CertificadoPresencial {
    public void generar(String estudiante) {
        System.out.println("📄  [CERTIFICADO PRESENCIAL] Generando en papel membretado");
        System.out.println("    Estudiante: " + estudiante);
        System.out.println("    → Imprimiendo con sello húmedo y firma manuscrita...");
    }
}
