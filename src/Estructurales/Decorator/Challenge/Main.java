package Estructurales.Decorator.Challenge;

public class Main {
    public static void main(String[] args){
        // Para cada combinación, una clase distinta.
        // El cliente debe saber qué clase exacta instanciar.

        ReporteEstudiante r1 = new ReporteConEncabezado(
                "Ana García", 4.2);
        System.out.println(r1.generar());

        System.out.println();

        ReporteEstudiante r2 = new ReporteConEncabezadoYMarcaDeAgua(
                "Carlos López", 3.8);
        System.out.println(r2.generar());

        System.out.println();

        ReporteEstudiante r3 = new ReporteConEncabezadoMarcaYSello(
                "María Ruiz", 4.7);
        System.out.println(r3.generar());

        // ❌ ¿Qué pasa si necesito solo sello + numeración?
        //    No existe esa clase. Hay que crearla.
        //    ¿Y encabezado + sello sin marca de agua?
        //    Otra clase más.
    }
}
