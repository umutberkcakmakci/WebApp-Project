package webapp.resource;

import java.sql.Date;

/**
 * @author Muhammad Ali
 *
 */

public class Movie {
    private int id;
    private String title;
    private String director;
    private Date releaseDate;
    private String genre;
    private String trailerURL;

    public Movie(String title, String director, Date releaseDate, String genre, String trailerURL) {
        this.title = title;
        this.director = director;
        this.releaseDate = releaseDate;
        this.genre = genre;
        this.trailerURL = trailerURL;
    }
    
    public Movie(int id, String title, String director, Date releaseDate, String genre, String trailerURL) {
    	this.id = id;
        this.title = title;
        this.director = director;
        this.releaseDate = releaseDate;
        this.genre = genre;
        this.trailerURL = trailerURL;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
    
    public String getTrailerURL() {
        return trailerURL;
    }
}
