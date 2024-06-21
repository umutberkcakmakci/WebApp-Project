package webapp.DAO;

import webapp.resource.User;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.logging.log4j.message.StringFormattedMessage;

public class UserLoginDAO extends AbstractDAO<User> {
	
	private static final String STATEMENT = 
            "SELECT email, name, surname, username, password "
          + "FROM Users WHERE email = ? AND password = ?";

	String email;
	String password;
	private static Connection con;
	
	public UserLoginDAO (final Connection con, final String email, final String password) {
		super(con);
        this.email = email;
		this.password = password;
		this.con = con;
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
                        pstmt.setString(2, password);
	
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String email = rs.getString("email");
				String name = rs.getString("name"); 
				String surname = rs.getString("surname"); 
				String username = rs.getString("username"); 
				String password = rs.getString("password");
				
				user = new User(email, name, surname, username, password);

			}
			
		}  finally {
			if (rs != null) {
				rs.close();
			}
	
			if (pstmt != null) {
				pstmt.close();
			}
			con.close();
		}
	
		this.outputParam = user;
		// return user;
	}
	
}
