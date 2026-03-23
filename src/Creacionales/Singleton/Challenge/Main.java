package Creacionales.Singleton.Challenge;

public class Main {

    public static void main(String[] args) {

        System.out.println("╔══════════════════════════════════════════════════════════╗");
        System.out.println("║   DEMOSTRACIÓN DEL PROBLEMA — Sin patrón Creacionales.Singleton       ║");
        System.out.println("╚══════════════════════════════════════════════════════════╝");

        // ── Escenario 1: Una sola orden ───────────────────────────────
        // Al crear ServicioOrden, se abren 3 conexiones simultáneamente.
        // El estudiante puede ver los 3 identificadores distintos.
        System.out.println("\n▶  Creando ServicioOrden (observa cuántas conexiones se abren):");
        ServicioOrden servicio = new ServicioOrden();

        servicio.crearOrden(1, 2, 1); // Ana compra 1 Mouse Inalámbrico

        // ── Escenario 2: Dos servicios paralelos ──────────────────────
        // En una app web real, cada request HTTP crea su propio
        // ServicioOrden. Aquí simulamos 3 requests simultáneos.
        System.out.println("\n\n▶  Simulando 3 requests simultáneos de usuarios distintos:");
        System.out.println("   (En una app web, cada request haría esto en su propio hilo)");
        System.out.println("   Observa cuántas conexiones se abren en total:\n");

        ServicioOrden servicio1 = new ServicioOrden(); // 3 conexiones más
        ServicioOrden servicio2 = new ServicioOrden(); // 3 conexiones más
        ServicioOrden servicio3 = new ServicioOrden(); // 3 conexiones más

        // En este punto ya hay 3 servicios × 3 conexiones = 9 conexiones abiertas.
        // Si MySQL tiene un límite de 10 conexiones simultáneas,
        // el siguiente request fallará.

        servicio1.crearOrden(1, 1, 1);
        servicio2.crearOrden(2, 3, 2);
        servicio3.crearOrden(1, 2, 3);

        // ── Resumen del problema ──────────────────────────────────────
        System.out.println("\n╔══════════════════════════════════════════════════════════╗");
        System.out.println("║                  RESUMEN DEL PROBLEMA                    ║");
        System.out.println("╠══════════════════════════════════════════════════════════╣");
        System.out.println("║  ServicioOrden instanciado: 4 veces                      ║");
        System.out.println("║  ConexionDB creadas       : 4 × 3 = 12 conexiones        ║");
        System.out.println("║  Conexiones necesarias    : 1 sería suficiente            ║");
        System.out.println("║                                                           ║");
        System.out.println("║  Cada ConexionDB tiene un identificador distinto (#XXX).  ║");
        System.out.println("║  Si hubieran sido la misma instancia, el número sería     ║");
        System.out.println("║  idéntico en todos los mensajes. Ese es el Creacionales.Singleton.     ║");
        System.out.println("╚══════════════════════════════════════════════════════════╝");
        System.out.println("\n➡  Próximo paso: aplicar el patrón Creacionales.Singleton a ConexionDB");
        System.out.println("   para que todos compartan la misma instancia.");
    }
}
