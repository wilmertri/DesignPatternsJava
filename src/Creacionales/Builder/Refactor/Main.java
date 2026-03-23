package Creacionales.Builder.Refactor;

public class Main {
    public static void main(String[] args) {
        UsuarioDTO usuario1 = new UsuarioDTO.Builder()
                .nombre("Juan")
                .email("juan@mail.com")
                .apellidos("Perez Leon")
                .build();
        System.out.println("Usuario 1:");
        System.out.println(usuario1);
    }
}
