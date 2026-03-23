package Estructurales.Facade.Refactor;

// ── Proceso batch — también usa la Facade ────────────────────────────
public class ProcesoMatriculaMasiva {
    private final MatriculaFacade facade = new MatriculaFacade();

    public void matricularLote(String[][] estudiantes) {
        System.out.println("\n══ PROCESO BATCH — Matrícula masiva ══");
        for (String[] datos : estudiantes) {
            try {
                facade.matricular(datos[0], datos[1], datos[2],
                        Double.parseDouble(datos[3]));
            } catch (IllegalStateException e) {
                System.out.println("❌ Error en lote: " + e.getMessage());
            }
        }
    }
}
