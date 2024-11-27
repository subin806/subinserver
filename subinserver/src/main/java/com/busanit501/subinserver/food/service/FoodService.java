package com.busanit501.subinserver.food.service;

import com.busanit501.subinserver.food.dao.FoodDAO;
import com.busanit501.subinserver.food.dto.FoodDTO;
import com.busanit501.subinserver.food.vo.FoodVO;
import com.busanit501.subinserver.jdbcex.util.MapperUtil;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

@Log4j2
public enum FoodService {
    INSTANCE;

    private FoodDAO foodDAO;
    private ModelMapper modelMapper;

    FoodService() {
        foodDAO = new FoodDAO();
        modelMapper = MapperUtil.INSTANCE.get();
    }
    //1. 등록
    public void register(FoodDTO foodDTO) throws SQLException {
       FoodVO foodVO = modelMapper.map(foodDTO, FoodVO.class);
        log.info("foodVo : " + foodVO);
        foodDAO.insert(foodVO);
    }
    //2.전체조회
    public List<FoodDTO> listAll() throws SQLException {
        List<FoodVO> voList = foodDAO.selectAll();
        voList.forEach(vo -> log.info("VO Finished Value: {}", vo.isFinished())); // VO 값 확인
        List<FoodDTO> dtoList = voList.stream()
                .map(vo -> modelMapper.map(vo, FoodDTO.class))
                .collect(Collectors.toList());
        dtoList.forEach(dto -> log.info("DTO Finished Value: {}", dto.isFinished())); // DTO 값 확인
        return dtoList;
    }

    //3
    // 하나 조회, 상세보기.
    public FoodDTO get(Long fno) throws SQLException {
        log.info("fno : " + fno);
        ///  디비에서 하나 조회 결과 받았음.
        FoodVO foodVO = foodDAO.selectOne(fno);
        // VO -> DTO 변환 작업.
        FoodDTO foodDTO = modelMapper.map(foodVO,FoodDTO.class);
        return foodDTO;

    }

    //4.수정
    public void update(FoodDTO foodDTO) throws SQLException {
        log.info("foodDTO : " + foodDTO);
        FoodVO foodVO = modelMapper.map(foodDTO, FoodVO.class);
        foodDAO.updateOne(foodVO);
    }

    //5.삭제
    public void delete(Long fno) throws SQLException {
        foodDAO.deleteFood(fno);
    }

}
