<%-- 
    Document   : homepage
    Created on : Jun 5, 2024, 3:42:19 PM
    Author     : vladislavtihonov
--%>
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
    <link rel="stylesheet" href="css/style2.css">
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
    <ul class="nav-list">
        <% User user = (User) session.getAttribute("user"); %>
        <li><a href="/movie-webapp-1.00/main-menu">Movies</a></li>
        <li><a href="/movie-webapp-1.00/user-home"><%= user.getName() %></a></li>
    </ul>
</nav>
<main class="container">
    <section class="movie-list">
        <% 
	List<Movie> movies = (List<Movie>) session.getAttribute("movies");
            for (Movie movie : movies) {
		            	
		    	%>
        <article class="movie-card">
            <img src=<%="https://img.youtube.com/vi/" + movie.getTrailerURL().substring(movie.getTrailerURL().indexOf("?v=") + 3) + "/0.jpg" %> alt="Movie 1">
            <div class="movie-info"><a href=<%= "http://localhost:8080/movie-webapp-1.00/movie?id=" + movie.getId() %>><%= movie.getTitle() %></a></div>
            <div class="movie-info">Genre: <%= movie.getGenre() %></div>
            <div class="movie-info">Director: <%= movie.getDirector() %></div>
        </article>
        <%  } %>









        <!-- Add more movie cards as needed -->
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
