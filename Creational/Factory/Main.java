public class Main {
    public static void main(String[] args) {
        EmployeeFactory managerFactory = new ManagerFactory();
        Employee manager = managerFactory.createEmployee();
        manager.performDuties();
        System.out.print("\n");

        EmployeeFactory engineerFactory = new EngineerFactory();
        Employee engineer = engineerFactory.createEmployee();
        engineer.performDuties();
    }
}
