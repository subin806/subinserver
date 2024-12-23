package com.busanit501.subinServer.food;

import com.busanit501.subinserver.food.dao.MemberDAO;
import com.busanit501.subinserver.food.vo.MemberVO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

@Log4j2
public class MemberDAOTest {
    private MemberDAO memberDAO;

    // 아래에 각 단위 테스트가 실행되기전에, 먼저 실행을 함.
    @BeforeEach
    public void ready() {
        memberDAO = new MemberDAO();
    }

    @Test
    public void getMemberWithMpwTest() throws SQLException {
        String mid = "lsy";
        String mpw = "1234";
       MemberVO memberVO = memberDAO.getMemberWithMpw(mid,mpw);
       log.info("memberVO 조회 확인: " +memberVO );
    }

}
