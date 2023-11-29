package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

// Класс "Логгер событий"
public class EventLogger {
    private static EventLogger instance;
    private PrintWriter writer;

    private EventLogger() {
        try {
            writer = new PrintWriter(new FileWriter("event_log.txt", true));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static synchronized EventLogger getInstance() {
        if (instance == null) {
            instance = new EventLogger();
        }
        return instance;
    }

    public void logEvent(String event) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String timestamp = dateFormat.format(new Date());
        writer.println(timestamp + ": " + event);
        writer.flush();
    }

    public void close() {
        writer.close();
    }
}
