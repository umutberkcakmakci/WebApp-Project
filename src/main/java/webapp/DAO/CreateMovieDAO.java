
package webapp.DAO;
import webapp.DAO.AbstractDAO;
import webapp.resource.Movie;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


/**
 *
 * @author Muhammad Ali
 */
public class CreateMovieDAO extends AbstractDAO {

    private static final String STATEMENT = "INSERT INTO movie (title, director, releasedate, genre, trailerurl) VALUES (?, ?, ?, ?, ?)";

    private final Movie movie;

    public CreateMovieDAO(Connection con, Movie movie) {
        super(con);

        if (movie == null) {
            LOGGER.error("The movie cannot be null.");
            throw new NullPointerException("The movie cannot be null.");
        }

        this.movie = movie;
    }

    @Override
    protected final void doAccess() throws SQLException {
        PreparedStatement pstmt = null;

        try {
            pstmt = con.prepareStatement(STATEMENT);
            pstmt.setString(1, movie.getTitle());
            pstmt.setString(2, movie.getDirector());
            pstmt.setDate(3, movie.getReleaseDate());
            pstmt.setString(4, movie.getGenre());
            pstmt.setString(5, movie.getTrailerURL());

            pstmt.execute();

            LOGGER.info("Movie %s successfully stored in the database.", movie.getTitle());
        } finally {
            if (pstmt != null) {
                pstmt.close();
            }
        }
    }
}

