package rustam.HW2;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentRestController {
    private final StudentController studentController;

    public StudentRestController(StudentController studentController) {
        this.studentController = studentController;
    }

    @GetMapping("/api/student/{id}")
    public Student getStudentById(@PathVariable int id) {
        return studentController.getStudentById(id);
    }

    @GetMapping("/api/student")
    public List<Student> getAllStudents() {
        return studentController.getAllStudents();
    }

    @GetMapping("/api/student/search")
    public List<Student> searchStudentsByName(@RequestParam String name) {
        return studentController.searchStudentsByName(name);
    }

    @GetMapping("/api/group/{groupName}/student")
    public List<Student> getStudentsByGroup(@PathVariable String groupName) {
        return studentController.getStudentsByGroup(groupName);
    }
}
