package controller.servlet.cattle;

import dao.CattleDAO;
import model.Cattle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "QueryCattleServlet", urlPatterns = {"/QueryCattleServlet"})
public class QueryCattleServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cattle_id = request.getParameter("id");

        CattleDAO dao = new CattleDAO();
        PrintWriter out = response.getWriter();
        
        Cattle res = dao.get(cattle_id);
        if (res == null) {
            out.print("The cattle you requested is not found.");
        } else {
            out.print("Good.");
        }
        
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
