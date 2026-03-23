package Estructurales.Decorator.Refactor;

public class DecoradorConfidencial extends ReporteDecorador{
    protected DecoradorConfidencial(Reporte reporteEnvuelto) {
        super(reporteEnvuelto);
    }

    @Override
    public String generar() {
        // Agrega su parte DESPUÉS y delega el resto al envuelto
        return reporteEnvuelto.generar()
                + "\n★ CONFIDENCIAL — USO INTERNO ★";
    }
}
