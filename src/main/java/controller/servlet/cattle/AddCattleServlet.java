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
import java.io.PrintWriter;

@WebServlet(name = "AddCattleServlet", urlPatterns = "/AddCattleServlet")
public class AddCattleServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Object cattleObj = request.getSession().getServletContext().getAttribute("cattle");
        CattlePOJO cattle = (cattleObj instanceof CattlePOJO ? (CattlePOJO) cattleObj : null);
        if (cattle == null) throw new ServletException("Casting cattleObj failed.");

        CattleServiceImpl cattleService = new CattleServiceImpl();
        PrintWriter out = response.getWriter();

        System.out.println("create: " + cattleService.createOrUpdate(cattle));
        if (cattleService.createOrUpdate(cattle) != null) {
            out.print("<p>添加成功</p>");
            out.print("<a href='/admin/query.jsp'>返回</a>&nbsp;<a href='/QueryCattleServlet?id=" + cattle.getId() + "'>查看</a>");
        } else {
            throw new ServletException("Failed appending a cattle object.");
        }

        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    public void destroy() {
        super.destroy();
        Neo4jSessionFactory.getInstance().close();
    }
}
