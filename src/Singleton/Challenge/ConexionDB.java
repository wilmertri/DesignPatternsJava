package Singleton.Challenge;

import java.sql.*;
import java.util.Properties;

/**
 * Clase de conexión a base de datos.
 * En este ejemplo SIN patrón Singleton, esta clase se instancia
 * libremente desde cualquier parte del código — ese es el problema.
 */
public class ConexionDB {

    private final String url;
    private final String usuario;
    private final String password;
    private Connection conexion;

    // ⚠ Constructor PÚBLICO — cualquiera puede hacer new ConexionDB()
    // Esto es exactamente lo que el Singleton viene a prohibir.
    public ConexionDB(String url, String usuario, String password) {
        this.url      = url;
        this.usuario  = usuario;
        this.password = password;
        this.conexion = conectar();
    }

    private Connection conectar() {
        try {
            Properties props = new Properties();
            props.setProperty("user",                    usuario);
            props.setProperty("password",                password);
            props.setProperty("useSSL",                  "false");
            props.setProperty("allowPublicKeyRetrieval", "true");
            props.setProperty("serverTimezone",          "UTC");
            props.setProperty("characterEncoding",       "UTF-8");

            Connection conn = DriverManager.getConnection(url, props);

            // Este mensaje imprime el hashCode del objeto para que los
            // estudiantes vean cuántas instancias distintas se crean.
            System.out.printf(
                    "🔌 [ConexionDB #%d] Nueva conexión establecida → %s%n",
                    System.identityHashCode(this), url
            );

            return conn;

        } catch (SQLException e) {
            // Si no hay MySQL disponible, usamos una conexión simulada
            // para que el ejemplo funcione en cualquier entorno de clase.
            System.out.printf(
                    "⚠  [ConexionDB #%d] BD no disponible — usando modo simulado.%n",
                    System.identityHashCode(this)
            );
            return null; // Manejado en query() y update()
        }
    }

    public ResultSet query(String sql) {
        System.out.printf(
                "   [ConexionDB #%d] Ejecutando: %s%n",
                System.identityHashCode(this), sql
        );

        if (conexion == null) {
            // Modo simulado: imprimimos el query pero no ejecutamos
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
                "   [ConexionDB #%d] Ejecutando update: %s%n",
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
            System.err.println("Error cerrando conexión: " + e.getMessage());
        }
    }

    public String getUrl() { return url; }

    // Muestra el identificador único de esta instancia en memoria
    public String getIdentificador() {
        return "ConexionDB#" + System.identityHashCode(this);
    }
}