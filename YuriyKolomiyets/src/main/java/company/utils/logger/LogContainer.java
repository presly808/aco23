package company.utils.logger;

import java.util.ArrayList;
import java.util.List;

public class LogContainer {

    private List<LogEvent> logEventList;

    public LogContainer() {
        this.logEventList = new ArrayList<>();
    }

    public void saveLog(LogEvent logEvent) {
        logEventList.add(logEvent);
    }
}
