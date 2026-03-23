package Creacionales.AbstractFactory.Refactor;

// ══════════════════════════════════════════════════════════════════════
// PASO 1: Interfaces comunes para cada tipo de documento.
//
// Antes cada clase era independiente: CarnetPresencial, CarnetVirtual,
// CertificadoPresencial, CertificadoVirtual. No tenían nada en común.
// El if/else era necesario para saber cuál instanciar.
//
// Ahora todas las variantes de Carnet hablan el mismo idioma (Carnet),
// y todas las variantes de Certificado hablan (Certificado).
// El servicio puede trabajar con ellas sin saber cuál es cuál.
// ══════════════════════════════════════════════════════════════════════
public interface Certificado {
    void generar(String estudiante);
}
