package Creacionales.Singleton.Refactor;

import Creacionales.Singleton.Challenge.Producto;
import Creacionales.Singleton.Challenge.Usuario;

public class ServicioOrden {

    // ── EL CAMBIO CLAVE ───────────────────────────────────────────────
    //
    // ANTES:
    //     private final RepositorioUsuario  repoUsuario   = new RepositorioUsuario();
    //     private final RepositorioProducto repoProducto  = new RepositorioProducto();
    //     private final ConexionDB          conexionOrdenes = new ConexionDB(...);
    //     → Al crear ServicioOrden se abrían 3 conexiones automáticamente.
    //
    // AHORA:
    //     Los repositorios no abren conexiones al instanciarse.
    //     ServicioOrden tampoco abre su propia ConexionDB.
    //     Todos comparten la única instancia via getInstance().
    //
    // ─────────────────────────────────────────────────────────────────

    private final RepositorioUsuario   repoUsuario  = new RepositorioUsuario();
    private final RepositorioProducto  repoProducto = new RepositorioProducto();

    public void crearOrden(int usuarioId, int productoId, int cantidad) {

        System.out.println("\n" + "=".repeat(60));
        System.out.println("INICIANDO crearOrden(usuarioId=" + usuarioId
                + ", productoId=" + productoId + ", cantidad=" + cantidad + ")");
        System.out.println("=".repeat(60));

        // ── Paso 1: Buscar usuario ────────────────────────────────────
        // Internamente usa ConexionDB.getInstance() → misma instancia
        Usuario usuario = repoUsuario.buscarPorId(usuarioId);
        if (usuario == null) {
            System.out.println("❌ Usuario no encontrado.");
            return;
        }
        System.out.println("✅ Usuario: " + usuario);

        // ── Paso 2: Buscar producto ───────────────────────────────────
        // Internamente usa ConexionDB.getInstance() → MISMA instancia
        Producto producto = repoProducto.buscarPorId(productoId);
        if (producto == null) {
            System.out.println("❌ Producto no encontrado.");
            return;
        }
        System.out.println("✅ Producto: " + producto);

        // ── Paso 3: Validaciones ──────────────────────────────────────
        double totalOrden = producto.getPrecio() * cantidad;

        if (!producto.hayStock(cantidad)) {
            System.out.println("❌ Stock insuficiente. Disponible: "
                    + producto.getStock() + ", solicitado: " + cantidad);
            return;
        }

        if (!usuario.tieneSaldoSuficiente(totalOrden)) {
            System.out.printf("❌ Saldo insuficiente. Saldo: $%.2f, Total: $%.2f%n",
                    usuario.getSaldoCuenta(), totalOrden);
            return;
        }

        // ── Paso 4: Registrar la orden ────────────────────────────────
        // Ya no hay una conexionOrdenes propia.
        // Se usa la misma instancia única.
        ConexionDB conexion = ConexionDB.getInstance();

        System.out.println("\n[ServicioOrden] Registrando orden usando "
                + conexion.getIdentificador());

        conexion.update(
                "INSERT INTO ordenes (usuario_id, producto_id, cantidad, total, estado) " +
                        "VALUES (" + usuarioId + ", " + productoId + ", "
                        + cantidad + ", " + totalOrden + ", 'PENDIENTE')"
        );

        // ── Paso 5: Actualizar stock y saldo ──────────────────────────
        repoProducto.reducirStock(productoId, cantidad);
        repoUsuario.actualizarSaldo(usuarioId,
                usuario.getSaldoCuenta() - totalOrden);

        System.out.println("\n" + "=".repeat(60));
        System.out.printf("✅ Orden creada.%n");
        System.out.printf("   Usuario : %s%n",       usuario.getNombre());
        System.out.printf("   Producto: %s x%d%n",   producto.getNombre(), cantidad);
        System.out.printf("   Total   : $%.2f%n",    totalOrden);
        System.out.println("=".repeat(60));
    }
}
