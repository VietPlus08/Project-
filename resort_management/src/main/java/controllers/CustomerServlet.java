package controllers;

import models.Customer;
import services.IBaseServices;
import services.impl.CustomerServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.Map;
import java.util.Optional;

@WebServlet (name = "CustomerServlet", urlPatterns = "/CustomerServlet")
public class CustomerServlet extends HttpServlet {
    IBaseServices<Customer> repositories = new CustomerServices();
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


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = Optional.ofNullable(req.getParameter("action")).orElse("");
        switch (action){
            case "doUpdate":
                update(req,resp);
                break;
            case "doCreate":
                createNew(req,resp);
                break;
            case "delete":
                delete(req,resp);
                break;
            default:
                findAll(req,resp);
        }
    }
    private void create(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.sendRedirect("customerJSP/CustomerRegistry.jsp");
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        repositories.delete(id);
        findAll(req,resp);
    }

    private void createNew(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String address = req.getParameter("address");
        Date date = Date.valueOf(req.getParameter("date"));
        int phone = Integer.parseInt(req.getParameter("phone"));
        String gender = req.getParameter("gender");
        String cusType = req.getParameter("cusType");
        Customer customer = new Customer(id,name,address,date,phone,gender,cusType);
        Map<String,String> error = repositories.create(customer);
        if (error.isEmpty()){
            findAll(req,resp);
            return;
        }
        req.setAttribute("message","Create is fail!!!");
        req.setAttribute("error",error);
        req.setAttribute("item",customer);
        req.getRequestDispatcher("customerJSP/CustomerRegistry.jsp").forward(req,resp);
    }

    private void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String address = req.getParameter("address");
        Date date = Date.valueOf(req.getParameter("date"));
        int phone = Integer.parseInt(req.getParameter("phone"));
        String gender = req.getParameter("gender");
        String cusType = req.getParameter("cusType");
        Customer customer = new Customer(id,name,address,date,phone,gender,cusType);
        Map<String,String> error = repositories.update(customer);
        if (error.isEmpty()){
            findAll(req,resp);
            return;
        }
        req.setAttribute("message","Update is fail!!!");
        req.setAttribute("error",error);
        req.setAttribute("item",customer);
        req.getRequestDispatcher("customerJSP/CustomerRegistry.jsp").forward(req,resp);
    }


    private void getInfo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        req.setAttribute("item", repositories.findById(id));
        req.getRequestDispatcher("customerJSP/CustomerRegistry.jsp").forward(req,resp);
    }
    private void findAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = "";
        req.setAttribute("list",repositories.findByCondition(id));
        req.getRequestDispatcher("customerJSP/CustomerList.jsp").forward(req,resp);
    }
    private void findByCondition(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = Optional.ofNullable((req.getParameter("id"))).orElse("");
        req.setAttribute("list",repositories.findByCondition(id));
        req.getRequestDispatcher("customerJSP/CustomerList.jsp").forward(req,resp);
    }
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
    }

    @Override
    public void destroy() {
        System.out.println("detroy servlet");
    }
}
