package com.busanit501.subinserver.jdbcex.controller;


import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Log4j2
@WebServlet(name = "LogoutController", urlPatterns = "/logout")
public class LogoutController extends HttpServlet {

    //로직 처리
    //로그인시, 임시로, 세션에 logInfo 키 이름으로, 값: 아이디 + 패스워드
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info("LoginController doPost");

        HttpSession session = request.getSession();
        session.removeAttribute("loginInfo");
        session.invalidate();

        response.sendRedirect("/login");


    }
}
