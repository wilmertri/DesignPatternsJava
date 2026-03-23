package Creacionales.Prototype.Refactor;

import java.util.HashMap;
import java.util.Map;

public class SyllabusRegistry {
    private final Map<String, Syllabus> plantillas = new HashMap<>();

    public void registrar(String clave, Syllabus plantilla) {
        plantillas.put(clave, plantilla);
        System.out.println("📁 [Registry] Plantilla registrada: " + clave);
    }

    // Retorna siempre un CLON, nunca la plantilla original.
    // El original queda intacto para futuras clonaciones.
    public Syllabus obtenerClon(String clave) {
        Syllabus plantilla = plantillas.get(clave);
        if (plantilla == null)
            throw new IllegalArgumentException("Plantilla no encontrada: " + clave);
        return plantilla.clonar();
    }
}
