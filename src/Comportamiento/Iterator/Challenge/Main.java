package Comportamiento.Iterator.Challenge;

public class Main {
    public static void main(String[] args) {
        CatalogoCursos catalogoCursos = new CatalogoCursos();
        ProcesadorCursos procesadorCursos = new ProcesadorCursos();
        procesadorCursos.listar(catalogoCursos);
    }
}
