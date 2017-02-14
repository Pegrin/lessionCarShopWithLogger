package logger;

import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.spi.LoggingEvent;

import java.util.Date;

/**
 * Created by olymp on 14.02.2017.
 */
public class CustomAppenderEmail extends AppenderSkeleton {
    private String username = "";
    private String password = "";

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    protected void append(LoggingEvent loggingEvent) {
        String event = layout.format(loggingEvent);
        MailSender.sendMail(username, password,
                "smtp.yandex.ru", 465, "Сообщение логгера", event);

    }

    @Override
    public void close() {

    }

    @Override
    public boolean requiresLayout() {
        return false;
    }
}
