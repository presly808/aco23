package company.utils.logger;

import java.util.Date;

public class LogEvent {

    private final String location;
    private final Date date;
    private final String message;

    public LogEvent(String location, Date date, String message) {
        this.location = location;
        this.date = date;
        this.message = message;
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
