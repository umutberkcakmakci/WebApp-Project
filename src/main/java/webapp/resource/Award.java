package webapp.resource;
import java.util.Date;
/**
 *
 * @author Meltem Yanoglu
 */

public class Award {
    private int awardID;
    private int movieID;
    private int personID;
    private String winnername;
    private Date year;
    private String category;
    private String genre;
 
    public Award(int awardID, int movieID,  int personID, String winnername,  Date year, String category,  String genre) {
        this.awardID = awardID;
        this.movieID = movieID;
        this.personID =personID;
        this.winnername = winnername;
        this.year = year;
        this.category = category;
        this.genre = genre;
    }


    //get-set
 
    public int getAwardID() {
        return awardID;
    }

    public void setAwardId(int awardID) {
        this.awardID = awardID;
    }

    public int getMovieID() {
        return movieID;
    }

    public void setMovieID(int movieID) {
        this.movieID = movieID;
    }

    public int getPersonID() {
        return personID;
    }

    public void setPersonID(int personID) {
        this.personID = personID;
    }

    public String getWinnername() {
        return winnername;
    }

    public void setWinnername(String winnername) {
        this.winnername = winnername;
    }

    public Date getYear() {
        return year;
    }

    public void setYear(Date year) {
        this.year = year;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    



}
   
