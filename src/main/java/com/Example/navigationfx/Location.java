package com.Example.navigationfx;

public class Location {

    private String name;
    private double distance;
    private double fuelAvailable;

    public Location(String name, double distance, double fuelAvailable) {
        this.name = name;
        this.distance = distance;
        this.fuelAvailable = fuelAvailable;
    }

    // Step 1: Convert one file line into a Location object
    public static Location fromFileString(String line) {
        String[] parts = line.split(",");

        String name = parts[0];
        double distance = Double.parseDouble(parts[1]);
        double fuelAvailable = Double.parseDouble(parts[2]);

        return new Location(name, distance, fuelAvailable);
    }

    public String getName() {
        return name;
    }

    public double getDistance() {
        return distance;
    }

    public double getFuelAvailable() {
        return fuelAvailable;
    }

    // Step 2: Convert a Location object back into a file line
    public String toFileString() {
        return name + "," + distance + "," + fuelAvailable;
    }

    @Override
    public String toString() {
        return name + " (Distance: " + distance + ", Fuel: " + fuelAvailable + ")";
    }
}
