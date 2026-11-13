package com.Example.navigationfx;

public class Vehicle {

    private String name;
    private Location currentLocation;
    private double fuel;

    public Vehicle(String name, Location startLocation, double fuel) {
        this.name = name;
        this.currentLocation = startLocation;
        this.fuel = fuel;
    }

    public String getName() {
        return name;
    }

    public Location getCurrentLocation() {
        return currentLocation;
    }

    public double getFuel() {
        return fuel;
    }

    public String move(Location destination) {
        double distance = Math.abs(destination.getDistance());
        if (fuel < distance) {
            return "Not enough fuel to move.";
        }

        fuel -= distance;
        currentLocation = destination;
        return "Vehicle moved to " + destination.getName() + ".";
    }

    public String refuel() {
        fuel += currentLocation.getFuelAvailable();
        return "Vehicle refueled.";
    }
}
