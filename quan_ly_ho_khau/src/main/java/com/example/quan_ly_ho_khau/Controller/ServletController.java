package com.example.quan_ly_ho_khau.Controller;

import com.example.quan_ly_ho_khau.Model.HouseHold;
import com.example.quan_ly_ho_khau.Model.HouseHoldDto;
import com.example.quan_ly_ho_khau.Service.impl.HouseHoldService;

import java.io.*;
import java.sql.Date;
import java.util.Optional;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "ServletController", value = "/ServletController")
public class ServletController extends HttpServlet {
    HouseHoldService houseHoldService = new HouseHoldService();
    public void init() {}
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String action = request.getParameter("action");
        switch (Optional.ofNullable(action).orElse("")) {
            case "displayInfo":
                displayPersonInHouseHold(request,response);
                break;
            case "update":
                getInfoForUpdate(request,response);
                break;
            case "doUpdate":
                doUpdate(request,response);
            case "search":
                searchByName(request,response);
                break;
            default:
                displayHouseHold(request, response);
        }
    }

    private void doUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        int numPerson = Integer.parseInt(request.getParameter("numPerson"));
        Date date = Date.valueOf(request.getParameter("date"));
        String address = request.getParameter("address");
        HouseHoldDto houseHoldDto = new HouseHoldDto(new HouseHold(id,name,numPerson,date,address));
        houseHoldService.updateHouseHold(houseHoldDto);
        displayHouseHold(request,response);
    }

    private void searchByName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        request.setAttribute("item",houseHoldService.searchByName(name));
        request.getRequestDispatcher("list.jsp").forward(request,response);
    }

    private void getInfoForUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        HouseHoldDto houseHoldDto = houseHoldService.searchById(id);
        request.setAttribute("item",houseHoldDto);
        request.getRequestDispatcher("update.jsp").forward(request,response);
    }

    private void displayPersonInHouseHold(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        request.setAttribute("id",houseHoldService.findPersonInHouseHold(id));
//        request.getRequestDispatcher();

    }
    private void displayHouseHold(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int pageIndex = Integer.parseInt(Optional.ofNullable(request.getParameter("pageIndex")).orElse("1"));
        request.setAttribute("pageIndex",pageIndex);
        request.setAttribute("maxPage",houseHoldService.getNumberPages());
        request.setAttribute("item",houseHoldService.findAll(pageIndex));
        request.setAttribute("listPersonInHouse",houseHoldService.findPersonInHouseHold());
        request.getRequestDispatcher("list.jsp").forward(request,response);
    }
    public void destroy () {
    }
}