<!-- This is the guy who has have a form and that is submitted to a 
	controller called products-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Offer</title>
</head>
<body>
<h1>Create Offer</h1>
<form action="offers" method = "post">
<pre>
Offer Code:<input type="text" name="couponCode" />
Discount:<input type="text" name="discount" />
Expire Date:<input type="text" name="expireDate" />
<input type = "hidden" name = "action" value = "create" />
<input type="submit" value = "Save">

</pre>

</form>
</body>
</html>