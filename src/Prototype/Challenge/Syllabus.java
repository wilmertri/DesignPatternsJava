package Prototype.Challenge;

// ══════════════════════════════════════════════════════════════════════
// CONTEXTO: Sistema universitario que genera plantillas de documentos.
// La universidad tiene plantillas base para syllabus de materias.
// Cada profesor toma la plantilla base y la personaliza para su materia.
//
// El problema: crear un syllabus desde cero es costoso.
// Hay que configurar: estructura, créditos, semanas, bibliografía base,
// competencias institucionales, política de notas, etc.
// Todo eso es igual para todos — solo cambia el nombre de la materia
// y el nombre del profesor.
// ══════════════════════════════════════════════════════════════════════

import java.util.ArrayList;
import java.util.List;

public class Syllabus {
    private String materia;
    private String profesor;
    private int    creditos;
    private int    semanas;
    private String politicaNotas;
    private String competenciaInstitucional;
    private List<String> bibliografia;
    private List<String> temas;

    public Syllabus(String materia,
                    String profesor,
                    int    creditos,
                    int    semanas,
                    String politicaNotas,
                    String competenciaInstitucional,
                    List<String> bibliografia,
                    List<String> temas) {

        this.materia                  = materia;
        this.profesor                 = profesor;
        this.creditos                 = creditos;
        this.semanas                  = semanas;
        this.politicaNotas            = politicaNotas;
        this.competenciaInstitucional = competenciaInstitucional;
        this.bibliografia             = bibliografia;
        this.temas                    = temas;

        // Simulación de proceso costoso:
        // en un sistema real esto podría ser leer configuraciones
        // desde BD, validar contra reglamento institucional, etc.
        System.out.println("⚙️  [Syllabus] Construyendo desde cero: " + materia
                + " (proceso costoso...)");
    }

    // Setters
    public void setMateria(String materia)   { this.materia  = materia; }
    public void setProfesor(String profesor) { this.profesor = profesor; }
    public void agregarTema(String tema)     { this.temas.add(tema); }

    public void imprimir() {
        System.out.println("\n┌─────────────────────────────────────────┐");
        System.out.println("│            SYLLABUS ACADÉMICO            │");
        System.out.println("├─────────────────────────────────────────┤");
        System.out.println("  Materia   : " + materia);
        System.out.println("  Profesor  : " + profesor);
        System.out.println("  Créditos  : " + creditos);
        System.out.println("  Semanas   : " + semanas);
        System.out.println("  Política  : " + politicaNotas);
        System.out.println("  Competencia: " + competenciaInstitucional);
        System.out.println("  Bibliografía:");
        bibliografia.forEach(b -> System.out.println("    - " + b));
        System.out.println("  Temas:");
        temas.forEach(t -> System.out.println("    - " + t));
        System.out.println("└─────────────────────────────────────────┘");
    }
}
