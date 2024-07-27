import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

public class SmartHomeSystem {
    private static CentralHub hub = new CentralHub();
    private static Map<Integer, SmartDevice> devices = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

        // Initial Setup
        setupInitialDevices();

        while (true) {
            System.out.println("Welcome to the Smart Home System");
            System.out.println("Do you want to add or remove a new device? (yes/no)");
            String response = scanner.nextLine().trim().toLowerCase();

            if (response.equals("yes")) {
                handleDeviceManagement();
            } else {
                printStatus();
            }

            System.out.println("Enter command: (turnOn, turnOff, schedule, trigger, status, exit)");
            String command = scanner.nextLine().trim().toLowerCase();

            switch (command) {
                case "turnon":
                    performAction("turnOn");
                    break;
                case "turnoff":
                    performAction("turnOff");
                    break;
                case "schedule":
                    handleSchedule(formatter);
                    break;
                case "trigger":
                    handleTrigger();
                    break;
                case "status":
                    printStatus();
                    break;
                case "exit":
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid command.");
            }

            // Ask again if the user wants to add or remove a new device
            System.out.println("Do you want to add or remove a new device? (yes/no)");
            response = scanner.nextLine().trim().toLowerCase();
        }
    }

    private static void setupInitialDevices() {
        // Initialize with some default devices
        Light light1 = new Light(1, 1); // Assuming 1 means On
        Thermostat thermostat2 = new Thermostat(2, 22);
        Door door3 = new Door(3, 0); // Assuming 0 means Locked

        hub.addDevice(light1);
        hub.addDevice(thermostat2);
        hub.addDevice(door3);

        devices.put(light1.getId(), light1);
        devices.put(thermostat2.getId(), thermostat2);
        devices.put(door3.getId(), door3);
    }

    private static void handleDeviceManagement() {
        System.out.println("Enter command: (add, remove)");
        String command = scanner.nextLine().trim().toLowerCase();

        switch (command) {
            case "add":
                addDevice();
                break;
            case "remove":
                removeDevice();
                break;
            default:
                System.out.println("Invalid command for device management.");
        }
    }

    private static void addDevice() {
        System.out.print("Enter device type (light/thermostat/door): ");
        String type = scanner.nextLine().trim().toLowerCase();

        System.out.print("Enter device ID: ");
        int id = Integer.parseInt(scanner.nextLine().trim());

        SmartDevice device = null;
        if (type.equals("light")) {
            System.out.print("Enter initial state (0 for off, 1 for on): ");
            int state = Integer.parseInt(scanner.nextLine().trim());
            device = new Light(id, state);
        } else if (type.equals("thermostat")) {
            System.out.print("Enter initial temperature: ");
            int temperature = Integer.parseInt(scanner.nextLine().trim());
            device = new Thermostat(id, temperature);
        } else if (type.equals("door")) {
            System.out.print("Enter initial state (0 for locked, 1 for unlocked): ");
            int state = Integer.parseInt(scanner.nextLine().trim());
            device = new Door(id, state);
        } else {
            System.out.println("Error: Invalid device type. Please enter 'light', 'thermostat', or 'door'.");
            return;
        }

        hub.addDevice(device);
        devices.put(id, device);
        System.out.println("Device added.");
    }

    private static void removeDevice() {
        System.out.print("Enter device ID to remove: ");
        int id = Integer.parseInt(scanner.nextLine().trim());

        if (devices.containsKey(id)) {
            devices.remove(id);
            hub.removeDevice(id); // Ensure the hub also removes the device
            System.out.println("Device removed.");
        } else {
            System.out.println("Device ID not found.");
        }
    }

    private static void performAction(String action) {
        System.out.print("Enter device ID: ");
        int id = Integer.parseInt(scanner.nextLine().trim());

        if (action.equals("turnOn")) {
            hub.turnOnDevice(id);
        } else if (action.equals("turnOff")) {
            hub.turnOffDevice(id);
        }
        System.out.println("Action performed.");
    }

    private static void handleSchedule(DateTimeFormatter formatter) {
        System.out.print("Enter device ID: ");
        int deviceId = Integer.parseInt(scanner.nextLine().trim());

        System.out.print("Enter schedule time (HH:mm): ");
        LocalTime time = LocalTime.parse(scanner.nextLine().trim(), formatter);

        System.out.print("Enter command (e.g., 'Turn On', 'Turn Off'): ");
        String command = scanner.nextLine().trim();

        hub.addSchedule(deviceId, time, command);
        System.out.println("Schedule added.");
    }

    private static void handleTrigger() {
        System.out.print("Enter trigger condition (e.g., 'temperature > 25', 'light is off'):");
        String condition = scanner.nextLine().trim();

        System.out.print("Enter trigger action (e.g., 'turnOff(1)', 'setTemperature(22)'):");
        String action = scanner.nextLine().trim();

        if (isValidTriggerCondition(condition) && isValidTriggerAction(action)) {
            hub.addTrigger(condition, action);
            System.out.println("Trigger added.");
        } else {
            System.out.println("Invalid trigger format. Please follow the provided examples.");
        }
    }

    private static boolean isValidTriggerCondition(String condition) {
        // Example validation logic
        return Pattern.matches("temperature\\s*[><=]\\s*\\d+|light\\s+is\\s+(on|off)", condition);
    }

    private static boolean isValidTriggerAction(String action) {
        // Example validation logic
        return Pattern.matches("turnOff\\(\\d+\\)|turnOn\\(\\d+\\)|setTemperature\\(\\d+\\)", action);
    }

    private static void printStatus() {
        System.out.println("Device Status:");
        for (SmartDevice device : devices.values()) {
            device.displayStatus();
        }
    }
}
