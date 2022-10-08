package controllers;

import models.Facility;
import models.support_facility.FacilityType;
import models.support_facility.Period;
import models.support_facility.UsedTimes;
import repositories.ITypeRepositories;
import repositories.impl.support_facility.FacilityTypeRepositories;
import repositories.impl.support_facility.PeriodRepositories;
import repositories.impl.support_facility.UsedTimesRepositories;
import services.IBaseServices;
import services.impl.FacilityServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet (name = "FacilityServlet", urlPatterns = "/FacilityServlet")
public class FacilityServlet extends HttpServlet {
    IBaseServices<Facility> facilityRepositories = new FacilityServices();
    ITypeRepositories<Period> periodRepositories = new PeriodRepositories();
    ITypeRepositories<FacilityType> facilityTypeRepositories = new FacilityTypeRepositories();
    ITypeRepositories<UsedTimes> usedTimesRepositories = new UsedTimesRepositories();

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
        req.setAttribute("period",periodRepositories.findAll());
        req.setAttribute("type",facilityTypeRepositories.findAll());
        req.setAttribute("times",usedTimesRepositories.findAll());
        req.setAttribute("list",facilityRepositories.findAll());
        req.getRequestDispatcher("facilityJSP/FacilityList.jsp").forward(req,resp);
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = Optional.ofNullable((req.getParameter("id"))).orElse("");
        facilityRepositories.delete(id);
        findAll(req,resp);}

    private void findByCondition(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = Optional.ofNullable((req.getParameter("id"))).orElse("");
        req.setAttribute("period",periodRepositories.findAll());
        req.setAttribute("type",facilityTypeRepositories.findAll());
        req.setAttribute("times",usedTimesRepositories.findAll());
        req.setAttribute("list",facilityRepositories.findAll());
        req.getRequestDispatcher("facilityJSP/FacilityList.jsp").forward(req,resp);
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
