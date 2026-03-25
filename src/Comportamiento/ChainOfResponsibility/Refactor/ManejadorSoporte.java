package Comportamiento.ChainOfResponsibility.Refactor;

// PASO 1: El manejador abstracto — define la cadena y el método de manejo
public abstract class ManejadorSoporte {
    // El siguiente en la cadena
    private ManejadorSoporte siguiente;

    public ManejadorSoporte setSiguiente(ManejadorSoporte siguiente) {
        this.siguiente = siguiente;
        return siguiente; // retorna el siguiente para encadenar fluido
    }

    // Lógica común: intentar manejar, si no → pasar al siguiente
    public void manejar(Ticket ticket) {
        if (puedeManejar(ticket)) {
            procesar(ticket);
        } else if (siguiente != null) {
            System.out.println("   ↪ Escalando al siguiente nivel...");
            siguiente.manejar(ticket);
        } else {
            System.out.println("⚠  Sin manejador disponible para: " + ticket);
        }
    }

    // Cada subclase define su criterio y su lógica
    protected abstract boolean puedeManejar(Ticket ticket);
    protected abstract void    procesar(Ticket ticket);
}
