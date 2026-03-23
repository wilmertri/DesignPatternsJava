package Estructurales.Decorator.Refactor;

// ══════════════════════════════════════════════════════════════════════
// PASO 4: Decoradores concretos — uno por característica.
//
// Cada decorador encapsula UNA sola responsabilidad.
// No hay duplicación. Cambiar el texto del encabezado
// = modificar UN solo archivo.
// ══════════════════════════════════════════════════════════════════════

// ── Decorador 1: Encabezado institucional ─────────────────────────────
public class DecoradorEncabezado extends ReporteDecorador{
    protected DecoradorEncabezado(Reporte reporteEnvuelto) {
        super(reporteEnvuelto);
    }

    @Override
    public String generar() {
        // Agrega su parte ANTES y delega el resto al envuelto
        return "╔══════════════════════════════════════╗\n"
                + "║   UNIVERSIDAD DE LA SABANA — REPORTE      ║\n"
                + "╚══════════════════════════════════════╝\n"
                + reporteEnvuelto.generar();  // delega hacia adentro
    }
}
