/**
 * 
 */
package webapp.DAO;
import webapp.resource.User;
import webapp.DAO.AbstractDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Umut Berk Cakmakci
 *
 */
public class CreateUserDAO extends AbstractDAO {

    private static final String STATEMENT = 
    		"INSERT INTO Users (email, name, surname, username, password) "
    		+ "VALUES (?, ?, ?, ?, ?)";
    
    private final User user;

	public CreateUserDAO(final Connection con, final User user) {
		super(con);
		// TODO Auto-generated constructor stub
		if (user == null) {
            LOGGER.error("The user cannot be null.");
            throw new NullPointerException("The user cannot be null.");
        }
		this.user = user;
	}
	
    @Override
    protected final void doAccess() throws SQLException {

        PreparedStatement pstmt = null;

        try {
            pstmt = con.prepareStatement(STATEMENT);
            pstmt.setString(1, user.getEmail());
            pstmt.setString(2, user.getName());
            pstmt.setString(3, user.getSurname());
            pstmt.setString(4, user.getUsername());
            pstmt.setString(5, user.getPassword());

            pstmt.executeQuery();
            
            LOGGER.info("User %d successfully stored in the database.", user.getEmail());
            
        } finally {
            if (pstmt != null) {
                pstmt.close();
            }
        }
    }
}
