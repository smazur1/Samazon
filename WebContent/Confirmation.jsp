<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Confirmation Page</title>
</head>
<body>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
You spent a total of $<c:out value="${total}" /> for this order.<br/>
Thank you for your purchase!
<%-- <form action="samazonservlet" method="post">
<input >
<input type="hidden" name="option" value="1"> 
<input type="submit" value="Go back to product list">
</form>--%>
</body>
</html>