package com.example.flat_management.controller;

import com.example.flat_management.models.Flat;
import com.example.flat_management.services.IBFlatServices;
import com.example.flat_management.services.impl.FlatService;

import java.io.*;
import java.sql.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "FlatController", value = "/FlatController")
public class Controller extends HttpServlet {
    IBFlatServices<Flat> repository = new FlatService();
    private String message;

    public void init() {
        message = "Hello World!";
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = Optional.ofNullable(request.getParameter("action")).orElse("");
        switch (action) {
            case "doCreate":
                registry(request, response);
                break;
            default:
                displayAll(request, response);
        }
    }

    private void registry(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        int area = Integer.parseInt(request.getParameter("area"));
        String status = request.getParameter("status");
        int stage = Integer.parseInt(request.getParameter("stage"));
        String type = request.getParameter("type");
        int price = Integer.parseInt(request.getParameter("price"));
        Date date_in = Date.valueOf(request.getParameter("date_in"));
        Date date_out = Date.valueOf(request.getParameter("date_out"));
        Flat flat = new Flat(id, area, status, stage, type, price, date_in, date_out);
        Map<String,String> error = repository.create(flat);
        if (error.isEmpty()){
            displayAll(request, response); return;
        }
        request.setAttribute("error",error);
        request.setAttribute("list",flat);
        request.getRequestDispatcher("create.jsp").forward(request,response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String action = Optional.ofNullable(request.getParameter("action")).orElse("");
        switch (action) {
            case "create":
                response.sendRedirect("create.jsp");
                break;
            case "search":
                searchById(request, response);
                break;
            case "update":
                getInfoForUpdate(request,response);
                break;
            case "delete":
                deleteById(request,response);
            default:
                displayAll(request, response);
        }
    }

    private void deleteById(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        repository.delete(id);
    }

    private void getInfoForUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String status = Optional.ofNullable(request.getParameter("status")).orElse("");
        request.setAttribute("list",repository.findById(id,status));
        request.getRequestDispatcher("create.jsp").forward(request,response);
    }

    private void searchById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = Optional.ofNullable(request.getParameter("id")).orElse("");
        String status = Optional.ofNullable(request.getParameter("status")).orElse("");
        request.setAttribute("list", repository.Search(id,status));
        request.getRequestDispatcher("list.jsp").forward(request, response);
    }

    private void displayAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("list", repository.findAll());
        request.getRequestDispatcher("list.jsp").forward(request, response);
    }

    public void destroy() {
    }
}