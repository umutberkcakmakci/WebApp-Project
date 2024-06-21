package webapp.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import webapp.resource.Movie;
public class TopRatedMovieDAO extends AbstractDAO<List<Movie>> {

    public TopRatedMovieDAO(Connection con) {
        super(con);
    }

    @Override
    protected void doAccess() throws SQLException {
        List<Movie> topRatedMovies = new ArrayList<>();
        try (PreparedStatement ps = con.prepareStatement("SELECT * FROM movies WHERE rating >= ?")) {
            ps.setDouble(1, 9.0); // Example: top-rated movies with rating >= 9.0
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
// Assuming rs.getDate("year") returns a java.sql.Date object
                    Movie movie = new Movie(Integer.toString(rs.getInt("id")), rs.getString("title"), rs.getDate("year"), rs.getString("genre"), rs.getString("trailerURL"));
                    topRatedMovies.add(movie);
                }
            }
        }
        outputParam = topRatedMovies;
    }
}
