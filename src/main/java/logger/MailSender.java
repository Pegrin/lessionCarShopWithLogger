package logger;

import java.util.Properties;
import java.util.StringTokenizer;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * Created by olymp on 14.02.2017.
 */
public class MailSender {
    public static void sendMail(final String mailUserName, final String mailPassword, String SMTPHost, int SMTPPort, String theme, String msg){

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", SMTPHost);
        props.put("mail.smtp.port", String.valueOf(SMTPPort));

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(mailUserName, mailPassword);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("logger@wtiger.org"));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse("mail@wtiger.org"));
            message.setSubject(theme);
            message.setText(msg);

            Transport.send(message);

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
