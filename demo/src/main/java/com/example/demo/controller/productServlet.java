package com.example.demo.controller;

import com.example.demo.model.Product;
import com.example.demo.repository.IBaseRepository;
import com.example.demo.repository.impl.ProductRepository;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "productServlet", value = "/productServlet")
public class productServlet extends HttpServlet {
    private String message;
    ProductRepository products = new ProductRepository();

    public void init() {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String action = request.getParameter("action");
        if (action == null) action = "";
        switch (action){
            default:
                goDisplayList(request,response);
        }

    }



    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    private void goDisplayList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("item",products.findAll());
        request.getRequestDispatcher("list.jsp").forward(request,response);
    }
}