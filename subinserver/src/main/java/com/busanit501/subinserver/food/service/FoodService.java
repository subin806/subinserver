package com.busanit501.subinserver.food.service;

import com.busanit501.subinserver.food.dao.FoodDAO;
import com.busanit501.subinserver.food.dto.FoodDTO;
import com.busanit501.subinserver.food.vo.FoodVO;
import com.busanit501.subinserver.jdbex.util.MapperUtil;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Log4j2
public enum FoodService {
    INSTANCE;

    private FoodDAO foodDAO;
    private ModelMapper modelMapper;

    FoodService() {
        foodDAO = new FoodDAO();
        modelMapper = MapperUtil.INSTANCE.get();
    }
    public void register(FoodDTO foodDTO) throws SQLException {
       FoodVO foodVO = modelMapper.map(foodDTO, FoodVO.class);
        log.info("foodVo : " + foodVO);
        foodDAO.insert(foodVO);
    }

}
