package Servlets;
import java.io.*;
import javax.servlet.*;
@SuppressWarnings("serial")
public class UserLoginServlet extends GenericServlet
{
	public ServletContext sct;
	
	@Override
	public void init() throws ServletException
	{
		sct=this.getServletContext();
	}
	
	@Override
	public void service(ServletRequest req,ServletResponse res) throws ServletException,IOException
	{
		String uname=req.getParameter("uname");
		String pword=req.getParameter("pword");
		String submit=req.getParameter("submit");
		
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		
		LoginDAO ldao=new LoginDAO();
		boolean b=ldao.validate(uname, pword, submit, sct);
		if(b)
		{
			String fname=(String) sct.getAttribute("fname");
			pw.println("Welcome,"+fname);
			RequestDispatcher rd=req.getRequestDispatcher("link2.html");
			rd.include(req,res);
		}
		else
		{
			pw.println("INVALID USER OR PASSWORD<br>");
			RequestDispatcher rd=req.getRequestDispatcher("Ulogin.html");
			rd.include(req,res);
		}
	}

}
