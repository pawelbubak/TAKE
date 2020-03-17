package ai.faces;

import ai.faces.model.Student;
import ai.faces.service.StudentsService;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.util.List;

@Named(value = "studentsBean")
@RequestScoped
public class StudentsBean {
    private List<Student> students;

    public StudentsBean() {
    }

    @PostConstruct
    public void init() {
        students = StudentsService.createStudents(20);
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
