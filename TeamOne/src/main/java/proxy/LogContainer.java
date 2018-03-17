package proxy;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// todo move to utills or even delete if we use log4j
public class LogContainer {

    private List<LogEvent> logEventList;

    public LogContainer() {
        this.logEventList = new ArrayList<>();
    }

    // todo wrong creating and closing of the stream
    // todo extract filename as a constant
    public void saveLog(LogEvent logEvent) throws IOException {
        logEventList.add(logEvent);
        File log = new File("log.txt");

        FileWriter fileWriter = new FileWriter(log, true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write(" ******* " + logEvent.toString() + " ******* " + "\n");
        bufferedWriter.close();
    }
}