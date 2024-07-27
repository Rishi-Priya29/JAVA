public class SalaryCalculationVisitor implements Visitor {
    @Override
    public void visit(Student student) {
        // No operation for Student
    }

    @Override
    public void visit(Professor professor) {
        System.out.println("Calculating salary for professor: " + professor.getName() + ". Salary: " + professor.getSalary());
    }
}
