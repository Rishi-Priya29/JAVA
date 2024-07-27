public interface ClgNotification {
    void addStudent(StudentObserver student);
    void removeStudent(StudentObserver student);
    void notifyStudents(String message);
}
