package Comportamiento.Iterator.Refactor;

import java.util.ArrayList;
import java.util.List;

// PASO 3: Implementación con ArrayList
public class CatalogoArrayList implements CatalogoIterable{
    private List<Curso> cursos = new ArrayList<>();

    public void agregar(Curso curso) {
        cursos.add(curso);
    }

    @Override
    public CursoIterator crearIterador() {
        return new IteradorArrayList(cursos);
    }

    // El iterador concreto para ArrayList
    private static class IteradorArrayList implements CursoIterator {
        private final List<Curso> cursos;
        private int indice = 0;

        public IteradorArrayList(List<Curso> cursos) {
            this.cursos = cursos;
        }

        @Override public boolean hasNext() {
            return indice < cursos.size();
        }

        @Override public Curso next() {
            return cursos.get(indice++);
        }
    }
}
