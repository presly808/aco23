package proxy;

import appDb.AppDb;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class LogEvent {

    private String place;
    private LocalDateTime localDateTime;


    public LogEvent(String place) {
        this.place = place;
        this.localDateTime = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "LogEvent: " +
                "method occur: " + place + '\'' +
                ", at " + localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")) +
                '}';
    }
}
