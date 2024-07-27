import java.time.LocalTime;

class Schedule {
    private int deviceId;
    private LocalTime time;
    private String command;

    public Schedule(int deviceId, LocalTime time, String command) {
        this.deviceId = deviceId;
        this.time = time;
        this.command = command;
    }

    public int getDeviceId() {
        return deviceId;
    }

    public LocalTime getTime() {
        return time;
    }

    public String getCommand() {
        return command;
    }
}
