package AbstractFactory.Refactor;

public class CarnetVirtual implements Carnet{

    @Override
    public void generar(String estudiante) {
        System.out.println("📲  [CARNET VIRTUAL] Generando carnet digital con QR");
        System.out.println("    Estudiante: " + estudiante);
        System.out.println("    → Enviando al correo institucional...");
    }

}
