package Servlets;
import java.io.*;
import javax.servlet.*;
@SuppressWarnings("serial")
public class AdminLoginServlet extends GenericServlet
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
		
		String uname=req.getParameter("uname");
		String pword=req.getParameter("pword");
		String submit=req.getParameter("submit");
		
		LoginDAO ldao=new LoginDAO();
		boolean k=ldao.validate(uname, pword, submit, sct);
		
		if(k)
		{
			String fname=(String)sct.getAttribute("fname");
			pw.println("Welcome Admin:"+fname+"<br>");
			RequestDispatcher rd=req.getRequestDispatcher("link1.html");
			rd.include(req, res);
		}
		else
		{
			pw.println("INVALID USER NAME OR PASSWORD");
			RequestDispatcher rd=req.getRequestDispatcher("Alogin.html");
			rd.include(req, res);
		}
		
	}
}
