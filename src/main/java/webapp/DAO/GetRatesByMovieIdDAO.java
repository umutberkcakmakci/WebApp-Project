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
 * Retrieves rates by movie ID from the database.
 */
public class GetRatesByMovieIdDAO extends AbstractDAO<List<Rates>> {

    /**
     * The SQL statement to be executed.
     */
    private static final String STATEMENT =
            "SELECT useremail, score, review FROM rates WHERE movieId = ?";

    /**
     * The movie ID to retrieve rates for.
     */
    private final int movieId;

    /**
     * Creates a new DAO for retrieving rates by movie ID.
     *
     * @param con     the connection to the database.
     * @param movieId the ID of the movie to retrieve rates for.
     */
    public GetRatesByMovieIdDAO(final Connection con, final int movieId) {
        super(con);
        this.movieId = movieId;
    }

    @Override
    protected final void doAccess() throws SQLException {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        final List<Rates> ratesList = new ArrayList<>();

        try {
            pstmt = con.prepareStatement(STATEMENT);
            pstmt.setInt(1, movieId);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                String useremail = rs.getString("useremail");
                int score = rs.getInt("score");
                String review = rs.getString("review");

                Rates rates = new Rates(movieId, useremail, score, review);
                ratesList.add(rates);
            }

            LOGGER.info("Rates for movie %d successfully retrieved from the database.", movieId);
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pstmt != null) {
                pstmt.close();
            }
        }

        outputParam = ratesList;
    }
}