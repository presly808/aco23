package proxy;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LogContainer {

    private List<LogEvent> logEventList;

    public LogContainer() {
        this.logEventList = new ArrayList<>();
    }

    public void saveLog(LogEvent logEvent) throws IOException {
        logEventList.add(logEvent);
        File log = new File("log.txt");

        FileWriter fileWriter = new FileWriter(log, true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write(" ******* " + logEvent.toString() + " ******* " + "\n");
        bufferedWriter.close();
    }
}