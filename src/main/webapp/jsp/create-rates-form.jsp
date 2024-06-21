<%-- 
    Document   : create-rates-form
    Created on : Apr 27, 2024, 09:20:12 PM
    Author     : Kejsi Bimaj
--%>
<%@ page import="webapp.resource.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Rating Confirmation</title>
        <link rel="stylesheet" href="../css/style2.css">
</head>
<body>
<body>
<header>
    <div class="header-content">
        <h1>Rate a Movie</h1>
        <p>We value your feedback!</p>
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
<h1>Rating Confirmation</h1>
<%

	String userEmail = (String) session.getAttribute("useremail");
	String movieId = (String) session.getAttribute("movieId");
	String score = (String) session.getAttribute("score");
	String review = (String) session.getAttribute("review");
	Boolean errorFlag = (Boolean) session.getAttribute("errorFlag");
%>

<%
    if (errorFlag == true) {
    out.println("<p>There was an error processing your rating. Please try again.</p>");
    } else { %>
        <p>Thank you, <%= userEmail %>! Your rating has been submitted successfully.</p>
		<p>Movie ID: <%= movieId %></p>
		<p>Score: <%= score %></p>
		<p>Review: <%= review %></p>
    <% }
    %>

</body>
</html>
