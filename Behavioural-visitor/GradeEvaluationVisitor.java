public class GradeEvaluationVisitor implements Visitor {
    @Override
    public void visit(Student student) {
        System.out.println("Evaluating grade for student: " + student.getName() + ". Grade: " + student.getGrade());
    }

    @Override
    public void visit(Professor professor) {
        // No operation for Professor
    }
}
