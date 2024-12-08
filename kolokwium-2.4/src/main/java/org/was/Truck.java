package org.was;

public class Truck extends Vehicle {
    public double dailyRate;
    public double cargoWeight;

    Truck(double dailyRate, double cargoWeight, String brand, String model, int year) {
        super(brand, model, year);

        this.dailyRate = dailyRate;
        this.cargoWeight = cargoWeight;
    }

    @Override
    double calculateRentalPrice(int days) {
        return this.dailyRate * days + cargoWeight * 100;
    }
}
