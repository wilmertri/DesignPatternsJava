package Creacionales.AbstractFactory.Refactor;

// ══════════════════════════════════════════════════════════════════════
// PASO 2: Implementaciones concretas para cada modalidad.
//
// Cada clase implementa su interfaz correspondiente.
// La lógica específica de cada modalidad está encapsulada aquí,
// no dispersa en if/else por todo el código.
// ══════════════════════════════════════════════════════════════════════

public class CarnetPresencial implements Carnet{

    @Override
    public void generar(String estudiante) {
        System.out.println("🪪  [CARNET PRESENCIAL] Generando carnet físico con foto");
        System.out.println("    Estudiante: " + estudiante);
        System.out.println("    → Imprimiendo en PVC con holograma...");
    }

}
