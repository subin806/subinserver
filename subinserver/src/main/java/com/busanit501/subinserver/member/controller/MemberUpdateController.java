package com.busanit501.subinserver.member.controller;


import com.busanit501.subinserver.member.dto.MemberDTO;
import com.busanit501.subinserver.member.service.MemberService;
import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Log4j2
@WebServlet(name = "MemberUpdateController",urlPatterns = "/member/update")
public class MemberUpdateController extends HttpServlet {
    private MemberService memberService = MemberService.INSTANCE;
//    private final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //화면 전달.
        // 서비스에서, 하나의 todo 더미 데이터를 조회 후,
        try {
            // 클릭한 게시글 번호를 가지고 와야함.
            Long mno = Long.parseLong(request.getParameter("mno"));
            MemberDTO memberDTO = memberService.get(mno);
            // 화면에 전달하기.
            request.setAttribute("dto", memberDTO);
            request.getRequestDispatcher("/WEB-INF/member/memberUpd.jsp")
                    .forward(request, response);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            MemberDTO memberDTO = new MemberDTO();
            memberDTO.setMno(Long.parseLong(request.getParameter("mno")));
            memberDTO.setId(request.getParameter("id"));
            memberDTO.setPassword(request.getParameter("password"));

            memberService.update(memberDTO);

            response.sendRedirect("/member/list");
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "회원 정보를 수정하는데 오류가 발생했습니다.");
        }
    }

}

