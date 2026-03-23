package Creacionales.AbstractFactory.Refactor;

// ══════════════════════════════════════════════════════════════════════
// PASO 4: Fábricas concretas — una por cada familia/modalidad.
//
// Cada fábrica concreta garantiza que sus productos son compatibles.
// DocumentoFactoryPresencial solo crea objetos Presenciales.
// Es imposible que mezcle un CarnetPresencial con un CertificadoVirtual.
// El compilador lo impide por diseño.
// ══════════════════════════════════════════════════════════════════════

public class DocumentoFactoryVirtual implements DocumentoFactory{
    @Override
    public Carnet crearCarnet() {
        return new CarnetVirtual();          // siempre Virtual
    }

    @Override
    public Certificado crearCertificado() {
        return new CertificadoVirtual();     // siempre Virtual
    }
}
