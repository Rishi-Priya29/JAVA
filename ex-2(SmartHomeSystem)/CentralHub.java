import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

// CentralHub class
class CentralHub implements Subject {
    private List<SmartDevice> devices = new ArrayList<>();
    private List<Schedule> schedules = new ArrayList<>();
    private List<Trigger> triggers = new ArrayList<>();

    @Override
    public void notifyObservers(String message) {
        System.out.println("Notification: " + message);
    }

    public void addDevice(SmartDevice device) {
        devices.add(device);
        notifyObservers("Device " + device.getId() + " added.");
    }

    public void removeDevice(int id) {
        SmartDevice deviceToRemove = findDeviceById(id);
        if (deviceToRemove != null) {
            devices.remove(deviceToRemove);
            notifyObservers("Device " + id + " removed.");
        } else {
            System.out.println("Device not found");
        }
    }

    public void turnOnDevice(int id) {
        SmartDevice device = findDeviceById(id);
        if (device != null) {
            device.turnOn();
            notifyObservers("Device " + id + " turned on.");
        } else {
            System.out.println("Device not found");
        }
    }

    public void turnOffDevice(int id) {
        SmartDevice device = findDeviceById(id);
        if (device != null) {
            device.turnOff();
            notifyObservers("Device " + id + " turned off.");
        } else {
            System.out.println("Device not found");
        }
    }

    public void addSchedule(int deviceId, LocalTime time, String command) {
        schedules.add(new Schedule(deviceId, time, command));
    }

    public void addTrigger(String condition, String action) {
        triggers.add(new Trigger(condition, action));
    }

    public void executeSchedules() {
        LocalTime now = LocalTime.now();
        for (Schedule schedule : schedules) {
            if (schedule.getTime().equals(now)) {
                SmartDevice device = findDeviceById(schedule.getDeviceId());
                if (device != null) {
                    if ("Turn On".equals(schedule.getCommand())) {
                        device.turnOn();
                    } else if ("Turn Off".equals(schedule.getCommand())) {
                        device.turnOff();
                    }
                    notifyObservers("Schedule executed: " + device.getStatus());
                }
            }
        }
    }

    public void checkTriggers() {
        for (Trigger trigger : triggers) {
            if (conditionMet(trigger.getCondition())) {
                int deviceId = Integer.parseInt(trigger.getAction().replaceAll("[^0-9]", ""));
                SmartDevice device = findDeviceById(deviceId);
                if (device != null) {
                    if (trigger.getAction().contains("turnOff")) {
                        device.turnOff();
                    }
                    notifyObservers("Trigger executed: " + device.getStatus());
                }
            }
        }
    }

    private boolean conditionMet(String condition) {
        // Placeholder logic for condition check
        return true;
    }

    private SmartDevice findDeviceById(int id) {
        for (SmartDevice device : devices) {
            if (device.getId() == id) {
                return device;
            }
        }
        return null;
    }

    public List<SmartDevice> getDevices() {
        return devices;
    }

    public List<Schedule> getSchedules() {
        return schedules;
    }

    public List<Trigger> getTriggers() {
        return triggers;
    }
}

