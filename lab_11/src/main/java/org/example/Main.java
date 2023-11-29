package org.example;

import java.util.HashMap;
import java.util.Map;

// Абстрактный класс для игрового персонажа
abstract class Character implements Cloneable {
    protected String name;
    protected int level;
    protected int health;

    public Character(String name, int level, int health) {
        this.name = name;
        this.level = level;
        this.health = health;
    }

    public abstract void attack();

    // Метод клонирования персонажа
    @Override
    public Character clone() throws CloneNotSupportedException {
        return (Character) super.clone();
    }
}

// Конкретный класс игрового персонажа "Воин"
class Warrior extends Character {
    private int strength;

    public Warrior(String name, int level, int health, int strength) {
        super(name, level, health);
        this.strength = strength;
    }

    @Override
    public void attack() {
        System.out.println("Воин " + name + " атакует с силой " + strength);
    }
}

// Конкретный класс игрового персонажа "Маг"
class Mage extends Character {
    private int mana;

    public Mage(String name, int level, int health, int mana) {
        super(name, level, health);
        this.mana = mana;
    }

    @Override
    public void attack() {
        System.out.println("Маг " + name + " атакует с использованием маны " + mana);
    }
}

// Класс-менеджер, реализующий паттерн "Прототип"
class CharacterManager {
    private Map<String, Character> characters;

    public CharacterManager() {
        characters = new HashMap<>();
    }

    // Метод для регистрации игровых персонажей
    public void registerCharacter(String name, Character character) {
        characters.put(name, character);
    }

    // Метод для получения клонированного персонажа по имени
    public Character getCharacter(String name) throws CloneNotSupportedException {
        Character character = characters.get(name);
        return character.clone();
    }
}

// Пример использования паттерна "Прототип" для управления игровыми персонажами
public class Main {
    public static void main(String[] args) {
        // Создаем менеджер персонажей
        CharacterManager characterManager = new CharacterManager();

        // Регистрируем воина
        Warrior warrior = new Warrior("Воин", 10, 100, 50);
        characterManager.registerCharacter("Warrior", warrior);

        // Регистрируем мага
        Mage mage = new Mage("Маг", 10, 100, 100);
        characterManager.registerCharacter("Mage", mage);

        try {
            // Клонируем воина и атакуем
            Character clonedWarrior = characterManager.getCharacter("Warrior");
            clonedWarrior.attack();

            // Клонируем мага и атакуем
            Character clonedMage = characterManager.getCharacter("Mage");
            clonedMage.attack();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
