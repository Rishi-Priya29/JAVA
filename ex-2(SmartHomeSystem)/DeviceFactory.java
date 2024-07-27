class DeviceFactory {
    public static SmartDevice createDevice(String type, int id, int initialState) {
        switch (type) {
            case "light":
                return new Light(id, initialState);
            case "thermostat":
                return new Thermostat(id, initialState);
            case "door":
                return new Door(id, initialState);
            default:
                throw new IllegalArgumentException("Invalid device type");
        }
    }
}
