package Comportamiento.ChainOfResponsibility.Refactor;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        // PASO 3: Construir la cadena — el orden importa
        ManejadorSoporte n1  = new SoporteN1();
        ManejadorSoporte n2  = new SoporteN2();
        ManejadorSoporte n3  = new SoporteN3();
        ManejadorSoporte vip = new SoporteVIP();

        // Encadenamiento fluido: n1 → n2 → n3 → vip
        n1.setSiguiente(n2).setSiguiente(n3).setSiguiente(vip);

        // PASO 4: Los tickets solo se envían al primero de la cadena
        List<Ticket> tickets = List.of(
                new Ticket(1, "No puedo ingresar a la plataforma"),
                new Ticket(2, "El módulo de notas no carga"),
                new Ticket(3, "Base de datos caída en producción"),
                new Ticket(4, "Falla generalizada en todos los servicios")
        );

        for (Ticket t : tickets) {
            System.out.println("\n── Ticket recibido: Nivel " + t.getNivel() + " ──");
            n1.manejar(t); // siempre entra por el primero
            System.out.println("Estado final: " + t.getEstado());
        }
    }
}
