package company.utils.logger;

public class LogEvent {

    private final String place;
    private final long time;

    public LogEvent(String place, long time ) {
        this.place = place;
        this.time = time;
    }

    public String getPlace() {
        return place;
    }

    public long getTime() {
        return time;
    }

    @Override
    public String toString() {
        return "LogEvent{" +
                "place='" + place + '\'' +
                ", time=" + time +
                '}';
    }
}
