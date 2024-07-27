public class PartTimeEmployeeFactory implements EmployeeFactory {
    private String roleType;

    public PartTimeEmployeeFactory(String roleType) {
        this.roleType = roleType;
    }

    @Override
    public Role createRole() {
        if (roleType.equalsIgnoreCase("developer")) {
            return new PartTimeDeveloper();
        } else if (roleType.equalsIgnoreCase("manager")) {
            return new PartTimeManager();
        }
        throw new IllegalArgumentException("Unknown role type.");
    }
}
