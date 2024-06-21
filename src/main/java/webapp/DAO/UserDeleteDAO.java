package webapp.DAO;

import webapp.resource.User;
import webapp.DAO.AbstractDAO;
import java.sql.*;

public class UserDeleteDAO extends AbstractDAO<User> {
	
	private static final String STATEMENT = "DELETE FROM Users WHERE email=? RETURNING *;";
	
	private final Connection con;
	
	User user;
	
	public UserDeleteDAO (final Connection con, final User u) {
		super(con);
		this.user = u;
		this.con = con;
	}

	@Override
	public void doAccess() throws SQLException {
		// TODO Auto-generated method stub
		
		PreparedStatement pstm = null;
		ResultSet rs = null;
		User deletedUser = null;
		
		try {
			
			pstm = con.prepareStatement(STATEMENT);
			pstm.setString(1, user.getEmail());
			
			rs = pstm.executeQuery();
			
			if (rs.next()) {
				deletedUser = new User(rs.getString("email"), 
						rs.getString("name"), 
						rs.getString("surname"), 
						rs.getString("username"), 
						rs.getString("password"));
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

        this.outputParam = deletedUser;
		//return deletedUser;
	}

}
