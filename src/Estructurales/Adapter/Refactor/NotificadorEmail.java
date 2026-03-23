package Estructurales.Adapter.Refactor;

public interface NotificadorEmail {
    void enviarEmail(String destinatario, String asunto, String cuerpo);
}
