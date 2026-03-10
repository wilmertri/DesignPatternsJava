package Singleton.Refactor;

public class Main {

    public static void main(String[] args) {

        // ══════════════════════════════════════════════════════════════
        // PARTE 1 — DEMOSTRACIÓN: Una sola conexión para todo
        // ══════════════════════════════════════════════════════════════

        System.out.println("╔══════════════════════════════════════════════════════════╗");
        System.out.println("║      SOLUCIÓN CON PATRÓN SINGLETON                       ║");
        System.out.println("╚══════════════════════════════════════════════════════════╝");

        System.out.println("\n▶ Obteniendo la instancia desde 3 puntos distintos del código:");

        ConexionDB instanciaA = ConexionDB.getInstance(); // RepositorioUsuario haría esto
        ConexionDB instanciaB = ConexionDB.getInstance(); // RepositorioProducto haría esto
        ConexionDB instanciaC = ConexionDB.getInstance(); // ServicioOrden haría esto

        System.out.println("\n   instanciaA → " + instanciaA.getIdentificador());
        System.out.println("   instanciaB → " + instanciaB.getIdentificador());
        System.out.println("   instanciaC → " + instanciaC.getIdentificador());

        System.out.println("\n   ¿A == B? " + (instanciaA == instanciaB)); // true
        System.out.println("   ¿B == C? " + (instanciaB == instanciaC)); // true
        System.out.println("   ¿A == C? " + (instanciaA == instanciaC)); // true

        System.out.println("\n   ✅ Los tres identificadores son IGUALES.");
        System.out.println("      Una sola conexión compartida por toda la aplicación.");

        // ══════════════════════════════════════════════════════════════
        // PARTE 2 — FLUJO COMPLETO CON UNA ORDEN
        // ══════════════════════════════════════════════════════════════

        System.out.println("\n\n▶ Ejecutando una orden — observa el identificador en cada paso:");

        ServicioOrden servicio = new ServicioOrden();
        servicio.crearOrden(1, 2, 1); // Ana compra 1 Mouse Inalámbrico

        // Todos los mensajes del output mostrarán el MISMO ConexionDB#XXXXX
        // RepositorioUsuario, RepositorioProducto y ServicioOrden
        // comparten la misma instancia.

        // ══════════════════════════════════════════════════════════════
        // PARTE 3 — SIMULANDO 3 REQUESTS SIMULTÁNEOS
        // ══════════════════════════════════════════════════════════════

        System.out.println("\n\n▶ Simulando 3 requests simultáneos:");
        System.out.println("   (Antes: 3 servicios × 3 conexiones = 9 conexiones abiertas)");
        System.out.println("   (Ahora: 3 servicios × 1 conexión  = 1 conexión compartida)\n");

        ServicioOrden servicio1 = new ServicioOrden();
        ServicioOrden servicio2 = new ServicioOrden();
        ServicioOrden servicio3 = new ServicioOrden();

        servicio1.crearOrden(1, 1, 1);
        servicio2.crearOrden(2, 3, 1);
        servicio3.crearOrden(1, 2, 2);

        // ══════════════════════════════════════════════════════════════
        // PARTE 4 — TABLA COMPARATIVA FINAL
        // ══════════════════════════════════════════════════════════════

        System.out.println("\n╔══════════════════════════════════════════════════════════╗");
        System.out.println("║                  COMPARATIVA FINAL                       ║");
        System.out.println("╠══════════════════════════════════════════════════════════╣");
        System.out.println("║                          ANTES       AHORA               ║");
        System.out.println("║  Constructor ConexionDB   public      private            ║");
        System.out.println("║  Instancias creadas       N (sin límite)  1              ║");
        System.out.println("║  Con 3 servicios activos  9 conexiones   1 conexión      ║");
        System.out.println("║  Credenciales de BD       Repetidas x3   En un lugar     ║");
        System.out.println("║  Identificadores iguales  No             Sí              ║");
        System.out.println("║  Riesgo de agotar BD      Alto           Controlado      ║");
        System.out.println("╚══════════════════════════════════════════════════════════╝");
    }
}