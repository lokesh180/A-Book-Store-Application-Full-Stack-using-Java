package Servlets;
import java.sql.*;
public class DeleteDAO
{
	public int z;
	public int delete(String bcode)
	{
		try
		{
			Connection con=DBConnection.getcon();
	        PreparedStatement ps=con.prepareStatement("delete from Book20 where bcode=?");
	        ps.setString(1,bcode);
			z=ps.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return z;
	}

}
