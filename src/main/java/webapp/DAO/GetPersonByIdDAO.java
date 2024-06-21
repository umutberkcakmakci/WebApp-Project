/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package webapp.DAO;
import webapp.DAO.AbstractDAO;
import webapp.resource.Person;
import webapp.resource.Role;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

/**
 *
 * @author Vladislav Tikhonov
 */
public class GetPersonByIdDAO extends AbstractDAO<Person> {
    
    private static final String STATEMENT = 
                "SELECT name, surname, shortBio, birthplace, birthdate, photolink, role "
            + "FROM Person WHERE personid = ?";
    private final int id;
    
    public GetPersonByIdDAO(final Connection con, final int id) {
		super(con);
	    this.id = id;
	}
    
    @Override
	public final void doAccess() throws SQLException {

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		// the results of the search
		Person person = null;

		try {
			pstmt = con.prepareStatement(STATEMENT);
			pstmt.setInt(1, id);

			rs = pstmt.executeQuery();
                        
                        if (rs.next()){

                            person = new Person(rs.getString("name"), 
                                rs.getString("surname"), 
                                rs.getString("shortBio"), 
                                rs.getString("birthplace"), 
                                rs.getDate("birthdate"), 
                                rs.getString("photolink"), 
				rs.getString("role"));
                            person.setId(id);
                        }

			LOGGER.info("Person with id: %d successfully listed.", id);
		} finally {
			if (rs != null) {
				rs.close();
			}

			if (pstmt != null) {
				pstmt.close();
			}

		}

		this.outputParam = person;
	}
}
