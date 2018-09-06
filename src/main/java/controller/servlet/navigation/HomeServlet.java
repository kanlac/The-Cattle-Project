package controller.servlet.navigation;

import model.ImagePOJO;
import service.impl.ImageServiceImpl;
import util.Neo4jSessionFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "HomeServlet", urlPatterns = {"/home"})
public class HomeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ImageServiceImpl imageService = new ImageServiceImpl();
        ArrayList<ImagePOJO> imageList = (ArrayList<ImagePOJO>)imageService.findAll();

        String alpha_image = imageList.get(0).getFilename();
        String alpha_desc = imageList.get(0).getDescription();
        String beta_image = imageList.get(1).getFilename();
        String beta_desc = imageList.get(1).getDescription();
        String gamma_image = imageList.get(2).getFilename();
        String gamma_desc = imageList.get(2).getDescription();


        getServletContext().setAttribute("alpha_image", alpha_image);
        getServletContext().setAttribute("alpha_desc", alpha_desc);
        getServletContext().setAttribute("beta_image", beta_image);
        getServletContext().setAttribute("beta_desc", beta_desc);
        getServletContext().setAttribute("gamma_image", gamma_image);
        getServletContext().setAttribute("gamma_desc", gamma_desc);

        request.getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
    }

    @Override
    public void destroy() {
        super.destroy();
        Neo4jSessionFactory.getInstance().close();
    }
}