package Prototype.Refactor;

// ══════════════════════════════════════════════════════════════════════
// PASO 2: Syllabus implementa Prototype.
//
// El cambio clave está en el método clonar():
// en lugar de construir desde cero, copia el estado del objeto actual
// y retorna un objeto nuevo con esos mismos valores.
//
// DEEP COPY vs SHALLOW COPY:
//   Shallow copy → copia referencias. Las listas serían compartidas.
//                  Modificar la lista de uno afecta al otro. Bug silencioso.
//   Deep copy    → copia el contenido. Cada objeto tiene sus propias listas.
//                  Modificar uno no afecta al otro. Esto es lo correcto.
// ══════════════════════════════════════════════════════════════════════

import java.util.ArrayList;
import java.util.List;

public class Syllabus implements Prototype<Syllabus> {

    private String materia;
    private String profesor;
    private int    creditos;
    private int    semanas;
    private String politicaNotas;
    private String competenciaInstitucional;
    private List<String> bibliografia;
    private List<String> temas;

    // Constructor completo — solo se llama UNA vez para la plantilla base
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

        System.out.println("⚙️  [Syllabus] Construyendo desde cero: " + materia
                + " (proceso costoso — solo ocurre una vez)");
    }

    // ── Constructor privado para la clonación ─────────────────────────
    // Solo clonar() lo llama. Recibe todos los valores ya listos.
    // No ejecuta ningún proceso costoso.
    private Syllabus(Syllabus origen) {
        this.materia                  = origen.materia;
        this.profesor                 = origen.profesor;
        this.creditos                 = origen.creditos;
        this.semanas                  = origen.semanas;
        this.politicaNotas            = origen.politicaNotas;
        this.competenciaInstitucional = origen.competenciaInstitucional;

        // ✅ DEEP COPY: nuevas listas con el mismo contenido.
        //    El clon tiene sus propias listas independientes.
        //    Modificar la bibliografía del clon no toca al original.
        this.bibliografia = new ArrayList<>(origen.bibliografia);
        this.temas        = new ArrayList<>(origen.temas);

        System.out.println("📋 [Syllabus] Clonado desde plantilla → " + materia
                + " (sin proceso costoso)");
    }

    // ── El método del patrón Prototype ───────────────────────────────
    @Override
    public Syllabus clonar() {
        return new Syllabus(this);
    }

    // ── Setters para personalizar el clon ────────────────────────────
    public Syllabus conMateria(String materia) {
        this.materia = materia;
        return this;
    }

    public Syllabus conProfesor(String profesor) {
        this.profesor = profesor;
        return this;
    }

    public Syllabus agregarTema(String tema) {
        this.temas.add(tema);
        return this;
    }

    public Syllabus agregarBibliografia(String referencia) {
        this.bibliografia.add(referencia);
        return this;
    }

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
