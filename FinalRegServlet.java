package Servlets;
import java.io.*;
import javax.servlet.*;
@SuppressWarnings("serial")
public class FinalRegServlet extends GenericServlet
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
		
		RegisterDAO rdao=new RegisterDAO();
		
		int k=rdao.register(rb);
		if(k>0)
		{
			pw.println("User Registered Successfully");
			RequestDispatcher rd=req.getRequestDispatcher("Ulogin.html");
			rd.include(req, res);
		}
	}

}
