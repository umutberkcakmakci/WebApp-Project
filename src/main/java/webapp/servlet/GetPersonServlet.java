/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package webapp.servlet;
import jakarta.servlet.ServletException;
import webapp.DAO.GetPersonByIdDAO;
import webapp.DAO.GetMoviesByPersonIdDAO;
import webapp.resource.Person;
import webapp.resource.Movie;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.apache.logging.log4j.message.StringFormattedMessage;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.List;
import webapp.resource.Award;
import org.javatuples.Pair;
import webapp.DAO.GetAwardsAndMovieNameByPersonIdDAO;
import webapp.resource.Message;

/**
 *
 * @author Vladislav Tikhonov
 */

@WebServlet(name = "getpersonservlet", urlPatterns = "/get-person")
public class GetPersonServlet extends AbstractDatabaseServlet {
    
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {


		// request parameter
                int id = -1;

		// model
		Person el = null;
                List<Pair<Award, String>> aw = null;
                List<Movie> mv = null;
                
                boolean errorFlag = false;
                boolean moviesFlag = false;
                boolean awardsFlag = false;
                String msg = "";

		try {

			// retrieves the request parameter
                        id = Integer.parseInt(req.getParameter("id"));

			// creates a new object for accessing the database and searching the employees
			el = new GetPersonByIdDAO(getConnection(), id).access().getOutputParam();

			LOGGER.info("Person was successfully searched by id %d.", id);

		} catch (NumberFormatException ex) {
                    
                        errorFlag = true;
			LOGGER.error("Cannot search for person. Invalid input parameters: salary must be integer.", ex);
		} catch (SQLException ex) {
                        errorFlag = true;
			LOGGER.error("Cannot search for person: unexpected error while accessing the database.", ex);
		}
                
                 if (!errorFlag){
                    try{
                        aw = new GetAwardsAndMovieNameByPersonIdDAO(getConnection(), el.getId()).access().getOutputParam();
                    } catch (SQLException ex) {
                        awardsFlag = true;
                        errorFlag = true;
			LOGGER.error("Cannot search for person: unexpected error while accessing the database.", ex);
		}
                 }
                
                if (!errorFlag){
                    try{
                        mv = new GetMoviesByPersonIdDAO(getConnection(), el.getId()).access().getOutputParam();
                    } catch (SQLException ex) {
                        moviesFlag = true;
                        errorFlag = true;
			LOGGER.error("Cannot search for person: unexpected error while accessing the database.", ex);
		}
                } 
                
                 HttpSession session = req.getSession();

                session.setAttribute("person", el);
                session.setAttribute("awards", aw);
                session.setAttribute("movies", mv);
                req.getRequestDispatcher("/jsp/get-person.jsp").forward(req, res);
                
	}

    
}
