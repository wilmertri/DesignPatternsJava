package Creacionales.AbstractFactory.Refactor;

public class CarnetHibrido implements Carnet{
    @Override
    public void generar(String estudiante) {
        System.out.println("🪪📲 [CARNET HÍBRIDO] Generando carnet físico + versión QR");
        System.out.println("    Estudiante: " + estudiante);
        System.out.println("    → Imprimiendo físico y enviando digital al correo...");
    }
}
