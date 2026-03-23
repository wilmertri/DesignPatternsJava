package Creacionales.Singleton.Challenge;

/**
 * Servicio que coordina la creación de una orden.
 *
 * Este es el punto donde el problema se vuelve más visible:
 * ServicioOrden crea sus propios repositorios, y cada repositorio
 * crea su propia ConexionDB. Una sola llamada a crearOrden()
 * puede abrir 3 o más conexiones a la BD de forma completamente
 * descontrolada.
 */
public class ServicioOrden {

    // ❌ PROBLEMA #3: ServicioOrden crea ambos repositorios.
    // Cada uno de ellos creará su propia ConexionDB al instanciarse.
    // Resultado: 2 conexiones abiertas solo por crear este servicio.
    private final RepositorioUsuario   repoUsuario   = new RepositorioUsuario();
    private final RepositorioProducto  repoProducto  = new RepositorioProducto();

    // ❌ PROBLEMA #4: El servicio TAMBIÉN abre su propia conexión
    // para registrar la orden en la tabla órdenes.
    // Ya llevamos 3 conexiones abiertas para una sola operación.
    private final ConexionDB conexionOrdenes = new ConexionDB(
            "jdbc:mysql://localhost:3306/tienda",
            "root",
            "mi_password"
    );

    public void crearOrden(int usuarioId, int productoId, int cantidad) {

        System.out.println("\n" + "=".repeat(60));
        System.out.println("INICIANDO crearOrden(usuarioId=" + usuarioId
                + ", productoId=" + productoId + ", cantidad=" + cantidad + ")");
        System.out.println("=".repeat(60));

        // ── Paso 1: Buscar usuario ────────────────────────────────────
        // Usa la ConexionDB de RepositorioUsuario
        Usuario usuario = repoUsuario.buscarPorId(usuarioId);
        if (usuario == null) {
            System.out.println("❌ Usuario no encontrado.");
            return;
        }
        System.out.println("✅ Usuario encontrado: " + usuario);

        // ── Paso 2: Buscar producto ───────────────────────────────────
        // Usa la ConexionDB de RepositorioProducto (distinta a la anterior)
        Producto producto = repoProducto.buscarPorId(productoId);
        if (producto == null) {
            System.out.println("❌ Producto no encontrado.");
            return;
        }
        System.out.println("✅ Producto encontrado: " + producto);

        // ── Paso 3: Validaciones de negocio ──────────────────────────
        double totalOrden = producto.getPrecio() * cantidad;

        if (!producto.hayStock(cantidad)) {
            System.out.println("❌ Stock insuficiente. Disponible: "
                    + producto.getStock() + ", solicitado: " + cantidad);
            return;
        }

        if (!usuario.tieneSaldoSuficiente(totalOrden)) {
            System.out.printf("❌ Saldo insuficiente. Saldo: $%.2f, Total orden: $%.2f%n",
                    usuario.getSaldoCuenta(), totalOrden);
            return;
        }

        // ── Paso 4: Registrar la orden ────────────────────────────────
        // Usa la TERCERA ConexionDB (conexionOrdenes)
        System.out.println("\n[ServicioOrden] Registrando orden usando "
                + conexionOrdenes.getIdentificador());

        conexionOrdenes.update(
                "INSERT INTO ordenes (usuario_id, producto_id, cantidad, total, estado) " +
                        "VALUES (" + usuarioId + ", " + productoId + ", " + cantidad
                        + ", " + totalOrden + ", 'PENDIENTE')"
        );

        // ── Paso 5: Actualizar stock ──────────────────────────────────
        // Vuelve a usar la ConexionDB de RepositorioProducto
        repoProducto.reducirStock(productoId, cantidad);

        // ── Paso 6: Descontar saldo al usuario ────────────────────────
        // Vuelve a usar la ConexionDB de RepositorioUsuario
        double nuevoSaldo = usuario.getSaldoCuenta() - totalOrden;
        repoUsuario.actualizarSaldo(usuarioId, nuevoSaldo);

        System.out.println("\n" + "=".repeat(60));
        System.out.printf("✅ Orden creada exitosamente.%n");
        System.out.printf("   Usuario : %s%n", usuario.getNombre());
        System.out.printf("   Producto: %s x%d%n", producto.getNombre(), cantidad);
        System.out.printf("   Total   : $%.2f%n", totalOrden);
        System.out.println("=".repeat(60));
    }
}