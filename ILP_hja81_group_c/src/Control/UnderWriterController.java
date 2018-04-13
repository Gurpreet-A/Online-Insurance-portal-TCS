package Control;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Premium.Premium_Calculation;
import Premium.viewProp;

/**
 * Servlet implementation class UnderWriterController
 */
public class UnderWriterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UnderWriterController() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		double amt=0;
		Connection con=null;
	
		String name=null;
		int bp=0;
		
		// TODO Auto-generated method stub
		viewProp vp=new viewProp();

		String action=request.getParameter("action");
		if(action.equals("generatePremium"))
		{
		int id2=Integer.parseInt(request.getParameter("proposal"));
		Premium_Calculation pc=new Premium_Calculation();
		double prem_amount=pc.premiumCalculation(id2);
		System.out.println("premCalculated"+prem_amount);
		String res="genPrem";
		System.out.println(res);

		request.setAttribute("res", res);
		RequestDispatcher rd=request.getRequestDispatcher("viewUnderWriterResult.jsp");
		rd.forward(request, response);
		}
		
		else if(action.equals("generateQuote"))
		{
		int id1=Integer.parseInt(request.getParameter("propID"));
		int gen=vp.genQuote(id1);
		
		try
		{
			 Class.forName("oracle.jdbc.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@172.25.192.71:1521:javadb","HJA81ORAUSER3D","tcshyd");
				
				
				PreparedStatement pst1=con.prepareStatement("select refered_by,sum_insured from project_table_3 where proposalId="+id1+" and refered_by=(Select name from broker_table_1)"+"");
				ResultSet rs=pst1.executeQuery();
				while(rs.next())
				{
				amt=rs.getDouble("sum_insured");
				name=rs.getString("refered_by");
				System.out.println(name);
				}
				PreparedStatement pst2=con.prepareStatement("select brokerage_points from broker_table_1 where name=?");
				pst2.setString(1, name);
				ResultSet rs7=pst2.executeQuery();
				while(rs7.next())
				{
					bp=rs7.getInt("brokerage_points");
					System.out.println(bp);
					
					if(amt>1000000)
					{
						bp=bp+500;
					}
					if(amt>=100000&&amt<=1000000)
					{
						bp=bp+350;
					}
					if(amt<100000)
					{
						bp=bp+100;
					}
					
				}	System.out.println(bp);
				PreparedStatement pst3=con.prepareStatement("update broker_table_1 set brokerage_points=? where name= ?");
				pst3.setInt(1,bp);
				pst3.setString(2, name);
				
				
				pst3.executeUpdate();
				
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
		String res="genQuote";
		System.out.println(res);

		request.setAttribute("res", res);
		RequestDispatcher rd=request.getRequestDispatcher("viewUnderWriterResult.jsp");
		rd.forward(request, response);
				
		}
		
		else if(action.equals("UpdatePremium"))
				{
			int id2=Integer.parseInt(request.getParameter("propID"));
			
			try
			{
				 Class.forName("oracle.jdbc.OracleDriver");
				con=DriverManager.getConnection("jdbc:oracle:thin:@172.25.192.71:1521:javadb","HJA81ORAUSER3D","tcshyd");
					
					
					PreparedStatement pst1=con.prepareStatement(" select premium_amount from project_table_3 where proposalID="+id2+"");
					
					
					ResultSet rs=pst1.executeQuery();
					while(rs.next())
					{
					amt=rs.getDouble("premium_amount");
					amt=amt-(0.05*amt);
					System.out.println(amt);
					}
					PreparedStatement pst2=con.prepareStatement(" update table project_table_3 set premium_amount="+amt+" where proposalID="+id2+"");
					pst2.executeUpdate();
					
				 
				 
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
			String res2="UpdatePrem";
			System.out.println(res2);
			request.setAttribute("res", res2);
			RequestDispatcher rd=request.getRequestDispatcher("viewUnderWriterResult.jsp");
			rd.forward(request, response);
				}
		
	}

}
