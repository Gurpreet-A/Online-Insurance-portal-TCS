package Control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Premium.viewProp;

/**
 * Servlet implementation class ManagerController
 */
public class ManagerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		int id=Integer.parseInt(request.getParameter("id"));
		String status=request.getParameter("status");
		viewProp vp=new viewProp();

		if(status.equalsIgnoreCase("approve"))
		{
		int count=vp.setApproved(id);
		String s="accepted";
		System.out.println(count);
		request.setAttribute("a", s);
		RequestDispatcher rd=request.getRequestDispatcher("ViewProposalWithPremiumResult.jsp");
		rd.forward(request, response);
		}
		
		else
		{
			String s="rejected";
			
			int j=vp.setReject(id);
			request.setAttribute("a", s);
			RequestDispatcher rd=request.getRequestDispatcher("ViewProposalWithPremiumResult.jsp");
			rd.forward(request, response);
			System.out.println(j);

		}	
		
		
		
		
		
	}

}
