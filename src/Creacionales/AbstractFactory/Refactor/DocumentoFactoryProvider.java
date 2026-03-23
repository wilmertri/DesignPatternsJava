package Creacionales.AbstractFactory.Refactor;

// ══════════════════════════════════════════════════════════════════════
// PASO 5: Un proveedor central que entrega la factory correcta.
//
// El único if/else que queda en todo el sistema vive aquí.
// Está aislado, tiene una sola responsabilidad, y es el único
// lugar que se toca cuando llega una nueva modalidad.
// ══════════════════════════════════════════════════════════════════════
public class DocumentoFactoryProvider {
    public static DocumentoFactory obtener(String modalidad) {
        return switch (modalidad.toUpperCase()) {
            case "PRESENCIAL" -> new DocumentoFactoryPresencial();
            case "VIRTUAL"    -> new DocumentoFactoryVirtual();
            case "HIBRIDA"    -> new DocumentoFactoryHibrida();
            default -> throw new IllegalArgumentException(
                    "Modalidad no soportada: " + modalidad
            );
        };
    }
}
