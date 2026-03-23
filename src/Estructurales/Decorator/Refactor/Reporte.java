package Estructurales.Decorator.Refactor;

// ══════════════════════════════════════════════════════════════════════
// PASO 1: La interfaz común.
//
// Tanto el componente base (ReporteEstudiante) como todos los
// decoradores implementan esta interfaz.
// Eso es lo que permite envolver unos dentro de otros:
// un decorador ES un Reporte y TIENE un Reporte.
// ══════════════════════════════════════════════════════════════════════
public interface Reporte {
    String generar();
}
