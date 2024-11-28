package com.busanit501.subinServer.jdbcex;

import com.busanit501.subinserver.jdbcex.dto.MemberDTO;
import com.busanit501.subinserver.jdbcex.dto.TodoDTO;
import com.busanit501.subinserver.jdbcex.service.MemberService;
import com.busanit501.subinserver.jdbcex.service.TodoService;
import lombok.extern.log4j.Log4j2;
import lombok.val;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

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
        log.info("MemberService loginTest: " + memberDTO.toString());
    }


}