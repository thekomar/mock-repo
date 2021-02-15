package ru.skillbox.trackstudent.service;


import ru.skillbox.trackstudent.entity.Rating;
import ru.skillbox.trackstudent.entity.Student;

public interface RatingService {
    Double calcAverage(Student student);

    Rating rate(Rating rating);
}
