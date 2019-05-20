<% String name=request.getParameter("uname");
String pwd=request.getParameter("pwd");
if(name.equals("chaithanya")&& pwd.equals("Chaithu@86"))
   response.sendRedirect("2.jsp");
else
	throw new RuntimeException("check ur user name or password once");

%>