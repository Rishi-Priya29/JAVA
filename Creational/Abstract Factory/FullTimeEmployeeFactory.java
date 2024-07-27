public class FullTimeEmployeeFactory implements EmployeeFactory {
    private String roleType;

    public FullTimeEmployeeFactory(String roleType) {
        this.roleType = roleType;
    }

    @Override
    public Role createRole() {
        if (roleType.equalsIgnoreCase("developer")) {
            return new FullTimeDeveloper();
        } else if (roleType.equalsIgnoreCase("manager")) {
            return new FullTimeManager();
        }
        throw new IllegalArgumentException("Unknown role type.");
    }
}
