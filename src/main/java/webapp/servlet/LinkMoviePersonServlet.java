/*
 * Copyright 2018-2023 University of Padua, Italy
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */ 
package webapp.servlet;

import jakarta.servlet.ServletException;
import webapp.resource.Person;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.awt.datatransfer.MimeTypeParseException;
import org.apache.logging.log4j.message.StringFormattedMessage;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import org.json.JSONObject;
import webapp.DAO.CreateParticipatesDAO;
import webapp.DAO.CreatePersonDAO;
import webapp.resource.Message;
import webapp.utils.ErrorCode;

/**
 *
 * @author Vladislav Tikhonov
 */
@WebServlet("/link-movie-person")
public class LinkMoviePersonServlet extends AbstractDatabaseServlet  {

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

                ErrorCode ec = null;
		Message m = null;
                String msg = null;
                int id = -1;
                boolean iserror = true;
		try {
                       int movieId = Integer.valueOf(req.getParameter("movieid"));
                       int personId = Integer.valueOf(req.getParameter("personid"));
                       String role = req.getParameter("role");

			// creates a new object for accessing the database and stores the person
			new CreateParticipatesDAO(getConnection(), movieId, personId, role).access().getOutputParam();
                        res.setStatus(HttpServletResponse.SC_OK);
                        iserror = false;
                        res.setContentType("application/json");
                        m = new Message(false, "Movie and person were successfully linked");
                        res.getWriter().write(new JSONObject().put("success", "movie and person linked").toString());
		} catch (NumberFormatException ex) {
                        ec = ErrorCode.INVALID_INPUT_PARAMETERS;
                        m = new Message(true, "Cannot link the movie and the person. Invalid input parameters.");
		} catch (SQLException ex) {
			if ("23505".equals(ex.getSQLState())) {
                            ec = ErrorCode.ENTRY_ALREADY_EXISTS;
                            m = new Message(true, "Cannot link the movie and the person: already linked.");

			} else {
                            ec = ErrorCode.DATABASE_ERROR;
                            m = new Message(true, "Cannot link the movie and the person: unexpected error while accessing the database.");
			}
		} catch (Exception ex){
                    ec = ErrorCode.INTERNAL_ERROR;
                    m = new Message(true, "There was an unexpected error.");
                }
                
                if (!iserror){
                
                    HttpSession session = req.getSession();
                    session.setAttribute("message", m);
                    req.getRequestDispatcher("/jsp/person-created.jsp").forward(req, res);
                } else {
                    res.setStatus(ec.getHTTPCode());
                    req.setAttribute("message", m);
                }

	}

}
