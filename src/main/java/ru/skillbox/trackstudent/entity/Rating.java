package ru.skillbox.trackstudent.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Rating {
    @Id
    private Long id;
    private Integer rating;
    @OneToOne
    @JoinColumn(nullable = false)
    private Student student;
    @OneToOne
    @JoinColumn(nullable = false)
    private Subject subject;
}
