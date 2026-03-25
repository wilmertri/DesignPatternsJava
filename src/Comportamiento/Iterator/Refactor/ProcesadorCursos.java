package Comportamiento.Iterator.Refactor;

// PASO 5: El procesador — usa CursoIterator sin saber qué hay detrás
public class ProcesadorCursos {
    // ✅ Mismo código para ArrayList, TreeMap, LinkedList, o cualquier
    //    otra estructura que implemente CatalogoIterable.
    public void listar(CatalogoIterable catalogo) {
        CursoIterator it = catalogo.crearIterador();
        int numero = 1;
        while (it.hasNext()) {
            Curso c = it.next();
            System.out.printf("  %d. [%s] %s (%d créditos)%n",
                    numero++, c.getCodigo(), c.getNombre(), c.getCreditos());
        }
    }

    public int contarCreditos(CatalogoIterable catalogo) {
        CursoIterator it = catalogo.crearIterador();
        int total = 0;
        while (it.hasNext()) total += it.next().getCreditos();
        return total;
    }
}
