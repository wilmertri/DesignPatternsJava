package Estructurales.Decorator.Refactor;

public abstract class ReporteDecorador implements Reporte {
    // ── El objeto envuelto ────────────────────────────────────────────
    // Puede ser el ReporteEstudiante base,
    // o CUALQUIER otro decorador ya aplicado.
    // Eso es lo que permite apilar decoradores sin límite.
    protected final Reporte reporteEnvuelto;

    protected ReporteDecorador(Reporte reporteEnvuelto) {
        this.reporteEnvuelto = reporteEnvuelto;
    }

    // Por defecto, delega al objeto envuelto.
    // Los decoradores concretos sobreescriben esto agregando su parte.
    @Override
    public String generar() {
        return reporteEnvuelto.generar();
    }

}
