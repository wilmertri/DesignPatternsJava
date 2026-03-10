package Prototype.Refactor;

// ══════════════════════════════════════════════════════════════════════
// PASO 1: La interfaz Prototype.
//
// Define el contrato: cualquier objeto que pueda clonarse
// debe implementar este método.
// Java ya tiene Cloneable, pero definir nuestra propia interfaz
// nos da más control y claridad semántica.
// ══════════════════════════════════════════════════════════════════════
public interface Prototype <T> {
    T clonar();
}
