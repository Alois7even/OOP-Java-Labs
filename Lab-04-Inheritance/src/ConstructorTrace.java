class Vehicle {
    Vehicle(String brand) {
        System.out.println("1. Vehicle constructor: " + brand);
    }
}

class Car extends Vehicle {
    Car(String brand, int doors) {
        super(brand);
        System.out.println("2. Car constructor: " + doors + " doors");
    }
}

class ElectricCar extends Car {
    ElectricCar(String brand, int doors, int batteryKwh) {
        super(brand, doors);
        System.out.println("3. ElectricCar constructor: " + batteryKwh + " kWh");
    }
}

public class ConstructorTrace {
    public static void main(String[] args) {
        new ElectricCar("Tesla", 4, 75);
    }
}