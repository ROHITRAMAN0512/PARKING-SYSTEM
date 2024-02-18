**Parking Lot Application**

A Java-based command-line application for managing a parking lot. This application allows users to create a parking lot, park cars, leave parking slots, and perform various queries related to the parked cars.

**Table of Contents**

•	Features
•	Prerequisites
•	How to Run
•	Commands
•	Example Usage
•	Contributing
•	License

**Features**

Create a parking lot with a specified capacity.
Park a car with a registration number and color.
Remove a car from a parking slot.
Display the current status of the parking lot.
Find registration numbers of cars with a particular color.
Find the slot number for a specific registration number.
Find slot numbers for cars with a particular color.
Interactive command prompt-based shell.

**Prerequisites**
Java (JDK) installed on your machine.

**How to Run**

1.	Clone the repository to your local machine.
2.	Open a terminal or command prompt.
3.	Navigate to the project directory.
4.	Compile the Java files using the following command: javac ParkingLotApplication.java
5.	Run the application: java ParkingLotApplication

**Commands**

•	**create_parking_lot <capacity>**: Create a parking lot with the specified capacity.  
•	**park <registration_number> <color>**: Park a car with the given registration number and color.  
•	**leave <slot_number>**: Remove a car from the specified parking slot.  
•	**status**: Display the current status of the parking lot.  
•	**registration_numbers_for_cars_with_colour <color>**: Find registration numbers of cars with a particular color.  
•	**slot_number_for_registration_number <registration_number>**: Find the slot number for a specific registration number.  
•	**slot_numbers_for_cars_with_colour <color>**: Find slot numbers for cars with a particular color.  
•	**exit**: Exit the application.

**Create a parking lot:**  
$ create_parking_lot 6
Created a parking lot with 6 slots 

**Park cars:**  
$ park KA-01-HH-1234 White
Allocated slot number: 1
$ park KA-01-HH-9999 White
Allocated slot number: 2  

**Display the status:**  





