<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Your Shopping Cart</title>
</head>


<style>
table, th, td {
	border: 1px solid black;
	border-collapse: collapse;
}

th, td {
	padding: 15px;
}

th {
	text-align: left;
}
</style>
</head>
<body>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<h2>Your Shopping Cart</h2>
<% double total=0;%>
	<table style="width: 100%">
		<tr>
			<th>Product Name</th>
			<th>Product Price</th>

		</tr>
		<c:forEach var="Cart" items="${cart}">
			<tr>
				<td><c:out value="${Cart.productname }" /></td>
				<td><c:out value="${Cart.price }" /></td>
           <%--     <%=total + ${Cart.price}; --%>

			</tr>
		</c:forEach>
	</table>

	<form action="samazonservlet" method="post">
		<p>
			<br />
		<h3>Want more?</h3>
		<br /> <input type="hidden" name="option" value="1"> 
			 <input type="submit" value="Go Back To List!">
		</p>
	</form>
	
<c:choose>
    <c:when test="${joe.equals('1')}">
    <style>body{ background-color: yellow; }</style>
   
  
    
	<form action="samazonservlet" method="post">
		<p>
			<br />
		<h3>Ready to order?</h3>
		<br /> <input type="hidden" name="option" value="5"> 
			 <input type="submit" value="Check out">
		</p>
	</form>
    
  </c:when>   
 
    <c:otherwise>
    
    <form action="samazonservlet" method="post">
		<p>
			<br />
		<h3>Login to Place Order</h3>
		<br /> <input type="hidden" name="option" value="7"> 
			 <input type="submit" value="Login">
		</p>
	</form>
    
    </c:otherwise>
</c:choose>	
	
	
	
	
	
	