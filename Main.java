package com.main;

import com.Vehicle.Vehicle;
import com.Customer.Customer;
import com.Rental.Rental;

import java.util.*;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Vehicle> vehicles = new ArrayList<>();
        List<Customer> customers = new ArrayList<>();
        List<Rental> rentals = new ArrayList<>();

        while (true) {
            System.out.println("\n--- EcoRideRental Menu ---");
            System.out.println("1. Add Vehicle");
            System.out.println("2. List Vehicles");
            System.out.println("3. Update Vehicle Availability");
            System.out.println("4. Delete Vehicle");
            System.out.println("5. List Customers");
            System.out.println("6. Add Customer");
            System.out.println("7. Rent a Vehicle");
            System.out.println("8. List Rentals");
            System.out.println("9. Exit");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> vehicles.forEach(System.out::println);
                case 2 -> {
                    System.out.print("Enter vehicle ID: ");
                    int newVid = sc.nextInt(); sc.nextLine();
                    System.out.print("Enter type: ");
                    String type = sc.nextLine();
                    System.out.print("Enter brand: ");
                    String brand = sc.nextLine();
                    System.out.print("Enter model: ");
                    String model = sc.nextLine();
                    System.out.print("Enter price per day: ");
                    double price = sc.nextDouble();
                    vehicles.add(new Vehicle(newVid, type, brand, model, price));
                    System.out.println("Vehicle added successfully!");
                }
                case 3 -> {
                    System.out.print("Enter vehicle ID to update availability: ");
                    int updateVid = sc.nextInt();
                    Vehicle updateVehicle = vehicles.stream()
                        .filter(v -> v.getId() == updateVid)
                        .findFirst().orElse(null);
                    if (updateVehicle != null) {
                        System.out.print("Enter availability (true/false): ");
                        boolean avail = sc.nextBoolean();
                        updateVehicle.setAvailable(avail);
                        System.out.println("Vehicle availability updated!");
                    } else {
                        System.out.println("Vehicle not found.");
                    }
                }
                case 4 -> {
                    System.out.print("Enter vehicle ID to delete: ");
                    int delVid = sc.nextInt();
                    vehicles.removeIf(v -> v.getId() == delVid);
                    System.out.println("Vehicle deleted successfully!");
                }
                case 5 -> customers.forEach(System.out::println);
                case 6 -> {
                    System.out.print("Enter customer ID: ");
                    int newCid = sc.nextInt(); sc.nextLine();
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter email: ");
                    String email = sc.nextLine();
                    System.out.print("Enter phone: ");
                    String phone = sc.nextLine();
                    customers.add(new Customer(newCid, name, email, phone));
                    System.out.println("Customer added successfully!");
                }
                case 7 -> {
                    System.out.print("Enter customer ID: ");
                    int cid = sc.nextInt();
                    System.out.print("Enter vehicle ID: ");
                    int vid = sc.nextInt();
                    System.out.print("Enter rental days: ");
                    int days = sc.nextInt();

                    Customer c = customers.stream().filter(x -> x.getId() == cid).findFirst().orElse(null);
                    Vehicle v = vehicles.stream().filter(x -> x.getId() == vid && x.isAvailable()).findFirst().orElse(null);

                    if (c != null && v != null) {
                        Rental r = new Rental(rentals.size() + 1, c, v, LocalDate.now(), LocalDate.now().plusDays(days));
                        rentals.add(r);
                        System.out.println("Rental successful: " + r);
                    } else {
                        System.out.println("Invalid customer or vehicle not available.");
                    }
                }
                case 8 -> rentals.forEach(System.out::println);
                case 9 -> {
                    System.out.println("Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
