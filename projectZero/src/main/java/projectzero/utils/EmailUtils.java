package projectzero.utils;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import java.util.concurrent.CompletableFuture;

public class EmailUtils {

    private static Properties props;

    static {
        props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");
    }

    public static void notifyUser(String email, String title, String text) {
        CompletableFuture.runAsync(() ->
        {
            try {
                sendHTMLEmail(
                        "service.projectzero@gmail.com",
                        email,
                        title,
                        "<h1>" + text + "</h1>",
                        "projectZero.pass"
                );
            } catch (MessagingException e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * Send html email via Gmail
     *
     * @param from     - sender's email address
     * @param to       - recipient's email address
     * @param title    - subject of email
     * @param htmlText - html email
     * @param password - password of sender gmail account
     * @throws MessagingException if problems with connection or authentication
     */
    private static void sendHTMLEmail(String from, String to, String title, String htmlText, String password) throws MessagingException {
        Message message = new MimeMessage(getSession(from, password));

        message.setFrom(new InternetAddress(from));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
        message.setSubject(title);
        message.setContent(htmlText, "text/html");

        Transport.send(message);
    }

    private static Session getSession(String email, String password) {
        return Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(email.substring(0, email.indexOf("@")), password);
                    }
                });
    }
}
