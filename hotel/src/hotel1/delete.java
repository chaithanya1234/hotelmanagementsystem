package hotel1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class delete extends HttpServlet {
	
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			response.setContentType("text/html");
			PrintWriter pw=response.getWriter();
			int id=Integer.parseInt(request.getParameter("id"));
		Class.forName("com.mysql.jdbc.Driver");
	Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel","root","");
	PreparedStatement st=con.prepareStatement("delete from customer where id=?");
	pw.print("deleted");
pw.print("<html>");
pw.print("<body>");
pw.print("<form action='list.jsp'>");
pw.print("<input type='submit' value='view'>");
pw.print("</form>");
pw.print("</body>");
pw.print("</html>");
	st.setInt(1,id);
	st.executeUpdate();
	st.close();
	con.close();
	}
		catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
