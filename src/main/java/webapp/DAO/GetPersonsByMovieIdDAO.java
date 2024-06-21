/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package webapp.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import static webapp.DAO.AbstractDAO.LOGGER;
import webapp.resource.Person;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Vladislav Tikhonov
 */
public class GetPersonsByMovieIdDAO extends AbstractDAO<List<Person>>{
    
    private static final String STATEMENT = 
              "SELECT person.personid, person.name, person.surname, person.shortbio, person.birthplace, person.birthdate, person.photolink, participates.role "
            + "FROM participates "
            + "INNER JOIN movie ON (movie.movieid = participates.movieid)"
            + "INNER JOIN person ON (person.personid = participates.personid)"
            + "WHERE movie.movieid = ?;";
    private final int id;
    
    public GetPersonsByMovieIdDAO(final Connection con, final int id) {
		super(con);
		this.id = id;
	}
    
    @Override
    public final void doAccess() throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		final List<Person> persons = new ArrayList<Person>();

		try {
			pstmt = con.prepareStatement(STATEMENT);

			pstmt.setInt(1, id);

			rs = pstmt.executeQuery();

			while (rs.next()) {
                                Person person = new Person(rs.getString("name"), 
                                rs.getString("surname"), 
                                rs.getString("shortBio"), 
                                rs.getString("birthplace"), 
                                rs.getDate("birthdate"), 
                                rs.getString("photolink"), 
				rs.getString("role"));
                                person.setId(rs.getInt("personid"));
				persons.add(person);
			}

			LOGGER.info("Person(s) with movie %d successfully listed.", id);
		} finally {
			if (rs != null) {
				rs.close();
			}

			if (pstmt != null) {
				pstmt.close();
			}

		}

		this.outputParam = persons;
	}
    
}
