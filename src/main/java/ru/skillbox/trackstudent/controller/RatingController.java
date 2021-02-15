package ru.skillbox.trackstudent.controller;

import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.skillbox.trackstudent.config.SwaggerConfig;
import ru.skillbox.trackstudent.entity.Rating;
import ru.skillbox.trackstudent.entity.Student;
import ru.skillbox.trackstudent.service.RatingService;
import ru.skillbox.trackstudent.util.TagName;

@Api(tags = TagName.RATING)
@RestController
@RequestMapping("/rating")
public class RatingController {

    private final RatingService ratingService;

    @Autowired
    public RatingController(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    @ApiOperation(value = "Изменение шаблона")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Шаблон успешно изменен"),
            @ApiResponse(code = 400, message = "Ошибка, один из параметров указан неверно")
    })
    @PostMapping("/calc-average")
    public Double calcAverage(@RequestBody Student student) {
        return ratingService.calcAverage(student);
    }


    @ApiOperation(value = "Сохранение оценки студента по предмету")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Оценка студента по прдемету успешно изменен"),
            @ApiResponse(code = 400, message = "Ошибка, один из параметров указан неверно"),
            @ApiResponse(code = 500, message = "Ошибка на стороне сервера")
    })
    @PostMapping("rate")
    public Rating rate(@ApiParam("Оценка стундета по предмету") @RequestBody Rating rating) {
        return ratingService.rate(rating);
    }

}
