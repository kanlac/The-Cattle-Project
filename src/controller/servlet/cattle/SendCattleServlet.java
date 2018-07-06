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

@WebServlet(name = "SendCattleServlet", urlPatterns = "/SendCattleServlet")
public class SendCattleServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Object cattleObj = request.getSession().getServletContext().getAttribute("cattle");
        Cattle cattle = (cattleObj instanceof Cattle ? (Cattle)cattleObj : null);
        if (cattle == null) throw new ServletException("Casting cattleObj failed.");

        CattleDAO dao = new CattleDAO();
        PrintWriter out = response.getWriter();

        if (dao.exist(cattle.getId())) {
            if (dao.alter(cattle)) {
                out.print("<p>更改成功</p>");
                out.print("<a href='/admin/query.jsp'>返回</a>");
                out.close();
            } else {
                throw new ServletException("Failed appending a cattle bean object.");
            }
        } else {
            if (dao.append(cattle)) {
                out.print("<p>添加成功</p>");
                out.print("<a href='/admin/query.jsp'>返回</a>");
                out.close();
            } else {
                throw new ServletException("Failed altering cattle.");
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
