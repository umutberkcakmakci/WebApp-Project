package webapp.DAO;

import webapp.resource.Movie;
import webapp.DAO.AbstractDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import webapp.resource.Award;

public class GetAwardByIdDAO extends AbstractDAO<Award> {

    private static final String STATEMENT = "SELECT awardid, movieid, personid, winnername, year, category, genre FROM Award WHERE awardid = ?";
    private final int awardId;
    

    public GetAwardByIdDAO(final Connection con, final int awardId) {
        super(con);
        this.awardId = awardId;
        
    }

    @Override
    public void doAccess() throws SQLException {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        Award award = null;

        try {
            pstmt = con.prepareStatement(STATEMENT);
            pstmt.setInt(1, awardId);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                // Retrieve movie details from the result set
            	award = new Award(rs.getInt("awardid"),
                                        rs.getInt("movieid"), rs.getInt("personid"), rs.getString("category"),
                                        new java.util.Date(rs.getDate("year").getTime()),
                                        rs.getString("winnername"), rs.getString("genre"));

            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pstmt != null) {
                pstmt.close();
            }
        }
        this.outputParam = award;
    }

}
