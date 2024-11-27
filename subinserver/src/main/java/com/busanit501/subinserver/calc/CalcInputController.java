package com.busanit501.subinserver.calc;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="calcInputController", urlPatterns = "/calc/input")

public class CalcInputController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doGet 호출 함.");
        //요청을 받고, 화면으로 전달 해주는 역할.
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/WEB-INF/calc/calc_input.jsp");
        dispatcher.forward(request,response);
    }
}