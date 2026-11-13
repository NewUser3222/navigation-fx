\# 🚗 NavigationFX



<div align="center">



\### 🗺️ Explore Locations. Manage Fuel. Navigate Your Journey.



An interactive vehicle navigation simulator built with \*\*Java 21 and JavaFX\*\*. Create a vehicle, explore available destinations, manage fuel consumption, and customize your own navigation environment.



!\[Java](https://img.shields.io/badge/Java-21-orange?style=for-the-badge\&logo=openjdk)

!\[JavaFX](https://img.shields.io/badge/JavaFX-Desktop%20GUI-blue?style=for-the-badge)

!\[OOP](https://img.shields.io/badge/Object--Oriented-Programming-purple?style=for-the-badge)

!\[Status](https://img.shields.io/badge/Status-Completed-success?style=for-the-badge)



</div>



\---



\## 🌎 Overview



NavigationFX is a desktop application that simulates basic vehicle navigation and fuel management.



Users can create a vehicle with a custom name and starting fuel amount, select destinations, travel between locations, and refuel using resources available at their current location.



The application also supports adding, removing, loading, and saving locations through file-based data management.



\## ✨ Key Features



| Feature | Description |

|:---|:---|

| 🚘 Vehicle Creation | Create a vehicle with a custom name and starting fuel |

| 🗺️ Location Navigation | Select destinations from an available location list |

| ⛽ Fuel Management | Track fuel consumption when traveling |

| 🔋 Refueling System | Replenish fuel using resources at the current location |

| ➕ Add Locations | Create custom locations with distance and fuel values |

| ➖ Remove Locations | Remove locations while protecting the vehicle's current location |

| 💾 Data Persistence | Load and save location data using a text file |

| ⚠️ Input Validation | Handle invalid input and prevent unsupported operations |

| 🖥️ JavaFX Interface | Interactive desktop interface with status updates |



\## 🎮 Application Workflow



1\. \*\*Create a Vehicle\*\* — Enter a vehicle name and starting fuel amount.

2\. \*\*Choose a Destination\*\* — Select an available location.

3\. \*\*Navigate\*\* — Travel to the selected destination if sufficient fuel is available.

4\. \*\*Refuel\*\* — Replenish fuel using the resources available at the current location.

5\. \*\*Manage Locations\*\* — Add or remove destinations.

6\. \*\*Save Changes\*\* — Store the updated location list for future use.



\## 🧠 Technologies \& Skills Demonstrated



\- ☕ \*\*Java 21\*\* — Core application development

\- 🖥️ \*\*JavaFX\*\* — Graphical user interface

\- 🧩 \*\*Object-Oriented Programming\*\* — Classes, objects, and encapsulation

\- 🔗 \*\*Class Relationships\*\* — Vehicle and Location objects

\- 📂 \*\*File I/O\*\* — Reading and writing location data

\- 📋 \*\*Java Collections\*\* — Observable lists and dynamic data management

\- ⚡ \*\*Event Handling\*\* — Interactive buttons and user actions

\- 🛡️ \*\*Input Validation\*\* — Numeric validation and error handling



\## 🏗️ Application Architecture



The application separates vehicle behavior, location data, and user interface responsibilities into individual classes.



| Class | Responsibility |

|:---|:---|

| `Main` | JavaFX application, interface, event handling, and file operations |

| `Vehicle` | Vehicle identity, current location, fuel tracking, movement, and refueling |

| `Location` | Location information, distance, available fuel, and file-data conversion |



\## 💾 Data Management



NavigationFX uses a text-based data file to store location information.



\*\*Location data format:\*\*



```text

LocationName,Distance,FuelAvailable

```



The application reads location records when it starts and writes updated location information when the user saves changes.



\## 📂 Project Structure



```text

NavigationFX/

│

└── src/

&#x20;   └── main/

&#x20;       └── java/

&#x20;           ├── com/

&#x20;           │   └── Example/

&#x20;           │       └── navigationfx/

&#x20;           │           ├── Location.java

&#x20;           │           ├── Main.java

&#x20;           │           └── Vehicle.java

&#x20;           │

&#x20;           └── resources/

&#x20;               ├── locations.txt

&#x20;               └── styles.css

```



\## ⚙️ Requirements



\- Java Development Kit (JDK) 21

\- JavaFX SDK compatible with Java 21

\- JavaFX runtime configuration



The application expects its location data file at `src/main/java/resources/locations.txt` when launched from the project root.



\---



<div align="center">



\### 🎓 Developed at Cuyahoga Community College



\*\*IT-2651 — Object-Oriented Programming\*\*



\*Combining object-oriented design, interactive interfaces, and file-based data management.\*



🚗 🗺️ ⛽



</div>

