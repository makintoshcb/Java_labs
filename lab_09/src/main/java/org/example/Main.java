package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

// Пример использования "Логгера событий"
public class Main {
    public static void main(String[] args) {
        EventLogger logger = EventLogger.getInstance();

        logger.logEvent("Событие 1");
        logger.logEvent("Событие 2");
        logger.logEvent("Событие 3");

        logger.close();
    }
}