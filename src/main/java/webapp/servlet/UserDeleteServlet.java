package webapp.servlet;

import webapp.DAO.GetUserByMailDAO;
import webapp.DAO.UserDeleteDAO;
import webapp.resource.User;
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

@WebServlet(name = "userdeleteservlet", urlPatterns = "/user-delete")
public class UserDeleteServlet extends AbstractDatabaseServlet {
	
	public void doDelete (HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		ErrorCode ec = null;
		Message m = null;
		
		try {
            String email = req.getParameter("email");
            
			if (email == null || email.equals("")) {
                //the email is empty
                ec = ErrorCode.EMAIL_MISSING;
                m = new Message(true, "missing email");
            }
            else {
                User u = new GetUserByMailDAO(getConnection(), email).access().getOutputParam();
                User delUser = (User) new UserDeleteDAO(getConnection(), u).access().getOutputParam();
                
                if (delUser != null) {
                    res.setStatus(HttpServletResponse.SC_OK);
                    res.setContentType("application/json");
                    res.getWriter().write(new JSONObject().put("success", "user removed").toString());
                } else {
                	ec = ErrorCode.USER_NOT_FOUND;
                	m = new Message(true, "User not found");
                }
            }
			
        } catch (IOException | SQLException e){
        	ec = ErrorCode.INTERNAL_ERROR;
        	m = new Message ("Cannot find the user: unexpected error while accessing the database. " + "E200: " + e.getMessage());
			LOGGER.error("Cannot find the user: unexpected error while accessing the database.", e);
	
        }
	
		try {
			// set the MIME media type of the response
			res.setContentType("text/html; charset=utf-8");

			// get a stream to write the response
			PrintWriter out = res.getWriter();

			// write the HTML page
			out.printf("<!DOCTYPE html>%n");

			out.printf("<html lang=\"en\">%n");
			out.printf("<head>%n");
			out.printf("<meta charset=\"utf-8\">%n");
			out.printf("<title>User Delete</title>%n");
			out.printf("</head>%n");

			out.printf("<body>%n");
			out.printf("<h1>User Delete</h1>%n");
			out.printf("<hr/>%n");

			if (m.isError()) {
				out.printf("<ul>%n");
				out.printf("<li>message: %s</li>%n", m.getErrorCode());
				out.printf("<li>message: %s</li>%n", m.getMessage());
				out.printf("<li>details: %s</li>%n", m.getErrorDetails());
				out.printf("</ul>%n");
			} else {
					out.printf("<p>%s</p>%n", m.getMessage());
					out.printf("<ul>%n");
					/*
					out.printf("<li>username: %s</li>%n", delUser.getUsername());
					out.printf("<li>name: %s</li>%n", u.getName());
					out.printf("<li>surname: %s</li>%n", u.getSurname());
					out.printf("<li>e-mail: %s</li>%n", u.getEmail());
					*/
					out.printf("</tr>%n");
				
			}

			out.printf("</body>%n");

			out.printf("</html>%n");

			// flush the output stream buffer
			out.flush();

			// close the output stream
			out.close();
		} catch (IOException ex) {
			//LOGGER.error(new StringFormattedMessage("Unable to send response when finding user %d.", ), ex);
			throw ex;
		} finally {
			
		}	
	}

}
