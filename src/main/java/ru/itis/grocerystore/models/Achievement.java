package ru.itis.grocerystore.models;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.io.File;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Slf4j
public class Achievement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String achievement;
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;
}
