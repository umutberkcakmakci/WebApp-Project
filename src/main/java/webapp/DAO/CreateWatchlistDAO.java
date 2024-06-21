package webapp.DAO;
import java.sql.Array;
import webapp.DAO.AbstractDAO;
import webapp.resource.WatchList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 
 * @author Meltem Yanoglu
 *
 */

 
 public class CreateWatchlistDAO extends AbstractDAO {
 
     private static final String INSERT_WATCHLIST_SQL = "INSERT INTO watchlist (useremail, movielist) VALUES (?, ?)";
 
     private final WatchList watchlist;
 
     public CreateWatchlistDAO(Connection connection, WatchList watchlist) {
         super(connection);
 
         if (watchlist == null) {
             LOGGER.error("The watchlist cannot be null.");
             throw new NullPointerException("The watchlist cannot be null.");
         }
 
         this.watchlist = watchlist;
     }
 
     @Override
     protected final void doAccess() throws SQLException {
         PreparedStatement pstmt = null;
 
         try {
            
            pstmt = con.prepareStatement(INSERT_WATCHLIST_SQL);
            pstmt.setString(1, watchlist.getName());
            Integer[] intArray = watchlist.getMovies().toArray(new Integer[0]);
            Array ids = con.createArrayOf("INTEGER", intArray);
            pstmt.setArray(2, ids);
            pstmt.executeUpdate();
 
             LOGGER.info("Watchlist '%s' successfully created in the database.", watchlist.getName());
         } finally {
             if (pstmt != null) {
                 pstmt.close();
             }
         }
     }
 }
 