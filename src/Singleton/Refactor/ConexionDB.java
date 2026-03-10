package Singleton.Refactor;
// ══════════════════════════════════════════════════════════════════════
// ARCHIVO: ConexionDB.java  — REFACTORIZADO CON SINGLETON
// ══════════════════════════════════════════════════════════════════════

import java.sql.*;
import java.util.Properties;

/**
 * CAMBIOS RESPECTO A LA VERSIÓN SIN PATRÓN:
 *
 * ANTES:  Constructor público  → cualquiera hacía new ConexionDB()
 *         Sin control          → N instancias abiertas sin límite
 *
 * AHORA:  Constructor privado  → nadie puede hacer new ConexionDB()
 *         Holder pattern       → una sola instancia, thread-safe
 *         getInstance()        → único punto de acceso en toda la app
 */
public class ConexionDB {

    private final String url;
    private Connection conexion;

    // ── SINGLETON: Constructor PRIVADO ────────────────────────────────
    // Antes era public. Este es el primer cambio clave.
    // A partir de aquí, NADIE fuera de esta clase puede hacer:
    //     new ConexionDB(...)
    private ConexionDB() {
        this.url = System.getenv().getOrDefault(
                "DB_URL",
                "jdbc:mysql://localhost:3306/tienda"
        );
        this.conexion = conectar();
    }

    // ── SINGLETON: Holder Pattern (Bill Pugh) ─────────────────────────
    // Esta clase interna NO se carga hasta que alguien llame
    // a getInstance() por primera vez.
    // La JVM garantiza que su inicialización es atómica → thread-safe
    // sin necesitar synchronized ni volatile.
    private static class Holder {
        private static final ConexionDB INSTANCIA = new ConexionDB();
    }

    // ── SINGLETON: Único punto de acceso ──────────────────────────────
    // Este método reemplaza a todos los "new ConexionDB(...)"
    // que había dispersos en RepositorioUsuario, RepositorioProducto
    // y ServicioOrden.
    public static ConexionDB getInstance() {
        return Holder.INSTANCIA;
    }

    // ─────────────────────────────────────────────────────────────────
    // Todo lo demás queda IGUAL que antes.
    // El patrón Singleton solo cambia CÓMO se obtiene la instancia,
    // no lo que la instancia hace.
    // ─────────────────────────────────────────────────────────────────

    private Connection conectar() {
        try {
            String usuario  = System.getenv().getOrDefault("DB_USER", "root");
            String password = System.getenv().getOrDefault("DB_PASS", "mi_password");

            Properties props = new Properties();
            props.setProperty("user",                    usuario);
            props.setProperty("password",                password);
            props.setProperty("useSSL",                  "false");
            props.setProperty("allowPublicKeyRetrieval", "true");
            props.setProperty("serverTimezone",          "UTC");
            props.setProperty("characterEncoding",       "UTF-8");

            Connection conn = DriverManager.getConnection(url, props);

            System.out.printf(
                    "🔌 [ConexionDB #%d] Conexión establecida → %s%n",
                    System.identityHashCode(this), url
            );

            return conn;

        } catch (SQLException e) {
            System.out.printf(
                    "⚠  [ConexionDB #%d] BD no disponible — modo simulado.%n",
                    System.identityHashCode(this)
            );
            return null;
        }
    }

    public ResultSet query(String sql) {
        System.out.printf(
                "   [ConexionDB #%d] Query: %s%n",
                System.identityHashCode(this), sql
        );

        if (conexion == null) {
            System.out.printf(
                    "   [ConexionDB #%d] (simulado) Query ejecutado.%n",
                    System.identityHashCode(this)
            );
            return null;
        }

        try {
            if (conexion.isClosed()) conexion = conectar();
            Statement stmt = conexion.createStatement();
            return stmt.executeQuery(sql);
        } catch (SQLException e) {
            throw new RuntimeException("Error en query: " + e.getMessage(), e);
        }
    }

    public int update(String sql) {
        System.out.printf(
                "   [ConexionDB #%d] Update: %s%n",
                System.identityHashCode(this), sql
        );

        if (conexion == null) {
            System.out.printf(
                    "   [ConexionDB #%d] (simulado) Update ejecutado.%n",
                    System.identityHashCode(this)
            );
            return 1;
        }

        try {
            if (conexion.isClosed()) conexion = conectar();
            Statement stmt = conexion.createStatement();
            return stmt.executeUpdate(sql);
        } catch (SQLException e) {
            throw new RuntimeException("Error en update: " + e.getMessage(), e);
        }
    }

    public void cerrar() {
        try {
            if (conexion != null && !conexion.isClosed()) {
                conexion.close();
            }
            System.out.printf(
                    "🔒 [ConexionDB #%d] Conexión cerrada.%n",
                    System.identityHashCode(this)
            );
        } catch (SQLException e) {
            System.err.println("Error cerrando: " + e.getMessage());
        }
    }

    public String getIdentificador() {
        return "ConexionDB#" + System.identityHashCode(this);
    }
}
