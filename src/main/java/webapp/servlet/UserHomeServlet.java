package webapp.servlet;

import webapp.DAO.UserLoginDAO;
import webapp.DAO.GetMovieByIdDAO;
import webapp.DAO.GetRatesByUserEmailDAO;
import webapp.DAO.GetWatchlistByUserEmailDAO;
import webapp.resource.User;
import webapp.resource.Movie;
import webapp.resource.Rates;
import webapp.resource.WatchList;
import webapp.resource.Message;
import webapp.utils.ErrorCode;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import javax.naming.NamingException;

import org.apache.logging.log4j.message.StringFormattedMessage;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.*;

import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

@WebServlet(name = "UserHomeServlet", urlPatterns ="/user-home")

public class UserHomeServlet extends AbstractDatabaseServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if (session.getAttribute("usertype") == "admin"){

            resp.setStatus(HttpServletResponse.SC_FORBIDDEN);
                
            resp.sendRedirect("/movie-webapp-1.00/admin-page");
        } else {
        
        List<Movie> movielist = new ArrayList<>();
        List<Rates> rateslist = new ArrayList<>();
        List<Movie> ratedMovieList = new ArrayList<>();
        //Map<Movie, String> movieImageMap = new HashMap<>();
        
        try (Connection con = getConnection()) {
            
            if (session.getAttribute("user") != null) {
                User user = (User) session.getAttribute("user");
                //User user = new User("johndoe@gmail.com", "John", "Doe", "johndoe", "12345678");

                GetWatchlistByUserEmailDAO userWatchlistDAO = new GetWatchlistByUserEmailDAO(con, user);
                Integer[] userMovies = userWatchlistDAO.access().getOutputParam();
                
                if (userMovies != null) {
                    for (int movieId : userMovies) {
                        Connection con2 = getConnection();
                        GetMovieByIdDAO movieDAO = new GetMovieByIdDAO(con2, movieId);
                        Movie movie = movieDAO.access().getOutputParam();
                        movielist.add(movie);
                        //String imageUrl = "https://img.youtube.com/vi/" + movie.getTrailerURL().substring(movie.getTrailerURL().indexOf("?v=") + 3) + "/0.jpg"; //fetchOpenGraphImageUrl(movie.getTrailerURL());
                        //movieImageMap.put(movie, imageUrl);
                    }
                } else {
                    System.out.println("The movie list is empty.");
                }
                
                Connection con3 = getConnection();
                GetRatesByUserEmailDAO getRatesDAO = new GetRatesByUserEmailDAO(con3, user.getEmail());
                rateslist = getRatesDAO.access().getOutputParam();
                
                for (Rates rates : rateslist) {
                    Connection con4 = getConnection();
                    GetMovieByIdDAO movieDAO = new GetMovieByIdDAO(con4, rates.getMovieId());
                    Movie movie = movieDAO.access().getOutputParam();
                    ratedMovieList.add(movie);
                }

                session.setAttribute("userWatchlist", movielist);
                session.setAttribute("userRatings", rateslist);
                session.setAttribute("userRatedMovies", ratedMovieList);
                //session.setAttribute("movieImageMap", movieImageMap);
                
                req.getRequestDispatcher("jsp/user-home-page.jsp").forward(req, resp);
            } else {
                resp.sendRedirect("user-login");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
       }
    } 

    /*@Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");

        String movie = req.getParameter("movie");
        user.addToWatchlist(movie);

        resp.sendRedirect("jsp/user-home-page.jsp");
    }*/
    
    /*private String fetchOpenGraphImageUrl(String videoUrl) {
        try {
            Document doc = Jsoup.connect(videoUrl).get();
            Element ogImage = doc.select("meta[property=og:image]").first();

            if (ogImage != null) {
                return ogImage.attr("content");
            } else {
                System.out.println("OpenGraph Image not found for URL: " + videoUrl);
                return null;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }*/
}
