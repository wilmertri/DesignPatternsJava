package Creacionales.Builder.RefactorTwo;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        // ── Caso 1: Solo los campos obligatorios ──────────────────────
        // ✅ Sin nulls. Sin ambigüedad.
        //    Los opcionales que no se pasen quedan null por defecto.
        UsuarioDTO usuario1 = new UsuarioDTO.Builder(
                "Ana",
                "ana@email.com",
                "García Ruiz"
        ).build();

        System.out.println("Usuario 1 (solo obligatorios):");
        System.out.println(usuario1);

        // ── Caso 2: Con todos los campos ──────────────────────────────
        // ✅ Cada línea dice exactamente qué campo está seteando.
        //    No hay dudas sobre qué es "MASCULINO" o "SOLTERO".
        UsuarioDTO usuario2 = new UsuarioDTO.Builder(
                "Carlos",
                "carlos@email.com",
                "López Martínez"
        )
                .fechaDeNacimiento(LocalDate.now().minusYears(25))
                .genero("MASCULINO")
                .estadoCivil("SOLTERO")
                .build();

        System.out.println("\nUsuario 2 (todos los campos):");
        System.out.println(usuario2);

        // ── Caso 3: Solo algunos opcionales ──────────────────────────
        // ✅ Solo fecha y género, sin estado civil.
        //    Antes no había un constructor para esta combinación.
        //    Ahora simplemente no se llama .estadoCivil().
        UsuarioDTO usuario3 = new UsuarioDTO.Builder(
                "María",
                "maria@email.com",
                "Ruiz Torres"
        )
                .fechaDeNacimiento(LocalDate.now().minusYears(30))
                .genero("FEMENINO")
                .build();

        System.out.println("\nUsuario 3 (fecha y género, sin estado civil):");
        System.out.println(usuario3);

        // ── Caso 4: Validación de obligatorios ────────────────────────
        // ✅ Si se omite un campo obligatorio, el error es inmediato
        //    y el mensaje dice exactamente qué falta.
        System.out.println("\nIntentando crear usuario sin email:");
        try {
            UsuarioDTO usuarioInvalido = new UsuarioDTO.Builder(
                    "Pedro",
                    "",              // email vacío
                    "Ramírez"
            ).build();
        } catch (IllegalArgumentException e) {
            System.out.println("❌ " + e.getMessage());
        }
    }
}
