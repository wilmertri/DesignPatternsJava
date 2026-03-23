package Estructurales.Decorator.Challenge;

// ❌ ¿Qué pasa si necesito encabezado + marca de agua?
//    Hay que crear OTRA subclase más.
public class ReporteConEncabezadoYMarcaDeAgua extends ReporteEstudiante{
    public ReporteConEncabezadoYMarcaDeAgua(String nombreEstudiante, double promedio) {
        super(nombreEstudiante, promedio);
    }

    @Override
    public String generar() {
        return "[ UNIVERSIDAD CENTRAL — REPORTE OFICIAL ]\n"
                + super.generar()
                + "\n*** CONFIDENCIAL ***";
    }
}
