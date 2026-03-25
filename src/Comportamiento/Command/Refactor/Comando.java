package Comportamiento.Command.Refactor;

// PASO 1: La interfaz Command
public interface Comando {
    void ejecutar();
    void deshacer();
}
