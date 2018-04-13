package Broker;


	import java.sql.Connection;
	import java.sql.DriverManager;
import java.sql.SQLException;

	public class DBUtil {
		public static Connection getDBConnection() throws ClassNotFoundException, SQLException {
			Connection con = null;
			
				Class.forName("oracle.jdbc.OracleDriver");
				con = DriverManager.getConnection("jdbc:oracle:thin:@172.25.192.71:1521:javadb","HJA81ORAUSER3D","tcshyd");
			
			
			return con;
		}
	    public static void closeConnection(Connection con)
	    {
	    	if(con!=null)
	    	{
	    		try{
	    			con.close();
	    		}catch(SQLException e)
	    		{
	    			e.printStackTrace();
	    		}
	    	}
	    }
}




