package Creacionales.AbstractFactory.Challenge;

public class ServicioDocumentos {
    public void generarDocumentosEstudiante(String estudiante,
                                            String modalidad) {

        System.out.println("\n══ Generando documentos para: "
                + estudiante + " [" + modalidad + "] ══");

        // ❌ PROBLEMA 1: if/else mezclado con lógica de negocio.
        //    Este bloque no hace nada relacionado con "generar documentos".
        //    Solo existe para decidir qué clases instanciar.
        //    Cada vez que llegue una nueva modalidad (Híbrida, Internacional)
        //    hay que venir a tocar este método de negocio.

        if (modalidad.equals("PRESENCIAL")) {

            CarnetPresencial carnet = new CarnetPresencial();
            carnet.generar(estudiante);

            CertificadoPresencial certificado = new CertificadoPresencial();
            certificado.generar(estudiante);

        } else if (modalidad.equals("VIRTUAL")) {

            CarnetVirtual carnet = new CarnetVirtual();
            carnet.generar(estudiante);

            CertificadoVirtual certificado = new CertificadoVirtual();
            certificado.generar(estudiante);

        } else {
            System.out.println("❌ Modalidad desconocida: " + modalidad);
        }

        // ❌ PROBLEMA 2: Riesgo de mezclar familias.
        //    Nada impide que alguien escriba esto por error:
        //
        //    CarnetPresencial carnet       = new CarnetPresencial();
        //    CertificadoVirtual certificado = new CertificadoVirtual();
        //
        //    Presencial + Virtual mezclados. El compilador no lo detecta.
        //    Es un error silencioso que solo se nota en producción.

        // ❌ PROBLEMA 3: Si se agrega una nueva modalidad HÍBRIDA,
        //    hay que agregar un else if aquí Y crear las nuevas clases.
        //    Dos archivos distintos modificados por un solo cambio.
        //    Más superficie de error.
    }
}
