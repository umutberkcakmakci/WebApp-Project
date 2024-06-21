package webapp.resource;

import java.util.ArrayList;
import java.util.List;

public class WatchList {
    private int id;
    private String name;
    private List<Integer> movies;

    public WatchList(String name) {
        this.name = name;
        this.movies = new ArrayList<>();
    }

    public WatchList(int id2, String name2, List<Integer> movies2) {
    	this.id = id2;
        this.name = name2;
        this.movies = movies2;
    }

    // Getter and setter methods
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getMovies() {
        return movies;
    }

    public void setMovies(List<Integer> movies) {
        this.movies = movies;
    }

    // Method to add a movie to the watchlist
    public void addMovie(Integer movie) {
        movies.add(movie);
    }

    // Method to remove a movie from the watchlist
    public void removeMovie(Integer movie) {
        movies.remove(movie);
    }

    // Method to get the size of the watchlist
    public int size() {
        return movies.size();
    }

    // Method to check if the watchlist is empty
    public boolean isEmpty() {
        return movies.isEmpty();
    }

    // Method to clear all movies from the watchlist
    public void clear() {
        movies.clear();
    }
}
