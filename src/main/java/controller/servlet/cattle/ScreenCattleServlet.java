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
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

@WebServlet(name = "ScreenCattleServlet", urlPatterns = {"/ScreenCattleServlet"})
public class ScreenCattleServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String filter_sex = request.getParameter("filter-sex");
        String filter_age_low = request.getParameter("filter-age-low");
        String filter_age_high = request.getParameter("filter-age-high");
        String filter_birth_origin = request.getParameter("filter-birth-origin");
        String filter_birth_close = request.getParameter("filter-birth-close");
        String filter_weight_low = request.getParameter("filter-weight-low");
        String filter_weight_high = request.getParameter("filter-weight-high");

        CattleServiceImpl cattleService = new CattleServiceImpl();
        ArrayList<CattlePOJO> list = (ArrayList<CattlePOJO>)cattleService.findAll();

        int age_low = !filter_age_low.equals("") ? Integer.parseInt(filter_age_low) : 0;
        int age_high = !filter_age_high.equals("") ? Integer.parseInt(filter_age_high) : Integer.MAX_VALUE;

        Date current = new Date();
        LocalDate localDateToday = current.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int currentYear = localDateToday.getYear();

        Date birth_origin = null, birth_close = null;
        if (!filter_birth_origin.equals(""))
            birth_origin = new Date(Long.parseLong(filter_birth_origin.replaceAll("-", "")));
        if (!filter_birth_close.equals(""))
            birth_close = new Date(Long.parseLong(filter_birth_close.replaceAll("-", "")));

        Double weight_low = !filter_weight_low.equals("") ? Double.parseDouble(filter_weight_low) : 0;
        Double weight_high = !filter_weight_high.equals("")? Double.parseDouble(filter_weight_high) : Double.MAX_VALUE;

        ArrayList<CattlePOJO> result = new ArrayList<>();
        for (CattlePOJO item : list) {

            Date birth = item.getBirthday();
            String birthStr = String.valueOf(birth.getTime());
            int birthYear = Integer.parseInt(birthStr.substring(0, 4));
            int age = currentYear - birthYear;

            boolean sex_meet = filter_sex.equals("none") || item.getSex().equals(filter_sex);
            boolean age_meet = age >= age_low && age <= age_high;
            boolean birth_meet = (birth_origin == null || (birth_origin != null && birth.compareTo(birth_origin) > 0)) && (birth_close == null || (birth_close !=null && birth.compareTo(birth_close) < 0));
            boolean weight_meet = item.getWeight() > weight_low && item.getWeight() < weight_high;

            if (sex_meet && age_meet && birth_meet && weight_meet) {
                result.add(item);
            }
        }

        request.setAttribute("condition-sex", filter_sex);
        request.setAttribute("condition-age", String.valueOf(age_low) + " - " + String.valueOf(age_high));
        request.setAttribute("condition-birth-origin", birth_origin != null ? formatDate(birth_origin) : "不限");
        request.setAttribute("condition-birth-close", birth_close != null ? formatDate(birth_close) : "不限");
        request.setAttribute("condition-weight", String.valueOf(weight_low) + " - " + String.valueOf(weight_high));

        request.setAttribute("result", result);

        getServletContext().getRequestDispatcher("/WEB-INF/filtered.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    public void destroy() {
        super.destroy();
        Neo4jSessionFactory.getInstance().close();
    }

    private String formatDate(Date date) {
        String time = String.valueOf(date.getTime());
        return time.substring(0, 4) + "-" + time.substring(4, 6) + "-" + time.substring(6);
    }
}
