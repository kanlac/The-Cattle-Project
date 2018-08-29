package controller.filter;

import model.CattlePOJO;
import service.impl.CattleServiceImpl;
import util.Neo4jSessionFactory;

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
        Neo4jSessionFactory.getInstance().close();
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        String sex = req.getParameter("sex");
        String birthday = req.getParameter("birthday");
        String weight = req.getParameter("weight");
        String children_id = req.getParameter("children_id");
        String parents_id = req.getParameter("parents_id");

        // Legitimacy
        if (sex.equals("") || birthday.equals("") || weight.equals("")) {
            throw new IllegalArgumentException("At least one of mandatory fields is null.");
        } else if (!Pattern.matches("(male|female)", sex)) {
            throw new IllegalArgumentException("Illegal element: [sex].");
        } else if (!Pattern.matches("((19)|(2[0-9]))[0-9]{2}-?(0[1-9]|1[0-2])-?(0[1-9]|[12][0-9]|3[01])", birthday)) {
            throw new IllegalArgumentException("Illegal element: [birthday].");
        } else {
            System.out.println("All element are legal.");

            CattleServiceImpl cattleService = new CattleServiceImpl();

            CattlePOJO cattle = new CattlePOJO(sex, new Date(Long.parseLong(birthday.replaceAll("-", ""))), Double.parseDouble(weight));

            String validIdRex = "[0-9, /,,/，]+";// contains only numbers or comma
            String splitRex = "[,，]";
            // add children
            if (Pattern.matches(validIdRex, children_id)) {
                String[] children = children_id.split(splitRex);
                for (String child : children) {
                    if (cattleService.find(Long.parseLong(child)) != null)
                        cattle.addChild(cattleService.find(Long.parseLong(child)));
                }
            } else {
                System.out.println("No valid children id input.");
            }
            // add parents
            // todo: couple check
            if (Pattern.matches(validIdRex, parents_id)) {
                String[] parents = parents_id.split(splitRex);
                for (String parent : parents) {
                    if (cattleService.find(Long.parseLong(parent)) != null)
                        cattle.addParent(cattleService.find(Long.parseLong(parent)));
                }
            } else {
                System.out.println("No valid parents id input.");
            }

            ((HttpServletRequest) req).getSession().getServletContext().setAttribute("cattle", cattle);

            chain.doFilter(req, resp);
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
