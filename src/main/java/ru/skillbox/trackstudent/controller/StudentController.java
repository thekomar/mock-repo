package ru.skillbox.trackstudent.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.skillbox.trackstudent.entity.Student;
import ru.skillbox.trackstudent.repo.StudentRepository;
import ru.skillbox.trackstudent.util.TagName;

@Api(tags = TagName.STUDENT)
@RestController
@RequestMapping("/student")
public class StudentController extends AbstractController<Student, StudentRepository> {
    public StudentController(StudentRepository repo) {
        super(repo);
    }
}
