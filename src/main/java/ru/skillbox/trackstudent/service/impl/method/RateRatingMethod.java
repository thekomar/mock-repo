package ru.skillbox.trackstudent.service.impl.method;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.skillbox.trackstudent.entity.Rating;
import ru.skillbox.trackstudent.repo.RatingRepository;

@Component("rate")
public class RateRatingMethod {
    private final RatingRepository ratingRepository;

    @Autowired
    public RateRatingMethod(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    public Rating call(Rating rating){
        return ratingRepository.save(rating);
    }
}
