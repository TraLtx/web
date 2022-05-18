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
  img{
  	height: 100px;
  }
  
  .jumbotron {
    background-color: #f4511e;
    color: #fff;
  }
  .box1{
	border: 2px solid #e6e6e6;
	border-radius: 9px;
	padding: 20px;
	margin-left:100px;
	margin-right:100px;
  }
  .button {
  background-color: #4CAF50; /* Green */
  border: none;
  color: white;
  padding: 10px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 4px 2px;
  cursor: pointer;
  border-radius: 8px;
}
  /*Wrap */

	  .wrapper {
	      margin-top: 10px;
	      display: grid;
	      grid-template-columns: repeat(3, 1fr);
	  }
  </style>
  
  

</head>

<body>

	<c:if test = "${customer ==  null}">
         <%
		    String redirectURL = "login"; //Ve trang index
		    response.sendRedirect(redirectURL);
		%>
    </c:if>
    
    

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
             <c:if test = "${customer ==  null}">
 				<a href="<%=request.getContextPath()%>/login" class="account-link">
	                <i class="fa fa-user" aria-hidden="true"></i>
	                <span>
	                  Login
	                </span>
              	</a>
              	<a href="<%=request.getContextPath()%>/register" class="account-link">
	                <i class="fa fa-user" aria-hidden="true"></i>
	                <span>
	                  Sign up
	                </span>
              	</a>
      		</c:if>

      		<c:if test = "${customer !=  null}">
 				<a href="<%=request.getContextPath()%>/cusAccount" class="account-link">
	                <i class="fa fa-user" aria-hidden="true"></i>
	                <span>
	                  <c:out value="${customer.fullname.firstName}" />
	                </span>
              	</a>
              	
              	<a href="<%=request.getContextPath()%>/viewCart" class="cart-link">
                <i class="fa fa-shopping-cart" aria-hidden="true"></i>
                <span>
                  Cart
                </span>
              </a>
      		</c:if>
              
              
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
                <li class="nav-item">
                  <a class="nav-link" href="<%=request.getContextPath()%>/home">Home </a>
                </li>

                <li class="nav-item">
                  <a class="nav-link" href="<%=request.getContextPath()%>/allBook">Products</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="<%=request.getContextPath()%>/viewOrder">Your Order</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="<%=request.getContextPath()%>/viewNewestOrder">Your Newest Order</a>
                </li>
              </ul>
            </div>
          </nav>
        </div>
      </div>
    </header>
    <!-- end header section -->
    
    
<div class="container">
	<br/>
		<h3 class="text-center">Handler order</h3>
		<hr>
		<div class="container text-left">
			<a href="<%=request.getContextPath()%>/viewCart" class="btn btn-success">Back</a>
	</div>
	<br/>
	
	<div class="row">
		<div style="float:left;width:800px;margin:auto;border: 3px solid black;border-radius: 12px;padding: 5px;">
			
			<form action="<%=request.getContextPath()%>/confirmOrder" method="post">
				
				<div class="form-group">
				<label for="infor" name="infor">Amount Book: <c:out value='${amount}' /></label>
				</div>
				
				<div class="form-group">
				<label for="infor" name="infor">Total Price (without ship cost): <c:out value='${totalPrice}' /></label>
				</div>
				
				<div class="form-group">
				<label for="fullname" >Your name: </label>
				<input  class="form-control" type="text" id="fullname" name="fullname" value="<c:out value='${customer.fullname.lastName} ${customer.fullname.midName} ${customer.fullname.firstName}' />" readonly>
				</div>

				<div class="form-group">
				<label for="email" >Email: </label>
				<input  class="form-control" type="text" id="email" name="email" value="<c:out value='${customer.email}' />" readonly>
				</div>

				<div class="form-group">
				<label for="phone" >Phone Number: </label>
				<input  class="form-control" type="text" id="phone" name="phone" value="<c:out value='${customer.phone}' />" readonly>
				</div>
				
				<div class="form-group">
				<label for="address" >Address: </label>
				<input  class="form-control" type="text" id="address" name="address" value="<c:out value='${customer.address.numberHouse},${customer.address.street},${customer.address.district},${customer.address.city},${customer.address.country}' />" readonly><br><br>
				</div>
								
				
				
				<input type="submit" value="Comfirm">
			</form>
				
			<script>
			function disable() {
				credit.checked = false;
			  document.getElementById("bank").disabled = true;
			  document.getElementById("number").disabled = true;
			  document.getElementById("type").disabled = true;
			  document.getElementById("expDate").disabled = true;
			}
			</script>
			
			<script>
			function display() {
				cash.checked = false;
				  document.getElementById("bank").disabled = false;
				  document.getElementById("number").disabled = false;
				  document.getElementById("type").disabled = false;
				  document.getElementById("expDate").disabled = false;
			}
			</script>
		</div>

