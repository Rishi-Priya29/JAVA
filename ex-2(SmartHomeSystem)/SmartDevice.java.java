abstract class SmartDevice {
    private int id;
    private String type;
    private String status;

    public SmartDevice(int id, String type) {
        this.id = id;
        this.type = type;
        this.status = "off";
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getStatus() {
        return status;
    }

    public void turnOn() {
        status = "on";
    }

    public void turnOff() {
        status = "off";
    }

    public abstract void displayStatus();
}
