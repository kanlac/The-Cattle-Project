package controller.filter;

import model.CattlePOJO;
import service.impl.CattleServiceImpl;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Date;
import java.util.regex.Pattern;

@WebFilter(filterName = "SendCattleFilter", urlPatterns = {"/AddCattleServlet"})
public class SendCattleFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        String sex = req.getParameter("sex");
        String birthday = req.getParameter("birthday");
        String weight = req.getParameter("weight");
        String children_id = req.getParameter("children_id");

        // Legitimacy
        if (sex.equals("") || birthday.equals("") || weight.equals("")) {
            throw new IllegalArgumentException("At least one of mandatory fields is null.");
        } else if(!Pattern.matches("(male|female)", sex)) {
            throw new IllegalArgumentException("Illegal element: [sex].");
        } else if(!Pattern.matches("((19)|(2[0-9]))[0-9]{2}-?(0[1-9]|1[0-2])-?(0[1-9]|[12][0-9]|3[01])", birthday)) {
            throw new IllegalArgumentException("Illegal element: [birthday].");
        } else {
            System.out.println("All element are legal.");

            CattleServiceImpl cattleService = new CattleServiceImpl();

            CattlePOJO cattle = new CattlePOJO(sex, new Date(Long.parseLong(birthday.replaceAll("-", ""))), Double.parseDouble(weight));
            if (cattleService.find(Long.parseLong(children_id)) == null)
                throw new IllegalArgumentException("The child node dose not exist.");
            else
                cattle.addChild(cattleService.find(Long.parseLong(children_id)));

            ((HttpServletRequest) req).getSession().getServletContext().setAttribute("cattle", cattle);

            chain.doFilter(req, resp);
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
