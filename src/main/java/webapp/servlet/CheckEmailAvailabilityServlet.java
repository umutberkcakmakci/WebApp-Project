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
import webapp.DAO.GetUserByMailDAO;


/**
 *
 * @author Vladislav Tikhonov
 */
@WebServlet(name = "CheckEmailAvailabilityServlet", urlPatterns = "/CheckEmailAvailability")
public class CheckEmailAvailabilityServlet extends AbstractDatabaseServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        User u = null;
        try {
            String email = request.getParameter("email");
            u = new GetUserByMailDAO(getConnection(), email).access().getOutputParam();

            if (u == null) {
                out.println("<font color=green><b>"+email+"</b> is avaliable");
            }
            else{
                out.println("<font color=red><b>"+email+"</b> is already in use</font>");
            }
                out.println();



        } catch (Exception ex) {

            out.println("Error ->" + ex.getMessage());

        } finally {
            out.close();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

}
