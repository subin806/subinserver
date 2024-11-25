package com.busanit501.subinserver.food.service;

import com.busanit501.subinserver.food.dto.FoodDTO;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public enum FoodService {
    INSTANCE;

    public void register(FoodDTO foodDTO) {
        System.out.println("글쓰기 작업하는 기능입니다.");
    }

    public List<FoodDTO> getList() {
        List<FoodDTO> foodList = IntStream.range(0,10).mapToObj(
                i -> {
                    // 10 반복 해서, 더미 인스턴스 10개 생성,
                    FoodDTO foodDTO = new FoodDTO();
                    foodDTO.setTitle("테스트AA " + i);
                    foodDTO.setFno((long) i);
                    foodDTO.setDueDate(LocalDate.now());
                    return  foodDTO;
                }).collect(Collectors.toList());
        return foodList;
    }

    public FoodDTO getOne(Long fno) {
        // 실제로, 디비에서 데이터 받아 와야 하지만,
        // 더미 데이터 이용하기.
        FoodDTO foodDTO = new FoodDTO();
        foodDTO.setFno(5L);
        foodDTO.setTitle("하나 조회 더미 데이터");
        foodDTO.setDueDate(LocalDate.now());
        return foodDTO;
    }
}
