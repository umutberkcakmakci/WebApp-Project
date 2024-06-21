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
import webapp.resource.Person;

/**
 *
 * @author vladislavtihonov
 */
public class DeleteWatchlistDAO extends AbstractDAO<Person> {
    private static final String STATEMENT = "DELETE FROM Watchlist WHERE useremail=?;";
    
    private final String useremail;
    
    public DeleteWatchlistDAO(final Connection con, final String useremail) {
        super(con);

        if (useremail == null) {
            LOGGER.error("The user email cannot be null.");
            throw new NullPointerException("The user email cannot be null.");
        }
        
        this.useremail = useremail;
    }
    
    @Override
	public void doAccess() throws SQLException {
		// TODO Auto-generated method stub
		
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			
			pstm = con.prepareStatement(STATEMENT);
			pstm.setString(1, useremail);
			
			pstm.execute();
			
			
			
		} finally {
            if (rs != null) {
                rs.close();
            }

            if (pstm != null) {
                pstm.close();
            }

            con.close();
        }

	}

   }
