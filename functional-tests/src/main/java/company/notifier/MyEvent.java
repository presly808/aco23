package company.notifier;

import java.util.Date;

/**
 * Created by serhii on 27.01.18.
 */
public class MyEvent {

    private Date date;
    private String place;
    private Object info;

    public MyEvent() {
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Object getInfo() {
        return info;
    }

    public void setInfo(Object info) {
        this.info = info;
    }
}
