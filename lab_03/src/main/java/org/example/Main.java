package org.example;

// Абстрактный класс устройства
abstract class Device {
    protected DeviceBridge bridge;

    public Device(DeviceBridge bridge) {
        this.bridge = bridge;
    }

    public abstract void operate();
}

// Реализация устройства - робот
class Robot extends Device {
    public Robot(DeviceBridge bridge) {
        super(bridge);
    }

    @Override
    public void operate() {
        bridge.operateDevice();
    }
}

// Реализация устройства - дрон
class Drone extends Device {
    public Drone(DeviceBridge bridge) {
        super(bridge);
    }

    @Override
    public void operate() {
        bridge.operateDevice();
    }
}

// Реализация устройства - автономное автомобиль
class AutonomousCar extends Device {
    public AutonomousCar(DeviceBridge bridge) {
        super(bridge);
    }

    @Override
    public void operate() {
        bridge.operateDevice();
    }
}

// Интерфейс моста
interface DeviceBridge {
    void operateDevice();
}

// Реализация моста для управления устройствами через сеть
class NetworkBridge implements DeviceBridge {
    @Override
    public void operateDevice() {
        // Реализация связи с удаленным устройством по сети
        System.out.println("Управляю устройством через сеть...");
    }
}

// Реализация моста для управления устройствами через Bluetooth
class BluetoothBridge implements DeviceBridge {
    @Override
    public void operateDevice() {
        // Реализация связи с удаленным устройством через Bluetooth
        System.out.println("Управляю устройством через Bluetooth...");
    }
}

public class Main {
    public static void main(String[] args) {
        // Создание и инициализация устройств
        Device robot = new Robot(new NetworkBridge());
        Device drone = new Drone(new BluetoothBridge());
        Device car = new AutonomousCar(new NetworkBridge());

        // Управление устройствами
        robot.operate();
        drone.operate();
        car.operate();
    }
}