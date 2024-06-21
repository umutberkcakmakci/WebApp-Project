<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Movie Showcase</title>
  <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;700&display=swap" rel="stylesheet">
  <link rel="stylesheet" href="css/userhomestyle.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
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
    <li><a href="#">Home</a></li>
    <li><a href="#">Movies</a></li>
    <li><a href="#">About</a></li>
    <li><a href="#">Contact</a></li>
    <li><a href="#">Sign Up</a></li>
    <li><a href="#">Login</a></li>
  </ul>
</nav>
<body>
<main class="container">
  <div class="form">


    <div class="tab-content">

      <div id="login">

        <form name="loginform" id="loginform" enctype="application/x-www-form-urlencoded" action="" method="post" >

          <div class="field-wrap">
            <input type="text" name="email" id="email" required autocomplete="off" placeholder="Email Address*"/>
          </div>

          <div class="field-wrap">
            <input type="password" name="password" id="password" required autocomplete="off" placeholder="Password*"/>
          </div>
          <br>
          <p class="forgot"><a href="#">Forgot Password?</a></p>

          <button type="submit" id="log-in" class="button button-block" >Log In</button>

        </form>

      </div>

    </div><!-- tab-content -->
    <div id="login-error" class="error-message"></div>
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

<script>
  $(document).ready(function(){
    $("#loginform").submit(function(event){
      event.preventDefault(); 

      var email = $("#email").val();
      var password = $("#password").val();

      if (!email || !password) {
        $("#login-error").text("Email and password cannot be null.");
        return;
      }

      if (!validateEmail(email)) {
        $("#login-error").text("Please enter a valid email address.");
        return;
      }

      login(email, password);
    });
  });

  function validateEmail(email) {
    var re = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    return re.test(email);
  }

  function login(email, password) {
	  $.ajax({
	    url: "/movie-webapp/user-login",
	    method: "POST",
	    contentType: "application/json",
	    data: JSON.stringify({ email: email, password: password }),
	    dataType: "json",
	    success: function(response) {
	      if (response.data === "success") {
	        sessionStorage.setItem("email", email);
	        console.log("geldi");
	        window.location.href = "/movie-webapp/user-home";
	      } else {
	        $("#login-error").text(response.data);
	      }
	    },
	    error: function(jqXHR, textStatus, errorThrown) {
	      console.error("An error occurred during login: ", textStatus, errorThrown);
	      $("#login-error").text("An error occurred. Please try again.");
	    }
	  });
	}
</script>


</body>
</html>

