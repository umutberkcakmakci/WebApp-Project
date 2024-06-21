package webapp.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import webapp.DAO.CreateRatesDAO;
import webapp.resource.Rates;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(name = "CreateRatesServlet", urlPatterns = "/createrates")
public class CreateRatesServlet extends AbstractDatabaseServlet {
    private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = LogManager.getLogger(CreateRatesServlet.class);

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userEmail = request.getParameter("useremail");
        String movieIdStr = request.getParameter("movieId");
        String scoreStr = request.getParameter("score");
        String review = request.getParameter("review");

        boolean errorFlag = false;
        String msg = "";
        try {
            int movieId = Integer.parseInt(movieIdStr);
            int score = Integer.parseInt(scoreStr);

            // Create a Rates object
            Rates rates = new Rates(movieId, userEmail, score, review);

            // Log the received data
            LOGGER.info("Data received: User Email: {}, Movie ID: {}, Score: {}, Review: {}", userEmail, movieId, score, review);

            // Call DAO to save the rating
            new CreateRatesDAO(getConnection(), rates).access();
            //createRatesDAO.doAccess();

        } catch (NumberFormatException e) {
            errorFlag = true;
            msg = e.toString();
            LOGGER.error("Invalid number format for movieId or score: ", e);
        } catch (SQLException e) {
            errorFlag = true;
            msg = e.getSQLState();
            LOGGER.error("SQL error while processing the rating: ", e);
        } catch (Exception e) {
            errorFlag = true;
            msg = e.toString();
            LOGGER.error("Unexpected error while processing the rating: ", e);
        }

     
        HttpSession session = request.getSession();
        session.setAttribute("useremail", userEmail);
        session.setAttribute("movieId", movieIdStr);
        session.setAttribute("score", scoreStr);
        session.setAttribute("review", review);
        session.setAttribute("errorFlag", errorFlag);


        response.sendRedirect(request.getContextPath() + "/jsp/create-rates-form.jsp");
    }
}
