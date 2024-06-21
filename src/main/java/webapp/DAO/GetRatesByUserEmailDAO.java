package webapp.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import webapp.resource.Rates;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kejsi Bimaj
 */

/**
 * Retrieves rates by user email from the database.
 */
public class GetRatesByUserEmailDAO extends AbstractDAO<List<Rates>> {

    /**
     * The SQL statement to be executed.
     */
    private static final String STATEMENT =
            "SELECT movieID, useremail, score, review FROM Rates WHERE useremail = ?";

    /**
     * The user email to retrieve rates for.
     */
    private final String userEmail;

    /**
     * Creates a new DAO for retrieving rates by user email.
     *
     * @param con       the connection to the database.
     * @param userEmail the email of the user to retrieve rates for.
     */
    public GetRatesByUserEmailDAO(final Connection con, final String userEmail) {
        super(con);
        this.userEmail = userEmail;
    }

    @Override
    public final void doAccess() throws SQLException {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Rates> ratesList = new ArrayList<>();

        try {
            pstmt = con.prepareStatement(STATEMENT);
            pstmt.setString(1, userEmail);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                int movieId = rs.getInt("movieID");
                int score = rs.getInt("score");
                String review = rs.getString("review");

                Rates rates = new Rates(movieId, userEmail, score, review);
                ratesList.add(rates);
            }

            LOGGER.info("Rates for user %s successfully retrieved from the database.", userEmail);
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pstmt != null) {
                pstmt.close();
            }
        }

        this.outputParam = ratesList;
    }
}