package com.busanit501.subinserver.food.controller;

import com.busanit501.subinserver.food.dto.FoodDTO;
import com.busanit501.subinserver.food.service.FoodService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "FoodListController", urlPatterns = "/food/list")
public class FoodListController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doGet : FoodListController");

        List<FoodDTO> foodList = FoodService.INSTANCE.getList();
        request.setAttribute("list", foodList);

        request.getRequestDispatcher("/WEB-INF/food/foodList.jsp")
                .forward(request, response);
    }
}
