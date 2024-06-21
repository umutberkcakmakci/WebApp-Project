<%-- 
    Document   : person-deleted
    Created on : Jun 3, 2024, 1:40:59 PM
    Author     : vladislavtihonov
--%>
<%@ page import="webapp.resource.Message"%>
<%@ page import="webapp.resource.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="refresh" content="7;url=http://localhost:8080/movie-webapp-1.00/admin-page" />
    <title>Movie Showcase</title>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="css/style3.css">
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
  <% Message m = (Message) session.getAttribute("message");  
     out.println(m.getMessage());%>
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

