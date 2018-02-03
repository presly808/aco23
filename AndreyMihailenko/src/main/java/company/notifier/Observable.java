package company.notifier;

/**
 * Created by serhii on 27.01.18.
 */
public interface Observable {
    void addListener(MyListener myListener);

    void callListener();
}
