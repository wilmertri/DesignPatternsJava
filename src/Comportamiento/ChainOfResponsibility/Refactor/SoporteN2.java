package Comportamiento.ChainOfResponsibility.Refactor;


public class SoporteN2 extends ManejadorSoporte{

    @Override
    protected boolean puedeManejar(Ticket ticket) {
        return ticket.getNivel() == 2;
    }

    @Override
    protected void procesar(Ticket ticket) {
        System.out.println("🔧 [Soporte N2] Analizando bug técnico:");
        System.out.println("   " + ticket.getDescripcion());
        System.out.println("   → Revisando logs del servidor...");
        System.out.println("   → Bug identificado y fix aplicado.");
        ticket.resolver();
    }
}
