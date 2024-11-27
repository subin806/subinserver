package com.busanit501.subinServer.member;

import com.busanit501.subinserver.member.dao.MemberDAO;
import com.busanit501.subinserver.member.vo.MemberVO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class memberDaoTest {
    private MemberDAO memberDAO;

    // 아래에 각 단위 테스트가 실행되기전에, 먼저 실행을 함.
    @BeforeEach
    public void ready() {
        memberDAO = new MemberDAO();
    }

    // 1
    @Test
    public void insetTest() throws Exception {
        MemberVO memberVO = MemberVO.builder()
                .id("id등록 테스트")
                .password("pasword등록테스트")
                .build();

        memberDAO.insert(memberVO);

    }

    //2, 전체 목록 조회 테스트
    @Test
    public void testList() throws SQLException {
        List<MemberVO> list = memberDAO.selectAll();
        list.forEach(vo -> System.out.println(vo));
    }

    //3, 하나 조회 테스트
    @Test
    public void getOneTest() throws SQLException {
        Long mno = 1L;
        MemberVO memberVO = memberDAO.selectOne(mno);
        System.out.println(memberVO);
    }

    // 4, 삭제 테스트
    @Test
    public void deleteTest() throws SQLException {
        Long mno = 1L;
        memberDAO.deleteTodo(mno);
    }

    // 5, 수정 테스트
    @Test
    public void updateTest() throws SQLException {
        MemberVO memberVO = MemberVO.builder()
                .mno(3L)
                .id("id 수정 테스트")
                .password("password 수정 테스트")
                .build();

        memberDAO.updateOne(memberVO);

    }
}
