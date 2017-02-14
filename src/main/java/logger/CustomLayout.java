package logger;

import org.apache.log4j.PatternLayout;
import org.apache.log4j.spi.LoggingEvent;

import java.util.Date;

/**
 * Created by olymp on 14.02.2017.
 */
public class CustomLayout extends PatternLayout {
    @Override
    public String format(LoggingEvent event) {
        String s = event.getMessage().toString();

        StringBuffer sb = new StringBuffer();
        String level = event.getLevel().toString();
        String time = String.valueOf(new Date());
        String msg = event.getMessage().toString();

        sb.append(time);
        sb.append(": ").append(level).append(": ");
        sb.append(msg);
        sb.append("\n");

        return sb.toString();
    }
}
