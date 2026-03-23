package Estructurales.Decorator.Challenge;

// ══════════════════════════════════════════════════════════════════════
// ❌ PROBLEMA: Explosión de subclases.
//
// Para cada combinación de funcionalidades extra,
// se crea una subclase nueva. Con 4 características opcionales
// (encabezado, marca de agua, numeración, sello) hay hasta
// 16 combinaciones posibles → 16 clases.
//
// Agregar UNA nueva característica opcional duplica el número
// de clases necesarias. Esto es insostenible.
// ══════════════════════════════════════════════════════════════════════

// Reporte con encabezado
public class ReporteConEncabezado extends ReporteEstudiante{
    public ReporteConEncabezado(String nombreEstudiante, double promedio) {
        super(nombreEstudiante, promedio);
    }

    @Override
    public String generar() {
        return "[ UNIVERSIDAD CENTRAL — REPORTE OFICIAL ]\n"
                + super.generar();
    }
}
