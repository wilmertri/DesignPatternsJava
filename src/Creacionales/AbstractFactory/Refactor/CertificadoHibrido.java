package Creacionales.AbstractFactory.Refactor;

public class CertificadoHibrido implements Certificado{

    @Override
    public void generar(String estudiante) {
        System.out.println("📄📑 [CERTIFICADO HÍBRIDO] Generando papel + PDF firmado");
        System.out.println("    Estudiante: " + estudiante);
        System.out.println("    → Imprimiendo físico y generando PDF con firma digital...");
    }

}
