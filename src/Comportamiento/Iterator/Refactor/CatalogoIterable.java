package Comportamiento.Iterator.Refactor;

// PASO 2: La interfaz del catálogo — cualquier colección que pueda
//         crear un iterador sobre sus cursos
public interface CatalogoIterable {
    CursoIterator crearIterador();
}
