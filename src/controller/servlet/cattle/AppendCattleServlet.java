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

@WebServlet(name = "AppendCattleServlet", urlPatterns = {"/AppendCattleServlet"})
public class AppendCattleServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Object cattleObj = request.getSession().getServletContext().getAttribute("cattle");
        Cattle cattle = (cattleObj instanceof Cattle ? (Cattle)cattleObj : null);
        if (cattle == null) throw new ServletException("Casting cattleObj failed.");

        if (new CattleDAO().append(cattle)) {
            PrintWriter out = response.getWriter();
            out.print("<p>添加成功</p>");
            out.print("<a href='/admin/query.jsp'>返回</a>");
            out.close();
        } else {
            throw new ServletException("Failed appending a cattle bean object.");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
