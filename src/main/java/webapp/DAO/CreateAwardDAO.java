package webapp.DAO;
import webapp.DAO.AbstractDAO;
import webapp.resource.Award;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 
 * @author Meltem Yanoglu
 *
 */

public class CreateAwardDAO extends AbstractDAO {
    
    private static final String STATEMENT = 
    "INSERT INTO Award (awardID, movieID, personID, winnername, year, category, genre)"
    + " VALUES (?, ?, ?, ?, ?, ?, ?)";
    
    private final Award award;

	public CreateAwardDAO(final Connection con, final Award award) {
		super(con);
		
		if (award==null) {
            LOGGER.error("The award cannot be null.");
            throw new NullPointerException("The award cannot be null.");
		}
		
		this.award = award;
	}

	@Override
	protected void doAccess() throws SQLException {
		
        PreparedStatement pstmt = null;

        try {
            pstmt = con.prepareStatement(STATEMENT);
            pstmt.setInt(1, award.getAwardID());
            pstmt.setInt(2, award.getMovieID());
            pstmt.setInt(3, award.getPersonID());
            pstmt.setString(4, award.getWinnername());
            pstmt.setDate(5, (Date) award.getYear());
            pstmt.setString(6, award.getCategory());
            pstmt.setString(7, award.getGenre());
            pstmt.execute();

            LOGGER.info("Award %d successfully stored in the database.", award.getAwardID(), award.getWinnername());
        } finally {
            if (pstmt != null) {
                pstmt.close();
            }
        }

    
    }
}
