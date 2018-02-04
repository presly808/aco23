package company.notifier;

import java.util.Date;

public class MyEvent {
    private final Date date;
    private final String place;
    private final Object info;

    public MyEvent(Date date, String place, Object info) {
        this.date = date;
        this.place = place;
        this.info = info;
    }

    public Date getDate() {
        return date;
    }


    public String getPlace() {
        return place;
    }


    public Object getInfo() {
        return info;
    }

}
