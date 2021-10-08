package Servlets;
import java.io.*;
import javax.servlet.*;
import java.sql.*;
@SuppressWarnings("serial")
public class ViewBooksServlet extends GenericServlet
{
	public Connection con;
	@Override
	public void init() throws ServletException
	{
		con=DBConnection.getcon();
	}
	
	@Override
	public void service(ServletRequest req,ServletResponse res) throws ServletException,IOException
	{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		ServletContext sct=this.getServletContext();
		String fname=(String)sct.getAttribute("fname");
		pw.println("Welcome User:"+fname+"<br>");
		
		RequestDispatcher rd=req.getRequestDispatcher("link2.html");
		rd.include(req, res);
		try
		{
			PreparedStatement ps=con.prepareStatement("select * from Book20");
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				pw.println("<br><br><br>Book Code :"+rs.getString(1));
				pw.println("<br>Book Name :"+rs.getString(2));
				pw.println("<br>Book Author :"+rs.getString(3));
				pw.println("<br>Book Price :"+rs.getFloat(4));
				pw.println("<br>Book Quantity :"+rs.getInt(5));
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
