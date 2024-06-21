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

/**
 *
 * @author vladislavtihonov
 */
public class DeleteMovieDAO extends AbstractDAO<Movie> {
    private static final String STATEMENT = "DELETE FROM Movie WHERE movieid=? RETURNING *;";
    
    private final Movie movie;
    
    public DeleteMovieDAO(final Connection con, final Movie movie) {
        super(con);

        if (movie == null) {
            LOGGER.error("The movie cannot be null.");
            throw new NullPointerException("The movie cannot be null.");
        }
        
        this.movie = movie;
    }
    
    @Override
	public void doAccess() throws SQLException {
		// TODO Auto-generated method stub
		
		PreparedStatement pstm = null;
		ResultSet rs = null;
		Movie deletedMovie = null;
		
		try {
			
			pstm = con.prepareStatement(STATEMENT);
			pstm.setInt(1, movie.getId());
			
			rs = pstm.executeQuery();
			
			if (rs.next()) {
				deletedMovie = new Movie(rs.getString("title"),
                                        rs.getString("director"),
                                        rs.getDate("releasedate"),
					rs.getString("genre"),
                                        rs.getString("trailerurl"));
                                deletedMovie.setId(rs.getInt("movieid"));
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

        this.outputParam = deletedMovie;
	}

   }
