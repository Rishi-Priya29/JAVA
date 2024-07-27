public class ManagerFactory implements EmployeeFactory {
    @Override
    public Employee createEmployee() {
        return new Manager();
    }
}
