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
import webapp.resource.Movie;
import webapp.resource.Role;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Vladislav Tikhonov
 */
public class GetMoviesByPersonIdDAO extends AbstractDAO<List<Movie>>{
    
    private static final String STATEMENT = 
              "SELECT movie.movieid, movie.title, movie.director, movie.releasedate, movie.genre, movie.trailerurl "
            + "FROM participates "
            + "INNER JOIN movie ON (movie.movieid = participates.movieid)"
            + "INNER JOIN person ON (person.personid = participates.personid)"
            + "WHERE person.personid = ?;";
    private final int id;
    
    public GetMoviesByPersonIdDAO(final Connection con, final int id) {
		super(con);
		this.id = id;
	}
    
    @Override
    public final void doAccess() throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		final List<Movie> movies = new ArrayList<Movie>();

		try {
			pstmt = con.prepareStatement(STATEMENT);

			pstmt.setInt(1, id);

			rs = pstmt.executeQuery();

			while (rs.next()) {
                                Movie mv = new Movie(rs.getString("title"),
                                        rs.getString("director"),
                                        rs.getDate("releasedate"),
					rs.getString("genre"),
                                        rs.getString("trailerurl"));
                                mv.setId(rs.getInt("movieid"));
				movies.add(mv);
			}

			LOGGER.info("Movie(s) with actor %d successfully listed.", id);
		} finally {
			if (rs != null) {
				rs.close();
			}

			if (pstmt != null) {
				pstmt.close();
			}

		}

		this.outputParam = movies;
	}
    
}
