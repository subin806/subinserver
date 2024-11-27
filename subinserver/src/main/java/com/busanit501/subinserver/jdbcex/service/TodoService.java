package com.busanit501.subinserver.jdbcex.service;

import com.busanit501.subinserver.jdbcex.dao.TodoDAO;
import com.busanit501.subinserver.jdbcex.dto.TodoDTO;
import com.busanit501.subinserver.jdbcex.util.MapperUtil;
import com.busanit501.subinserver.jdbcex.vo.TodoVO;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

@Log4j2
public enum TodoService {
    INSTANCE;
    // 2가지, 다른 클래스에 의존함.
    // 1) 모델 맵퍼 기능
    // 2) DAO 기능

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
        TodoDTO todoDTO = modelMapper.map(todoVO,TodoDTO.class);
        return todoDTO;

    }

    //4 수정 기능
    public void update(TodoDTO todoDTO) throws SQLException {
        log.info("todoDTO : " + todoDTO);
        TodoVO todoVO = modelMapper.map(todoDTO, TodoVO.class);
        todoDAO.updateOne(todoVO);

    }

    //5 삭제 기능.
public void delete(Long tno) throws SQLException {
        todoDAO.deleteTodo(tno);
}

}

