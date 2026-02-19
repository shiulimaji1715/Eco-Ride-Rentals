package com.Vehicle;

public class Vehicle {
    private int id;
    private String type;
    private String brand;
    private String model;
    private boolean available;
    private double pricePerDay;

    public Vehicle(int id, String type, String brand, String model, double pricePerDay) {
        this.id = id;
        this.type = type;
        this.brand = brand;
        this.model = model;
        this.pricePerDay = pricePerDay;
        this.available = true;
    }

    public int getId() { return id; }
    public String getType() { return type; }
    public String getBrand() { return brand; }
    public String getModel() { return model; }
    public boolean isAvailable() { return available; }
    public double getPricePerDay() { return pricePerDay; }

    public void setAvailable(boolean available) { this.available = available; }

    @ Override
    public String toString() {
        return id + " - " + brand + " " + model + " (" + type + ") ₹" + pricePerDay + "/day | Available: " + available;
    }
}