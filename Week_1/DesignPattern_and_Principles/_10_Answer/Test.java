package Week_1.DesignPattern_and_Principles._10_Answer;

public class Test {
    public static void main(String[] args) {
        // Create model
        Student student = new Student("John Doe", 1, "A");

        // Create view
        StudentView view = new StudentView();

        // Create controller
        StudentController controller = new StudentController(student, view);

        // Display initial student details
        controller.updateView();

        // Update student details
        controller.setStudentName("Jane Doe");
        controller.setStudentGrade("B");

        // Display updated student details
        controller.updateView();
    }
}
