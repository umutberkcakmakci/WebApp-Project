package webapp.servlet;

import webapp.DAO.UserLoginDAO;
import webapp.resource.User;
import webapp.resource.Message;
import webapp.utils.ErrorCode;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import javax.naming.NamingException;

import org.apache.logging.log4j.message.StringFormattedMessage;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.*;

import org.json.JSONObject;
import java.io.BufferedReader;

/**
 * @author Umut Berk Cakmakci
 *
 */

@WebServlet(name="UserLoginServlet", urlPatterns="/user-login")
public class UserLoginServlet extends AbstractDatabaseServlet {
	
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
    	
        String logout = req.getParameter("query");
        if ("logout".equals(logout)) {
            HttpSession session = req.getSession();  
            if (session != null) {
                session.invalidate();  
            }
        }
        resp.sendRedirect("html/loginpage.html");
    	//req.getRequestDispatcher("jsp/user-login-form.jsp").forward(req, resp);
    }
	
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

        // request parameters
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String emailEnd = email.substring(email.indexOf("@")+1);
        
     // Retrieve request parameters
        /*StringBuilder sb = new StringBuilder();
        BufferedReader reader = req.getReader();
        try {
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
        } finally {
            reader.close();
        }

        JSONObject jsonObject = new JSONObject(sb.toString());
        String email = jsonObject.getString("email");
        String password = jsonObject.getString("password");*/

        // model
        ErrorCode ec = null;
        Message m = null;
        boolean loggable = true;

        //User u = null;
        User loggeduser = null;

        try (Connection con = getConnection()){
            // retrieves the request parameters

            UserLoginDAO userloginDAO = new UserLoginDAO(con, email, password);            
            User u = userloginDAO.access().getOutputParam();

            // Check if User object is null before accessing its properties
            if (u == null) {
                loggable = false;
                ec = ErrorCode.WRONG_CREDENTIALS;
                m = new Message(true, "credentials are wrong");
            } else {
                if (u.getEmail() == null || u.getEmail().equals("")) {
                    loggable = false;
                    ec = ErrorCode.EMAIL_MISSING;
                    m = new Message(true, "missing email");
                } else if (u.getPassword() == null || u.getPassword().equals("")) {
                    loggable = false;
                    ec = ErrorCode.PASSWORD_MISSING;
                    m = new Message(true, "missing password");
                }
            }

            if (loggable) {
                HttpSession session = req.getSession();
                session.setAttribute("user", u);
                if ("moviedb.com".equals(emailEnd)){
                    session.setAttribute("usertype", "admin");
                    m = new Message(true, "everything works");

                    res.setStatus(HttpServletResponse.SC_OK);
                
                    res.sendRedirect("/movie-webapp-1.00/admin-page");
                } else {
                    session.setAttribute("usertype", "user");
                    m = new Message(true, "everything works");

                    res.setStatus(HttpServletResponse.SC_OK);
                
                    res.sendRedirect("/movie-webapp-1.00/user-home");
                }
                
            } else {
                res.setStatus(ec.getHTTPCode());
                res.setContentType("application/json");

                JSONObject jsonObject1 = new JSONObject();
                jsonObject1.put("error", m.getMessage());

                PrintWriter writer = res.getWriter();
                writer.write(jsonObject1.toString());
                writer.flush();
            }

        } catch (SQLException ex) {
            m = new Message ("Cannot find the user: unexpected error while accessing the database. " + "E200: " + ex.getMessage());

            LOGGER.error("Cannot find the user: unexpected error while accessing the database.", ex);

            // Send JSON response in case of SQLException
            res.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            res.setContentType("application/json");

            JSONObject jsonObject1 = new JSONObject();
            jsonObject1.put("error", m.getMessage());

            PrintWriter writer = res.getWriter();
            writer.write(jsonObject1.toString());
            writer.flush();
        }
    }
}

