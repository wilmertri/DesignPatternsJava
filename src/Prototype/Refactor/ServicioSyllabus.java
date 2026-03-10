package Prototype.Refactor;

import java.util.List;

public class ServicioSyllabus {
    private final SyllabusRegistry registry = new SyllabusRegistry();

    public ServicioSyllabus() {
        // ✅ El proceso costoso ocurre UNA sola vez por plantilla.
        //    Todas las materias del semestre que compartan la misma
        //    configuración base parten de aquí.
        Syllabus plantillaIngenieria = new Syllabus(
                "PLANTILLA BASE",
                "Sin asignar",
                3,
                16,
                "Parcial 30% + Final 40% + Proyecto 30%",
                "Pensamiento sistémico y resolución de problemas",
                List.of(
                        "Pressman, R. - Ingeniería de Software",
                        "Sommerville, I. - Ingeniería de Software"
                ),
                List.of("Introducción a la materia")
        );

        registry.registrar("INGENIERIA_BASE", plantillaIngenieria);
    }

    public void generarSyllabusDelSemestre() {

        System.out.println("\n── Generando syllabus del semestre ──\n");

        // ✅ Cada syllabus parte del clon de la plantilla.
        //    Sin proceso costoso. Sin repetir configuración base.
        //    Solo se personaliza lo que cambia.

        Syllabus syllabusPatrones = registry.obtenerClon("INGENIERIA_BASE")
                .conMateria("Patrones de Diseño")
                .conProfesor("Dr. Ramírez")
                .agregarTema("Patrones Creacionales")
                .agregarTema("Patrones Estructurales")
                .agregarTema("Patrones de Comportamiento")
                .agregarBibliografia("Gamma et al. - Design Patterns");

        Syllabus syllabusArquitectura = registry.obtenerClon("INGENIERIA_BASE")
                .conMateria("Arquitectura de Software")
                .conProfesor("Dra. López")
                .agregarTema("Estilos arquitectónicos")
                .agregarTema("Atributos de calidad")
                .agregarBibliografia("Richards & Ford - Fundamentals of Software Architecture");

        Syllabus syllabusBaseDatos = registry.obtenerClon("INGENIERIA_BASE")
                .conMateria("Base de Datos Avanzado")
                .conProfesor("Mg. Torres")
                .agregarTema("Modelado relacional")
                .agregarTema("Optimización de queries")
                .agregarBibliografia("Ramakrishnan - Database Management Systems");

        syllabusPatrones.imprimir();
        syllabusArquitectura.imprimir();
        syllabusBaseDatos.imprimir();

        // ✅ VERIFICACIÓN: los clones son independientes entre sí.
        //    Modificar uno no afecta a los demás (deep copy).
        System.out.println("\n── Verificando independencia de los clones ──");
        System.out.println("¿Son el mismo objeto?");
        System.out.println("  syllabusPatrones == syllabusArquitectura → "
                + (syllabusPatrones == syllabusArquitectura)); // false
    }
}
