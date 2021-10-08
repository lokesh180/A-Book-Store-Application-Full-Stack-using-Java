package Servlets;
import java.sql.*;
public class AddBookDAO
{
	public int z;
	public int addbook(BookBean bb)
	{
		try
		{
			Connection con=DBConnection.getcon();
			PreparedStatement ps=con.prepareStatement("insert into Book20 values(?,?,?,?,?)");
			ps.setString(1,bb.getBcode());
			ps.setString(2, bb.getBname());
			ps.setString(3, bb.getBauthor());
			ps.setFloat(4, bb.getBprice());
			ps.setInt(5, bb.getBqty());
			z=ps.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return z;
		
	}

}
