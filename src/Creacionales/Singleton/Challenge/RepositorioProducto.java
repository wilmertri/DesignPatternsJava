package Creacionales.Singleton.Challenge;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RepositorioProducto {

    // ❌ PROBLEMA #2: Otro repositorio, OTRA ConexionDB completamente independiente.
    // RepositorioProducto no sabe nada de la conexión de RepositorioUsuario.
    // Son dos conexiones abiertas al mismo servidor. Innecesario.
    private final ConexionDB conexion;

    private static final String URL      = "jdbc:mysql://localhost:3306/tienda";
    private static final String USUARIO  = "root";
    private static final String PASSWORD = "mi_password";

    public RepositorioProducto() {
        System.out.println("\n[RepositorioProducto] Creando mi propia ConexionDB...");
        this.conexion = new ConexionDB(URL, USUARIO, PASSWORD);
    }

    public Producto buscarPorId(int id) {
        System.out.println("[RepositorioProducto] Buscando producto id=" + id
                + " usando " + conexion.getIdentificador());

        ResultSet rs = conexion.query(
                "SELECT id, nombre, categoria, precio, stock " +
                        "FROM productos WHERE id = " + id
        );

        if (rs == null) {
            return productoSimulado(id);
        }

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
        System.out.println("[RepositorioProducto] Reduciendo stock de producto id=" + productoId
                + " usando " + conexion.getIdentificador());

        int filas = conexion.update(
                "UPDATE productos SET stock = stock - " + cantidad +
                        " WHERE id = " + productoId + " AND stock >= " + cantidad
        );
        return filas > 0;
    }

    // Datos simulados para demostración sin BD
    private Producto productoSimulado(int id) {
        return switch (id) {
            case 1  -> new Producto(1, "Laptop Pro",    "Electrónica", 1200.00, 5);
            case 2  -> new Producto(2, "Mouse Inalámbrico", "Accesorios", 35.00, 20);
            case 3  -> new Producto(3, "Teclado Mecánico",  "Accesorios", 85.00, 12);
            default -> new Producto(id, "Producto " + id, "General", 50.00, 10);
        };
    }
}
