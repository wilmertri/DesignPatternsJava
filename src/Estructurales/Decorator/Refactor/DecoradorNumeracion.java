package Estructurales.Decorator.Refactor;

// ── Decorador 4: Numeración de páginas ───────────────────────────────
public class DecoradorNumeracion extends ReporteDecorador{
    private final int totalPaginas;

    public DecoradorNumeracion(Reporte reporte, int totalPaginas) {
        super(reporte);
        this.totalPaginas = totalPaginas;
    }

    @Override
    public String generar() {
        return reporteEnvuelto.generar()
                + "\n─── Página 1 de " + totalPaginas + " ───";
    }
}
