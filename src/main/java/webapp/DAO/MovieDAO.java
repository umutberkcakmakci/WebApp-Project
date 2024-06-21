package webapp.DAO;

import webapp.resource.Movie;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

public class MovieDAO extends AbstractDAO<List<Movie>> {

    public MovieDAO(Connection con) {
        super(con);
    }

    @Override
    protected void doAccess() throws SQLException {
        List<Movie> movies = new ArrayList<>();
        PreparedStatement ps = null;
	ResultSet rs = null;
        try {
            ps = con.prepareStatement("SELECT movieID, title, director, releasedate, genre, trailerURL FROM movie limit 10");
            rs = ps.executeQuery(); 
                while (rs.next()) {
// Assuming rs.getDate("year") returns a java.sql.Date object
                    Movie movie = new Movie(rs.getString("title"),
                                        rs.getString("director"),
                                        rs.getDate("releasedate"),
					rs.getString("genre"),
                                        rs.getString("trailerurl"));
                                movie.setId(rs.getInt("movieid"));
                    movies.add(movie);
                
            } 
        } finally {
			if (rs != null) {
				rs.close();
			}
	
			if (ps != null) {
                            ps.close();
			}

		} 
        outputParam = movies;
    }
}
