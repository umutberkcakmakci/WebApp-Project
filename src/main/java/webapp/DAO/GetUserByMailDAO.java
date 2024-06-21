package webapp.DAO;

import webapp.DAO.AbstractDAO;
import webapp.resource.User;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.logging.log4j.message.StringFormattedMessage;

public class GetUserByMailDAO extends AbstractDAO<User> {
	
	private static final String STATEMENT = 
            "SELECT email, name, surname, username, password "
          + "FROM users WHERE email = ?";

	private final String email;
	
	public GetUserByMailDAO (final Connection con, final String email) {
		super(con);
	    this.email = email;
	}
	
	@Override
	public final void doAccess() throws SQLException {
	
		PreparedStatement pstmt = null;
		ResultSet rs = null;
			
		// the results of the search
		User user = null;
			
		try {
			pstmt = con.prepareStatement(STATEMENT);
	        pstmt.setString(1, email);
	
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				user = new User(rs.getString("email"), 
                        		rs.getString("name"), 
                        		rs.getString("surname"), 
                        		rs.getString("username"), 
                        		rs.getString("password"));
			}
			
			LOGGER.info("User %d successfully listed.", email);
			
		}  finally {
			if (rs != null) {
				rs.close();
			}
	
			if (pstmt != null) {
				pstmt.close();
			}

		}
	
		this.outputParam = user;
		// return user;
	}

}
