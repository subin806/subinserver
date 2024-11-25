package com.busanit501.subinserver.food.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class FoodDTO {
    private Long fno;
    private String title;
    private LocalDate dueDate;
    private boolean finished;
}
