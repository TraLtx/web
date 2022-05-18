<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>User Management Application</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>

	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: tomato">
			<ul class="navbar-nav">
			</ul>
		</nav>
	</header>
	<center>
        <h1>Books Management</h1>
        <div class="container text-left">

				<a href="<%=request.getContextPath()%>/webItem" class="btn btn-success">Back to WebItem</a>
		</div>
    </center>
    <div align="center">
        <c:if test="${bookItem.image != null}">
            <form action="updateItem" method="post">
        </c:if>
        <c:if test="${bookItem.image == null}">
            <form action="pushItem" method="post">
        </c:if>
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    <c:if test="${bookItem != null}">
                        Edit Book
                    </c:if>
                    <c:if test="${bookItem == null}">
                        Add New Book
                    </c:if>
                </h2>
            </caption>
                <c:if test="${bookItem != null}">
                    <input type="hidden" name="id" value="<c:out value='${bookItem.id}' />" />
                </c:if>  
             
             <tr>
                <th>ID: </th>
                <td>
                	<label name="id" size="45"><c:out value='${bookItem.id}' /></label>                    
                </td>
            </tr>
            
            
            <tr>
                <th>Price: </th>
                <td>
                    <input type="text" name="price" size="45"
                            value="<c:out value='${bookItem.price}' />"
                    />
                </td>
            </tr>
            
            <tr>
                <th>Image: </th>
                <td>
                    <input type="text" name="image" size="45"
                            value="<c:out value='${bookItem.image}' />"
                    />
                </td>
            </tr>
                        
            <tr>
                <th>Status: </th>
                <td>
                    <label>pushed</label>
                </td>
            </tr>
            
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Update" />
                </td>
            </tr>
        </table>
        </form>
    </div>   
</body>
</html>
