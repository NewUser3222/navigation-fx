# 🧭 NavigationFX

<div align="center">

### 🚗 JavaFX Vehicle Navigation & Fuel Management Simulator

A desktop application built with Java 21 and JavaFX, featuring vehicle management, destination navigation, fuel consumption, refueling, and location data persistence.

<br>

![Java](https://img.shields.io/badge/Java-21-orange?logo=openjdk&logoColor=white)
![JavaFX](https://img.shields.io/badge/JavaFX-Desktop%20Application-blue)
![OOP](https://img.shields.io/badge/Design-Object--Oriented-purple)
![Status](https://img.shields.io/badge/Status-Completed-success)

</div>

---

## 🌎 Project Overview

NavigationFX is an interactive vehicle navigation simulator developed as part of my Java programming coursework.

The application allows users to create a vehicle, travel between available destinations, manage fuel levels, and maintain location records. It combines a JavaFX graphical interface with object-oriented programming and file-based data storage.

## ✨ Features

| Feature | Description |
|---|---|
| 🚘 Vehicle Creation | Create a vehicle with a custom name and starting fuel amount. |
| 📍 Destination Selection | Browse and select available locations. |
| ⛽ Fuel Management | Track fuel consumption when traveling between destinations. |
| 🔋 Refueling | Refill the vehicle using fuel available at its current location. |
| ➕ Location Management | Add new destinations with distance and fuel information. |
| ➖ Location Removal | Remove locations while protecting the vehicle's current location. |
| 💾 Data Persistence | Load and save location information using text files. |
| 🛡️ Input Validation | Handle invalid input, duplicate locations, and insufficient fuel. |
| 🖥️ JavaFX Interface | Interactive desktop interface with buttons, lists, input fields, and status messages. |

## 🎮 How It Works

1. 🚘 **Create a Vehicle** — Enter a vehicle name and starting fuel amount.
2. 📍 **Choose a Destination** — Select an available location from the destination list.
3. 🚗 **Travel** — Move to the selected destination if sufficient fuel is available.
4. ⛽ **Refuel** — Replenish fuel based on the current location's available fuel.
5. 🗺️ **Manage Locations** — Add or remove destinations as needed.
6. 💾 **Save Your Data** — Save location information for future sessions.

## 🏗️ Object-Oriented Design

The application is organized into three primary Java classes:

| Class | Responsibility |
|---|---|
| `Main.java` | Builds the JavaFX interface and coordinates application functionality. |
| `Vehicle.java` | Manages vehicle information, movement, fuel consumption, and refueling. |
| `Location.java` | Stores location information and handles file data conversion. |

This structure separates application presentation, vehicle behavior, and location data management.

## 🛠️ Technologies & Concepts

- ☕ **Java 21** — Core application programming language.
- 🖥️ **JavaFX** — Graphical user interface development.
- 🧱 **Object-Oriented Programming** — Classes, objects, encapsulation, and interaction.
- 📋 **ObservableList** — Managing location data displayed in the interface.
- 📂 **Java File I/O** — Reading and writing location records.
- 🎨 **CSS** — Stylesheet resource included with the application.

## 📁 Project Structure

```text
NavigationFX/
├── src/
│   └── main/
│       └── java/
│           ├── com/
│           │   └── Example/
│           │       └── navigationfx/
│           │           ├── Main.java
│           │           ├── Vehicle.java
│           │           └── Location.java
│           └── resources/
│               ├── locations.txt
│               └── styles.css
├── .gitignore
└── README.md
```

## 🧠 What I Learned

Through this project, I developed practical experience with:

- Designing and organizing multi-class Java applications.
- Applying object-oriented programming principles.
- Building interactive desktop applications with JavaFX.
- Validating user input and handling application errors.
- Managing collections and dynamically updating interface data.
- Reading and writing persistent data using file handling.
- Connecting application logic with a graphical user interface.

---

<div align="center">

### 👨‍💻 Developer

**Joshua Parker**

*IT Programming & Development*

[![GitHub](https://img.shields.io/badge/GitHub-NewUser3222-181717?logo=github)](https://github.com/NewUser3222)

</
