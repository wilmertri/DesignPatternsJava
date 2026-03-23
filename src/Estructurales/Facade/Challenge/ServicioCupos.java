package Estructurales.Facade.Challenge;

public class ServicioCupos {
    public boolean asignarCupo(String estudianteId, String cursoId) {
        System.out.println("🪑 [Cupos] Asignando cupo...");
        System.out.println("   Estudiante: " + estudianteId
                + " | Curso: " + cursoId);
        System.out.println("   ✅ Cupo asignado.");
        return true;
    }
}
