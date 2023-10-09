<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="saveProduct" method="post">
		<label>Product Name:</label> <input type="text" name="name"><br />
		<label>Price:</label> <input type="number" name="price"><br />
		<label>Quantity:</label> <input type="text" name="quantity"><br />
		<input type="submit" value="Submit">
	</form>
</body>
</html>