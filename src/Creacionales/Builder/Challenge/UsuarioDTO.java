package Creacionales.Builder.Challenge;

import java.time.LocalDate;

public class UsuarioDTO {
    private String nombre;
    private String email;
    private String apellidos;
    private LocalDate fechaDeNacimiento;
    private String genero;
    private String estadoCivil;

    // ❌ PROBLEMA 1: Un solo constructor obliga a pasar TODOS los campos.
    //    ¿Qué pasa si el género o el estado civil son opcionales?
    //    El caller igual debe pasarlos, aunque sea null.
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
