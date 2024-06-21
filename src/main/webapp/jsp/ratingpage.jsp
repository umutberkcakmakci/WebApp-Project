<%-- 
    Document   : ratingpage.jsp
    Created on : Jun 6, 2024, 8:57:00 PM
    Author     : vladislavtihonov
--%>
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
    <title>Submit Rate</title>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="../css/ratingstyle.css">
</head>
<body>
<header>
    <div class="header-content">
        <h1>Rate a Movie</h1>
        <p>We value your feedback!</p>
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
<div class="form-container">
    <div class="form-box">
        <% Movie movie = (Movie) session.getAttribute("movie"); %>
        <form id="ratingForm" action="/movie-webapp-1.00/createrates" method="POST">
            <input type="hidden" id="useremail" name="useremail" value=<%=user.getEmail()%>>
            <input type="hidden" id="movieId" name="movieId" value=<%=movie.getId()%>>

            <label>Rate the Movie</label>
            <div class="star-rating">
                <input type="radio" id="5-stars" name="score" value="5" required />
                <label for="5-stars" class="star">&#9733;</label>
                <input type="radio" id="4-stars" name="score" value="4" />
                <label for="4-stars" class="star">&#9733;</label>
                <input type="radio" id="3-stars" name="score" value="3" />
                <label for="3-stars" class="star">&#9733;</label>
                <input type="radio" id="2-stars" name="score" value="2" />
                <label for="2-stars" class="star">&#9733;</label>
                <input type="radio" id="1-star" name="score" value="1" />
                <label for="1-star" class="star">&#9733;</label>
            </div>

            <label for="review">Write a Review</label>
            <textarea id="review" name="review" rows="4" required></textarea>

            <input type="submit" value="SUBMIT">
        </form>
        <div class="success-message" id="successMessage">Submit was successful!</div>
    </div>
</div>
<footer>
    <p>&copy; 2024 Movie Database. All rights reserved.</p>
</footer>
</body>
</html>
