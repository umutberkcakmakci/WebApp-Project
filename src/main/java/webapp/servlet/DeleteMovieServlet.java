package webapp.servlet;

import webapp.DAO.GetPersonByIdDAO;
import webapp.DAO.DeletePersonDAO;
import webapp.resource.Movie;
import webapp.resource.Message;
import webapp.utils.ErrorCode;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.message.StringFormattedMessage;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.List;
import java.util.*;

import org.json.JSONObject;
import webapp.DAO.DeleteMovieDAO;
import webapp.DAO.GetMovieByIdDAO;
import static webapp.servlet.AbstractDatabaseServlet.LOGGER;

@WebServlet(name = "deletemovieservlet", urlPatterns = "/delete-movie")
public class DeleteMovieServlet extends AbstractDatabaseServlet {
	
	public void doPost (HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		ErrorCode ec = null;
		Message m = null;
                boolean iserror = true;
		
		try {
                Integer id = Integer.parseInt(req.getParameter("id"));
            
			if (id == null || id < 1) {
                    ec = ErrorCode.WRONG_FORMAT;
                    m = new Message(true, "wrong id");
            }
            else {
                Movie mv = new GetMovieByIdDAO(getConnection(), id).access().getOutputParam();
                Movie delMovie = new DeleteMovieDAO(getConnection(), mv).access().getOutputParam();
                
                if (delMovie != null) {
                    res.setStatus(HttpServletResponse.SC_OK);
                    res.setContentType("application/json");
                    iserror = false;
                    m = new Message(false, "Movie with id = " + id + " was succesfully deleted");
                    res.getWriter().write(new JSONObject().put("success", "movie removed").toString());
                } else {
                	ec = ErrorCode.NOT_FOUND;
                	m = new Message(true, "Movie not found");
                }
            }
			
        } catch (IOException | SQLException e){
        	ec = ErrorCode.INTERNAL_ERROR;
        	m = new Message ("Cannot find the movie: unexpected error while accessing the database. " + "E200: " + e.getMessage());
			LOGGER.error("Cannot find the movie: unexpected error while accessing the database.", e);
	
        }
                if (!iserror){
                HttpSession session = req.getSession();

                // insert in the session the email an the role
                session.setAttribute("message", m);
                req.getRequestDispatcher("/jsp/person-deleted.jsp").forward(req, res);
                } else {
                    res.setStatus(ec.getHTTPCode());
                    req.setAttribute("message", m);
                }

	}

}

