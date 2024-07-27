import java.util.ArrayList;
import java.util.List;

public class ClgNotificationImplementation implements ClgNotification {
    private final List<StudentObserver> students;

    public ClgNotificationImplementation() {
        this.students = new ArrayList<>();
    }

    @Override
    public void addStudent(StudentObserver student) {
        students.add(student);
    }

    @Override
    public void removeStudent(StudentObserver student) {
        students.remove(student);
    }

    @Override
    public void notifyStudents(String message) {
        for (StudentObserver student : students) {
            student.update(message);
        }
    }
}
