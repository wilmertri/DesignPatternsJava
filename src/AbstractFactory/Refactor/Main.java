package AbstractFactory.Refactor;

public class Main {
    public static void main(String[] args) {

        ServicioDocumentos servicio = new ServicioDocumentos();

        // ✅ Las tres modalidades funcionan con exactamente
        //    el mismo código en ServicioDocumentos.
        servicio.generarDocumentosEstudiante("Ana García",   "PRESENCIAL");
        servicio.generarDocumentosEstudiante("Carlos López", "VIRTUAL");

        // ✅ Modalidad nueva — ServicioDocumentos no se tocó.
        servicio.generarDocumentosEstudiante("María Ruiz",   "HIBRIDA");

        // ✅ Error claro si la modalidad no existe.
        System.out.println("\n── Intentando modalidad inexistente ──");
        try {
            servicio.generarDocumentosEstudiante("Luis Torres", "NOCTURNA");
        } catch (IllegalArgumentException e) {
            System.out.println("❌ " + e.getMessage());
        }
    }
}
