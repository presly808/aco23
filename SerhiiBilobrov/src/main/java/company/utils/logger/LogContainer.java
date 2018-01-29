package company.utils.logger;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by serhii on 28.01.18.
 */
public class LogContainer {

    private List<LogEvent> logEventList;

    public LogContainer() {
        this.logEventList = new ArrayList<>();
    }

    public void saveLog(LogEvent logEvent) {
        logEventList.add(logEvent);
    }
}
