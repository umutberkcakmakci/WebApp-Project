package webapp.rest;

import webapp.DAO.CreatePersonDAO;
import webapp.resource.Person;
import webapp.resource.Actions;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.EOFException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * A REST resource for creating {@link Person}s.
 *
 * @author Nicola Ferro (ferro@dei.unipd.it)
 * @version 1.00
 * @since 1.00
 */
public final class CreatePersonRR extends AbstractRR {

	/**
	 * Creates a new REST resource for creating {@code Employee}s.
	 *
	 * @param req the HTTP request.
	 * @param res the HTTP response.
	 * @param con the connection to the database.
	 */
	public CreatePersonRR(final HttpServletRequest req, final HttpServletResponse res, Connection con) {
		super(Actions.CREATE_PERSON, req, res, con);
	}


	@Override
	protected void doServe() throws IOException {

		try {
			final Person person = Person.fromJSON(req.getInputStream());

			// creates a new DAO for accessing the database and stores the person
			new CreatePersonDAO(con, person).access();

		} catch (EOFException ex) {
			LOGGER.warn("Cannot create the person: no Person JSON object found in the request.", ex);

			res.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		} catch (SQLException ex) {
			LOGGER.error("Cannot create the person: unexpected database error.", ex);

			res.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		}
	}


}
