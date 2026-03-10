package AbstractFactory.Refactor;

// ══════════════════════════════════════════════════════════════════════
// PASO 6: ServicioDocumentos — completamente limpio.
//
// ANTES: Tenía if/else para saber qué clases instanciar.
//        Conocía CarnetPresencial, CarnetVirtual, etc.
//        Cambiar una modalidad = modificar este servicio.
//
// AHORA: Solo conoce DocumentoFactory, Carnet y Certificado.
//        No sabe nada de Presencial, Virtual ni Híbrido.
//        Agregar una nueva modalidad = este servicio no se toca.
// ══════════════════════════════════════════════════════════════════════

public class ServicioDocumentos {
    public void generarDocumentosEstudiante(String estudiante,
                                            String modalidad) {

        System.out.println("\n══ Generando documentos para: "
                + estudiante + " [" + modalidad + "] ══");

        // ✅ Una línea reemplaza todo el if/else.
        //    El servicio recibe la factory correcta sin saber cuál es.
        DocumentoFactory factory = DocumentoFactoryProvider.obtener(modalidad);

        // ✅ Siempre las mismas dos líneas sin importar la modalidad.
        //    La factory garantiza que Carnet y Certificado
        //    son de la misma familia. Mezclas imposibles.
        Carnet      carnet      = factory.crearCarnet();
        Certificado certificado = factory.crearCertificado();

        carnet.generar(estudiante);
        certificado.generar(estudiante);
    }
}
