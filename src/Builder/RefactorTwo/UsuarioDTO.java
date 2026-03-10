package Builder.RefactorTwo;

import java.time.LocalDate;

public class UsuarioDTO {
    // ── Campos del objeto final ───────────────────────────────────────
    // final: una vez construido, el objeto no cambia.
    private final String nombre;
    private final String email;
    private final String apellidos;
    private final LocalDate fechaDeNacimiento;
    private final String genero;
    private final String estadoCivil;

    // ── Constructor PRIVADO ───────────────────────────────────────────
    // Nadie puede hacer new UsuarioDTO(...) directamente.
    // El único que puede llamar este constructor es el Builder.
    private UsuarioDTO(Builder builder) {
        this.nombre            = builder.nombre;
        this.email             = builder.email;
        this.apellidos         = builder.apellidos;
        this.fechaDeNacimiento = builder.fechaDeNacimiento;
        this.genero            = builder.genero;
        this.estadoCivil       = builder.estadoCivil;
    }

    // ══════════════════════════════════════════════════════════════════
    // CLASE INTERNA: Builder
    // ══════════════════════════════════════════════════════════════════

    public static class Builder {

        // Campos obligatorios — sin estos no tiene sentido el objeto
        private final String nombre;
        private final String email;
        private final String apellidos;

        // Campos opcionales — tienen valor por defecto null
        private LocalDate fechaDeNacimiento = null;
        private String genero            = null;
        private String estadoCivil       = null;

        // ── Constructor del Builder: solo los obligatorios ────────────
        // Si nombre, email o apellidos no se pasan, el objeto
        // ni siquiera empieza a construirse.
        public Builder(String nombre, String email, String apellidos) {
            if (nombre    == null || nombre.isBlank())
                throw new IllegalArgumentException("El nombre es obligatorio.");
            if (email     == null || email.isBlank())
                throw new IllegalArgumentException("El email es obligatorio.");
            if (apellidos == null || apellidos.isBlank())
                throw new IllegalArgumentException("Los apellidos son obligatorios.");

            this.nombre    = nombre;
            this.email     = email;
            this.apellidos = apellidos;
        }

        // ── Métodos opcionales ────────────────────────────────────────
        // Cada uno retorna "this" para permitir el encadenamiento.
        // El nombre del método dice exactamente qué campo está seteando.
        // No hay ambigüedad posible.

        public Builder fechaDeNacimiento(LocalDate fechaDeNacimiento) {
            this.fechaDeNacimiento = fechaDeNacimiento;
            return this;
        }

        public Builder genero(String genero) {
            this.genero = genero;
            return this;
        }

        public Builder estadoCivil(String estadoCivil) {
            this.estadoCivil = estadoCivil;
            return this;
        }

        // ── build(): construye y retorna el UsuarioDTO final ──────────
        public UsuarioDTO build() {
            return new UsuarioDTO(this);
        }
    }

    // ── Getters ───────────────────────────────────────────────────────
    public String getNombre()            { return nombre; }
    public String getEmail()             { return email; }
    public String getApellidos()         { return apellidos; }
    public LocalDate getFechaDeNacimiento() { return fechaDeNacimiento; }
    public String getGenero()            { return genero; }
    public String getEstadoCivil()       { return estadoCivil; }

    @Override
    public String toString() {
        return "UsuarioDTO {" +
                "\n  nombre            = " + nombre +
                "\n  email             = " + email +
                "\n  apellidos         = " + apellidos +
                "\n  fechaDeNacimiento = " + fechaDeNacimiento +
                "\n  genero            = " + genero +
                "\n  estadoCivil       = " + estadoCivil +
                "\n}";
    }
}
