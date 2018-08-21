package controller.servlet.cattle;

import model.CattlePOJO;
import service.impl.CattleServiceImpl;
import util.Neo4jSessionFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "GenTableServlet", urlPatterns = {"/GenTableServlet"})
public class GenTableServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sort_method = request.getParameter("sort");
        if (sort_method == null) sort_method = "";
        System.out.println("sort_method = " + sort_method);

        CattleServiceImpl cattleService = new CattleServiceImpl();
        ArrayList<CattlePOJO> cattleList;

        switch (sort_method) {
            case ("id"):
                cattleList = cattleService.sortById();
                break;
            case ("birthday"):
                cattleList = cattleService.sortByBirthday();
                break;
            case ("birthday_desc"):
                cattleList = cattleService.sortByBirthdayDesc();
                break;
            case ("weight"):
                cattleList = cattleService.sortByWeight();
                break;
            default:
                cattleList = (ArrayList<CattlePOJO>)cattleService.findAll();
        }

        request.setAttribute("cattleList", cattleList);
        getServletContext().getRequestDispatcher("/WEB-INF/all.jsp").forward(request, response);
    }

    @Override
    public void destroy() {
        super.destroy();
        Neo4jSessionFactory.getInstance().close();
    }
}
