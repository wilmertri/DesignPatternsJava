package Comportamiento.Observer.Refactor;

// PASO 4: Uso
public class Main {
    public static void main(String[] args) {

        ServicioPedido servicio = new ServicioPedido();

        // Se suscriben los componentes que les interesa el evento
        servicio.suscribir(new ObservadorEmail());
        servicio.suscribir(new ObservadorInventario());
        servicio.suscribir(new ObservadorFactura());
        servicio.suscribir(new ObservadorLog());

        servicio.cambiarEstado("PED-001", "CONFIRMADO");
        servicio.cambiarEstado("PED-002", "CANCELADO");

        // Agregar SMS sin tocar ServicioPedido
        servicio.suscribir(new ObservadorSMS());
        servicio.cambiarEstado("PED-003", "ENVIADO");
    }
}
