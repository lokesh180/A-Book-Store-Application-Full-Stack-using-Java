package Servlets;
import java.sql.*;
public class UpdateDAO 
{
	public int z;
	public int update(String bcode,String bname,String bauthor,float bprice,int bqty)
	{
		try
		{
			Connection con=DBConnection.getcon();
	        PreparedStatement ps=con.prepareStatement("update Book20 set bname=?,bauthor=?,bprice=?,bqty=? where bcode=?");
	        ps.setString(1,bname);
			ps.setString(2,bauthor);
			ps.setFloat(3, bprice);
			ps.setInt(4, bqty);
			ps.setString(5, bcode);
			z=ps.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return z;
	}

}
