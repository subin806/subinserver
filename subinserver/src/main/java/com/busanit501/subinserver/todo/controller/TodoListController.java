package com.busanit501.subinserver.todo.controller;

import com.busanit501.subinserver.todo.dto.TodoDTO;
import com.busanit501.subinserver.todo.service.TodoService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "TodoListController",urlPatterns = "/todo/list")
public class TodoListController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doGet : TodoListController");
        List<TodoDTO> todoList = TodoService.INSTANCE.getList();
        request.setAttribute("list", todoList);
        request.getRequestDispatcher("/WEB-INF/todo/todoList.jsp")
                .forward(request, response);
    }

}
