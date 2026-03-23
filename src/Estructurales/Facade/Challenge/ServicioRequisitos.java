package Estructurales.Facade.Challenge;

public class ServicioRequisitos {
    public boolean validarRequisitos(String estudianteId, String cursoId) {
        System.out.println("📋 [Requisitos] Validando requisitos previos...");
        System.out.println("   Estudiante: " + estudianteId
                + " | Curso: " + cursoId);
        System.out.println("   ✅ Requisitos cumplidos.");
        return true;
    }
}
