package Creacionales.FactoryMethod.Refactor;
// ══════════════════════════════════════════════════════════════════════
// PASO 4: Agregar WhatsApp sin tocar nada de lo anterior.
//
// Esta es la prueba del OCP en acción:
// el sistema se EXTENDIÓ con un nuevo canal sin MODIFICAR
// ninguna clase existente.
// ══════════════════════════════════════════════════════════════════════
public class NotificacionWhatsApp implements Notificacion{
    @Override
    public void enviar(String destinatario, String mensaje) {
        System.out.println("💬 [WHATSAPP] Para: " + destinatario);
        System.out.println("   Mensaje: " + mensaje);
        System.out.println("   (Enviando por WhatsApp Business API...)");
    }
}
