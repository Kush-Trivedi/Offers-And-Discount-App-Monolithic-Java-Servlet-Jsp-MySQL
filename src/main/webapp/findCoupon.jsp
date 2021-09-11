<!-- This is the guy who has have a form and that is submitted to a 
	controller called offers-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Find Offer</title>
</head>
<body>
<h1>Find Offer</h1>
<form action="offers" method="post">
<pre>
Offer Code:<input type="text" name="couponCode" />
<input type = "hidden" name = "action" value = "find" />
<input type="submit" value = "Find">

</pre>

</form>

</body>
</html>