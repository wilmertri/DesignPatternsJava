package Estructurales.Facade.Challenge;

public class Main {
    public static void main(String[] args) {

        ControladorMatricula controlador = new ControladorMatricula();

        controlador.matricular(
                "EST-001",
                "CS-301",
                "ana@universidad.edu",
                450000
        );

        // Cualquier otro cliente que quiera matricular
        // debe repetir toda esta orquestación.
        // El conocimiento del proceso está en el controlador,
        // no en un lugar centralizado.
    }
}
