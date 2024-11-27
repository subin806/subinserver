package com.busanit501.subinserver.todo.service;


import com.busanit501.subinserver.todo.dto.TodoDTO;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public enum TodoService {
    INSTANCE;

    //글 등록하는 기능
    public void register(TodoDTO todoDTO) {
        System.out.println("글쓰기 작업을 하는 기능입니다");
    }
    //조회, 샘플, 하드코딩, 더미 데이터
    public List<TodoDTO> getList() {
       //디비에서 데이터를 조회해서, 전달하기.
        List<TodoDTO> todoList = IntStream.range(0,10).mapToObj(
                i -> {
                    // 10 반복 해서, 더미 인스턴스 10개 생성,
                    TodoDTO todoDTO = new TodoDTO();
                    todoDTO.setTitle("테스트AA " + i);
                    todoDTO.setTno((long) i);
                    todoDTO.setDueDate(LocalDate.now());
                    return  todoDTO;
                }).collect(Collectors.toList());
        return todoList;
    }
    public TodoDTO getOne(Long tno) {
        // 실제로, 디비에서 데이터 받아 와야 하지만,
        // 더미 데이터 이용하기.
        TodoDTO todoDTO = new TodoDTO();
        todoDTO.setTno(5L);
        todoDTO.setTitle("하나 조회 더미 데이터");
        todoDTO.setDueDate(LocalDate.now());
        return todoDTO;
    }
}
