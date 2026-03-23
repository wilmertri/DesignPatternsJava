package Creacionales.AbstractFactory.Challenge;

public class CertificadoVirtual {
    public void generar(String estudiante) {
        System.out.println("📑  [CERTIFICADO VIRTUAL] Generando PDF con firma digital");
        System.out.println("    Estudiante: " + estudiante);
        System.out.println("    → Aplicando firma digital y enviando por correo...");
    }
}
