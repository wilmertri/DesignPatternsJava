package AbstractFactory.Refactor;

public class DocumentoFactoryHibrida implements DocumentoFactory{
    @Override
    public Carnet crearCarnet() {
        return new CarnetHibrido();          // siempre Híbrido
    }

    @Override
    public Certificado crearCertificado() {
        return new CertificadoHibrido();     // siempre Híbrido
    }
}
