package Creacionales.AbstractFactory.Refactor;

public class DocumentoFactoryPresencial implements DocumentoFactory{
    @Override
    public Carnet crearCarnet() {
        return new CarnetPresencial();       // siempre Presencial
    }

    @Override
    public Certificado crearCertificado() {
        return new CertificadoPresencial();  // siempre Presencial
    }
}
