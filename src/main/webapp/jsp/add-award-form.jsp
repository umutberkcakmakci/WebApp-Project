<%@ page import="webapp.resource.User"%>
<%@ page contentType="text/html;charset=utf-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Add Award</title>
  <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;500;700&display=swap" rel="stylesheet">
  <link rel="stylesheet" href="css/style2.css">
</head>
<body>
  <header>
    <nav>
    <% User user = (User) session.getAttribute("user"); %>
    <ul class="nav-list">
        <li><a href="/movie-webapp-1.00/main-menu">Movies</a></li>
        <li><a href="/movie-webapp-1.00/admin-page"><%= user.getName() %></a></li>
      </ul>
    </nav>
  </header>
  <main>
    <h1>Add Award</h1>
    <form id="add-award-form" enctype="application/x-www-form-urlencoded" name="add-award-form" action="/movie-webapp/add-award" method="post">
      <label for="awardId">Award ID:</label>
      <input type="number" id="awardId" name="awardId" required>
      <label for="movieId">Movie ID:</label>
      <input type="number" id="movieId" name="movieId" required>
      <label for="personId">Person ID:</label>
      <input type="number" id="personId" name="personId" required>
      <label for="winnerName">Winner Name:</label>
      <input type="text" id="winnerName" name="winnerName" required>
      <label for="year">Year:</label>
      <input type="date" id="year" name="year" required>
      <label for="category">Category:</label>
      <input type="text" id="category" name="category" required>
      <label for="genre">Genre:</label>
      <input type="text" id="genre" name="genre" required>
      <button type="submit">Add Award</button>
    </form>
  </main>
</body>
</html>
