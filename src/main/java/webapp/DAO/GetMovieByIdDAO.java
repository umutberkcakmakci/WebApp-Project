package webapp.DAO;

import webapp.resource.Movie;
import webapp.DAO.AbstractDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;

public class GetMovieByIdDAO extends AbstractDAO<Movie> {

    private static final String STATEMENT = "SELECT movieID, title, director, releasedate, genre, trailerURL FROM Movie WHERE movieid = ?";
    private final int movieId;
    

    public GetMovieByIdDAO(final Connection con, final int movieId) {
        super(con);
        this.movieId = movieId;
        
    }

    @Override
    public void doAccess() throws SQLException {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        Movie movie = null;

        try {
            pstmt = con.prepareStatement(STATEMENT);
            pstmt.setInt(1, movieId);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                // Retrieve movie details from the result set
            	int id = rs.getInt("movieID");
                String title = rs.getString("title");
                String director = rs.getString("director");
                Date releaseDate = rs.getDate("releasedate");
                String genre = rs.getString("genre");
                String trailerURL = rs.getString("trailerURL");

                
                // Create a Movie object with the retrieved details
                movie = new Movie(id, title, director, releaseDate, genre, trailerURL);

            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pstmt != null) {
                pstmt.close();
            }
        }
        this.outputParam = movie;
    }

}
