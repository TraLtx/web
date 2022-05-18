<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
  <!-- Basic -->
  <meta charset="utf-8" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge" />
  <!-- Mobile Metas -->
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
  <!-- Site Metas -->
  <link rel="icon" href="resources/resources/images/fevicon.png" type="image/gif" />
  <meta name="keywords" content="" />
  <meta name="description" content="" />
  <meta name="author" content="" />

  <title>Minics</title>


  <!-- bootstrap core css -->
  <link rel="stylesheet" type="text/css" href="resources/css/bootstrap.css" />

  <!-- fonts style -->
  <link href="https://fonts.googleapis.com/css?family=Poppins:400,700&display=swap" rel="stylesheet"> <!-- range slider -->

  <!-- font awesome style -->
  <link href="resources/css/font-awesome.min.css" rel="stylesheet" />

  <!-- Custom styles for this template -->
  <link href="resources/css/style.css" rel="stylesheet" />
  <!-- responsive style -->
  <link href="resources/css/responsive.css" rel="stylesheet" />
  
  
  
 
  <style>
  .jumbotron {
    background-color: #f4511e;
    color: #fff;
  }
  </style>
  
  

</head>

<body>

  <div class="hero_area">
    <!-- header section strats -->
    <header class="header_section">
      <div class="header_top">
        <div class="container-fluid">
          <div class="top_nav_container">
            <div class="contact_nav">
              <a href="">
                <i class="fa fa-phone" aria-hidden="true"></i>
                <span>
                  Call : +01 123455678990
                </span>
              </a>
              <a href="">
                <i class="fa fa-envelope" aria-hidden="true"></i>
                <span>
                  Email : demo@gmail.com
                </span>
              </a>
            </div>
            <from class="search_form">
              <input type="text" class="form-control" placeholder="Search here...">
              <button class="" type="submit">
                <i class="fa fa-search" aria-hidden="true"></i>
              </button>
            </from>
            <div class="user_option_box">
              <a href="" class="account-link">
                <i class="fa fa-user" aria-hidden="true"></i>
                <span>
                  My Account
                </span>
              </a>
              <a href="" class="cart-link">
                <i class="fa fa-shopping-cart" aria-hidden="true"></i>
                <span>
                  Cart
                </span>
              </a>
            </div>
          </div>

        </div>
      </div>
      <div class="header_bottom">
        <div class="container-fluid">
          <nav class="navbar navbar-expand-lg custom_nav-container ">
            <a class="navbar-brand" href="index.html">
              <span>
                Minics
              </span>
            </a>

            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
              <span class=""> </span>
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
              <ul class="navbar-nav ">
                <li class="nav-item active">
                  <a class="nav-link" href="index.html">Home <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="about.html"> About</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="product.html">Products</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="why.html">Why Us</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="testimonial.html">Testimonial</a>
                </li>
              </ul>
            </div>
          </nav>
        </div>
      </div>
    </header>
    <!-- end header section -->

<div style="width:600px;margin: auto;border: 3px solid #e8e8e8;border-radius: 12px;padding: 5px;">
	<form action="<%=request.getContextPath()%>/registerResult" method="post">
	
		<div class="form-group">
		<label for="password">First name:</label>
		<input type="text" class="form-control" id="firstName" name="firstName">
		</div>
		
		<div class="form-group">
		<label for="password">Mid name:</label>
		<input type="text" class="form-control" id="midName" name="midName">
		</div>
		
		<div class="form-group">
		<label for="password">Last name:</label>
		<input type="text" class="form-control" id="lastName" name="lastName">
		</div>
				
		<div class="form-group">
		<label for="username">Username:</label>
		<input type="text" class="form-control" id="username" name="username">
		</div>

		<div class="form-group">
		<label for="password">Password:</label>
		<input type="password" class="form-control" id="password" name="password">
		</div>
		
		<div class="form-group">
		<label for="password">Email:</label>
		<input type="text" class="form-control" id="email" name="email">
		</div>
		
		<div class="form-group">
		<label for="password">Phone:</label>
		<input type="text" class="form-control" id="phone" name="phone">
		</div>
		
		<div class="form-group">
		<label for="password">Number house:</label>
		<input type="text" class="form-control" id="numberHouse" name="numberHouse">
		</div>
		
		<div class="form-group">
		<label for="password">Street:</label>
		<input type="text" class="form-control" id="street" name="street">
		</div>
		
		<div class="form-group">
		<label for="password">District:</label>
		<input type="text" class="form-control" id="district" name="district">
		</div>
		
		<div class="form-group">
		<label for="password">City:</label>
		<input type="text" class="form-control" id="city" name="city">
		</div>
		
		<div class="form-group">
		<label for="password">Country:</label>
		<input type="text" class="form-control" id="country" name="country">
		</div>
				
		<div class="form-group">
		<input type="submit" value="Register" />	
		</div>	
		<!-- <input type="button" onclick="alert('Done!')" value="Submit"> -->
	</form>
</div>
</div>

  <!-- footer section -->
  <footer class="footer_section">
    <div class="container">
      <p>
        &copy; <span id="displayYear"></span> All Rights Reserved By
        <a href="https://html.design/">Free Html Templates</a>
      </p>
    </div>
  </footer>
  <!-- footer section -->

  <!-- jQery -->
  <script src="js/jquery-3.4.1.min.js"></script>
  <!-- bootstrap js -->
  <script src="js/bootstrap.js"></script>
  <!-- custom js -->
  <script src="js/custom.js"></script>


</body>

</html>