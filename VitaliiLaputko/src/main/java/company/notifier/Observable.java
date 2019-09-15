package company.notifier;

public interface Observable {
    void addListener(MyListener myListener);
    void callListener();
}
