package controller.filter;

import model.Cattle;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Date;
import java.util.regex.Pattern;

@WebFilter(filterName = "SendCattleFilter", urlPatterns = {"/SendCattleServlet"})
public class SendCattleFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        String id = req.getParameter("id");
        String sex = req.getParameter("sex");
        String birthday = req.getParameter("birthday");
        String weight = req.getParameter("weight");
        String variety = req.getParameter("variety");
        String father_id = req.getParameter("father_id");
        String mother_id = req.getParameter("mother_id");
        String children_id = req.getParameter("children_id");

        /** Legitimacy check **/
        if (id.equals("") || sex.equals("") || birthday.equals("") || weight.equals("") || variety.equals("")) {
            throw new IllegalArgumentException("At least one of mandatory fields is null.");
        } else if (!Pattern.matches("[0-9]+", id)) {
            throw new IllegalArgumentException("Illegal element: [id].");
        } else if(!Pattern.matches("[mf]", sex)) {
            throw new IllegalArgumentException("Illegal element: [sex].");
        } else if(!Pattern.matches("((19)|(2[0-9]))[0-9]{2}-?(0[1-9]|1[0-2])-?(0[1-9]|[12][0-9]|3[01])", birthday)) {
            throw new IllegalArgumentException("Illegal element: [birthday].");
        } else if(!father_id.equals("") && !Pattern.matches("[0-9]+", father_id)) {
            throw new IllegalArgumentException("Illegal element: [father_id].");
        } else if(!mother_id.equals("") && !Pattern.matches("[0-9]+", mother_id)) {
            throw new IllegalArgumentException("Illegal element: [mother_id].");
        } else {
            System.out.println("All element are legal.");

            Cattle cattle = new Cattle(id, sex.substring(0, 1), new Date(Long.parseLong(birthday.replaceAll("-", ""))), Double.parseDouble(weight), variety, father_id, mother_id, children_id);
            ((HttpServletRequest) req).getSession().getServletContext().setAttribute("cattle", cattle);

            chain.doFilter(req, resp);
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
