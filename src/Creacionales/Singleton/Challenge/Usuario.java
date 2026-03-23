package Creacionales.Singleton.Challenge;


public class Usuario {

    private final int    id;
    private final String nombre;
    private final String email;
    private final String rol;        // "CLIENTE", "ADMIN", etc.
    private       double saldoCuenta;

    public Usuario(int id, String nombre, String email, String rol, double saldoCuenta) {
        this.id           = id;
        this.nombre       = nombre;
        this.email        = email;
        this.rol          = rol;
        this.saldoCuenta  = saldoCuenta;
    }

    public int    getId()          { return id; }
    public String getNombre()      { return nombre; }
    public String getEmail()       { return email; }
    public String getRol()         { return rol; }
    public double getSaldoCuenta() { return saldoCuenta; }

    public void setSaldoCuenta(double saldo) { this.saldoCuenta = saldo; }

    public boolean tieneSaldoSuficiente(double monto) {
        return saldoCuenta >= monto;
    }

    @Override
    public String toString() {
        return String.format(
                "Usuario{id=%d, nombre='%s', email='%s', rol='%s', saldo=$%.2f}",
                id, nombre, email, rol, saldoCuenta
        );
    }
}
