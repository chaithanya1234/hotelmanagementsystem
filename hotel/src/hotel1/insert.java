package hotel1;

import java.io.*;

import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.sql.*;
@WebServlet("/insert")
public class insert extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   PrintWriter pw=response.getWriter();
	   String id=request.getParameter("id");
	   String name=request.getParameter("cn");
	   String add=request.getParameter("add");
	   String cit=request.getParameter("cit");
	   String cot=request.getParameter("cot");
	   String phone=request.getParameter("phone");
	   String email=request.getParameter("email");
		   try {
			   
			   Class.forName("com.mysql.jdbc.Driver");
			   Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel","root","");
			   String query="insert into customer values(?,?,?,?,?,?)";
			   PreparedStatement ps= con.prepareStatement(query);
			   ps.setInt(1, Integer.parseInt(id));
			   ps.setString(2, name);
			  // ps.setString(3, add);
			   ps.setString(3, cit);
			   ps.setString(4, cot);
			   ps.setString(5, phone);
			   ps.setString(6, email);
			   ps.executeUpdate();
			   pw.print("sucessfully inserted");
			   ps.close();
			   con.close();
		   }
		   catch(SQLException| ClassNotFoundException e) {
			   e.printStackTrace();
		   }
		   RequestDispatcher rd=request.getRequestDispatcher("add.jsp");
				   rd.forward(request, response);;
	   }
	}


