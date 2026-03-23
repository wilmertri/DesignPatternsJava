package Estructurales.Decorator.Challenge;

// ══════════════════════════════════════════════════════════════════════
// CONTEXTO: Sistema universitario que genera reportes de estudiantes.
// Un reporte base muestra la información académica básica.
// Según el contexto, el reporte puede necesitar:
//   - Encabezado institucional
//   - Marca de agua "CONFIDENCIAL"
//   - Numeración de páginas
//   - Sello de autenticidad
//
// El problema: cada combinación posible exige una clase nueva.
// ══════════════════════════════════════════════════════════════════════

// ── El reporte base ───────────────────────────────────────────────────
public class ReporteEstudiante {
    private String nombreEstudiante;
    private double promedio;

    public ReporteEstudiante(String nombreEstudiante, double promedio) {
        this.nombreEstudiante = nombreEstudiante;
        this.promedio         = promedio;
    }

    public String generar() {
        return "Estudiante: " + nombreEstudiante
                + " | Promedio: " + promedio;
    }
}
