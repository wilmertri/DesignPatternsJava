package Creacionales.AbstractFactory.Refactor;

// ══════════════════════════════════════════════════════════════════════
// PASO 3: La Abstract Factory — el corazón del patrón.
//
// Define el CONTRATO de qué documentos puede crear una fábrica.
// No sabe nada de modalidades concretas.
// Solo declara: "cualquier fábrica de documentos universitarios
// debe saber crear un Carnet y un Certificado."
//
// DIFERENCIA CON FACTORY METHOD:
//   Factory Method → crea UN solo tipo de objeto.
//   Abstract Factory → crea una FAMILIA de objetos relacionados
//                      garantizando que son compatibles entre sí.
// ══════════════════════════════════════════════════════════════════════

public interface DocumentoFactory {
    Carnet       crearCarnet();
    Certificado  crearCertificado();
}
