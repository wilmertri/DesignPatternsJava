package Estructurales.Facade.Refactor;

public class ControladorMatricula {
    // ✅ Solo conoce la Facade. Cero acoplamiento a subsistemas.
    private final MatriculaFacade facade = new MatriculaFacade();

    public void procesarSolicitud(String estudianteId, String cursoId,
                                  String email,        double monto) {
        try {
            // Una línea reemplaza toda la orquestación manual
            String recibo = facade.matricular(
                    estudianteId, cursoId, email, monto);
            System.out.println("[Controlador] Recibo generado: " + recibo);

        } catch (IllegalStateException e) {
            System.out.println("[Controlador] ❌ Error: " + e.getMessage());
        }
    }
}
