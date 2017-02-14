package logger;

import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.spi.LoggingEvent;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by olymp on 14.02.2017.
 */
public class CustomAppender extends AppenderSkeleton {

    @Override
    protected void append(LoggingEvent loggingEvent) {
        String event = layout.format(loggingEvent);
        System.out.println(event);
    }

    @Override
    public void close() {}

    @Override
    public boolean requiresLayout() {
        return false;
    }
}
