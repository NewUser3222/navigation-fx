package com.Example.navigationfx;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main extends Application {

    private Vehicle vehicle;

    private Label vehicleLabel = new Label("Vehicle: (none)");
    private Label locationLabel = new Label("Current Location: (none)");
    private Label fuelLabel = new Label("Fuel: (none)");
    private Label statusLabel = new Label("Status: Ready.");

    private ObservableList<Location> locations = FXCollections.observableArrayList();
    private ListView<Location> locationListView = new ListView<>(locations);

    @Override
    public void start(Stage stage) {

        // Step 1: Load locations from the file
        loadLocations();

        locationListView.setPrefHeight(150);

        TextField vehicleNameField = new TextField();
        TextField fuelField = new TextField();
        Button createVehicleBtn = new Button("Create Vehicle");

        createVehicleBtn.setOnAction(e -> {
            String name = vehicleNameField.getText().trim();
            String fuelText = fuelField.getText().trim();

            if (name.isEmpty()) {
                statusLabel.setText("Status: Please enter a vehicle name.");
                return;
            }

            if (fuelText.isEmpty()) {
                statusLabel.setText("Status: Please enter starting fuel.");
                return;
            }

            try {
                double fuel = Double.parseDouble(fuelText);

                if (fuel < 0) {
                    statusLabel.setText("Status: Fuel cannot be negative.");
                    return;
                }

                if (locations.isEmpty()) {
                    statusLabel.setText("Status: No locations available.");
                    return;
                }

                vehicle = new Vehicle(name, locations.get(0), fuel);
                updateLabels();
                statusLabel.setText("Status: Vehicle created successfully.");

            } catch (NumberFormatException ex) {
                statusLabel.setText("Status: Fuel must be a valid number.");
            }
        });

        Button moveBtn = new Button("Move Vehicle");
        moveBtn.setOnAction(e -> {
            if (vehicle == null) {
                statusLabel.setText("Status: Please create a vehicle first.");
                return;
            }

            Location selected = locationListView.getSelectionModel().getSelectedItem();

            if (selected == null) {
                statusLabel.setText("Status: Please select a destination.");
                return;
            }

            String result = vehicle.move(selected);
            statusLabel.setText("Status: " + result);
            updateLabels();
        });

        Button refuelBtn = new Button("Refuel");
        refuelBtn.setOnAction(e -> {
            if (vehicle == null) {
                statusLabel.setText("Status: Please create a vehicle first.");
                return;
            }

            String result = vehicle.refuel();
            statusLabel.setText("Status: " + result);
            updateLabels();
        });

        Button addLocationBtn = new Button("Add Location");
        addLocationBtn.setOnAction(e -> showAddLocationWindow());

        Button removeLocationBtn = new Button("Remove Location");
        removeLocationBtn.setOnAction(e -> {
            Location selected = locationListView.getSelectionModel().getSelectedItem();

            if (selected == null) {
                statusLabel.setText("Status: Please select a location to remove.");
                return;
            }

            if (vehicle != null && vehicle.getCurrentLocation() == selected) {
                statusLabel.setText("Status: Cannot remove the vehicle's current location.");
                return;
            }

            locations.remove(selected);
            statusLabel.setText("Status: Location removed successfully.");
        });

        // Step 2: Add Save button
        Button saveLocationBtn = new Button("Save Locations");
        saveLocationBtn.setOnAction(e -> saveLocations());

        VBox root = new VBox(10);
        root.setPadding(new Insets(15));

        root.getChildren().addAll(
                vehicleLabel,
                locationLabel,
                fuelLabel,
                new Label("Vehicle Name:"), vehicleNameField,
                new Label("Starting Fuel:"), fuelField,
                createVehicleBtn,
                new Label("Available Locations:"), locationListView,
                moveBtn,
                refuelBtn,
                addLocationBtn,
                removeLocationBtn,
                saveLocationBtn,
                statusLabel
        );

        Scene scene = new Scene(root, 420, 650);
        stage.setTitle("NavigationFX");
        stage.setScene(scene);
        stage.show();
    }

    // Step 3: Read locations from locations.txt
    private void loadLocations() {

        try (BufferedReader reader = new BufferedReader(
                new FileReader("src/main/java/resources/locations.txt"))) {

            String line;

            while ((line = reader.readLine()) != null) {

                if (!line.trim().isEmpty()) {
                    locations.add(Location.fromFileString(line));
                }
            }

        } catch (IOException | RuntimeException ex) {
            statusLabel.setText("Status: Error loading locations.");
            ex.printStackTrace();
        }
    }

    // Step 4: Write current locations back to locations.txt
    private void saveLocations() {

        try (BufferedWriter writer = new BufferedWriter(
                new FileWriter("src/main/java/resources/locations.txt"))) {

            for (Location location : locations) {
                writer.write(location.toFileString());
                writer.newLine();
            }

            statusLabel.setText("Status: Locations saved successfully.");

        } catch (IOException ex) {
            statusLabel.setText("Status: Error saving locations.");
            ex.printStackTrace();
        }
    }

    private void updateLabels() {
        if (vehicle != null) {
            vehicleLabel.setText("Vehicle: " + vehicle.getName());
            locationLabel.setText("Current Location: " + vehicle.getCurrentLocation().getName());
            fuelLabel.setText("Fuel: " + vehicle.getFuel());
        }
    }

    private void showAddLocationWindow() {
        Stage window = new Stage();
        window.setTitle("Add New Location");

        TextField nameField = new TextField();
        TextField distanceField = new TextField();
        TextField fuelField = new TextField();

        Button addBtn = new Button("Add Location");
        Button cancelBtn = new Button("Cancel");

        addBtn.setOnAction(e -> {
            String name = nameField.getText().trim();
            String distText = distanceField.getText().trim();
            String fuelText = fuelField.getText().trim();

            if (name.isEmpty()) {
                statusLabel.setText("Status: Please enter a location name.");
                return;
            }

            for (Location loc : locations) {
                if (loc.getName().equalsIgnoreCase(name)) {
                    statusLabel.setText("Status: A location with that name already exists.");
                    return;
                }
            }

            try {
                double dist = Double.parseDouble(distText);
                double fuelAvail = Double.parseDouble(fuelText);

                locations.add(new Location(name, dist, fuelAvail));
                statusLabel.setText("Status: Location added successfully.");
                window.close();

            } catch (NumberFormatException ex) {
                statusLabel.setText("Status: Distance and fuel must be valid numbers.");
            }
        });

        cancelBtn.setOnAction(e -> window.close());

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(10));

        layout.getChildren().addAll(
                new Label("Name:"), nameField,
                new Label("Distance:"), distanceField,
                new Label("Fuel Available:"), fuelField,
                addBtn,
                cancelBtn
        );

        window.setScene(new Scene(layout, 300, 250));
        window.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
