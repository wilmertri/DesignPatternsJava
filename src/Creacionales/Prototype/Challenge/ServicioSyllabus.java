package Creacionales.Prototype.Challenge;

import java.util.ArrayList;
import java.util.List;

public class ServicioSyllabus {
    public void generarSyllabusDelSemestre() {

        // ❌ PROBLEMA 1: Cada syllabus se construye desde cero.
        //    Los campos comunes (créditos, semanas, política de notas,
        //    competencia institucional, bibliografía base) se repiten
        //    idénticos en cada instanciación.
        //    Si cambia la política de notas institucional,
        //    hay que actualizar cada new Syllabus(...) por separado.

        List<String> biblioBase = new ArrayList<>();
        biblioBase.add("Pressman, R. - Ingeniería de Software");
        biblioBase.add("Sommerville, I. - Ingeniería de Software");

        List<String> temasPatrones = new ArrayList<>();
        temasPatrones.add("Introducción a patrones");
        temasPatrones.add("Patrones Creacionales");

        Syllabus syllabusPatrones = new Syllabus(
                "Patrones de Diseño",
                "Dr. Ramírez",
                3,
                16,
                "Parcial 30% + Final 40% + Proyecto 30%",  // repetido
                "Pensamiento sistémico y resolución de problemas",  // repetido
                biblioBase,          // lista repetida
                temasPatrones
        );

        // ❌ PROBLEMA 2: Para el segundo syllabus hay que volver a
        //    construir TODA la configuración base desde cero.
        //    El proceso costoso se repite innecesariamente.

        List<String> biblioBase2 = new ArrayList<>();
        biblioBase2.add("Pressman, R. - Ingeniería de Software");  // duplicado
        biblioBase2.add("Sommerville, I. - Ingeniería de Software"); // duplicado

        List<String> temasArquitectura = new ArrayList<>();
        temasArquitectura.add("Introducción a arquitectura");
        temasArquitectura.add("Estilos arquitectónicos");

        Syllabus syllabusArquitectura = new Syllabus(
                "Arquitectura de Software",
                "Dra. López",
                3,               // igual que el anterior
                16,              // igual que el anterior
                "Parcial 30% + Final 40% + Proyecto 30%",           // igual
                "Pensamiento sistémico y resolución de problemas",   // igual
                biblioBase2,     // misma bibliografía, nuevo objeto
                temasArquitectura
        );

        // ❌ PROBLEMA 3: Las listas son referencias compartidas.
        //    Si modificamos la bibliografía de uno,
        //    podría afectar al otro sin que nadie se dé cuenta.
        //    Este bug es silencioso y difícil de rastrear.

        syllabusPatrones.imprimir();
        syllabusArquitectura.imprimir();
    }
}
