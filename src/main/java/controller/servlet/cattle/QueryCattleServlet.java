package controller.servlet.cattle;

import dao.CattleDao;
import dao.impl.CattleDaoImpl;
import model.CattlePOJO;
import util.Neo4jSessionFactory;

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

        CattleDao cattleDao = new CattleDaoImpl();
        PrintWriter out = response.getWriter();
        
        CattlePOJO target = cattleDao.find(Long.parseLong(cattle_id));
        if (target == null) {
            out.print("The cattle you requested is not found.");
        } else {
            request.setAttribute("target", target);
            getServletContext().getRequestDispatcher("/WEB-INF/pedigree.jsp").forward(request, response);
            response.sendRedirect("/WEB-INF/pedigree.jsp");
        }

        out.close();
    }

    @Override
    public void destroy() {
        super.destroy();
        Neo4jSessionFactory.getInstance().close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
