package company.notifier;

public interface Observable {
    void callListener();
    void addListener(MyListener myListener);
}
