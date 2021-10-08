package Servlets;
import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.*; 
@SuppressWarnings("serial")
public class DeleteBookServlet extends GenericServlet 
{
	public ServletContext sct;
	
	@Override
	public void init() throws ServletException
	{
		sct=this.getServletContext();
	}
	
	@Override
	public void service(ServletRequest req,ServletResponse res)
	throws ServletException,IOException
	{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		
		String bcode=req.getParameter("bcode");
		 String submit=req.getParameter("submit");
		 
		 if(submit.equals("GetData"))
		 {
		
		try
		{
			Connection con=DBConnection.getcon();
			PreparedStatement ps=con.prepareStatement("select * from Book20 where bcode=?");
			ps.setString(1,bcode);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				pw.println("----------Existing Data------------");
				pw.println("<br><br><br>Book Code :"+rs.getString(1));
				pw.println("<br>Book Name :"+rs.getString(2));
				pw.println("<br>Book Author :"+rs.getString(3));
				pw.println("<br>Book Price :"+rs.getFloat(4));
				pw.println("<br>Book Quantity :"+rs.getInt(5));
			}
			RequestDispatcher rd=req.getRequestDispatcher("dbook.html");
			rd.include(req, res);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		 }
		 else
		 {
		String fname=(String)sct.getAttribute("fname");
		pw.println("Welcome User:"+fname+"<br>");
		
		
		DeleteDAO ddao=new DeleteDAO();
		int k=ddao.delete(bcode);
		if(k>0)
		{
			RequestDispatcher rd=req.getRequestDispatcher("link1.html");
			rd.include(req, res);
			pw.println("<br><br>Books Deleted Successfully");
		}
		else
		{
			pw.println("No Book Deleted");
		}
		 }
				
	}

}

