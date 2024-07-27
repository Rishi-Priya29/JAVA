class Door extends SmartDevice {
    public Door(int id, int initialState) {
        super(id, "door");
        if (initialState == 1) {
            turnOn();
        }
    }

    @Override
    public void displayStatus() {
        System.out.println("Door " + getId() + " is " + getStatus() + ".");
    }
}
