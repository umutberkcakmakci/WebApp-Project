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
import webapp.resource.Movie;
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
import webapp.DAO.CreateMovieDAO;
import static webapp.servlet.AbstractDatabaseServlet.LOGGER;

/**
 *
 * @author Vladislav Tikhonov
 */
@WebServlet("/create-movie")
public class CreateMovieServlet extends AbstractDatabaseServlet  {

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		Movie e = null;
                String msg = null;
		try {
			e = parseRequest(req);

			// creates a new object for accessing the database and stores the person
			new CreateMovieDAO(getConnection(), e).access();
                        msg = "Movie was successfully added to the database.";
			LOGGER.info("Movie %s was successfully created in the database.", e.getTitle());

		} catch (NumberFormatException ex) {
                        msg = "Cannot create the movie. Invalid input parameters."; 
			LOGGER.error(
					"Cannot create the movie. Invalid input parameters.",
					ex);
		} catch (SQLException ex) {
                        msg = "Cannot create the movie: unexpected error while accessing the database." + ex.getSQLState();
			LOGGER.error("Cannot create the movie: unexpected error while accessing the database.", ex);
                } catch (MimeTypeParseException ex) {
                    msg = "Mime type parse error.";
		}

		HttpSession session = req.getSession();
                session.setAttribute("message", msg);
                req.getRequestDispatcher("/jsp/award-created.jsp").forward(req, res);

	}

	private Movie parseRequest(HttpServletRequest req) throws IOException, MimeTypeParseException, ServletException {

		// request parameters
		String title = null;
                String director = null;
                Date release_date = null;
                String genre = null;
                String trailerURL = null;
                
                title = req.getParameter("title");
                director = req.getParameter("director");
                genre = req.getParameter("genre");
                release_date = Date.valueOf(req.getParameter("releasedate"));
                trailerURL = req.getParameter("trailerurl");

		// creates a new person from the request parameters
		return new Movie(title, director, release_date, genre, trailerURL);
	}
}