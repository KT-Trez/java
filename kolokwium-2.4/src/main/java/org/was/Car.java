package org.was;

public class Car extends Vehicle {
    public double dailyRate;

    Car(double dailyRate, String brand, String model, int year) {
        super(brand, model, year);

        this.dailyRate = dailyRate;
    }

    @Override
    double calculateRentalPrice(int days) {
        return this.dailyRate * days;
    }
}
