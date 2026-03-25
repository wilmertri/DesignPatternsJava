package Comportamiento.ChainOfResponsibility.Refactor;

// PASO 2: Los manejadores concretos
public class SoporteN1 extends ManejadorSoporte{

    @Override
    protected boolean puedeManejar(Ticket ticket) {
        return ticket.getNivel() == 1;
    }

    @Override
    protected void procesar(Ticket ticket) {
        System.out.println("👨‍💻 [Soporte N1] Resolviendo ticket básico:");
        System.out.println("   " + ticket.getDescripcion());
        System.out.println("   → Solución: reseteo de credenciales enviado al email.");
        ticket.resolver();
    }
}
