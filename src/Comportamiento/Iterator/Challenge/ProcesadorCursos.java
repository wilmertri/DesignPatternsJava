package Comportamiento.Iterator.Challenge;

public class ProcesadorCursos {
    public void listar(CatalogoCursos catalogo) {
        // ❌ Acoplado a ArrayList e índice numérico.
        // Si CatalogoCursos cambia a TreeSet, este código se rompe.
        for (int i = 0; i < catalogo.cursos.size(); i++) {
            System.out.println((i + 1) + ". " + catalogo.cursos.get(i));
        }
    }
}
