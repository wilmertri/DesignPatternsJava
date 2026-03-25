package Comportamiento.Iterator.Refactor;

// ══════════════════════════════════════════════════════════════════════
// ✅ CON ITERATOR
// El catálogo expone un Iterator — el procesador lo usa sin saber
// qué estructura hay detrás. ArrayList, TreeSet, LinkedList:
// el código de procesamiento no cambia.
// ══════════════════════════════════════════════════════════════════════

// El modelo
public class Curso {
    private String nombre;
    private String codigo;
    private int    creditos;

    public Curso(String nombre, String codigo, int creditos) {
        this.nombre   = nombre;
        this.codigo   = codigo;
        this.creditos = creditos;
    }

    public String getNombre()   { return nombre; }
    public String getCodigo()   { return codigo; }
    public int    getCreditos() { return creditos; }
}
