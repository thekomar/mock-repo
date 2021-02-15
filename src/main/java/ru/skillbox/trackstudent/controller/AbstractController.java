package ru.skillbox.trackstudent.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.*;
import ru.skillbox.trackstudent.entity.BaseEntity;


public abstract class AbstractController<T extends BaseEntity, R extends JpaRepository<T, ?>> {
    protected R repo;

    public AbstractController(R repo) {
        this.repo = repo;
    }

    @GetMapping("{id}")
    @ApiOperation(value = "Поиск сущности по id")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Сущность найдена"),
            @ApiResponse(code = 400, message = "Ошибка, один из параметров указан неверно"),
            @ApiResponse(code = 404, message = "Сущность не найдена"),
            @ApiResponse(code = 500, message = "Ошибка на стороне сервера")
    })
    public T find(@PathVariable("id") T obj) {
        return obj;
    }

    @ApiOperation(value = "Сохранение сущности")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Сущность успешно сохранилась"),
            @ApiResponse(code = 400, message = "Ошибка, один из параметров указан неверно"),
            @ApiResponse(code = 500, message = "Ошибка на стороне сервера")
    })
    @PostMapping
    public T save(@RequestBody T obj) {
        return repo.save(obj);
    }

    @ApiOperation(value = "Обновление сущности по id")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Сущность обновилась"),
            @ApiResponse(code = 400, message = "Ошибка, один из параметров указан неверно"),
            @ApiResponse(code = 404, message = "Сущность для обновления не найдена"),
            @ApiResponse(code = 500, message = "Ошибка на стороне сервера")
    })
    @PutMapping
    public T update(@RequestBody T obj) {
        return repo.save(obj);
    }


    @ApiOperation(value = "Удаление сущности по id")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Сущность удалилась"),
            @ApiResponse(code = 400, message = "Ошибка, один из параметров указан неверно"),
            @ApiResponse(code = 404, message = "Сущность для удаления не найдена"),
            @ApiResponse(code = 500, message = "Ошибка на стороне сервера")
    })
    @DeleteMapping
    public void delete(T obj) {
        repo.delete(obj);
    }
}
