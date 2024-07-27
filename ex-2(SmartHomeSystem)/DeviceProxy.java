class DeviceProxy extends SmartDevice {
    private SmartDevice realDevice;

    public DeviceProxy(SmartDevice realDevice) {
        super(realDevice.getId(), realDevice.getType());
        this.realDevice = realDevice;
    }

    @Override
    public void turnOn() {
        realDevice.turnOn();
    }

    @Override
    public void turnOff() {
        realDevice.turnOff();
    }

    @Override
    public String getStatus() {
        return realDevice.getStatus();
    }

    @Override
    public void displayStatus() {
        realDevice.displayStatus();
    }
}
