<%@page import="java.sql.Connection"%>
<%@page import="webapp.DAO.GetMovieByIdDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="webapp.resource.WatchList, webapp.resource.Movie, 
webapp.resource.User, webapp.DAO.GetMovieByIdDAO, java.sql.Connection, 
webapp.resource.Rates" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.List"%>
<%@ page import="java.lang.String"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Movie Showcase</title>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="css/userhomestyle.css">
</head>
<body>
<header>
    <div class="header-content">
        <h1>Movie Database</h1>
        <p>Discover the latest movies !</p>
    </div>
</header>
<nav>
    <button class="nav-toggle" aria-label="toggle navigation">&#9776;</button>
    <% User user = (User) session.getAttribute("user"); %>
    <ul class="nav-list">
        <li><a href="/movie-webapp-1.00/main-menu">Movies</a></li>
        <li><a href="/movie-webapp-1.00/user-home"><%= user.getName() %></a></li>
        <li><a href="/movie-webapp-1.00/user-login?query=logout">Logout</a></li>
    </ul>
</nav>

<main class="container">

    <div class="row">
        <div class="column left">
            <div class="column-title">Personal Information<br>
            
			<ul>
			  <li>Name: <%= user.getName() %></li>
			  <li>Surname: <%= user.getSurname() %></li>
			  <li>Username: <%= user.getUsername() %></li>
			  <li>Email: <%= user.getEmail() %></li>
			</ul>
            </div>
        </div>

        <div class="column middle">
            <div class="column-title">Your Watchlist<br>
		       <ul>
		        <% 
		        
		        List<Movie> userMovies = (List<Movie>) session.getAttribute("userWatchlist");

		        if (userMovies != null) {
		            for (Movie movie : userMovies) {
		            	
		    	%>
				<div class="card">
                    <div class="card-row">
                        <div class="card-left">
                            <img src=<%="https://img.youtube.com/vi/" + movie.getTrailerURL().substring(movie.getTrailerURL().indexOf("?v=") + 3) + "/0.jpg" %> alt="Movie 1">
                        </div>
                        <div class="card-middle">
                            <div class="card-title"><a href=<%= "http://localhost:8080/movie-webapp-1.00/movie?id=" + movie.getId() %>><%= movie.getTitle() %></a></div>
                            <div class="card-description">Genre: <%= movie.getGenre() %></div>
                            <div class="card-description">Director: <%= movie.getDirector() %></div>
                            <div class="card-description"><a href="<%= movie.getTrailerURL() %>" target="_blank">Trailer</a></div>
                        </div>
                    </div>
                </div>
		    	<%  
		            }
		        } else {
		
		        %>
		                <li>No movies found.</li>  
		        <%  
		        }
		        %>
		    	</ul>
                
            </div>
                        <div><a href="/movie-webapp-1.00/jsp/create-watchlist.jsp">Create new watchlist!</a></div>
        </div>

        <div class="column right">
            <div class="column-title">Your Reviews<br>
            
            <%
            	List<Rates> userRatings = (List<Rates>) session.getAttribute("userRatings");
		        List<Movie> userRatedMovies = (List<Movie>) session.getAttribute("userRatedMovies");
		        
		        if (userRatings != null) {
		            for (Movie movies2 : userRatedMovies) {	
		            	for (Rates rating : userRatings) {
		            		if (rating.getMovieId() == movies2.getId()) {
		            
			%>
                <div class="card">
                    <div class="card-title">Movie: <%= movies2.getTitle() %></div>
                    <div class="card-description">Score: <%= rating.getScore() %></div>
                    <div class="card-description">Review: <%= rating.getReview() %></div>
                </div>
                
                <%  
    			
		            		}
		            	}
		            }
		        } else {
		
		        %>
		                <li>No rating found.</li>  
		        <%  
		        }
		        %>
            </div>
        </div>
    </div>

</main>
</body>
<footer>
    <p>&copy; 2024 Movie Database. All rights reserved.</p>
</footer>
<script>
    document.querySelector('.nav-toggle').addEventListener('click', () => {
        document.querySelector('.nav-list').classList.toggle('expanded');
    });
</script>

</html>
    