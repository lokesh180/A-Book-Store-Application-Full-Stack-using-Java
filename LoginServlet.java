package Servlets;
import java.io.*;
import javax.servlet.*;
@SuppressWarnings("serial")
public class LoginServlet extends GenericServlet 
{
	@Override
	public void service(ServletRequest req,ServletResponse res) throws ServletException,IOException
	{
		String submit=req.getParameter("login");
		if(submit.equals("ADMIN"))
		{
			RequestDispatcher rd=req.getRequestDispatcher("Alogin.html");
			rd.forward(req, res);
		}
		else
		{
			RequestDispatcher rd=req.getRequestDispatcher("Ulogin.html");
			rd.forward(req, res);
		}
	}

}
