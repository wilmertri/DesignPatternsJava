package FactoryMethod.Challenge;

public class Main {
    public static void main(String[] args) {

        ServicioMatricula servicio = new ServicioMatricula();

        servicio.matricular("Ana García",   "EMAIL");
        servicio.matricular("Carlos López", "SMS");
        servicio.matricular("Luis Torres",  "PUSH");

        // ¿Qué pasa si la universidad agrega WhatsApp?
        // Hay que abrir ServicioMatricula.java y modificarlo.
        // Y si otros servicios también envían notificaciones,
        // hay que modificarlos a todos. Ese es el problema.
        servicio.matricular("María Ruiz",   "WHATSAPP"); // "❌ Tipo desconocido"
    }
}
