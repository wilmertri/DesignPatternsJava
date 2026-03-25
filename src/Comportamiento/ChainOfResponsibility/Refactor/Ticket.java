package Comportamiento.ChainOfResponsibility.Refactor;

// ══════════════════════════════════════════════════════════════════════
// ✅ CON CHAIN OF RESPONSIBILITY
// Cada manejador decide si procesa el ticket o lo pasa al siguiente.
// La cadena se configura en Main — no hay if/else en los manejadores.
// Agregar un nivel = una clase nueva + conectarla a la cadena.
// ══════════════════════════════════════════════════════════════════════

// El objeto que viaja por la cadena — contiene la información del ticket
public class Ticket {
    private int    nivel;
    private String descripcion;
    private String estado = "PENDIENTE";

    public Ticket(int nivel, String descripcion) {
        this.nivel       = nivel;
        this.descripcion = descripcion;
    }

    public int    getNivel()       { return nivel; }
    public String getDescripcion() { return descripcion; }
    public String getEstado()      { return estado; }
    public void   resolver()       { this.estado = "RESUELTO"; }

    @Override
    public String toString() {
        return "Ticket[Nivel=" + nivel + ", estado=" + estado
                + ", desc='" + descripcion + "']";
    }
}
