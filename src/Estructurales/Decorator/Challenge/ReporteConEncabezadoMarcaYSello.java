package Estructurales.Decorator.Challenge;

// ❌ ¿Y si necesito encabezado + marca de agua + sello?
//    Otra subclase. Y así hasta el infinito.
public class ReporteConEncabezadoMarcaYSello extends ReporteEstudiante{
    public ReporteConEncabezadoMarcaYSello(String nombreEstudiante, double promedio) {
        super(nombreEstudiante, promedio);
    }

    @Override
    public String generar() {
        return "[ UNIVERSIDAD CENTRAL — REPORTE OFICIAL ]\n"
                + super.generar()
                + "\n*** CONFIDENCIAL ***"
                + "\n[SELLO AUTÉNTICO]";
    }

}
