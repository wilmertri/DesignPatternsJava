package Creacionales.Singleton.Refactor;

// ══════════════════════════════════════════════════════════════════════
// ARCHIVO: RepositorioUsuario.java  — REFACTORIZADO
// ══════════════════════════════════════════════════════════════════════

import java.sql.ResultSet;
import java.sql.SQLException;
import Creacionales.Singleton.Challenge.Usuario;

public class RepositorioUsuario {

    // ── EL CAMBIO CLAVE ───────────────────────────────────────────────
    //
    // ANTES:
    //     private final ConexionDB conexion;
    //     public RepositorioUsuario() {
    //         this.conexion = new ConexionDB(URL, USUARIO, PASSWORD);
    //     }
    //
    // AHORA:
    //     No hay campo de instancia.
    //     No hay constructor con lógica.
    //     Cada método pide la instancia única cuando la necesita.
    //
    // ─────────────────────────────────────────────────────────────────

    public Usuario buscarPorId(int id) {
        // getInstance() retorna SIEMPRE la misma instancia
        // que ya tienen RepositorioProducto y ServicioOrden.
        ConexionDB conexion = ConexionDB.getInstance();

        System.out.println("[RepositorioUsuario] Buscando usuario id=" + id
                + " usando " + conexion.getIdentificador());

        ResultSet rs = conexion.query(
                "SELECT id, nombre, email, rol, saldo_cuenta " +
                        "FROM usuarios WHERE id = " + id
        );

        if (rs == null) return usuarioSimulado(id);

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
        ConexionDB conexion = ConexionDB.getInstance();

        System.out.println("[RepositorioUsuario] Actualizando saldo usuario id=" + usuarioId
                + " usando " + conexion.getIdentificador());

        int filas = conexion.update(
                "UPDATE usuarios SET saldo_cuenta = " + nuevoSaldo +
                        " WHERE id = " + usuarioId
        );
        return filas > 0;
    }

    private Usuario usuarioSimulado(int id) {
        return switch (id) {
            case 1  -> new Usuario(1, "Ana García",   "ana@tienda.com",    "CLIENTE", 500.00);
            case 2  -> new Usuario(2, "Carlos López", "carlos@tienda.com", "CLIENTE", 150.00);
            default -> new Usuario(id, "Usuario " + id, "u" + id + "@tienda.com", "CLIENTE", 100.00);
        };
    }
}
