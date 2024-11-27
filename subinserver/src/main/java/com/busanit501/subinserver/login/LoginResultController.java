package com.busanit501.subinserver.login;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginResultController", urlPatterns = "/login/result")
public class LoginResultController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       System.out.println("doPost,loginResultController 서블릿을 경유해서 로직처리");
        String id = request.getParameter("id");
        String password = request.getParameter("password");

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1> id: " + id + "</h1>");
        out.println("<h1> password: " + password + "</h1>");
        out.println("</body></html>");
    }
}
