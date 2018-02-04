package company.utils.logger;

import java.util.ArrayList;
import java.util.List;

public class LogContainer {
    private List<LogEvent> logCotainer;

    public LogContainer() {
        this.logCotainer = new ArrayList<>();
    }

    public void saveLog(LogEvent event) { logCotainer.add(event); }
}
