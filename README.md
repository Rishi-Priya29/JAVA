Design Patterns Implemented:
Behavioral Patterns:
Observer Pattern: Implemented with ClgNotification and StudentObserver to simulate a notification system where students receive updates on their grades.

Visitor Pattern: Demonstrated using GradeEvaluationVisitor and SalaryCalculationVisitor to apply operations (like grade evaluation and salary calculation) on Student and Professor objects without modifying their classes.

-------------------------------------------------------*****************------------------------------------------------------
Factory Pattern: Used in the creation of different types of Employee objects, such as Engineer and Manager, using EmployeeFactory and EngineerFactory.

Abstract Factory Pattern: Applied to create different types of employees (e.g., FullTimeEmployeeFactory, PartTimeEmployeeFactory) and associated roles (FullTimeDeveloper, PartTimeManager, etc.).

-------------------------------------------------------*****************------------------------------------------------------
Structural Patterns:
Adapter Pattern: Implemented to adapt and integrate a LegacyBillingSystem into a new BillingSystem using BillingSystemAdapter.

Proxy Pattern: Used to control access to PatientData via PatientDataProxy, ensuring data access restrictions and lazy initialization.

-------------------------------------------------------*****************------------------------------------------------------

Smart Home System (Integration Project):
Design Patterns Applied: This project integrates multiple design patterns, such as:

Factory Pattern: For creating smart devices like Light, Door, Thermostat, etc.

Proxy Pattern: To control access and interactions with smart devices via DeviceProxy.

Observer Pattern: To update schedules based on device changes.

Objective: Demonstrates how design patterns can work together to create a scalable and efficient smart home system.

Solution Approach:

Behavioral Patterns enhance object communication and reduce dependencies between them.

Creational Patterns provide flexible mechanisms for creating objects, promoting code reuse and maintainability.

Structural Patterns simplify object relationships, offering easier and more modular design choices.

The Smart Home System project brings these patterns together in a practical, real-world scenario, simulating a smart home environment with controlled access to devices, notifications, and scheduling.

-------------------------------------------------------*****************------------------------------------------------------

To run the project:
Clone the repository using git clone https://github.com/Rishi-Priya29/JAVA.git, navigate to the project directory, compile the Java files with javac *.java, and then run the project using java Main.
