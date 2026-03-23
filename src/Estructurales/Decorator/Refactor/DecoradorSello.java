package Estructurales.Decorator.Refactor;

// ── Decorador 3: Sello de autenticidad ───────────────────────────────
public class DecoradorSello extends ReporteDecorador{
    protected DecoradorSello(Reporte reporteEnvuelto) {
        super(reporteEnvuelto);
    }

    @Override
    public String generar() {
        return reporteEnvuelto.generar()
                + "\n[SELLO: DOCUMENTO AUTÉNTICO — " + fechaActual() + "]";
    }

    private String fechaActual() {
        return java.time.LocalDate.now().toString();
    }
}
