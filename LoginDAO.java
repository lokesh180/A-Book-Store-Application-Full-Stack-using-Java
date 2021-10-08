package Servlets;
import java.sql.*;
import javax.servlet.*;
public class LoginDAO
{
	public boolean z;
	public boolean validate(String uname,String pword,String submit,ServletContext sct)
	{
		try
		{
			Connection con=DBConnection.getcon();
			if(submit.equals("USER LOGIN"))
			{
				PreparedStatement ps=con.prepareStatement("select * from UserReg20 where uname=? and pword=?");
				ps.setString(1, uname);
				ps.setString(2, pword);
				ResultSet rs=ps.executeQuery();
				if(rs.next())
				{
					z=true;
					sct.setAttribute("fname",rs.getString(3));
				}
			}
			else
			{
				PreparedStatement ps=con.prepareStatement("select * from Admin where uname=? and pword=?");
				ps.setString(1, uname);
				ps.setString(2, pword);
				ResultSet rs=ps.executeQuery();
				if(rs.next())
				{
					z=true;
					sct.setAttribute("fname",rs.getString(3));
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return z;
	}
}
