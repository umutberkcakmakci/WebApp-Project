/**
 * 
 */
package webapp.servlet;

import webapp.DAO.CreateUserDAO;
import webapp.DAO.GetUserByMailDAO;
import webapp.resource.User;
import webapp.resource.Message;
import webapp.utils.ErrorCode;
import webapp.servlet.AbstractDatabaseServlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.GenericServlet;
import java.awt.datatransfer.MimeTypeParseException;
import javax.naming.NamingException;

import org.apache.logging.log4j.message.StringFormattedMessage;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.List;
import java.util.*;

import org.json.JSONObject;

/**
 * @author Umut Berk Cakmakci
 *
 */

@WebServlet("/register-user")
public class RegisterUserServlet extends AbstractDatabaseServlet {
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		// model
		User u = null;
		String msg = null;
                ErrorCode ec = null;
		Message m = null;
                boolean iserror = true;
		
		try {
			
		u = parseRequest(req);
		Connection con = getConnection();
                new CreateUserDAO(con, u).access();
            	
                res.setStatus(HttpServletResponse.SC_OK);
                iserror = false;
                res.setContentType("application/json");
                m = new Message(false, "User with email " + u.getEmail() + " was successfully created in the database.");

		} catch (SQLException ex) {
                    if ("02000".equals(ex.getSQLState())) {
                res.setStatus(HttpServletResponse.SC_OK);
                iserror = false;
                res.setContentType("application/json");
                m = new Message(false, "User with email " + u.getEmail() + " was successfully created in the database.");
			} else if ("23505".equals(ex.getSQLState())) {
                            ec = ErrorCode.ENTRY_ALREADY_EXISTS;
                            m = new Message(true, "Cannot register the user: user already exists.");
			} else {
                            ec = ErrorCode.DATABASE_ERROR;
                            m = new Message(true, "Cannot create the person: unexpected error while accessing the database.");
			}
		} catch (MimeTypeParseException e) {
			ec = ErrorCode.PARSE_ERROR;
                        m = new Message(true, "Mime type parse error.");
		} 
                
                if (!iserror){
                
                    HttpSession session = req.getSession();
                    session.setAttribute("message", m);
                    req.getRequestDispatcher("/jsp/user-created.jsp").forward(req, res);
                } else {
                    res.setStatus(ec.getHTTPCode());
                    req.setAttribute("message", m);
                }
				
	}
	
	private User parseRequest (HttpServletRequest req) throws IOException, MimeTypeParseException, ServletException {
		
		// request parameters
		String username = null;
		String name = null;
		String surname = null;
		String email = null;
		String password = null;
		
		// retrieves the request parameters
		email = req.getParameter("email");
		name = req.getParameter("name");
		surname = req.getParameter("surname");
		username = req.getParameter("username");
		password = req.getParameter("password");
		
		return new User(email, name, surname, username, password);
	}

}
