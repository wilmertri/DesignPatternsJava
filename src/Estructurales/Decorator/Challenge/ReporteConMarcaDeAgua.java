package Estructurales.Decorator.Challenge;

public class ReporteConMarcaDeAgua extends ReporteEstudiante{
    public ReporteConMarcaDeAgua(String nombreEstudiante, double promedio) {
        super(nombreEstudiante, promedio);
    }

    @Override
    public String generar() {
        return super.generar()
                + "\n*** CONFIDENCIAL ***";
    }
}
