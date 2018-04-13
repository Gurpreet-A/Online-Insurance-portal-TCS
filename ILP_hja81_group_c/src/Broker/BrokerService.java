
package Broker;
import java.util.*;

public class BrokerService {


	
		
		
		public int AddBroker (Broker broker) throws Exception {
			//Connect DAO to create
			BrokerDAO brokerDAO = new BrokerDAO();
			return brokerDAO.AddBroker(broker);
			
		} 
		
		

	}

	
	
	
	
	
	
	
	

	
	
	
	
	
