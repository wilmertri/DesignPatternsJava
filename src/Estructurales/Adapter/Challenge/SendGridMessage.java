package Estructurales.Adapter.Challenge;

public class SendGridMessage {
    private String to;
    private String subject;
    private String htmlBody;
    private String apiKey;

    public SendGridMessage(String to, String subject,
                           String htmlBody, String apiKey) {
        this.to       = to;
        this.subject  = subject;
        this.htmlBody = htmlBody;
        this.apiKey   = apiKey;
    }

    public String getTo()       { return to; }
    public String getSubject()  { return subject; }
    public String getHtmlBody() { return htmlBody; }
    public String getApiKey()   { return apiKey; }
}
