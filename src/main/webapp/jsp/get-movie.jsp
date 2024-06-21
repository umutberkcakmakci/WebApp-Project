<%@page import="java.sql.Connection"%>
<%@page import="webapp.DAO.GetMovieByIdDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="webapp.resource.WatchList, webapp.resource.Movie, 
webapp.resource.User, webapp.resource.Person, webapp.DAO.GetMovieByIdDAO, java.sql.Connection, 
webapp.resource.Rates" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.List"%>
<%@ page import="java.lang.String"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Movie Details</title>
  <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;700&display=swap" rel="stylesheet">
  <link rel="stylesheet" href="css/style2.css">
  <style>
        .movie-info {
            display: flex;
            align-items: center;
        }

        .poster {
            /* Adjust as needed */
            margin-right: 20px; /* Adjust spacing between poster and cast images */
        }

        .cast {
            flex: 1; /* Fill remaining space */
        }

        .cast-images {
            display: flex;
            flex-wrap: wrap;
            gap: 10px; /* Adjust spacing between cast images */
        }

        .cast-images img {
            max-width: 100px; /* Adjust maximum width of cast images */
            height: auto;
        }
    </style>
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
  </ul>
</nav>
<main class="container">
  <section class="movie-details">
    <article class="movie-card">
          <%
              Movie movie = (Movie) session.getAttribute("movie");
              %>
        <img src=<%="https://img.youtube.com/vi/" + movie.getTrailerURL().substring(movie.getTrailerURL().indexOf("?v=") + 3) + "/0.jpg" %> alt="Movie 1" class="poster">
          <h2>Cast</h2>
          <% 
		        
		        List<Person> persons = (List<Person>) session.getAttribute("persons");

		        for (Person person : persons) {
		            	
		    	%>
				<div class="card">
                    <div class="card-row">
                        <div class="card-left">
                            <img src=<%
                                if (person.getPhotolink() == null){
                                    out.print("default.webp");
                                } else {
                                    out.print(person.getPhotolink()); 
                                }
                            %> alt="Person 1">
                        </div>
                        <div class="card-middle">
                            <div class="card-title"><a href=<%= "http://localhost:8080/movie-webapp-1.00/get-person?id=" + person.getId() %>><%= person.getName() + " " + person.getSurname() %></a></div>    
                            <div class="card-description"><%= person.getRole()%></div> 
                        </div>
                    </div>
                </div>
		    	<%  
		            } %>
      <div class="movie-info-text">
        <h2><%= movie.getTitle()%></h2>
        <p><strong>Director:</strong> <%= movie.getDirector()%></p>
        <p><strong>Release Date:</strong> <%= movie.getReleaseDate()%></p>
        <p><strong>Genre:</strong> <%= movie.getGenre()%></p>
        <p><strong>moviedb ID:</strong> <%= movie.getId()%></p>
        <p><a href="<%= movie.getTrailerURL() %>" target="_blank">Trailer</a></p>
      </div>
      <div class="column-title"><h2>Movie Reviews</h2><br>
            
            <%
            	List<Rates> userRatings = (List<Rates>) session.getAttribute("rates");
		        
		        if (userRatings != null) {	
		            	for (Rates rating : userRatings) {
		            
			%>
                <div class="card">
                    <div class="card-title">User <%= rating.getUseremail() %></div>
                    <div class="card-description">Score: <%= rating.getScore() %></div>
                    <div class="card-description">Review: <%= rating.getReview() %></div>
                </div>
                
                <%  
    			
		            }
		        } else {
		
		        %>
		                <li>No rating found.</li>  
		        <%  
		        }
		        %>
            </div>
        </div>
        <div><a href="jsp/ratingpage.jsp">Leave the review</a></div>
    </article>
  </section>
</main>
<footer>
  <p>&copy; 2024 Movie Database. All rights reserved.</p>
</footer>
<script>
    document.querySelector('.nav-toggle').addEventListener('click', () => {
        document.querySelector('.nav-list').classList.toggle('expanded');
    });
</script>
</body>
</html>
