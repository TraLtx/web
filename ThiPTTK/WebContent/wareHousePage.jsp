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

	<c:if test = "${staff ==  null}">
         <%
		    String redirectURL = ""; //Ve trang index
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
              <a href="" class="account-link">
                <i class="fa fa-user" aria-hidden="true"></i>
                <span>
                   <c:out value="Staff ${staff.name}" />
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
                <li class="nav-item">
                  <a class="nav-link" href="<%=request.getContextPath()%>/staff">Home</a>
                </li>
                <li class="nav-item active">
                  <a class="nav-link" href="<%=request.getContextPath()%>/wareHouse">Ware House<span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="<%=request.getContextPath()%>/webItem">Web Item</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="why.html">Stored Book</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="testimonial.html">ZZZZ</a>
                </li>
              </ul>
            </div>
          </nav>
        </div>
      </div>
    </header>
    <!-- end header section -->
    
    <!-- slider section -->

      <div class="row">

		<div class="container">
		<br/>
			<h3 class="text-center">List of Books in Warehouse</h3>
			<hr>
			<div class="container text-left">

				<a href="<%=request.getContextPath()%>/newBook" class="btn btn-success">Add
					New Book</a>
			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>Book_ID</th>
						<th>Title</th>
						<th>Cost</th>
						<th>Author</th>
						<th>Language</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<!--   for (Todo todo: todos) {  -->
					<c:forEach var="book" items="${listBook}">

						<tr>
							<td><c:out value="${book.typeID}${book.bookID}" /></td>
                    		<td><c:out value="${book.title}" /></td>
                    		<td><c:out value="${book.cost}" /></td>
                    		<td><c:out value="${book.author}" /></td>
                    		<td><c:out value="${book.language}" /></td>
							<td> 
								<a href="<%=request.getContextPath()%>/push?id=<c:out value='${book.bookID}' />">Push</a>  
								&nbsp;&nbsp;&nbsp;&nbsp;
                        		<a href="<%=request.getContextPath()%>/edit?id=<c:out value='${book.bookID}' />">Edit</a>  
                        		&nbsp;&nbsp;&nbsp;&nbsp;
                        		<a href="<%=request.getContextPath()%>/delete?id=<c:out value='${book.bookID}' />">Delete</a>  
                       		</td>
						</tr>
					</c:forEach>
					<!-- } -->
				</tbody>

			</table>
		</div>
	</div>
</div>
	<!-- end slider section -->


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