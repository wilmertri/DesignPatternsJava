package Builder.Challenge;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // ❌ PROBLEMA 2: Al leer esta línea, es imposible saber
        //    qué campo corresponde a cada valor sin ir al constructor.
        //    ¿"MASCULINO" es el género o el estado civil?
        //    ¿"SOLTERO" es el estado civil o el género?
        //    Solo lo sabe quien escribió el constructor.
        UsuarioDTO usuario1 = new UsuarioDTO(
                "Carlos",
                "carlos@email.com",
                "López Martínez",
                LocalDate.now().minusYears(20),
                "MASCULINO",   // ← ¿esto es genero o estadoCivil?
                "SOLTERO"      // ← ¿esto es estadoCivil o genero?
        );
        System.out.println("Usuario 1:");
        System.out.println(usuario1);

        // ❌ PROBLEMA 3: Si género y estado civil son opcionales,
        //    el caller está obligado a pasar null explícitamente.
        //    El código queda lleno de nulls sin contexto.
        UsuarioDTO usuario2 = new UsuarioDTO(
                "Ana",
                "ana@email.com",
                "García Ruiz",
                LocalDate.now().minusYears(35),
                null,   // ← ¿qué campo es este null?
                null    // ← ¿y este?
        );
        System.out.println("\nUsuario 2:");
        System.out.println(usuario2);

        // ❌ PROBLEMA 4: Si mañana se agrega un campo nuevo,
        //    por ejemplo "telefono", hay que actualizar el constructor
        //    Y cada una de estas llamadas en todo el proyecto.
    }
}
