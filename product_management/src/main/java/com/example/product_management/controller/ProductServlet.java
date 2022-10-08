package com.example.product_management.controller;

import com.example.product_management.model.Product;
import com.example.product_management.service.IBaseService;
import com.example.product_management.service.impl.ProductService;

import java.io.*;
import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "productServlet", value = "/productServlet")
public class ProductServlet extends HttpServlet {
    IBaseService<Product> productService = new ProductService();
    public void init() {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) action = "";
        switch (action){
            case "registry":
                registry(req,resp); break;
            case "search":
                searchByName(req,resp); break;
            default:
                displayList(req,resp); break;
        }
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String action = request.getParameter("action");
        if (action == null) action = "";
        switch (action){
            case "update":
                getInfoUpdate(request,response); break;
            case "create":
                response.sendRedirect("registry.jsp"); break;
            case "delete":
                delete(request,response); break;
            case "paging":
                displayList(request,response);break;
            default:
                displayList(request,response); break;
        }
    }

    private void displayCurrentPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int pageIndex = Integer.parseInt(request.getParameter("index"));
        request.setAttribute("item",productService.findItemForCurrentPage(pageIndex));
        request.setAttribute("maxPage",productService.getNumberPage());
        request.getRequestDispatcher("list.jsp").forward(request,response);
    }

    private void searchByName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String pageIndex = request.getParameter("index");
        if (pageIndex == null) pageIndex = "1";
        request.setAttribute("name",name);
        request.setAttribute("maxPage",productService.getNumberPage(name));
        request.setAttribute("item",productService.searchByName(name, Integer.parseInt(pageIndex)));
        request.getRequestDispatcher("list.jsp").forward(request, response);
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        productService.deleteOject(name);
        displayList(request,response);
    }

    private void registry(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String name = req.getParameter("name");
        String price   = req.getParameter("price");
        String quantity = req.getParameter("quantity");
        String color = req.getParameter("color");
        String des = req.getParameter("des");
        String category = req.getParameter("category");
        Product product = new Product(Arrays.asList(name,price,quantity,color,des,category));
        Map<String,String> error = productService.registry(product);
        if (error.isEmpty()){
            displayList(req,resp); return;
        }
        req.setAttribute("error",error);
        req.setAttribute("item",product);
        req.getRequestDispatcher("registry.jsp").forward(req,resp);
    }

    private void getInfoUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        Product product = productService.getObjectByName(name);
        request.setAttribute("item",product);
        request.getRequestDispatcher("registry.jsp").forward(request,response);
    }

    private void displayList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int index = Integer.parseInt(Optional.ofNullable(request.getParameter("index")).orElse("1"));
        request.setAttribute("index", index);
        request.setAttribute("item",productService.findItemForCurrentPage(index));
        request.setAttribute("maxPage",productService.getNumberPage());
        request.getRequestDispatcher("list.jsp").forward(request,response);
    }
}