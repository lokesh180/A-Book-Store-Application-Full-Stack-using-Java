package Servlets;
import java.io.*;
import javax.servlet.*;
@SuppressWarnings("serial")
public class RegServlet1 extends GenericServlet
{
	public RegBean rb;
	public ServletContext sct;
	
	@Override
	public void init() throws ServletException
	{
		rb=new RegBean();
		sct=this.getServletContext();
	}
	
	@Override
	public void service(ServletRequest req,ServletResponse res) throws ServletException,IOException
	{
		String uname=req.getParameter("uname");
		String pword=req.getParameter("pword");
		String fname=req.getParameter("fname");
		String lname=req.getParameter("lname");
		
		rb.setUname(uname);
		rb.setPword(pword);
		rb.setFname(fname);
		rb.setLname(lname);
		sct.setAttribute("beanref",rb);
		
		RequestDispatcher rd=req.getRequestDispatcher("Register2.html");
		rd.forward(req, res);
	}
}
