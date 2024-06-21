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
import webapp.resource.Award;
import java.util.ArrayList;
import java.util.List;
import org.javatuples.Pair;

/**
 *
 * @author Vladislav Tikhonov
 */
public class GetAwardsAndMovieNameByPersonIdDAO extends AbstractDAO<List<Pair<Award, String>>>{
    
    private static final String STATEMENT = 
              "SELECT award.awardid, award.winnername, award.year, award.category, award.genre, movie.title "
            + "FROM award "
            + "INNER JOIN movie ON (movie.movieid = award.movieid)"
            + "WHERE award.personid = ?;";
    private final int id;
    
    public GetAwardsAndMovieNameByPersonIdDAO(final Connection con, final int id) {
		super(con);
		this.id = id;
	}
    
    @Override
    public final void doAccess() throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		final List<Pair<Award, String>> awards = new ArrayList<Pair<Award,String>>();

		try {
			pstmt = con.prepareStatement(STATEMENT);

			pstmt.setInt(1, id);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				awards.add(new Pair(
                                        new Award(rs.getInt("awardid"),
                                        id, id, rs.getString("category"),
                                        new java.util.Date(rs.getDate("year").getTime()),
                                        rs.getString("winnername"),
										rs.getString("genre")),
                                        rs.getString("title")));
			}

			LOGGER.info("Award(s) with actor %d successfully listed.", id);
		} finally {
			if (rs != null) {
				rs.close();
			}

			if (pstmt != null) {
				pstmt.close();
			}

		}

		this.outputParam = awards;
	}
    
}

