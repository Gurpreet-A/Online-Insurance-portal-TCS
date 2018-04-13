package Broker;


	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
import java.util.ArrayList;



	public class BrokerDAO {
	
		public int AddBroker(Broker broker) throws Exception{
			
			int broker_id = 0;
			Connection conn = DBUtil.getDBConnection();
			PreparedStatement ps1=null;
			PreparedStatement ps2=null;
			
			ResultSet rs = null;
			
		//	PreparedStatement pst=conn.prepareStatement("select sum_insured from project_table_3 ")
			
			
			ps1 = conn.prepareStatement("insert into broker_table_1 values(broker_seq1.nextval,?,?,?,?,?,?,?)");
			try{
			ps1.setString(1,broker.getName());
			ps1.setString(2, broker.getAddress());
			ps1.setString(3, broker.getCity());
			ps1.setString(4, broker.getState());
			ps1.setLong(5,broker.getZipcode());
			ps1.setLong(6, broker.getPhonenumber());
			ps1.setInt(7,broker.getBrokerage_Points());
			broker_id = ps1.executeUpdate();
			
			
			}

			catch (SQLException e)
			{
				System.out.println("Exception occured while performing create broker operation");
				e.printStackTrace();
			}
			finally{
				//DBUtil.closeResultSet(rs);
				//DBUtil.closeStatement(ps1);
				//DBUtil.closeStatement(ps2);
				DBUtil.closeConnection(conn);	
			}
			
			return broker_id;
			
		}

		
		

	}

	
	
	
	
	
	
	

