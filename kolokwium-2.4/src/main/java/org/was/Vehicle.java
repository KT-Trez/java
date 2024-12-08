package org.was;

public abstract class Vehicle {
    public String brand;
    public String model;
    public int year;

    public Vehicle(String brand, String model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
    }

    public String getFullDescription() {
        return "Brand: " + this.brand + ", Model: " + this.model + ", Year: " + this.year;
    }

    abstract double calculateRentalPrice(int days);
}
