package com.busanit501.subinServer.member;

import com.busanit501.subinserver.food.service.FoodService;
import com.busanit501.subinserver.member.dto.MemberDTO;
import com.busanit501.subinserver.member.service.MemberService;
import com.busanit501.subinserver.member.vo.MemberVO;
import lombok.extern.log4j.Log4j2;
import lombok.val;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Log4j2
public class MemberServiceTest {
    private MemberService memberService;

    @BeforeEach
    public void ready() {
        memberService = MemberService.INSTANCE;
    }

    //1.register
    @Test
    public void testInsert() throws SQLException {
        // 더미 데이터, 화면에서 전달 받은 TodoDTO
        MemberDTO memberDTO = MemberDTO.builder()
                .id("admin")
                .password("1234")
                .build();
        memberService.insert(memberDTO);
    }

    //2.select
    @Test
    public void testSelectAll() throws SQLException {
        List<MemberDTO> dtoList = memberService.listAll();
        // null 체크 추가
        if (dtoList == null) {
            log.error("dtoList is null. Check the getAllMembers() method or database configuration.");
            return; // 테스트 종료
        }
        for (MemberDTO memberDTO:dtoList) {
            log.info(memberDTO);
        }
    }

    //3,하나조회
    @Test
    public void testSelectOne() throws SQLException {
        val memberDTO = memberService.get(3L);
        log.info("하나 조회. memberDTO " + memberDTO);
    }

    //4 수정 기능
    @Test
    public void testUpdateOne() throws SQLException {
        MemberDTO memberDTO = MemberDTO.builder()
                .mno(3L)
                .id("수정된 id")
                .password("123456")
                .build();

        memberService.update(memberDTO);
    }

    //5. 삭제
    @Test

    public void testDelteOne() throws SQLException {
        memberService.delete(3L);
    }

}
