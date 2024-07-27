public class Main {
    public static void main(String[] args) {
      
        Person student1 = new Student("Stud 1", 90.0);
        Person student2 = new Student("Stud 2", 85.0);
        Person professor1 = new Professor("Professor 1", 100000.0);

        Visitor gradeEvaluator = new GradeEvaluationVisitor();
        Visitor salaryCalculator = new SalaryCalculationVisitor();


        student1.accept(gradeEvaluator);
        student2.accept(gradeEvaluator);
        professor1.accept(salaryCalculator);
    }
}
