package com.busanit501.subinserver.jdbex.service;

import com.busanit501.subinserver.jdbex.dao.TodoDAO;
import com.busanit501.subinserver.jdbex.dto.TodoDTO;
import com.busanit501.subinserver.jdbex.util.MapperUtil;
import com.busanit501.subinserver.jdbex.vo.TodoVO;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

@Log4j2
public enum TodoService {
    INSTANCE;

    private TodoDAO todoDAO;
    private ModelMapper modelMapper;

    // 생성자 이용해서, 초기화하기.
    TodoService() {
        todoDAO = new TodoDAO();
        modelMapper = MapperUtil.INSTANCE.get();
    }

    //1
    // register

    public void register(TodoDTO todoDTO) throws SQLException {

        // 모델 맵퍼 이용시.
        TodoVO todoVO = modelMapper.map(todoDTO, TodoVO.class);
        // 기존 로깅 기록 출력
//        System.out.println("todoVo : "+ todoVO);
        log.info("todoVo : " + todoVO);

        // DAO 외주 맡기기,
        todoDAO.insert(todoVO);
    } // register

    //2
    // 전체 조회
    public List<TodoDTO> listAll() throws SQLException {
        List<TodoVO> voList = todoDAO.selectAll();
        log.info("voList : " + voList);

        List<TodoDTO> dtoList = voList.stream().map(vo -> modelMapper.map(vo, TodoDTO.class))
                .collect(Collectors.toList());
        return dtoList;
    }

    //3
    // 하나 조회, 상세보기.
    public TodoDTO get(Long tno) throws SQLException {
        log.info("tno : " + tno);
        ///  디비에서 하나 조회 결과 받았음.
        TodoVO todoVO = todoDAO.selectOne(tno);
        // VO -> DTO 변환 작업.
        TodoDTO todoDTO = modelMapper.map(todoVO,TodoDTO.class);
        return todoDTO;

    }


}
