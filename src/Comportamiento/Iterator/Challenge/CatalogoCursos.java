package Comportamiento.Iterator.Challenge;

// ══════════════════════════════════════════════════════════════════════
// CONTEXTO: Sistema de cursos de programación.
// Los cursos se pueden almacenar en distintas estructuras:
// ArrayList (por defecto), árbol ordenado, o lista enlazada.
// El código que procesa los cursos no debería cambiar según
// la estructura interna que use el catálogo.
// ══════════════════════════════════════════════════════════════════════

import java.util.ArrayList;
import java.util.List;

// ❌ SIN PATRÓN — el procesador depende de la estructura interna
public class CatalogoCursos {
    // Hoy es un ArrayList — mañana podría cambiar a TreeSet o LinkedList
    public List<String> cursos = new ArrayList<>();

    public CatalogoCursos() {
        cursos.add("Patrones de Diseño");
        cursos.add("Arquitectura de Software");
        cursos.add("Base de Datos Avanzado");
        cursos.add("Desarrollo Web");
    }
}
