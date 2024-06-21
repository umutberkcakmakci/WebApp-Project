package webapp.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

/**
 *
 * @author Kejsi Bimaj
 */

@WebServlet("/admin-page")
public class AdminPageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String usertype = (String) session.getAttribute("usertype");
        if ("user".equals(usertype)) {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            response.sendRedirect("/movie-webapp-1.00/user-home");
        } else {
            request.getRequestDispatcher("/jsp/admin-page.jsp").forward(request, response);
        }
    }

    /*@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }*/
}