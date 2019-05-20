package hotel1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw=response.getWriter();
		response.setContentType("text/html");
		try {
			int id=Integer.parseInt(request.getParameter("id"));
		Class.forName("com.mysql.jdbc.Driver");
	Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel","root","");
	PreparedStatement st=con.prepareStatement("select * from customer where id=?");
	st.setInt(1,id);
	ResultSet rs=st.executeQuery();
	while(rs.next())
	pw.println(rs.getInt(1)+"  "+rs.getString(2)+ " "+rs.getString(3)+" "+rs.getString(4)+" " +rs.getString(5)+" "+rs.getString(6));
	st.executeUpdate();
	st.close();
	con.close();
	}
		catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
