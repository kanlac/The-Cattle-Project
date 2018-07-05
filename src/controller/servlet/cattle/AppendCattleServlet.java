package controller.servlet.cattle;

import model.Cattle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AppendCattleServlet", urlPatterns = {"/AppendCattleServlet"})
public class AppendCattleServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Object cattleObj = request.getParameter("cattle");
        Cattle cattle = (cattleObj instanceof Cattle ? (Cattle)cattleObj : null);
        if (cattle == null) System.out.println("Casting cattleObj failed");


    }
}
