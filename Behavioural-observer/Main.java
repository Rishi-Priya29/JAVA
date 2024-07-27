public class Main {
    public static void main(String[] args) {
        ClgNotificationImplementation notificationSys = new ClgNotificationImplementation();

        StudentObserver stu1 = new Student("Student 1");
        StudentObserver stu2 = new Student("Student 2");
        StudentObserver stu3 = new Student("Student 3");
        StudentObserver stu4 = new Student("Student 4");


        notificationSys.addStudent(stu1);
        notificationSys.addStudent(stu2);
        notificationSys.addStudent(stu3);
        notificationSys.addStudent(stu4);


        

        notificationSys.notifyStudents("New exam schedule has been released!");
        
        System.out.print("\n");

        notificationSys.removeStudent(stu3);

        notificationSys.notifyStudents("Saturday is an holiday");
    }
}
