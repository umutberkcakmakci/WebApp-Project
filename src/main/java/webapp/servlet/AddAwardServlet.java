package webapp.servlet;

import java.awt.datatransfer.MimeTypeParseException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;

import org.apache.logging.log4j.message.StringFormattedMessage;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import webapp.DAO.CreateAwardDAO;
import webapp.resource.Award;


@WebServlet(name = "addAwardServlet", urlPatterns = "/add-award")
public class AddAwardServlet extends AbstractDatabaseServlet {

	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
		req.getRequestDispatcher("jsp/add-award-form.jsp").forward(req, resp);
	}
	
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
       
        //model
        Award award = null;
        String msg = null;

        try {
                        
			award = parseRequest(req);

			// creates a new object for accessing the database and stores the person
			new CreateAwardDAO(getConnection(), award).access().getOutputParam();
                msg = "Award was successfully created in the database.";
			LOGGER.info("Award %s %s was successfully created in the database.", award.getAwardID(), award.getWinnername());
        
        } catch (NumberFormatException ex) {
                        msg = "Cannot create the award. Invalid input parameters."; 
			LOGGER.error("Cannot create the award. Invalid input parameters.",ex);

		} catch (SQLException ex) {
			if ("23505".equals(ex.getSQLState())) {
                                msg = "Cannot create the award: award already exists.";
				LOGGER.error(new StringFormattedMessage("Cannot create the winner name: winner name %d already exists.",
						award.getWinnername()), ex);
			} else if ("23503".equals(ex.getSQLState())) {
                                msg = "Cannot create the award: foreign key violation.";
				LOGGER.error(new StringFormattedMessage("Cannot create the winner name: winner name %d already exists.",
						award.getWinnername()), ex);
			} else {
                msg = "Cannot create the award: unexpected error while accessing the database.";
				LOGGER.error("Cannot create the award: unexpected error while accessing the database.", ex);
			}
                } catch (MimeTypeParseException ex) {
                msg = "Mime type parse error.";
		}
                HttpSession session = req.getSession();
                session.setAttribute("message", msg);
                req.getRequestDispatcher("/jsp/award-created.jsp").forward(req, res);

    }

    private Award parseRequest(HttpServletRequest req) throws IOException, MimeTypeParseException, ServletException {
        //request parameter
        int awardId = 0;
        int movieId = 0;
        int personId = 0;
        String category = null;
        Date year = null;
        String winnerName = null;
        String genre = null;
       

        // Retrieve award details from request parameters
        awardId = Integer.parseInt(req.getParameter("awardId"));
        movieId = Integer.parseInt(req.getParameter("movieId"));
        personId = Integer.parseInt(req.getParameter("personId"));
        category = req.getParameter("category");
        year = Date.valueOf(req.getParameter("year"));
        winnerName = req.getParameter("winnerName"); // Use winnerName for clarity
        genre = req.getParameter("genre"); 

        return new Award(awardId, movieId, personId, category, year, winnerName, genre);
    }

}