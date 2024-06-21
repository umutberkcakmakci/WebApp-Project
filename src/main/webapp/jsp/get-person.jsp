<%@ page import="java.util.Random"%>
<%@ page import="webapp.resource.Person"%>
<%@ page import="webapp.resource.Movie"%>
<%@ page import="webapp.resource.User"%>
<%@ page import="java.util.List"%>
<%@ page import="webapp.resource.Award"%>
<%@ page import="org.javatuples.Pair"%>
<html lang="en">
	<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Movie Showcase</title>
  <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;700&display=swap" rel="stylesheet">
  <link rel="stylesheet" href="css/personstyle.css">
	</head>


	<body class="home">
            <header>
    <div class="header-content">
        <h1>Movie Database</h1>
        <p>Discover the latest movies !</p>
    </div>
</header>
<nav>
  <% User user = (User) session.getAttribute("user"); %>
    <ul class="nav-list">
        <li><a href="/movie-webapp-1.00/main-menu">Movies</a></li>
        <li><a href="/movie-webapp-1.00/user-home"><%= user.getName() %></a></li>
    </ul>
</nav>
		
		<div id="site-content">
			<header class="site-header">
				<div class="container">
					<div class="person-information">
                                            <h1 class="person-name">
                                                <%
                                                    Person p = (Person) session.getAttribute("person");
                                                    out.println(p.getName() + " " + p.getSurname());
                                                    %>
                                            </h1>
						<small class="person-description">
                                                    <%
                                                    out.println(p.getRole());
                                                    %>
                                                </small>
                                                
                                                <small class="person-description">
                                                    <%
                                                    out.println(", Date of Birth: " + p.getBirthdate() + ", Place of Birth: " + p.getBirthplace());
                                                    %>
                                                </small>
                                                
                                                <small class="person-description">
                                                    <%
                                                    out.println(", moviedb ID: " + p.getId());
                                                    %>
                                                </small>
					</div>

					
				</div>
			</header>

			<main class="main-content">
				<div class="fullwidth-block" id="about">
					<div class="container">
                                            <%
                                                if (p.getPhotolink() == null){
                                                    out.println("<figure class=\"author-image\"><img src=\"default.webp\" width=\"320\" height=\"320\" alt=\"Placeholder Image\"></figure>");
                                                } else {
                                                    out.println("<figure class=\"author-image\"><img src=\"" + p.getPhotolink() + "\" width=\"320\" height=\"320\" alt=\"Photo\"></figure>");
                                                }
                                                %>
						<h2 class="section-title">About</h2>
                                                <p>
                                                    <%
                                                        out.println(p.getShortBio());
                                                        %>
                                                </p>

					</div> 
				</div> 

				<div class="fullwidth-block" id="awards">
					<div class="container">
						<h2 class="section-title">Awards</h2>

						<div class="row">
                                                    <%
                                                        List<Pair<Award, String>> aw = (List<Pair<Award, String>>) session.getAttribute("awards");
                                                        if (aw != null){
                                                            int counter = 0;
                                                            for (Pair<Award, String> a : aw) {
                                                                counter++;
                                                                Award awar = a.getValue0();
                                                                String movieName = a.getValue1();
                                                                out.println("<div class=\"col-md-6 col-sm-4 col-xs-12\"><div class=\"step\"><h3 class=\"step-title\"><span class=\"step-num\">" + counter + "</span>" + movieName + "</h3><p>" + awar.getGenre() + " " + (awar.getYear().getYear() + 1900) + " " + awar.getCategory() + "</p></div></div>");
                                                        }
                                                        }
                                                        %>
						</div>
					</div> 
				</div> 

				<div class="fullwidth-block" id="filmography">
					<div class="container">
						<h2 class="section-title">Filmography</h2>
						<h3 class="section-desc">Movies, that the person was involved with</h3>

						<div class="row">
							<div class="col-md-12">
                                                            <%
                                                                List<Movie> mv = (List<Movie>) session.getAttribute("movies");
                                                                if (mv != null){
                                                                    for (Movie m : mv) {
                                                                        out.println("<div class=\"movie\"><h3 class=\"year\">" + (m.getReleaseDate().getYear() + 1900) + "</h3><p class=\"desc\">" + m.getGenre() + "</p><strong><a href=\"http://localhost:8080/movie-webapp-1.00/movie?id=" + m.getId() + "\">" + m.getTitle() + "</a></strong></div>");
                                                                }
                                                                }
                                                                %>
							</div>
						</div>
					</div> 
				</div> 

			</main>

			<footer class="site-footer">
				<div class="container">
					<p>&copy; 2024 Movie Database. All rights reserved.</p>
				</div>
			</footer>
		</div>

		

		
		
		
		
		
	

</body></html>
