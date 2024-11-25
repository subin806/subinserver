package com.busanit501.subinServer.food;

import com.busanit501.subinserver.food.dao.FoodDAO;
import com.busanit501.subinserver.food.vo.FoodVO;
import com.busanit501.subinserver.jdbex.vo.TodoVO;
import com.sun.tools.javac.comp.Todo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class FoodDAOTest {
    private FoodDAO foodDAO;
    @BeforeEach
    public void ready() {
        foodDAO = new FoodDAO();
    }

    @Test
    public void getTime() {
        System.out.println("sql 전달 후, 시간 조회 확인용: " + foodDAO.getTime());
    }

    @Test
    public void getTime2() throws SQLException {
        System.out.println("sql 전달 후, " +
                "시간 조회 확인용: 자동 반납 @Cleanup 확인 " + foodDAO.getTime2());
    }

    @Test
    public void insetTest() throws Exception {
        FoodVO foodVO = FoodVO.builder()
                .title("샘플 데이터 추가1")
                .dueDate(LocalDate.now())
                .finished(false)
                .build();

        foodDAO.insert(foodVO);
    }
  // 전체 목록 조회 테스트
    @Test
    public void testList() throws SQLException {
        List<FoodVO> list = foodDAO.selectAll();
        list.forEach(vo -> System.out.println(vo));
    }
// 하나 조회 테스트
    @Test
    public void getOneTest() throws SQLException {
        Long fno = 3L;
        FoodVO foodVO = FoodDAO.selectOne(fno);
        System.out.println(foodVO);
    }

    //수정테스트
    @Test
    public void updateTest() throws SQLException {
        FoodVO foodVO = FoodVO.builder()
                .fno(8L)
                .title("수정 테스트 중")
                .finished(true)
                .dueDate(LocalDate.of(2024, 12, 30))
                .build();

        foodDAO.updateOne(foodVO);
    }

    //삭제테스트
    @Test
    public void deleteTest() throws SQLException {
        Long fno = 7L;
        foodDAO.deleteTodo(fno);
    }
}
