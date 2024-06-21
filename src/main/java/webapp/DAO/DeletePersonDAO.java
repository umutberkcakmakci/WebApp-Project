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

/**
 *
 * @author vladislavtihonov
 */
public class DeletePersonDAO extends AbstractDAO<Person> {
    private static final String STATEMENT = "DELETE FROM Person WHERE personid=? RETURNING *;";
    
    private final Person person;
    
    public DeletePersonDAO(final Connection con, final Person person) {
        super(con);

        if (person == null) {
            LOGGER.error("The person cannot be null.");
            throw new NullPointerException("The person cannot be null.");
        }
        
        this.person = person;
    }
    
    @Override
	public void doAccess() throws SQLException {
		// TODO Auto-generated method stub
		
		PreparedStatement pstm = null;
		ResultSet rs = null;
		Person deletedPerson = null;
		
		try {
			
			pstm = con.prepareStatement(STATEMENT);
			pstm.setInt(1, person.getId());
			
			rs = pstm.executeQuery();
			
			if (rs.next()) {
				deletedPerson = new Person(rs.getString("name"), 
                                rs.getString("surname"), 
                                rs.getString("shortBio"), 
                                rs.getString("birthplace"), 
                                rs.getDate("birthdate"), 
                                rs.getString("photolink"), 
				rs.getString("role"));
                            person.setId(rs.getInt("personid"));
			}
			
		} finally {
            if (rs != null) {
                rs.close();
            }

            if (pstm != null) {
                pstm.close();
            }

            con.close();
        }

        this.outputParam = deletedPerson;
	}

   }
