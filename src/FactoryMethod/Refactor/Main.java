package FactoryMethod.Refactor;

public class Main {
    public static void main(String[] args) {
        // ── Servicio de matrículas ─────────────────────────────────────
        ServicioMatricula matriculas = new ServicioMatricula();

        matriculas.matricular("Ana García",   "EMAIL");
        matriculas.matricular("Carlos López", "SMS");
        matriculas.matricular("Luis Torres",  "PUSH");

        // ✅ WhatsApp funciona sin haber tocado ServicioMatricula
        matriculas.matricular("María Ruiz",   "WHATSAPP");

        // ── Servicio de calificaciones reutiliza la misma factory ──────
        System.out.println("\n" + "─".repeat(50));
        ServicioCalificaciones calificaciones = new ServicioCalificaciones();

        calificaciones.publicarCalificacion("Ana García",   "Patrones de Diseño", 4.5, "EMAIL");
        calificaciones.publicarCalificacion("Carlos López", "Arquitectura",        3.8, "SMS");

        // ── La factory también se puede usar directamente ──────────────
        System.out.println("\n" + "─".repeat(50));
        System.out.println("── Uso directo de la factory ──");

        NotificacionFactory factory = new NotificacionFactory();

        // El tipo puede venir de una BD, de un archivo de config,
        // de una preferencia del usuario — la factory no le importa.
        String[] tipos = {"EMAIL", "SMS", "PUSH", "WHATSAPP"};
        for (String tipo : tipos) {
            Notificacion n = factory.crear(tipo);
            n.enviar("demo@universidad.edu", "Prueba del canal " + tipo);
        }
    }
}
