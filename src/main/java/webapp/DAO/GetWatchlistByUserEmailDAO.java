package webapp.DAO;

import webapp.resource.WatchList;
import webapp.resource.Movie;
import webapp.resource.User;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.logging.log4j.message.StringFormattedMessage;

public class GetWatchlistByUserEmailDAO extends AbstractDAO<Integer[]> {

	   private static final String STATEMENT = "SELECT movielist FROM Watchlist WHERE useremail=?;";

	   private final Connection con;
	   User email;
	   
	   public GetWatchlistByUserEmailDAO (final Connection con, final User em) {
		   super(con);
		   this.email = em;
		   this.con = con;		   
	   }
	   
	   @Override
	   public final void doAccess() throws SQLException {
		   
	        PreparedStatement pstmt = null;
			ResultSet rs = null;
			Integer[] movieIds = null;
				
			// the results of the search
			User user = email;

	        try {
	        	
	        	pstmt = con.prepareStatement(STATEMENT);
		        pstmt.setString(1, user.getEmail());
		
				rs = pstmt.executeQuery();

	            if (rs.next()) {
	            	movieIds = (Integer[]) rs.getArray("movielist").getArray();
	            }
	        } finally {
				if (rs != null) {
					rs.close();
				}
		
				if (pstmt != null) {
					pstmt.close();
				}
				con.close();
	        }
	        this.outputParam = movieIds;
	   }

}
