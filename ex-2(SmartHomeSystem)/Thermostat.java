class Thermostat extends SmartDevice {
    private int temperature;

    public Thermostat(int id, int initialTemperature) {
        super(id, "thermostat");
        this.temperature = initialTemperature;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int newTemperature) {
        this.temperature = newTemperature;
    }

    @Override
    public void displayStatus() {
        System.out.println("Thermostat " + getId() + " is set to " + getTemperature() + " degrees.");
    }
}
