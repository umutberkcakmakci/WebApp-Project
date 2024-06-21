package webapp.servlet;

import webapp.DAO.GetPersonByIdDAO;
import webapp.DAO.DeletePersonDAO;
import webapp.resource.Person;
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
import static webapp.servlet.AbstractDatabaseServlet.LOGGER;

@WebServlet(name = "deletepersonservlet", urlPatterns = "/delete-person")
public class DeletePersonServlet extends AbstractDatabaseServlet {
	
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
                Person p = new GetPersonByIdDAO(getConnection(), id).access().getOutputParam();
                Person delPerson = new DeletePersonDAO(getConnection(), p).access().getOutputParam();
                
                if (delPerson != null) {
                    res.setStatus(HttpServletResponse.SC_OK);
                    res.setContentType("application/json");
                    iserror = false;
                    m = new Message(false, "Person with id = " + id + " was succesfully deleted");
                    res.getWriter().write(new JSONObject().put("success", "person removed").toString());
                } else {
                	ec = ErrorCode.PERSON_NOT_FOUND;
                	m = new Message(true, "Person not found");
                }
            }
			
        } catch (IOException | SQLException e){
        	ec = ErrorCode.INTERNAL_ERROR;
        	m = new Message ("Cannot find the person: unexpected error while accessing the database. " + "E200: " + e.getMessage());
			LOGGER.error("Cannot find the person: unexpected error while accessing the database.", e);
	
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

