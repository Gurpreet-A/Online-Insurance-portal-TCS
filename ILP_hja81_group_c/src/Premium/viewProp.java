package Premium;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class viewProp 
{
	private String driver="oracle.jdbc.OracleDriver";
	private String url="jdbc:oracle:thin:@172.25.192.71:1521:javadb";
	//private String url="jdbc:oracle:thin:@localhost:1521:XE";
	private String uname="HJA81ORAUSER3D";
	//private String uname="system";
	private String pwd="tcshyd";
 Connection con=null;
	 
 public int setApproved(int id)
 { 
	 int i=0;
	 
 try
 {
	 Class.forName(driver);
		con=DriverManager.getConnection(url,uname,pwd);
		
		
		PreparedStatement pst1=con.prepareStatement(" update project_table_3 set status='approved' where proposalID="+id+"");
		 i=pst1.executeUpdate();
		
	 
	 
 }
 catch(Exception e)
	{
		System.out.println("exception me");
		e.printStackTrace();
	}
	
	finally
	{
		if(con!=null){
			try{
				con.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	
	}	
		
	return i;
 
 }

public int genQuote(int id1)
{
	try
	 {
		System.out.println("inside quote gen");
		 Class.forName(driver);
			con=DriverManager.getConnection(url,uname,pwd);
			PreparedStatement pst1=con.prepareStatement("update  project_table_3 set quote='generated' where status='approved' and proposalID="+id1+" ");
	      pst1.executeUpdate();
	      
	
}
	 catch(Exception e)
		{
			System.out.println("exception me");
			e.printStackTrace();
		}
		
		finally
		{
			if(con!=null){
				try{
					con.close();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		
		}
	return 0;

	
}

public int setReject(int id) 
{
	 int i=0;
	 
try
{
	 Class.forName(driver);
		con=DriverManager.getConnection(url,uname,pwd);
		
		
		PreparedStatement pst1=con.prepareStatement(" update project_table_3 set status='Rejected' where proposalID="+id+"");
		 i=pst1.executeUpdate();
		
	 
	 
}
catch(Exception e)
	{
		System.out.println("exception me");
		e.printStackTrace();
	}
	
	finally
	{
		if(con!=null){
			try{
				con.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	
	}	
		
	return i;


	
}

}
