package webapp.resource;

import java.util.List;
import java.util.ArrayList;

/*
 *  This java class represents the data about a user.
 *  
 *  Author: Umut Berk Cakmakci
 *  
 */

public class User {
	
	// The username of the user
	private String username; 
	
	// The name of the user
	private String name;
	
	// The surname of the user
	private String surname;
	
	// The e-mail address of the user
	private String email;
	
	// The password of the user
	private String password;
	
    private List<String> watchlist;
	
		
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the surname
	 */
	public String getSurname() {
		return surname;
	}

	/**
	 * @param surname the surname to set
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * @param watchlist the watchlist to set
	 */
	public void setWatchlist(List<String> watchlist) {
		this.watchlist = watchlist;
	}

	public void UserWatchlist(String email) {
        this.email = email;
        this.watchlist = new ArrayList<>();
    }

    public List<String> getWatchlist() {
        return watchlist;
    }

    public void addToWatchlist(String movie) {
        watchlist.add(movie);
    }

	public User (String email, String name, String surname, String username, String password) {
		this.username = username;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.password = password;
	}

	public User(String email2, String password2) {
		this.email = email2;
		this.password = password2;
	}
	
}
