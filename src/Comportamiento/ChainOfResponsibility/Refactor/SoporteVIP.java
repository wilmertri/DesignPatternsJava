package Comportamiento.ChainOfResponsibility.Refactor;

// ✅ Nuevo nivel sin tocar los existentes
public class SoporteVIP extends ManejadorSoporte{

    @Override
    protected boolean puedeManejar(Ticket ticket) {
        return ticket.getNivel() >= 4;
    }

    @Override
    protected void procesar(Ticket ticket) {
        System.out.println("⭐ [Soporte VIP] Atención prioritaria:");
        System.out.println("   " + ticket.getDescripcion());
        System.out.println("   → Director de tecnología notificado.");
        ticket.resolver();
    }
}
