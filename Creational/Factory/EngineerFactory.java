public class EngineerFactory implements EmployeeFactory {
    @Override
    public Employee createEmployee() {
        return new Engineer();
    }
}
