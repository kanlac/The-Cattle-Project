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

        String alpha = imageList.get(0).getFilename();
        String beta = imageList.get(1).getFilename();
        String gamma = imageList.get(2).getFilename();
        System.out.println("gamma = " + gamma);

        getServletContext().setAttribute("alpha", alpha);
        getServletContext().setAttribute("beta", beta);
        getServletContext().setAttribute("gamma", gamma);

        request.getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
    }

    @Override
    public void destroy() {
        super.destroy();
        Neo4jSessionFactory.getInstance().close();
    }
}