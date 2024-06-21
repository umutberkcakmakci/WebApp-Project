package webapp.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Date;
import webapp.resource.Award;
//import webapp.util.DatabaseConnection;
//import com.google.gson.Gson;

@WebServlet(name = "AwardDetailsServlet", urlPatterns = "/award-detail")
public class AwardDetailsServlet extends AbstractDatabaseServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        int awardId = Integer.parseInt(req.getParameter("id"));
        Award award = null;

        try (Connection connection = getConnection()){
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM awards WHERE awardId = ?"); 
            statement.setInt(1, awardId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    int movieId = resultSet.getInt("movieId");
                    int personId = resultSet.getInt("personId");
                    String category = resultSet.getString("category");
                    Date year = resultSet.getDate("year");
                    String winnerName = resultSet.getString("winnerName");
                    String genre = resultSet.getString("genre");

                    award = new Award(awardId, movieId, personId, category, year, winnerName, genre);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        res.setContentType("application/json");
        PrintWriter out = res.getWriter();
        //out.print(new Gson().toJson(award));
        out.flush();
    }
}
