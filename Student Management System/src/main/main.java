package main;

import controller.StudentController;
import model.StudentModel;
import view.StudentView;

public class main {
    public static void main(String[] args) {
        StudentModel model = new StudentModel();
        StudentView view = new StudentView();
        StudentController controller = new StudentController(model, view);
        controller.start();
    }
}
