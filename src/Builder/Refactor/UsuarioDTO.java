package Builder.Refactor;

import java.time.LocalDate;

public class UsuarioDTO {
    private final String nombre;
    private final String email;
    private final String apellidos;
    private final LocalDate fechaDeNacimiento;
    private final String genero;
    private final String estadoCivil;

    public UsuarioDTO(String nombre,
                      String email,
                      String apellidos,
                      LocalDate fechaDeNacimiento,
                      String genero,
                      String estadoCivil) {
        this.nombre           = nombre;
        this.email            = email;
        this.apellidos        = apellidos;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.genero           = genero;
        this.estadoCivil      = estadoCivil;
    }

    public static class Builder {
        private String nombre;
        private String email;
        private String apellidos;
        private LocalDate fechaDeNacimiento;
        private String genero;
        private String estadoCivil;

        public Builder nombre(String nombre) {
            this.nombre = nombre;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder apellidos(String apellidos) {
            this.apellidos = apellidos;
            return this;
        }

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

        public UsuarioDTO build() {
            return new UsuarioDTO(nombre, email, apellidos, fechaDeNacimiento, genero, estadoCivil);
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
