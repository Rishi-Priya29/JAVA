class Light extends SmartDevice {
    public Light(int id, int initialState) {
        super(id, "light");
        if (initialState == 1) {
            turnOn();
        }
    }

    @Override
    public void displayStatus() {
        System.out.println("Light " + getId() + " is " + getStatus() + ".");
    }
}
