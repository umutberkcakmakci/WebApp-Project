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
import webapp.resource.Movie;

/**
 *
 * @author vladislavtihonov
 */
public class DeleteAwardDAO extends AbstractDAO<Award> {
    private static final String STATEMENT = "DELETE FROM Award WHERE awardid=? RETURNING *;";
    
    private final Award award;
    
    public DeleteAwardDAO(final Connection con, final Award award) {
        super(con);

        if (award == null) {
            LOGGER.error("The award cannot be null.");
            throw new NullPointerException("The award cannot be null.");
        }
        
        this.award = award;
    }
    
    @Override
	public void doAccess() throws SQLException {
		// TODO Auto-generated method stub
		
		PreparedStatement pstm = null;
		ResultSet rs = null;
		Award deletedAward = null;
		
		try {
			
			pstm = con.prepareStatement(STATEMENT);
			pstm.setInt(1, award.getAwardID());
			
			rs = pstm.executeQuery();
			
			if (rs.next()) {
				deletedAward = new Award(rs.getInt("awardid"),
                                        rs.getInt("movieid"), rs.getInt("personid"), rs.getString("category"),
                                        new java.util.Date(rs.getDate("year").getTime()),
                                        rs.getString("winnername"), rs.getString("genre"));
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

        this.outputParam = deletedAward;
	}

   }
