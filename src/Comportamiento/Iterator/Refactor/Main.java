package Comportamiento.Iterator.Refactor;

public class Main {
    public static void main(String[] args) {

        // Catálogo con ArrayList
        CatalogoArrayList arrayList = new CatalogoArrayList();
        arrayList.agregar(new Curso("Patrones de Diseño",     "CS-301", 3));
        arrayList.agregar(new Curso("Arquitectura Software",  "CS-401", 4));
        arrayList.agregar(new Curso("Base de Datos Avanzado", "CS-302", 3));

        // Catálogo con TreeMap (ordenado por código)
        CatalogoOrdenado ordenado = new CatalogoOrdenado();
        ordenado.agregar(new Curso("Desarrollo Web",          "CS-201", 3));
        ordenado.agregar(new Curso("Patrones de Diseño",      "CS-301", 3));
        ordenado.agregar(new Curso("Arquitectura Software",   "CS-401", 4));

        ProcesadorCursos procesador = new ProcesadorCursos();

        // ✅ Exactamente el mismo código para ambas estructuras
        System.out.println("── Catálogo ArrayList ──");
        procesador.listar(arrayList);
        System.out.println("Total créditos: " + procesador.contarCreditos(arrayList));

        System.out.println("\n── Catálogo Ordenado (TreeMap) ──");
        procesador.listar(ordenado);
        System.out.println("Total créditos: " + procesador.contarCreditos(ordenado));
    }
}
