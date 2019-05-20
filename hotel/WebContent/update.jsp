<%@ page import="java.sql.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
<% 
Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel","root","");
int k=Integer.parseInt(request.getParameter("id"));
PreparedStatement st=con.prepareStatement( "select * from customer where id = ?");
st.setInt(1, k);
ResultSet rs = st.executeQuery();
 %>
<%while(rs.next()){
%> 
<form  action="update1" name="edit">
id: <%=rs.getInt(1)%><input type="hidden" name="id" value="<%=rs.getInt(1) %>"/><br/><br/>
customer name :<input type="text" name="cn" value="<%=rs.getString(2)%>"/> <br/><br/>
city : <input type="text" name="cit"  value="<%=rs.getString(3) %>"/><br/><br/>
country :<input type="text" name="cot"  value="<%=rs.getString(4) %>"/><br/><br/>
phone no : <input type="text" name="phone"  value="<%=rs.getString(5) %>"/><br/><br/>
Email : <input type="text"name="email"  value="<%=rs.getString(6) %>"/><br/><br/>
<input type="submit" value="update"/>
</form>
<%
}
%>
</center>
</body>
</html>