package com.busanit501.subinserver.jdbex.vo;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

    @Data
    @Builder
    public class TodoVO {
        private Long tno;
        private String title;
        private LocalDate dueDate;
        private boolean finished;
    }
