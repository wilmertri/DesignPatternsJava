package Comportamiento.ChainOfResponsibility.Challenge;

public class Main {
    public static void main(String[] args) {
        SoporteTecnico soporte = new SoporteTecnico();
        soporte.procesarTicket(2, "No puedo acceder a mi cuenta.");
        soporte.procesarTicket(5, "El sistema se cae constantemente.");
    }
}
