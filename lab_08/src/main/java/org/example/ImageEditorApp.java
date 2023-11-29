package org.example;
import java.util.ArrayList;
import java.util.List;

// Интерфейс для команд редактора
interface Command {
    void execute();
}

// Класс для редактирования изображений
class ImageEditor {
    private List<Command> history;

    public ImageEditor() {
        history = new ArrayList<>();
    }

    // Метод для выполнения команды редактирования
    public void executeCommand(Command command) {
        command.execute();
        history.add(command);
    }

    // Метод для отмены последней команды
    public void undo() {
        if (!history.isEmpty()) {
            Command lastCommand = history.remove(history.size() - 1);
            lastCommand.execute(); // Опционально можно сделать отмену команды
        } else {
            System.out.println("История изменений пуста");
        }
    }

    // Метод для сохранения истории изменений
    public List<Command> saveHistory() {
        return new ArrayList<>(history);
    }

    // Метод для восстановления истории изменений
    public void restoreHistory(List<Command> savedHistory) {
        history = new ArrayList<>(savedHistory);
    }
}

// Пример команды для изменения яркости изображения
class BrightnessCommand implements Command {
    private int oldValue;
    private int newValue;

    public BrightnessCommand(int newValue) {
        this.newValue = newValue;
    }

    @Override
    public void execute() {
        // Изменение яркости изображения
        System.out.println("Изменение яркости изображения: " + newValue);
    }
}

// Пример команды для резкости изображения
class SharpnessCommand implements Command {
    private int oldValue;
    private int newValue;

    public SharpnessCommand(int newValue) {
        this.newValue = newValue;
    }

    @Override
    public void execute() {
        // Изменение резкости изображения
        System.out.println("Изменение резкости изображения: " + newValue);
    }
}

public class ImageEditorApp {
    public static void main(String[] args) {
        // Создание редактора изображений
        ImageEditor editor = new ImageEditor();

        // Создание и выполнение команд редактирования
        BrightnessCommand brightnessCommand = new BrightnessCommand(50);
        editor.executeCommand(brightnessCommand);

        SharpnessCommand sharpnessCommand = new SharpnessCommand(2);
        editor.executeCommand(sharpnessCommand);

        // Отмена последней команды
        editor.undo();

        // Сохранение истории изменений
        List<Command> savedHistory = editor.saveHistory();

        // Восстановление истории изменений
        editor.restoreHistory(savedHistory);

        // Повторное выполнение истории изменений
        for (Command command : savedHistory) {
            editor.executeCommand(command);
        }
    }
}