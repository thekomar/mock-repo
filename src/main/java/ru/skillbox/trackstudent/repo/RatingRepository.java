package ru.skillbox.trackstudent.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.skillbox.trackstudent.entity.Rating;
import ru.skillbox.trackstudent.entity.Student;

import java.util.List;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Long> {
    public List<Rating> findAllByStudent(Student student);
}
