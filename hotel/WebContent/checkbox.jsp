<%-- /<%@page import="java.sql.*"%>
<%
String room="";
String rooms[]=request.getParameterValues("roomtype");
for(int i=0;room+=rooms[i]+" ";)
		{
try{
Class.forName("com.mysql.jdbc.Driver");
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
Statement st=con.createStatement();
int i=st.executeUpdate("insert into customer(roomtype) values('"+room+"')");
out.println("Data is successfully inserted into database.");
}
catch(Exception e){
System.out.println(e);
}
%> --%>