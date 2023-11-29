package org.example;
import java.io.File;
import java.io.IOException;

// Интерфейс для адаптера чтения данных
interface DataReader {
    void readData(File file) throws IOException;
}

// Интерфейс для адаптера записи данных
interface DataWriter {
    void writeData(File file) throws IOException;
}

// Адаптер для чтения данных из CSV файла
class CsvDataReader implements DataReader {
    @Override
    public void readData(File file) throws IOException {
        // Реализация чтения данных из CSV файла
        System.out.println("Читаю данные из CSV файла " + file.getName() + "...");
    }
}

// Адаптер для чтения данных из JSON файла
class JsonDataReader implements DataReader {
    @Override
    public void readData(File file) throws IOException {
        // Реализация чтения данных из JSON файла
        System.out.println("Читаю данные из JSON файла " + file.getName() + "...");
    }
}

// Адаптер для чтения данных из XML файла
class XmlDataReader implements DataReader {
    @Override
    public void readData(File file) throws IOException {
        // Реализация чтения данных из XML файла
        System.out.println("Читаю данные из XML файла " + file.getName() + "...");
    }
}

// Адаптер для записи данных в CSV файл
class CsvDataWriter implements DataWriter {
    @Override
    public void writeData(File file) throws IOException {
        // Реализация записи данных в CSV файл
        System.out.println("Записываю данные в CSV файл " + file.getName() + "...");
    }
}

// Адаптер для записи данных в JSON файл
class JsonDataWriter implements DataWriter {
    @Override
    public void writeData(File file) throws IOException {
        // Реализация записи данных в JSON файл
        System.out.println("Записываю данные в JSON файл " + file.getName() + "...");
    }
}

// Адаптер для записи данных в XML файл
class XmlDataWriter implements DataWriter {
    @Override
    public void writeData(File file) throws IOException {
        // Реализация записи данных в XML файл
        System.out.println("Записываю данные в XML файл " + file.getName() + "...");
    }
}

public class Main {
    public static void main(String[] args) {
        // Пример использования адаптеров

        // Чтение данных из CSV файла
        File csvFile = new File("data.csv");
        DataReader csvDataReader = new CsvDataReader();
        try {
            csvDataReader.readData(csvFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Чтение данных из JSON файла
        File jsonFile = new File("data.json");
        DataReader jsonDataReader = new JsonDataReader();
        try {
            jsonDataReader.readData(jsonFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Чтение данных из XML файла
        File xmlFile = new File("data.xml");
        DataReader xmlDataReader = new XmlDataReader();
        try {
            xmlDataReader.readData(xmlFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Запись данных в CSV файл
        File csvOutputFile = new File("output.csv");
        DataWriter csvDataWriter = new CsvDataWriter();
        try {
            csvDataWriter.writeData(csvOutputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Запись данных в JSON файл
        File jsonOutputFile = new File("output.json");
        DataWriter jsonDataWriter = new JsonDataWriter();
        try {
            jsonDataWriter.writeData(jsonOutputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Запись данных в XML файл
        File xmlOutputFile = new File("output.xml");
        DataWriter xmlDataWriter = new XmlDataWriter();
        try {
            xmlDataWriter.writeData(xmlOutputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}