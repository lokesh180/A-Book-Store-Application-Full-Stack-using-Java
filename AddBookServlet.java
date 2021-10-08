package Servlets;
import java.io.*;
import javax.servlet.*;
@SuppressWarnings("serial")
public class AddBookServlet extends GenericServlet
{
	public ServletContext sct;
	public BookBean bb;
	
	@Override 
	public void init() throws ServletException
	{
		sct=this.getServletContext();
		bb=new BookBean();
	}
	
	@Override
	public void service(ServletRequest req,ServletResponse res) throws ServletException,IOException
	{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		
		String bcode=req.getParameter("bcode");
		String bname=req.getParameter("bname");
		String bauthor=req.getParameter("bauthor");
		Float bprice=Float.parseFloat(req.getParameter("bprice"));
		Integer bqty=Integer.parseInt(req.getParameter("bqty"));
		String fname=(String)sct.getAttribute("fname");
		
		bb.setBcode(bcode);
		bb.setBauthor(bauthor);
		bb.setBname(bname);
		bb.setBprice(bprice);
		bb.setBqty(bqty);
		
		pw.println("Welcome Admin:"+fname+"<br>");
		
		RequestDispatcher rd=req.getRequestDispatcher("link1.html");
		rd.include(req, res);
		
		AddBookDAO ad=new AddBookDAO();
		int r=ad.addbook(bb);
		if(r>0)
		{
			pw.println("<br>Books Added Successfully");
		}
		
	}
}
