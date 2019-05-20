<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<style>
body{
background-repeat:no-repeat;
background-size: 1500px 700px;
}
</style>
<body background="7-Star-Hotels-Room.jpg">
<center>
<br><br><br><br><br><br><br><br><br>
<form action="insert" method="post">
CUSTOMER ID:      <input type="number" name="id"></br>
CUSTOMER NAME:    <input type="text" name="cn"></br>
CITY:             <input type="dropdown" name="cit"></br>
COUNTRY:          <input type="dropdown" name="cot"></br>
PHONE NO:         <input type="number" name="phone"></br>
EMAIL:            <input type="email" name="email"></br>
<input type="submit" value="save details">
</form>
<form action="2.jsp">
<input type='submit' value='goback'>
</form>
</center>
</body>
</html>