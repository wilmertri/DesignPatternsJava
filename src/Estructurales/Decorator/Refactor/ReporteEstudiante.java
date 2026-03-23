package Estructurales.Decorator.Refactor;

// ══════════════════════════════════════════════════════════════════════
// PASO 2: El componente base — implementa la interfaz.
//
// Sin cambios respecto al original.
// Solo implementa Reporte en lugar de ser una clase independiente.
// ══════════════════════════════════════════════════════════════════════
public class ReporteEstudiante implements Reporte{
    private final String nombreEstudiante;
    private final double promedio;

    public ReporteEstudiante(String nombreEstudiante, double promedio) {
        this.nombreEstudiante = nombreEstudiante;
        this.promedio         = promedio;
    }

    @Override
    public String generar() {
        return "Estudiante: " + nombreEstudiante
                + " | Promedio: " + promedio;
    }
}
