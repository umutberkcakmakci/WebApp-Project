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

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.message.StringFormatterMessageFactory;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Gets the {@code DataSource} for managing the connection pool to the database.
 *
 * @author Nicola Ferro (ferro@dei.unipd.it)
 * @version 1.00
 * @since 1.00
 */
public abstract class AbstractDatabaseServlet extends HttpServlet {

	/**
	 * A LOGGER available for all the subclasses.
	 */
	protected static final Logger LOGGER = LogManager.getLogger(AbstractDatabaseServlet.class,
			StringFormatterMessageFactory.INSTANCE);

	/**
	 * The connection pool to the database.
	 */
	private DataSource ds;

	/**
	 * Gets the {@code DataSource} for managing the connection pool to the database.
	 *
	 * @param config a {@code ServletConfig} object containing the servlet's configuration and initialization
	 *               parameters.
	 *
	 * @throws ServletException if an exception has occurred that interferes with the servlet's normal operation
	 */
	public void init(ServletConfig config) throws ServletException {

		// the JNDI lookup context
		InitialContext cxt;

		try {
			cxt = new InitialContext();
			ds = (DataSource) cxt.lookup("java:/comp/env/jdbc/student-webedge");

			LOGGER.info("Connection pool to the database pool successfully acquired.");
		} catch (NamingException e) {
			ds = null;

			LOGGER.error("Unable to acquire the connection pool to the database.", e);

			throw new ServletException("Unable to acquire the connection pool to the database", e);
		}
	}

	/**
	 * Releases the {@code DataSource} for managing the connection pool to the database.
	 */
	public void destroy() {
		ds = null;
		LOGGER.info("Connection pool to the database pool successfully released.");
	}

	/**
	 * Returns a {@link  Connection} for accessing the database.
	 *
	 * @return a {@link Connection} for accessing the database
	 *
	 * @throws java.sql.SQLException if anything goes wrong in obtaining the connection.
	 */
	protected final Connection getConnection() throws SQLException {
		try {
			return ds.getConnection();
		} catch (final SQLException e) {
			LOGGER.error("Unable to acquire the connection from the pool.", e);
			throw e;
		}
	}

}
