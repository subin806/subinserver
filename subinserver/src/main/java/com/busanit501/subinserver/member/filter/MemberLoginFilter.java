//package com.busanit501.subinserver.member.filter;
//
//import lombok.extern.log4j.Log4j2;
//
//import javax.servlet.*;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import java.io.IOException;
//
//@WebFilter(urlPatterns = {"/member/*"})
//@Log4j2
//public class MemberLoginFilter implements Filter {
//
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        log.info("doFilter ,/member/* 하위로 들어오는 모든 url 에 대해서 로그인 체크함");
//        HttpServletRequest request = (HttpServletRequest) servletRequest;
//        HttpServletResponse response = (HttpServletResponse) servletResponse;
//
//        HttpSession session = request.getSession();
//
//        if(session.isNew()) {
//            log.info("최초로 서버에 요청을함.");
//            response.sendRedirect("/member/login");
//            return;
//        }
//
//        if(session.getAttribute("loginInfo") == null) {
//            log.info("2번째 이후로 서버에 요청을했고, 하지만, 로그인 정보는 없는 경우.");
//            // 로그인 컨트롤러가 아직 없음, 곧 만들 예정.
//            response.sendRedirect("/member/login");
//            return;
//        }
//
//        if(session.getAttribute("loginInfo") != null) {
//            String result  = (String) session.getAttribute("loginInfo");
//            log.info("session.getAttribute(\"loginInfo\") result : " + result);
//        }
//        filterChain.doFilter(servletRequest, servletResponse);
//    }
//}
