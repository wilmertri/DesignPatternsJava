package AbstractFactory.Refactor;

public class CertificadoVirtual implements Certificado{

    @Override
    public void generar(String estudiante) {
        System.out.println("📑  [CERTIFICADO VIRTUAL] Generando PDF con firma digital");
        System.out.println("    Estudiante: " + estudiante);
        System.out.println("    → Aplicando firma digital y enviando por correo...");
    }

}
