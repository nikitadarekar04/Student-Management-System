package controller;

import model.Student;
import model.StudentModel;
import view.StudentView;
import java.util.List;

public class StudentController {
	private StudentModel model;
    private StudentView view;

    public StudentController(StudentModel model, StudentView view) {
        this.model = model;
        this.view = view;
    }

    public void start() {
        while(true) {
            int choice = view.showMenu();
            switch(choice) {
                case 1:
                    Student s = view.getStudentDetails();
                    model.addStudent(s);
                    view.showMessage("Student added successfully!");
                    break;
                case 2:
                    List<Student> students = model.getAllStudents();
                    view.showStudents(students);
                    break;
                case 3:
                    int id = view.getStudentId();
                    view.showMessage("Enter new details:");
                    Student updated = view.getStudentDetails();
                    if(model.updateStudent(id, updated.getName(), updated.getMarks())) {
                        view.showMessage("Student updated successfully!");
                    } else {
                        view.showMessage("Student not found!");
                    }
                    break;
                case 4:
                    int deleteId = view.getStudentId();
                    if(model.deleteStudent(deleteId)) {
                        view.showMessage("Student deleted successfully!");
                    } else {
                        view.showMessage("Student not found!");
                    }
                    break;
                case 5:
                    view.showMessage("Exiting program...");
                    return;
                default:
                    view.showMessage("Invalid choice! Try again.");
            }
        }
    }
}
