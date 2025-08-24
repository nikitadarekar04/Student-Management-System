package model;
import java.util.ArrayList;

public class StudentModel {
	private ArrayList<Student> students = new ArrayList<>();

    // CRUD operations
    public void addStudent(Student student) {
        students.add(student);
    }

    public ArrayList<Student> getAllStudents() {
        return students;
    }

    public Student getStudentById(int id) {
        for(Student s : students) {
            if(s.getId() == id) return s;
        }
        return null;
    }

    public boolean updateStudent(int id, String name, double marks) {
        Student s = getStudentById(id);
        if(s != null) {
            s.setName(name);
            s.setMarks(marks);
            return true;
        }
        return false;
    }

    public boolean deleteStudent(int id) {
        Student s = getStudentById(id);
        if(s != null) {
            students.remove(s);
            return true;
        }
        return false;
    }
}
