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

				<a href="<%=request.getContextPath()%>/wareHouse" class="btn btn-success">Back to Warehouse</a>
		</div>
    </center>
    <div align="center">
        <c:if test="${book != null}">
            <form action="update" method="post">
        </c:if>
        <c:if test="${book == null}">
            <form action="addBook" method="post">
        </c:if>
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    <c:if test="${book != null}">
                        Edit Book
                    </c:if>
                    <c:if test="${book == null}">
                        Add New Book
                    </c:if>
                </h2>
            </caption>
                <c:if test="${book != null}">
                    <input type="hidden" name="id" value="<c:out value='${book.bookID}' />" />
                </c:if>  
             
             <tr>
                <th>ID: </th>
                <td>
                	<label name="bookID" size="45"><c:out value='${book.bookID}' /></label>                    
                </td>
            </tr>
            
            <tr>
                <th>TypeID: </th>
                <td>
                	<label name="typeID" size="45"><c:out value='${book.typeID}' /></label>   
                </td>
            </tr>
            
             <tr>
                <th>ISBN: </th>
                <td>
                    <input type="text" name="isbn" size="45"
                            value="<c:out value='${book.isbn}' />"
                        />
                </td>
            </tr>
                        
            <tr>
                <th>Title: </th>
                <td>
                    <input type="text" name="title" size="45"
                            value="<c:out value='${book.title}' />"
                        />
                </td>
            </tr>
            
            <tr>
                <th>Author: </th>
                <td>
                    <input type="text" name="author" size="45"
                            value="<c:out value='${book.author}' />"
                        />
                </td>
            </tr>
            
            <tr>
                <th>Language: </th>
                <td>
                    <input type="text" name="language" size="45"
                            value="<c:out value='${book.language}' />"
                    />
                </td>
            </tr>
            
            <tr>
                <th>Number Of Pages: </th>
                <td>
                    <input type="text" name="numOfPages" size="45"
                            value="<c:out value='${book.numOfPages}' />"
                    />
                </td>
            </tr>
            
            <tr>
                <th>Summary: </th>
                <td>
                    <input type="text" name="summary" size="45"
                            value="<c:out value='${book.summary}' />"
                    />
                </td>
            </tr>
            
            <tr>
                <th>Publish Year: </th>
                <td>
                    <input type="text" name="publishYear" size="45"
                            value="<c:out value='${book.publishYear}' />"
                    />
                </td>
            </tr>
            
            <tr>
                <th>Cost: </th>
                <td>
                    <input type="text" name="cost" size="5"
                            value="<c:out value='${book.cost}' />"
                    />
                </td>
            </tr>
            
            <tr>
                <th>Barcode: </th>
                <td>
                    <input type="text" name="barcode" size="45"
                            value="<c:out value='${book.barcode}' />"
                    />
                </td>
            </tr>
            
            <tr>
                <th>Status: </th>
                <td>
                    <label>received</label>
                </td>
            </tr>
            
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save" />
                </td>
            </tr>
        </table>
        </form>
    </div>   
</body>
</html>

<!-- 
<tr>
                <th>Status: </th>
                <td>
                    <form>
				    <div class="form-group">
				      <select class="form-control" id="status" name="status">
				        <option>received</option>
				        <option>web</option>
				        <option>stored</option>
				    </div>
				  </form>
                </td>
            </tr>
 -->
