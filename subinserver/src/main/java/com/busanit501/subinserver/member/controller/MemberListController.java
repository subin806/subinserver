package com.busanit501.subinserver.member.controller;


import lombok.extern.log4j.Log4j2;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

@Log4j2
@WebServlet(name = "MemberListController", urlPatterns = "/member/list")
public class MemberListController extends HttpServlet {
    private MemberService memberService = MemberService.INSTANCE;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response){
        log.info("doGet MemberListController 확인");
        try{
            List<MeberDTO> memberList = memberService.listAll();
            request.setAttribute("list", memberList);
            request.getRequestDispatcher(:"WEB-INF/member/memberlist.jsp")
            .forward(request, response);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
