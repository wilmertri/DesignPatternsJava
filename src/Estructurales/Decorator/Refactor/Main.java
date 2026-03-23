package Estructurales.Decorator.Refactor;

public class Main {
    public static void main(String[] args){
        // ── Reporte base ──────────────────────────────────────────────
        Reporte base = new ReporteEstudiante("Ana García", 4.2);

        System.out.println("── Reporte base ──");
        System.out.println(base.generar());

        // ── Solo encabezado ───────────────────────────────────────────
        // Envolvemos el base con el decorador de encabezado
        Reporte conEncabezado = new DecoradorEncabezado(base);

        System.out.println("\n── Con encabezado ──");
        System.out.println(conEncabezado.generar());

        // ── Encabezado + confidencial ─────────────────────────────────
        // Envolvemos el anterior con el decorador confidencial.
        // Cada capa agrega su parte y delega al interior.
        Reporte conEncabezadoYMarca = new DecoradorConfidencial(
                new DecoradorEncabezado(base)
        );

        System.out.println("\n── Con encabezado + confidencial ──");
        System.out.println(conEncabezadoYMarca.generar());

        // ── Todas las capas apiladas ──────────────────────────────────
        // ✅ Esta combinación no requirió ninguna clase nueva.
        //    Solo apilar decoradores existentes en el orden deseado.
        Reporte completo = new DecoradorNumeracion(
                        new DecoradorSello(
                        new DecoradorConfidencial(
                        new DecoradorEncabezado(base)
                        )), 3);

        System.out.println("\n── Reporte completo (todas las capas) ──");
        System.out.println(completo.generar());

        // ── Combinación sin encabezado ────────────────────────────────
        // ✅ Antes era imposible sin crear una nueva clase.
        //    Ahora simplemente se omite ese decorador.
        Reporte soloSelloYNumeracion = new DecoradorNumeracion(
                new DecoradorSello(base), 1);

        System.out.println("\n── Solo sello + numeración (sin encabezado) ──");
        System.out.println(soloSelloYNumeracion.generar());
    }
}
