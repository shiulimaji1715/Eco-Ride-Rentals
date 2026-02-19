package com.Rental;

import com.Customer.Customer;
import com.Vehicle.Vehicle;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Rental {
    private int id;
    private Customer customer;
    private Vehicle vehicle;
    private LocalDate startDate;
    private LocalDate endDate;
    private double totalCost;

    public Rental(int id, Customer customer, Vehicle vehicle, LocalDate startDate, LocalDate endDate) {
        this.id = id;
        this.customer = customer;
        this.vehicle = vehicle;
        this.startDate = startDate;
        this.endDate = endDate;

        long days = ChronoUnit.DAYS.between(startDate, endDate);
        if (days <= 0) days = 1; // minimum 1 day rental
        this.totalCost = days * vehicle.getPricePerDay();

        vehicle.setAvailable(false);
    }

    @Override
    public String toString() {
        return "Rental #" + id + " | " + customer.getName() + " rented "
               + vehicle.getBrand() + " " + vehicle.getModel()
               + " from " + startDate + " to " + endDate
               + " | Total: ₹" + totalCost;
    }
}
