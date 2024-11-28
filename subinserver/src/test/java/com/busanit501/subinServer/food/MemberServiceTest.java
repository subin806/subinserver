package com.busanit501.subinServer.food;

import com.busanit501.subinserver.food.dto.MemberDTO;
import com.busanit501.subinserver.food.service.MemberService;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

@Log4j2
public class MemberServiceTest {
    private MemberService memberService;

    @BeforeEach
    public void ready() {
        memberService = MemberService.INSTANCE;
    }

    // 등록
    @Test
    public void loginTest() throws SQLException {
     MemberDTO memberDTO = memberService.login("lsy", "1234");
     log.info("MemberService loginTest : " + memberDTO.toString());
    }


}
