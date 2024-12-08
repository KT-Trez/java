package org.was;

public class Main {
    public static void main(String[] args) {
        Car toyota = new Car(150, "Toyota", "Corolla", 2021);
        Truck truck = new Truck(150, 200, "Star", "20", 1980);

        System.out.println(toyota.getFullDescription() + " | " + toyota.calculateRentalPrice(5) + " PLN");
        System.out.println(truck.getFullDescription() + " | " + toyota.calculateRentalPrice(5) + " PLN");
    }
}