package hotel1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.PreparedStatement;


@WebServlet("/update1")
public class update1 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		   try {
		   Class.forName("com.mysql.jdbc.Driver");
		   PrintWriter pw=response.getWriter();
		   Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel","root","");
		   int id=Integer.parseInt(request.getParameter("id"));
		   String cn=request.getParameter("cn");
		   String add=request.getParameter("add");
		   String cit=request.getParameter("cit");
		   String cot=request.getParameter("cot");
		   String phone=request.getParameter("phone");
		   String email=request.getParameter("email");
		   PreparedStatement ps=con.prepareStatement("update customer set cn=?,cit=?,cot=?,phone=?,email=? where id=?");
		   ps.setString(1,cn);
		  // ps.setString(2,add);
		   ps.setString(2,cit);
		   ps.setString(3,cot);
		   ps.setString(4,phone);
		   ps.setString(5,email);
		   ps.setInt(6,id);
		   ps.executeUpdate();
		   pw.print("updated succesfully");
		   ps.close();
		   con.close();
		   }
		   catch(Exception e) {
			   e.printStackTrace();
		   }

}
}