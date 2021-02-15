package ru.skillbox.trackstudent.service.impl.method;

import org.springframework.stereotype.Component;
import ru.skillbox.trackstudent.entity.Rating;
import ru.skillbox.trackstudent.entity.Student;
import ru.skillbox.trackstudent.repo.RatingRepository;

import java.util.List;

@Component("average")
public class CalcAverageRatingMethod {
    private final RatingRepository ratingRepository;

    public CalcAverageRatingMethod(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    public Double call(Student student) {
        final List<Rating> ratings = ratingRepository.findAllByStudent(student);
        int sum = ratings.stream()
                .mapToInt(Rating::getRating)
                .sum();
        return (double) (sum / ratings.size());
    }
}
