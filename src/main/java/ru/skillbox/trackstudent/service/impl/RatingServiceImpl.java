package ru.skillbox.trackstudent.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.skillbox.trackstudent.entity.Rating;
import ru.skillbox.trackstudent.entity.Student;
import ru.skillbox.trackstudent.service.RatingService;
import ru.skillbox.trackstudent.service.impl.method.CalcAverageRatingMethod;
import ru.skillbox.trackstudent.service.impl.method.RateRatingMethod;

@Service("rating")
public class RatingServiceImpl implements RatingService {
    private final CalcAverageRatingMethod calcAverageRatingMethod;
    private final RateRatingMethod rateRatingMethod;

    @Autowired
    public RatingServiceImpl(CalcAverageRatingMethod calcAverageRatingMethod, RateRatingMethod rateRatingMethod) {
        this.calcAverageRatingMethod = calcAverageRatingMethod;
        this.rateRatingMethod = rateRatingMethod;
    }

    @Override
    public Double calcAverage(Student student) {
        return calcAverageRatingMethod.call(student);
    }


    @Override
    public Rating rate(Rating rating) {
        return rateRatingMethod.call(rating);
    }
}
