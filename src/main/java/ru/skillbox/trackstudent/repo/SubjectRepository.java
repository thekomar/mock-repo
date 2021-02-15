package ru.skillbox.trackstudent.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.skillbox.trackstudent.entity.Subject;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, String> {
}
