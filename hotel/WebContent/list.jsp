<html>
<style>
body{
background-color:yellow;
}
</style>
<body>
<center>
<h1>list of customers</h1>
</center>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.*"%>
<%
try{
Connection con=null;
Statement st=null;
ResultSet rs=null;
String q="select * from customer";
Class.forName("com.mysql.jdbc.Driver");
con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel","root","");
st=con.createStatement();
rs=st.executeQuery(q);
%>
<center>
<table border="2">
<tr>
<td>customer id</td>
<td>customer name</td>
<td>city</td>
<td>country</td>
<td>phone no</td>
<td>email</td>
</tr>
<%while(rs.next())
{
%>
<tr>
<td><%= rs.getInt(1) %></td>
    <td><%= rs.getString(2) %></td>
    <td><%= rs.getString(3) %></td>
    <td><%= rs.getString(4) %></td>
    <td><%= rs.getString(5) %></td>
    <td><%= rs.getString(6) %></td>
   </tr>
<%}
con.close();
}
catch(Exception e)
{
e.printStackTrace();
}%>
</table>
</center>
<div class=del>
<form action="delte.jsp" method="get">
<input type="submit" value="delete customers"/>
</form>
</div>
<div class=ad>
<form action="add.jsp" method="get">
<input type="submit" value="add customers"/>
</form>
</div>
<div class=u>
<form action="up.jsp" method="get">
<input type="submit" value="update customers"/>
</form>
</div>
</body>
<style>
.del{
position:absolute; 
   	margin-left:34%; 
   	margin-top:40%  
   	width:150px;
   	bottom:280px;
}
.ad{
position:absolute; 
   	margin-left:45%;
   	margin-top:45%   
   	width:150px;
   	bottom:280px;
}
.u{
position:absolute; 
   	margin-left:57%;
   	margin-top:43%;   
   	width:150px;
   	bottom:280px;
}
</style>
</html>ss