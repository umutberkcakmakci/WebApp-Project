<%-- 
    Document   : create-watchlist
    Created on : Jun 5, 2024, 9:46:41 PM
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
    <link rel="stylesheet" href="../css/style3.css">
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
    <h1>Create watchlist</h1>
    <div class="form">


        <div class="tab-content">
            <div id="login">

                <form action="/movie-webapp-1.00/create-watchlist" method="post">
                     <input type="hidden" id="watchlist_name" name="watchlist_name" value=<%=user.getEmail()%>>

                        <div class="field-wrap">
                            <label for="ids">
                                Movies' Ids<span class="req">*</span>
                            </label>
                            <input type="text" name="ids" required autocomplete="off" />

                    <button type="submit" id="sign-up" class="button button-block"/>Submit</button>

                </form>

            </div>


        </div><!-- tab-content -->

    </div> <!-- /form -->
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
</body>
</html>

