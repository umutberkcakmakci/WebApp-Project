<%-- 
    Document   : admin-page
    Created on : Jun 6, 2024, 9:57:51 AM
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
    <title>Admin Panel</title>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="css/adminstyle.css">
</head>
<body>
<header>
    <h1>Admin Panel</h1>
</header>

<nav>
    <button class="nav-toggle" aria-label="toggle navigation">&#9776;</button>
    <% User user = (User) session.getAttribute("user"); %>
    <ul class="nav-list">
        <li><a href="/movie-webapp-1.00/admin-page"><%= user.getName() %></a></li>
        <li><a href="/movie-webapp-1.00/main-menu">Movies</a></li>
        <li><a href="/movie-webapp-1.00/user-login?query=logout">Logout</a></li>
    </ul>
</nav>
<main>
    <div id="form-links" class="form-selector">
        <button onclick="showSection('movieFormSection')">Movie Form</button> <br>
        <button onclick="showSection('personFormSection')">Person Form</button> <br>
        <button onclick="showSection('awardFormSection')">Award Form</button> <br>
        <button onclick="showSection('linkFormSection')">Link Movie and Person</button> <br>
        <button onclick="showSection('modifyMovieSection')">Delete Movie</button> <br>
        <button onclick="showSection('modifyPersonSection')">Delete Person</button> <br>
        <button onclick="showSection('modifyAwardSection')">Delete Award</button> <br>
    </div>

    <section id="movieFormSection">
        <h2>Create Movie Form</h2>
        <a href="/movie-webapp-1.00/html/create-movie.html">Go to form</a>
    </section>

    <section id="personFormSection">
        <h2>Create Person Form</h2>
         <a href="/movie-webapp-1.00/html/create-person.html">Go to form</a>
    </section>
    
    <section id="awardFormSection">
        <h2>Create Award Form</h2>
         <a href="/movie-webapp-1.00/html/add-award.html">Go to form</a>
    </section>
    
    <section id="linkFormSection">
        <h2>Link Movie and Person</h2>
         <a href="/movie-webapp-1.00/html/link-movie-person-role.html">Go to form</a>
    </section>

    <section id="modifyMovieSection">
        <h2>Delete Movie</h2>
        <a href="/movie-webapp-1.00/html/delete-movie.html">Go to form</a>
    </section>

    <section id="modifyPersonSection">
        <h2>Delete Person</h2>
        <a href="/movie-webapp-1.00/html/delete-person.html">Go to form</a>
    </section>
    
    <section id="modifyAwardSection">
        <h2>Delete Award</h2>
        <a href="/movie-webapp-1.00/html/delete-award.html">Go to form</a>
    </section>
</main>
<script>
    function showSection(sectionId) {
        const sections = document.querySelectorAll('main section');
        sections.forEach(section => {
            if (section.id === sectionId) {
                section.classList.add('visible');
            } else {
                section.classList.remove('visible');
            }
        });
    }

    document.getElementById('fetchMovieForm').addEventListener('submit', function(event) {
        event.preventDefault();
        const movieID = document.getElementById('fetchMovieID').value;
        fetch(`/fetch-movie?movieID=${movieID}`)
            .then(response => response.json())
            .then(data => {
                document.getElementById('movieDetails').innerHTML = `
                    <p>Title: ${data.title}</p>
                    <p>Director: ${data.director}</p>
                    <p>Genre: ${data.genre}</p>
                    <p>Release Date: ${data.releasedate}</p>
                    <p>Trailer URL: <a href="${data.trailerurl}" target="_blank">${data.trailerurl}</a></p>
                `;
                document.getElementById('modifyMovieForm').style.display = 'block';
                document.getElementById('deleteMovieForm').style.display = 'block';

                document.getElementById('modifyMovieID').value = movieID;
                document.getElementById('modifyTitleID').value = data.title;
                document.getElementById('modifyDirectorID').value = data.director;
                document.getElementById('modifyGenreID').value = data.genre;
                document.getElementById('modifyReleaseDateID').value = data.releasedate;
                document.getElementById('modifyTrailerURLID').value = data.trailerurl;
                document.getElementById('deleteMovieID').value = movieID;
            });
    });

    document.getElementById('fetchPersonForm').addEventListener('submit', function(event) {
        event.preventDefault();
        const movieID = document.getElementById('fetchPersonMovieID').value;
        fetch(`/fetch-person?movieID=${movieID}`)
            .then(response => response.json())
            .then(data => {
                let personDetailsHTML = '';
                data.forEach(person => {
                    personDetailsHTML += `
                        <div>
                            <p>Name: ${person.name}</p>
                            <p>Surname: ${person.surname}</p>
                            <p>Short Bio: ${person.shortBio}</p>
                            <p>Role: ${person.role}</p>
                            <p>Birth place: ${person.birthplace}</p>
                            <p>Birth date: ${person.birthdate}</p>
                            <p>Photo URL: <a href="${person.photolink}" target="_blank">${person.photolink}</a></p>
                        </div>
                    `;
                });
                document.getElementById('personDetails').innerHTML = personDetailsHTML;
                document.getElementById('modifyPersonForm').style.display = 'block';
                document.getElementById('deletePersonForm').style.display = 'block';

                const person = data[0];
                document.getElementById('modifyPersonID').value = person.id;
                document.getElementById('modifyPersonNameID').value = person.name;
                document.getElementById('modifyPersonSurnameID').value = person.surname;
                document.getElementById('modifyPersonShortBioID').value = person.shortBio;
                document.getElementById('modifyPersonRoleID').value = person.role;
                document.getElementById('modifyPersonBirthplaceID').value = person.birthplace;
                document.getElementById('modifyPersonBirthdateID').value = person.birthdate;
                document.getElementById('modifyPersonPhotoLinkID').value = person.photolink;
                document.getElementById('deletePersonMovieID').value = movieID;
            });
    });
        function logout() {
        // Add your logout logic here, e.g., clearing session storage, redirecting to login page, etc.
        alert('You have been logged out.');
        // For example, to redirect to the login page:
        window.location.href = '/login';
    }
        document.querySelector('.nav-toggle').addEventListener('click', function() {
        document.querySelector('.nav-list').classList.toggle('active');
    });

</script>
</body>
</html>
