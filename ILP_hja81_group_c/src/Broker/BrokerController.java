
package Broker;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BrokerController
 */
@WebServlet("/BrokerController")
public class BrokerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BrokerController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	int brokerage_points=0;
	
		// TODO Auto-generated method stub
				System.out.println("BrokerController::doPost invoked");
				
				String action=request.getParameter("action");
				System.out.println("User action received by controller "+action);
				
				
				
				if("AddBroker".equals(action))
				{
					
					Broker b= new Broker();
					b.setName(request.getParameter("name"));
					System.out.println(b.getName());
					b.setAddress(request.getParameter("address"));
					b.setCity(request.getParameter("city"));
					b.setState(request.getParameter("state"));
					b.setZipcode(Long.parseLong(request.getParameter("zipcode")));
					b.setPhonenumber(Long.parseLong(request.getParameter("phonenumber")));
					System.out.println(b.getPhonenumber());
					b.setBrokerage_Points(brokerage_points);
					System.out.println(b.getBrokerage_Points());
					BrokerService cs = new BrokerService();
					
				    int broker_id = 0;
					try {
						broker_id = cs.AddBroker(b);
						System.out.println(broker_id);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
					
					//set customer ID as an attribute which will be available to the forwarded JSP
					request.setAttribute("broker_id",broker_id);
					RequestDispatcher reqDispatcher = request.getRequestDispatcher("BrokerResult.jsp");
					reqDispatcher.forward(request, response);
					
				}
			
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}

}
