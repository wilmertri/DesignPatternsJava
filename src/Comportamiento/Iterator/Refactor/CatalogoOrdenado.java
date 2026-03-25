package Comportamiento.Iterator.Refactor;

// PASO 4: Otra implementación — misma interfaz, estructura interna diferente
//         El procesador no sabe ni le importa cuál usa

public class CatalogoOrdenado implements CatalogoIterable{
    // Internamente usa un TreeMap ordenado por código
    private java.util.TreeMap<String, Curso> cursos = new java.util.TreeMap<>();

    public void agregar(Curso curso) {
        cursos.put(curso.getCodigo(), curso);
    }

    @Override
    public CursoIterator crearIterador() {
        return new IteradorTreeMap(cursos.values().iterator());
    }

    private static class IteradorTreeMap implements CursoIterator {

        private final java.util.Iterator<Curso> iterator;

        public IteradorTreeMap(java.util.Iterator<Curso> iterator) {
            this.iterator = iterator;
        }

        @Override public boolean hasNext() {
            return iterator.hasNext();
        }

        @Override public Curso next() {
            return iterator.next();
        }
    }
}
