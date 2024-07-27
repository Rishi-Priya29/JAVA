public class Main {
    public static void main(String[] args) {
        EmployeeFactory factory = new FullTimeEmployeeFactory("developer"); // Change to "parttime" and "manager" as needed
        Role role = factory.createRole();
        role.describeRole();
    }
}
