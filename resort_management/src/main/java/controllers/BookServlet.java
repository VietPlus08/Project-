package controllers;

import models.Book;
import services.IBaseServices;
import services.impl.BookServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet (name = "BookServlet", urlPatterns = "/BookServlet")
public class BookServlet extends HttpServlet {
    IBaseServices<Book> repositories = new BookServices();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = Optional.ofNullable(req.getParameter("action")).orElse("");
        switch (action){
            case "update":
                getInfo(req,resp); break;
            case "create":
                create(req,resp); break;
            case "search":
                findByCondition(req,resp); break;
            case "delete":
                delete(req,resp); break;
            default:
                findAll(req,resp);
        }

    }
    private void findAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("list",repositories.findAll());
        req.getRequestDispatcher("bookJSP/BookList.jsp").forward(req,resp);
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = Optional.ofNullable((req.getParameter("id"))).orElse("");
        repositories.delete(id);
        findAll(req,resp);}

    private void findByCondition(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = Optional.ofNullable((req.getParameter("id"))).orElse("");
        req.setAttribute("list",repositories.findAll());
        req.getRequestDispatcher("bookJSP/BookList.jsp").forward(req,resp);
    }

    private void create(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.setAttribute("gender",genderRepositories.findAll());
//        req.setAttribute("degree",degreeRepositories.findAll());
//        req.setAttribute("position",positionRepositories.findAll());
//        req.getRequestDispatcher("employeeJSP/EmployeeRegistry.jsp").forward(req,resp);
    }

    private void getInfo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String id = req.getParameter("id");
//        req.setAttribute("item", repositories.findById(id));
//        req.setAttribute("gender",genderRepositories.findAll());
//        req.setAttribute("degree",degreeRepositories.findAll());
//        req.setAttribute("position",positionRepositories.findAll());
//        req.getRequestDispatcher("employeeJSP/EmployeeRegistry.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        super.doPost(req, resp);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        super.service(req, resp);
    }
}
