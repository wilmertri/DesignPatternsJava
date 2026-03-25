package Comportamiento.ChainOfResponsibility.Refactor;

public class SoporteN3 extends ManejadorSoporte{

    @Override
    protected boolean puedeManejar(Ticket ticket) {
        return ticket.getNivel() == 3;
    }

    @Override
    protected void procesar(Ticket ticket) {
        System.out.println("🚨 [Desarrollo N3] Atendiendo incidente crítico:");
        System.out.println("   " + ticket.getDescripcion());
        System.out.println("   → Hotfix desplegado en producción.");
        System.out.println("   → Postmortem programado para mañana.");
        ticket.resolver();
    }
}
