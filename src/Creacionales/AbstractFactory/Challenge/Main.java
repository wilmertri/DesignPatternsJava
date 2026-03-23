package Creacionales.AbstractFactory.Challenge;

public class Main {
    public static void main(String[] args) {
        ServicioDocumentos servicio = new ServicioDocumentos();

        servicio.generarDocumentosEstudiante("Ana García", "PRESENCIAL");
        servicio.generarDocumentosEstudiante("Carlos López", "VIRTUAL");

        // ¿Qué pasa si llega modalidad HIBRIDA?
        servicio.generarDocumentosEstudiante("María Ruiz", "HIBRIDA"); // ❌ desconocida
    }
}
