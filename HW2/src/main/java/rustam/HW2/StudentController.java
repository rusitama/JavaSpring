package rustam.HW2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class StudentController {
    private List<Student> students;

    public StudentController() {
        this.students = new ArrayList<>();
        // Создание начальных данных со студентами
        initializeStudents();
    }

    private void initializeStudents() {
        // Создание 5-10 студентов для начальных данных
        for (int i = 1; i <= 10; i++) {
            students.add(new Student(i, "Student" + i, "Group" + (i % 3 + 1)));
        }
    }

    public Student getStudentById(int id) {
        return students.stream()
                .filter(student -> student.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public List<Student> getAllStudents() {
        return students;
    }

    public List<Student> searchStudentsByName(String name) {
        return students.stream()
                .filter(student -> student.getName().contains(name))
                .collect(Collectors.toList());
    }

    public List<Student> getStudentsByGroup(String groupName) {
        return students.stream()
                .filter(student -> student.getGroupName().equals(groupName))
                .collect(Collectors.toList());
    }
}
