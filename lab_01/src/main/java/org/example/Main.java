package org.example;

// Абстрактный класс инструмента рисования
abstract class DrawingTool {
    abstract void draw();
}

// Класс карандаша
class Pencil extends DrawingTool {
    void draw() {
        System.out.println("Draw pensil");
    }
}

// Класс кисти
class Brush extends DrawingTool {
    void draw() {
        System.out.println("Draw brush");
    }
}

// Класс ластика
class Eraser extends DrawingTool {
    void draw() {
        System.out.println("Draw eraser");
    }
}

// Фабрика инструментов рисования
class DrawingToolFactory {
    static DrawingTool createTool(String toolType) {
        if (toolType.equals("карандаш")) {
            return new Pencil();
        } else if (toolType.equals("кисть")) {
            return new Brush();
        } else if (toolType.equals("ластик")) {
            return new Eraser();
        }
        return null;
    }

    public static void main(String []args) {


// Пример использования

// Создание фабрики инструментов рисования
        DrawingToolFactory factory = new DrawingToolFactory();

// Создание инструментов с помощью фабрики
        DrawingTool pencil = factory.createTool("карандаш");
        DrawingTool brush = factory.createTool("кисть");
        DrawingTool eraser = factory.createTool("ластик");

// Использование инструментов для рисования
        pencil.draw();
        brush.draw();
        eraser.draw();
    }
}