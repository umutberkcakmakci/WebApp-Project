/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package webapp.DAO;
import webapp.resource.Person;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author Vladislav Tikhonov
 */
public class CreateParticipatesDAO extends AbstractDAO {
    
    private static final String STATEMENT = 
            "INSERT INTO participates (movieid, personid, role) "
            + "VALUES (?, ?, ?);";
    
    private final int movieId;
    private final int personId;
    private final String role;
    
    public CreateParticipatesDAO(final Connection con, final int movieId, final int personId, String role) {
        super(con);

        if (movieId < 1 || personId < 1 ) {
            LOGGER.error("The id cannot be null.");
            throw new NullPointerException("The id cannot be null.");
        }

        this.movieId = movieId;
        this.personId = personId;
        this.role = role;
    }
    
    @Override
    protected final void doAccess() throws SQLException {

        PreparedStatement pstmt = null;

        try {
            pstmt = con.prepareStatement(STATEMENT);
            pstmt.setInt(1, movieId);
            pstmt.setInt(2, personId);
            pstmt.setString(3, role);


            pstmt.execute();
           

            LOGGER.info("Person and movie were successfully linked.");
        } finally {
            if (pstmt != null) {
                pstmt.close();
            }
        }

    }
    
}
