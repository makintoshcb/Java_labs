package org.example;
// Класс Автомобиль
class Car {
    private String brand;
    private String model;
    private String color;
    private boolean hasSunroof;
    private boolean hasBluetooth;

    // Приватный конструктор
    private Car(Builder builder) {
        this.brand = builder.brand;
        this.model = builder.model;
        this.color = builder.color;
        this.hasSunroof = builder.hasSunroof;
        this.hasBluetooth = builder.hasBluetooth;
    }

    // Геттеры
    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public boolean hasSunroof() {
        return hasSunroof;
    }

    public boolean hasBluetooth() {
        return hasBluetooth;
    }

    // Класс Строитель
    static class Builder {
        private String brand;
        private String model;
        private String color;
        private boolean hasSunroof;
        private boolean hasBluetooth;

        // Конструктор
        public Builder(String brand, String model) {
            this.brand = brand;
            this.model = model;
        }

        // Методы для установки дополнительных опций
        public Builder setColor(String color) {
            this.color = color;
            return this;
        }

        public Builder setHasSunroof(boolean hasSunroof) {
            this.hasSunroof = hasSunroof;
            return this;
        }

        public Builder setHasBluetooth(boolean hasBluetooth) {
            this.hasBluetooth = hasBluetooth;
            return this;
        }

        // Метод для построения объекта Car
        public Car build() {
            return new Car(this);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // Создаем объект Car с использованием паттерна "Строитель"
        Car car = new Car.Builder("Toyota", "Camry")
                .setColor("Red")
                .setHasSunroof(true)
                .setHasBluetooth(true)
                .build();

        // Выводим информацию об автомобиле
        System.out.println("Марка: " + car.getBrand());
        System.out.println("Модель: " + car.getModel());
        System.out.println("Цвет: " + car.getColor());
        System.out.println("Наличие люка: " + (car.hasSunroof() ? "Есть" : "Нет"));
        System.out.println("Наличие Bluetooth: " + (car.hasBluetooth() ? "Есть" : "Нет"));
    }
}