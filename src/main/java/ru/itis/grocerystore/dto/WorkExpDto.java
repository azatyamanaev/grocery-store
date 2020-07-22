package ru.itis.grocerystore.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WorkExpDto {
    private String start;
    private String end;
    private String company;
    private String position;
    private String duties;
}