</div>



  <!-- product section -->


  <!-- end product section -->

  <!-- why us section -->

  <section class="why_us_section layout_padding">
    <div class="container">
      <div class="heading_container heading_center">
        <h2>
          Why Choose Us
        </h2>
      </div>
      <div class="row">
        <div class="col-md-4">
          <div class="box ">
            <div class="img-box">
              <img src="resources/images/w1.png" alt="">
            </div>
            <div class="detail-box">
              <h5>
                Fast Delivery
              </h5>
              <p>
                variations of passages of Lorem Ipsum available
              </p>
            </div>
          </div>
        </div>
        <div class="col-md-4">
          <div class="box ">
            <div class="img-box">
              <img src="resources/images/w2.png" alt="">
            </div>
            <div class="detail-box">
              <h5>
                Chip Shiping
              </h5>
              <p>
                variations of passages of Lorem Ipsum available
              </p>
            </div>
          </div>
        </div>
        <div class="col-md-4">
          <div class="box ">
            <div class="img-box">
              <img  src="resources/images/w3.png" alt="">
            </div>
            <div class="detail-box">
              <h5>
                Best Quality
              </h5>
              <p>
                variations of passages of Lorem Ipsum available
              </p>
            </div>
          </div>
        </div>
      </div>
    </div>
  </section>

  <!-- end why us section -->


  <!-- client section --><!-- end client section -->

  <!-- info section -->
  <section class="info_section ">
    <div class="container">
      <div class="row">
        <div class="col-md-3">
          <div class="info_contact">
            <h5>
              <a href="" class="navbar-brand">
                <span>
                  Minics
                </span>
              </a>
            </h5>
            <p>
              <i class="fa fa-map-marker" aria-hidden="true"></i>
              Address
            </p>
            <p>
              <i class="fa fa-phone" aria-hidden="true"></i>
              +01 1234567890
            </p>
            <p>
              <i class="fa fa-envelope" aria-hidden="true"></i>
              demo@gmail.com
            </p>
          </div>
        </div>
        <div class="col-md-3">
          <div class="info_info">
            <h5>
              Information
            </h5>
            <p>
              Eligendi sunt, provident, debitis nemo, facilis cupiditate velit libero dolorum aperiam enim nulla iste maxime corrupti ad illo libero minus.
            </p>
          </div>
        </div>
        <div class="col-md-3">
          <div class="info_links">
            <h5>
              Useful Link
            </h5>
            <ul>
              <li>
                <a href="index.html">
                  Home
                </a>
              </li>
              <li>
                <a href="about.html">
                  About
                </a>
              </li>
              <li>
                <a href="product.html">
                  Products
                </a>
              </li>
              <li>
                <a href="why.html">
                  Why Us
                </a>
              </li>
              <li>
                <a href="testimonial.html">
                  Testimonial
                </a>
              </li>
            </ul>
          </div>
        </div>
        <div class="col-md-3">
          <div class="info_form ">
            <h5>
              Newsletter
            </h5>
            <form action="">
              <input type="email" placeholder="Enter your email">
              <button>
                Subscribe
              </button>
            </form>
            <div class="social_box">
              <a href="">
                <i class="fa fa-facebook" aria-hidden="true"></i>
              </a>
              <a href="">
                <i class="fa fa-twitter" aria-hidden="true"></i>
              </a>
              <a href="">
                <i class="fa fa-instagram" aria-hidden="true"></i>
              </a>
              <a href="">
                <i class="fa fa-youtube" aria-hidden="true"></i>
              </a>
            </div>
          </div>
        </div>
      </div>
    </div>
  </section>

  <!-- end info_section -->

	

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

<!-- <div class="form-group">
				<label for="shipment">Shipment: </label>
			      <select class="form-control" id="shipment" name="shipment">
			        <option>Normal</option>
			        <option>Fast</option>
			        <option>Express</option>
			        </select>
			    </div>
				
				<div class="form-group">
				<label for="note">Note: </label>
				<input type="text" class="form-control" id="note" name="note">
				</div>
				
				<div class="form-group">
				<label for="payment">Payment: </label>
				
				<input type="checkbox" id="cash" name="cash" value="cash" onclick="disable()">
				<label for="cash">Cash</label>
				
				<input type="checkbox" id="credit" name="credit" value="credit" onclick="display()">
				<label for="credit">Credit</label>
				</div>
				
				<div class="form-group">
				<label for="bank">Bank:</label>
				<input type="text" class="form-control" id="bank" name="bank">
				</div>
				
				<div class="form-group">
				<label for="number">Number Card:</label>
				<input type="text" class="form-control" id="number" name="number">
				</div>
				
				<div class="form-group">
				<label for="type">Type:</label>
					<select class="form-control" id="type" name="type">
			        <option>ATM</option>
			        <option>Visa</option>
			        </select>
				</div>
				
				<div class="form-group">
				<label for="expDate">ExpDate:</label>
				<input type="text" class="form-control" id="expDate" name="expDate">
				</div> -->