package controller.servlet.cattle;

import dao.CattleDao;
import dao.impl.CattleDaoImpl;
import model.CattlePOJO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "AddCattleServlet", urlPatterns = "/AddCattleServlet")
public class AddCattleServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Object cattleObj = request.getSession().getServletContext().getAttribute("cattle");
        CattlePOJO cattle = (cattleObj instanceof CattlePOJO ? (CattlePOJO) cattleObj : null);
        if (cattle == null) throw new ServletException("Casting cattleObj failed.");

        CattleDao cattleDao = new CattleDaoImpl();
        PrintWriter out = response.getWriter();

        System.out.println("create: " + cattleDao.createOrUpdate(cattle));
        if (cattleDao.createOrUpdate(cattle) != null) {
            out.print("<p>添加成功</p>");
            out.print("<a href='/admin/query.jsp'>返回</a>");
        } else {
            throw new ServletException("Failed appending a cattle object.");
        }

        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
