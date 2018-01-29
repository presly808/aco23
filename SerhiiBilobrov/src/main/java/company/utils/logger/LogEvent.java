package company.utils.logger;

import java.util.Date;

/**
 * Created by serhii on 28.01.18.
 */
public class LogEvent {
    private final String location;
    private final Date date;
    private final String message;

    public LogEvent(String location, Date date, String message) {
        this.location = location;
        this.date = date;
        this.message = message;
    }

    public String getLocation() {
        return location;
    }

    public Date getDate() {
        return date;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "LogEvent{" +
                "location='" + location + '\'' +
                ", date=" + date +
                ", message='" + message + '\'' +
                '}';
    }
}
