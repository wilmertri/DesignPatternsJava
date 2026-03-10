package Singleton.Challenge;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RepositorioUsuario {

    // ❌ PROBLEMA #1: Este repositorio crea SU PROPIA ConexionDB.
    // No sabe que RepositorioProducto ya creó otra.
    // No hay coordinación. No hay límite.
    private final ConexionDB conexion;

    private static final String URL      = "jdbc:mysql://localhost:3306/tienda";
    private static final String USUARIO  = "root";
    private static final String PASSWORD = "mi_password";

    public RepositorioUsuario() {
        System.out.println("\n[RepositorioUsuario] Creando mi propia ConexionDB...");
        // Cada vez que alguien instancia RepositorioUsuario,
        // se abre UNA nueva conexión a la BD.
        this.conexion = new ConexionDB(URL, USUARIO, PASSWORD);
    }

    public Usuario buscarPorId(int id) {
        System.out.println("[RepositorioUsuario] Buscando usuario id=" + id
                + " usando " + conexion.getIdentificador());

        ResultSet rs = conexion.query(
                "SELECT id, nombre, email, rol, saldo_cuenta " +
                        "FROM usuarios WHERE id = " + id
        );

        // Si estamos en modo simulado (sin BD real), retornamos datos de prueba
        if (rs == null) {
            return usuarioSimulado(id);
        }

        try {
            if (rs.next()) {
                return new Usuario(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("email"),
                        rs.getString("rol"),
                        rs.getDouble("saldo_cuenta")
                );
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException("Error leyendo usuario: " + e.getMessage(), e);
        }
    }

    public boolean actualizarSaldo(int usuarioId, double nuevoSaldo) {
        System.out.println("[RepositorioUsuario] Actualizando saldo de usuario id=" + usuarioId
                + " usando " + conexion.getIdentificador());

        int filas = conexion.update(
                "UPDATE usuarios SET saldo_cuenta = " + nuevoSaldo +
                        " WHERE id = " + usuarioId
        );
        return filas > 0;
    }

    // Datos simulados para demostración sin BD
    private Usuario usuarioSimulado(int id) {
        return switch (id) {
            case 1  -> new Usuario(1, "Ana García",   "ana@tienda.com",    "CLIENTE", 500.00);
            case 2  -> new Usuario(2, "Carlos López", "carlos@tienda.com", "CLIENTE", 150.00);
            default -> new Usuario(id, "Usuario " + id, "u" + id + "@tienda.com", "CLIENTE", 100.00);
        };
    }
}
