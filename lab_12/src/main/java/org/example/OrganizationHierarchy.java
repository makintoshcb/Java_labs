package org.example;

import java.util.ArrayList;
import java.util.List;

// Абстрактный класс, представляющий компонент организационной иерархии
abstract class OrganizationComponent {
    protected String name;

    public OrganizationComponent(String name) {
        this.name = name;
    }

    public abstract void add(OrganizationComponent component);
    public abstract void remove(OrganizationComponent component);
    public abstract void display(int depth);
}

// Класс, представляющий подразделение
class Department extends OrganizationComponent {
    private List<OrganizationComponent> components;

    public Department(String name) {
        super(name);
        components = new ArrayList<>();
    }

    @Override
    public void add(OrganizationComponent component) {
        components.add(component);
    }

    @Override
    public void remove(OrganizationComponent component) {
        components.remove(component);
    }

    @Override
    public void display(int depth) {
        String indentation = "";
        for (int i = 0; i < depth; i++) {
            indentation += "-";
        }
        System.out.println(indentation + name);

        for (OrganizationComponent component : components) {
            component.display(depth + 1);
        }
    }
}

// Класс, представляющий сотрудника
class Employee extends OrganizationComponent {
    public Employee(String name) {
        super(name);
    }

    @Override
    public void add(OrganizationComponent component) {
        throw new UnsupportedOperationException("Cannot add to an employee");
    }

    @Override
    public void remove(OrganizationComponent component) {
        throw new UnsupportedOperationException("Cannot remove from an employee");
    }

    @Override
    public void display(int depth) {
        String indentation = "";
        for (int i = 0; i < depth; i++) {
            indentation += "-";
        }
        System.out.println(indentation + name);
    }
}

// Пример использования организационной иерархии
public class OrganizationHierarchy {
    public static void main(String[] args) {
        // Создание подразделений
        OrganizationComponent engineeringDepartment = new Department("Engineering Department");
        OrganizationComponent salesDepartment = new Department("Sales Department");

        // Создание сотрудников
        OrganizationComponent johnDoe = new Employee("John Doe");
        OrganizationComponent janeSmith = new Employee("Jane Smith");
        OrganizationComponent aliceJohnson = new Employee("Alice Johnson");
        OrganizationComponent bobWilliams = new Employee("Bob Williams");

        // Добавление сотрудников в подразделения
        engineeringDepartment.add(johnDoe);
        engineeringDepartment.add(janeSmith);
        salesDepartment.add(aliceJohnson);
        salesDepartment.add(bobWilliams);

        // Вывод иерархии
        engineeringDepartment.display(0);
        salesDepartment.display(0);
    }
}