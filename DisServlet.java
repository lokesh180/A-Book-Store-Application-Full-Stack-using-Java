package Servlets;
import java.io.*;
import javax.servlet.*;
@SuppressWarnings("serial")
public class DisServlet extends GenericServlet
{
	public RegBean rb;
	public ServletContext sct;
	
	@Override
	public void init() throws ServletException
	{
		sct=this.getServletContext();
		rb=(RegBean)sct.getAttribute("beanref");
	}
	
	@Override
	public void service(ServletRequest req,ServletResponse res) throws ServletException,IOException
	{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		pw.println("---------- Registration Details ----------");
		pw.println("<br>Uname:"+rb.getUname());
		pw.println("<br>Password:"+rb.getPword());
		pw.println("<br>First Name:"+rb.getFname());
		pw.println("<br>Last Name:"+rb.getLname());
		pw.println("<br>Address:"+rb.getAddr());
		pw.println("<br>Phone NO:"+rb.getPhno());
		pw.println("<br>Mail ID:"+rb.getMid());
		pw.println("<br>");
		pw.println("<form action='final' method='post'>");
		pw.println("<input type='submit' value='REGISTER'>");
		pw.println("</form");
	}
}
