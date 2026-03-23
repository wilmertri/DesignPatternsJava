package Estructurales.Facade.Refactor;

public class Main {
    public static void main(String[] args) {

        // ── Un solo controlador ───────────────────────────────────────
        System.out.println("=== Matrícula individual ===");
        ControladorMatricula controlador = new ControladorMatricula();
        controlador.procesarSolicitud(
                "EST-001", "CS-301", "ana@universidad.edu", 450000
        );

        // ── Proceso batch usando la misma Facade ──────────────────────
        // ✅ La lógica del proceso está en la Facade, no duplicada aquí
        System.out.println("\n=== Matrícula en lote ===");
        ProcesoMatriculaMasiva batch = new ProcesoMatriculaMasiva();
        batch.matricularLote(new String[][] {
                {"EST-002", "CS-301", "carlos@universidad.edu", "450000"},
                {"EST-003", "CS-302", "maria@universidad.edu",  "380000"},
        });

        // ── Cancelación ───────────────────────────────────────────────
        // ✅ Otra operación de alto nivel ofrecida por la Facade
        System.out.println("\n=== Cancelación ===");
        MatriculaFacade facade = new MatriculaFacade();
        facade.cancelarMatricula(
                "EST-001", "CS-301", "ana@universidad.edu"
        );
    }
}
