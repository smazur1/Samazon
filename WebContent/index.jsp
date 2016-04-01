<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Shop at Samazon</title>
</head>
<body>


 <img src="Image/samazon.jpeg"/>
	<form action="samazonservlet" method="post">
		<p>
			<label for="viewproduct">View Product List:</label> 
				
				<input type="hidden" name="option" value="1">
				
				<input type="submit">
		</p>
	</form>


</body>
</html>