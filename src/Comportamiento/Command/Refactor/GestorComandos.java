package Comportamiento.Command.Refactor;

import java.util.ArrayDeque;
import java.util.Deque;

// PASO 3: El Invoker — ejecuta comandos y gestiona el historial
public class GestorComandos {
    private final Deque<Comando> historial = new ArrayDeque<>();
    private final Deque<Comando> rehacibles = new ArrayDeque<>();

    public void ejecutar(Comando comando) {
        comando.ejecutar();
        historial.push(comando);
        rehacibles.clear(); // al ejecutar, se pierde el redo
    }

    public void deshacer() {
        if (historial.isEmpty()) {
            System.out.println("⚠  No hay acciones para deshacer.");
            return;
        }
        Comando ultimo = historial.pop();
        ultimo.deshacer();
        rehacibles.push(ultimo);
    }

    public void rehacer() {
        if (rehacibles.isEmpty()) {
            System.out.println("⚠  No hay acciones para rehacer.");
            return;
        }
        Comando siguiente = rehacibles.pop();
        siguiente.ejecutar();
        historial.push(siguiente);
    }
}
