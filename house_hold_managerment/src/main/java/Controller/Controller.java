package Controller;

import Service.impl.HouseHoldService;
import Service.impl.IBaseService;
import model.HouseHold;
import model.HouseHoldDto;

import java.io.*;
import java.sql.Date;
import java.util.Optional;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "Controller", value = "/Controller")
public class Controller extends HttpServlet {
    IBaseService<HouseHoldDto> repository = new HouseHoldService();
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String action = request.getParameter("action");
        switch (Optional.ofNullable(action).orElse("")){
            case "search":
                searchByName(request,response) ;break;
            case "update":
                getInfoUpdate(request,response); break;
            case "doUpdate":
                doUpdate(request,response); break;
            default:
                displayHouseHold(request,response);
        }
    }

    private void displayHouseHold(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int currentPage = Integer.parseInt(Optional.ofNullable(request.getParameter("currentPage")).orElse("1"));
        request.setAttribute("list",repository.findAll(currentPage));
        request.setAttribute("maxPage",repository.countHouseHold());
        request.setAttribute("currentPage",currentPage);
        request.getRequestDispatcher("list.jsp").forward(request,response);
    }

    private void doUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        int numPerson = Integer.parseInt(request.getParameter("numPerson"));
        Date date = Date.valueOf(request.getParameter("date"));
        String address = request.getParameter("address");
        HouseHoldDto houseHoldDto = new HouseHoldDto(new HouseHold(id,name,numPerson,date,address));
        repository.updateHouseHold(houseHoldDto);
        displayHouseHold(request,response);
    }

    private void getInfoUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        request.setAttribute("item",repository.findById(id));
        request.getRequestDispatcher("update.jsp").forward(request,response);
    }

    private void searchByName(HttpServletRequest request, HttpServletResponse response) {

    }


    public void destroy() {
    }
}