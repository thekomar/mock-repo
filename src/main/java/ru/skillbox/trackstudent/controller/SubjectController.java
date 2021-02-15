package ru.skillbox.trackstudent.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.skillbox.trackstudent.entity.Subject;
import ru.skillbox.trackstudent.repo.SubjectRepository;
import ru.skillbox.trackstudent.util.TagName;

@Api(tags = TagName.SUBJECT)
@RestController
@RequestMapping("/subject")
public class SubjectController extends AbstractController<Subject, SubjectRepository> {
    public SubjectController(SubjectRepository repo) {
        super(repo);
    }
}
