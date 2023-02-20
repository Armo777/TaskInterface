package ru.top.core;

public class CoffeeMachineModel implements CoffeeMachine, ErrorDisplay {

    private int waterCapacity;
    private int coffeeCapacity;
    private int wasteCapacity;

    public CoffeeMachineModel(int waterCapacity, int coffeeCapacity, int wasteCapacity) {
        this.waterCapacity = waterCapacity;
        this.coffeeCapacity = coffeeCapacity;
        this.wasteCapacity = wasteCapacity;
    }

    public int getWaterCapacity() {
        return waterCapacity;
    }

    public void setWaterCapacity(int waterCapacity) {
        this.waterCapacity = waterCapacity;
    }

    public int getCoffeeCapacity() {
        return coffeeCapacity;
    }

    public void setCoffeeCapacity(int coffeeCapacity) {
        this.coffeeCapacity = coffeeCapacity;
    }

    public int getWasteCapacity() {
        return wasteCapacity;
    }

    public void setWasteCapacity(int wasteCapacity) {
        this.wasteCapacity = wasteCapacity;
    }

    @Override
    public void turnOn() {
        System.out.println("Кофемашина включена");
    }

    @Override
    public void turnOff() {
        System.out.println("Кофемашина выключена");
    }

    @Override
    public void makeEspresso() {
        if (coffeeCapacity < 22) {
            displayError("Отсутствует молотое кофе");
        } else if (waterCapacity < 30) {
            displayError("Отсутствует вода");
        } else {
            coffeeCapacity -= 22;
            waterCapacity -= 30;
            wasteCapacity += 22;
            System.out.println("Эспрессо готов");
        }
    }

    @Override
    public void makeAmericano() {
        if (coffeeCapacity < 22) {
            displayError("Отсутствует молотое кофе");
        } else if (waterCapacity < 100) {
            displayError("Отсутствует вода");
        } else {
            coffeeCapacity -= 22;
            waterCapacity -= 100;
            wasteCapacity += 22;
            System.out.println("Американо готов");
        }
    }

    @Override
    public void clean() {
        wasteCapacity = 0;
        System.out.println("Бак отработанного кофе очищен");
    }

    @Override
    public void displayError(String errorMessage) {
        System.out.println("Ошибка: " + errorMessage);
    }
}
