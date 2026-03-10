package Singleton.Refactor;

// ══════════════════════════════════════════════════════════════════════
// ARCHIVO: RepositorioProducto.java  — REFACTORIZADO
// ══════════════════════════════════════════════════════════════════════

import java.sql.ResultSet;
import java.sql.SQLException;
import Singleton.Challenge.Producto;

public class RepositorioProducto {

    // ── EL CAMBIO CLAVE ───────────────────────────────────────────────
    //
    // ANTES:
    //     private final ConexionDB conexion;
    //     public RepositorioProducto() {
    //         this.conexion = new ConexionDB(URL, USUARIO, PASSWORD);
    //     }
    //
    // AHORA:
    //     Sin campo. Sin new. Solo getInstance() cuando se necesita.
    //
    // ─────────────────────────────────────────────────────────────────

    public Producto buscarPorId(int id) {
        ConexionDB conexion = ConexionDB.getInstance();

        System.out.println("[RepositorioProducto] Buscando producto id=" + id
                + " usando " + conexion.getIdentificador());

        ResultSet rs = conexion.query(
                "SELECT id, nombre, categoria, precio, stock " +
                        "FROM productos WHERE id = " + id
        );

        if (rs == null) return productoSimulado(id);

        try {
            if (rs.next()) {
                return new Producto(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("categoria"),
                        rs.getDouble("precio"),
                        rs.getInt("stock")
                );
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException("Error leyendo producto: " + e.getMessage(), e);
        }
    }

    public boolean reducirStock(int productoId, int cantidad) {
        ConexionDB conexion = ConexionDB.getInstance();

        System.out.println("[RepositorioProducto] Reduciendo stock producto id=" + productoId
                + " usando " + conexion.getIdentificador());

        int filas = conexion.update(
                "UPDATE productos SET stock = stock - " + cantidad +
                        " WHERE id = " + productoId + " AND stock >= " + cantidad
        );
        return filas > 0;
    }

    private Producto productoSimulado(int id) {
        return switch (id) {
            case 1  -> new Producto(1, "Laptop Pro",         "Electrónica", 1200.00, 5);
            case 2  -> new Producto(2, "Mouse Inalámbrico",  "Accesorios",    35.00, 20);
            case 3  -> new Producto(3, "Teclado Mecánico",   "Accesorios",    85.00, 12);
            default -> new Producto(id, "Producto " + id,    "General",       50.00, 10);
        };
    }
}
