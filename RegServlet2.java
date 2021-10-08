package Servlets;
import java.io.*;
import javax.servlet.*;
@SuppressWarnings("serial")
public class RegServlet2 extends GenericServlet
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
		String addr=req.getParameter("addr");
		String mid=req.getParameter("mid");
		Long phno=Long.parseLong(req.getParameter("phno"));
		
		rb.setAddr(addr);
		rb.setMid(mid);
		rb.setPhno(phno);
		
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		pw.println("Details are valid....");
		pw.println("You can check  the details here");
		pw.println("<a href='dis'>View Details</a>");
	}

}
