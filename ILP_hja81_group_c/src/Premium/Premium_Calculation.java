package Premium;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Premium_Calculation
{
	private String driver="oracle.jdbc.OracleDriver";
	private String url="jdbc:oracle:thin:@172.25.192.71:1521:javadb";
	//private String url="jdbc:oracle:thin:@localhost:1521:XE";
	private String uname="HJA81ORAUSER3D";
	//private String uname="system";
	private String pwd="tcshyd";
 Connection con=null;
	
 public double premiumCalculation(int proposalID)
	{
		 double premium_amount=0;
         int age_comp = 0;
         int gender_comp=0;
         int occupation_comp=0;
         int govt_tax=0;
         double total_premium = 0;
         double total_premium_1 = 0;
int cust_id=0;
         double sum_insured = 0;   //to be taken from table
         double no_of_years = 0;  //to be taken from table
         //String insurance_type=null;
     
         
    ArrayList<Double> t_amount1=new ArrayList<Double>();
	ArrayList<Customer> customer=new ArrayList<Customer>();

	
	try
	{
		Class.forName(driver);
		con=DriverManager.getConnection(url,uname,pwd);
		
          
		PreparedStatement pstp=con.prepareStatement("select custid from createproposal_test1 where proposalId="+proposalID+"");
		
ResultSet rsp=pstp.executeQuery();
while(rsp.next())
{
	cust_id=rsp.getInt("custid");
}
PreparedStatement pst=con.prepareStatement("select * from TBL_CUSTOMER_hja81_2 where cust_id="+cust_id+"");
		ResultSet rs=pst.executeQuery();
		
		
		
		//setting customer object and arraylist
		while(rs.next())
		{
			Customer cust=new Customer();
			cust.setCustomer_id(rs.getInt("CUST_ID"));
			cust.setCustomer_Name(rs.getString("CUST_NAME"));
			cust.setCustomer_age(rs.getInt("CUST_AGE"));
			cust.setCustomer_Type(rs.getString("CUST_TYPE"));
			cust.setCustomer_Occupation(rs.getString("OCCUPATION"));
			cust.setCustomer_Gender(rs.getString("GENDER"));
			cust.setCustomer_address(rs.getString("ADDRESS"));
			cust.setCustomer_City(rs.getString("CITY"));
			cust.setCustomer_State(rs.getString("STATE"));
			cust.setCustomer_Zipcode(rs.getLong("ZIP"));
			cust.setCustomer_PhoneNumber(rs.getLong("PHONE_NUMER"));
			
			customer.add(cust);
			
			System.out.println("cust aaded"+customer.size());
			
			PreparedStatement pst1=con.prepareStatement("select * from rules where insurance_type=(select cust_type from tbl_customer_hja81_2 where cust_id="+cust.getCustomer_id()+")");
					
			ResultSet rs1=pst1.executeQuery();
			while(rs1.next())
			{
				
			
					
					if(cust.getCustomer_age()>80)
						{age_comp=rs1.getInt(2);
					System.out.println("age comp"+age_comp);}
					else if(cust.getCustomer_age()>60&&cust.getCustomer_age()<=80)
						age_comp=rs1.getInt(3);
					else if(cust.getCustomer_age()>40&&cust.getCustomer_age()<=60)
						age_comp=rs1.getInt(4);
					else if(cust.getCustomer_age()<=40)
						age_comp=rs1.getInt(5);
					
					govt_tax=rs1.getInt(6);
					System.out.println("govt tax"+govt_tax);

					//premium calculation
			/* ###################################################################################### */		
					if(cust.getCustomer_Type().equalsIgnoreCase("individual"))
					{
						PreparedStatement pst2=con.prepareStatement("select * from createproposal_test1 where custid=(select cust_id from tbl_customer_hja81_2 where cust_type='individual' and cust_id="+cust.getCustomer_id()+")");
						
						ResultSet rs3=pst2.executeQuery();
						
						while(rs3.next())
						{
							sum_insured=rs3.getDouble("sum_insured");
							no_of_years=rs3.getInt("noofyears");
							System.out.println(no_of_years);

						}
						if(cust.getCustomer_Occupation().equalsIgnoreCase("mining"))
						{
							occupation_comp=rs1.getInt(9);
							System.out.println("oc"+occupation_comp);
						}
						
							else
							{	occupation_comp=rs1.getInt(10);
						System.out.println("oc"+occupation_comp);
							}
						if(cust.getCustomer_Gender().equalsIgnoreCase("male"))
							{
							gender_comp=rs1.getInt(7);
						System.out.println("gender"+gender_comp);}
							else
								gender_comp=rs1.getInt(8);
						
						
						
						if(no_of_years<5)
						{
							System.out.println("gsdrtgr");
							System.out.println("values passed"+age_comp+""+gender_comp+""+occupation_comp+""+govt_tax);

							premium_amount=sum_insured/(no_of_years*12);
							total_premium=premium_amount+((premium_amount*age_comp)/100)+((premium_amount*gender_comp)/100)
							     +((premium_amount*occupation_comp)/100)+((premium_amount*govt_tax)/100);
							total_premium_1=Math.round(total_premium*1000.0)/1000.0;
							
							t_amount1.add(total_premium_1);
							
							
							
							System.out.println("no of yrs<5 added in list"+total_premium+"size"+t_amount1.size());
							
							PreparedStatement pst5=con.prepareStatement("select * from createproposal_test1 where custid=(select cust_id from tbl_customer_hja81_2 where cust_type='individual' and cust_id="+cust.getCustomer_id()+")");
							
							ResultSet rs11=pst5.executeQuery();
							
							
							
							PreparedStatement pst6=con.prepareStatement("insert into project_table_3 values(?,?,?,?,?,?,?,?,?,?)");
							
							while(rs11.next())
							{
							pst6.setInt(1, rs11.getInt("proposalId"))  ;
							  pst6.setInt(2, rs11.getInt("custid")); 
							   pst6.setString(3,rs11.getString("Insurance_Type")); 
							  pst6.setDouble(4,rs11.getDouble("sum_insured")); 
							    pst6.setInt(5,rs11.getInt("noofyears")); 
							 pst6.setString(6,rs11.getString("insuranceproduct"));
							  pst6.setString(7,rs11.getString("refered_by")); 
							  pst6.setDouble(8,total_premium_1); 
							  pst6.setString(9,"null"); 
							  pst6.setString(10,"null"); 

								pst6.executeUpdate();

							}
							
							
					    }
						
						else
						{
							premium_amount=sum_insured/(no_of_years*12);
							  total_premium=premium_amount+((premium_amount*govt_tax)/100);
							  total_premium_1=Math.round(total_premium*1000.0)/1000.0;
								
								t_amount1.add(total_premium_1);
							  
							  
								System.out.println("no of yrs>5 added in list"+total_premium_1+"size"+t_amount1.size());

								PreparedStatement pst5=con.prepareStatement("select * from createproposal_test1 where custid=(select cust_id from tbl_customer_hja81_2 where cust_type='individual' and cust_id="+cust.getCustomer_id()+")");
								
								ResultSet rs11=pst5.executeQuery();
								
								
								
								PreparedStatement pst6=con.prepareStatement("insert into project_table_3 values(?,?,?,?,?,?,?,?,?,?)");
								
								while(rs11.next())
								{
								pst6.setInt(1, rs11.getInt("proposalId"))  ;
								  pst6.setInt(2, rs11.getInt("custid")); 
								   pst6.setString(3,rs11.getString("Insurance_Type")); 
								  pst6.setDouble(4,rs11.getDouble("sum_insured")); 
								    pst6.setInt(5,rs11.getInt("noofyears")); 
								 pst6.setString(6,rs11.getString("insuranceproduct"));
								  pst6.setString(7,rs11.getString("refered_by")); 
								  pst6.setDouble(8,total_premium_1); 
								  pst6.setString(9,"null"); 
								  pst6.setString(10,"null"); 
									pst6.executeUpdate();

								}
								

								
						}

							
						
						
						
						
						
						
					}
		/*########################################################################################*/
		else if(cust.getCustomer_Type().equalsIgnoreCase("group"))
					{
			
			PreparedStatement pst2=con.prepareStatement("select * from createproposal_test1 where custid=(select cust_id from tbl_customer_hja81_2 where cust_type='group' and cust_id="+cust.getCustomer_id()+")");
			
			ResultSet rs3=pst2.executeQuery();
			
			while(rs3.next())
			{
				System.out.println(rs3.getInt("proposalId"));
				System.out.println(rs3.getInt("noofyears"));

				sum_insured=rs3.getDouble("sum_insured");
				no_of_years=rs3.getInt("noofyears");
			}
						if(cust.getCustomer_Occupation().equalsIgnoreCase("mining"))
							occupation_comp=rs1.getInt(9);
						
							else
							{	occupation_comp=rs1.getInt(10);
						System.out.println("oc"+occupation_comp);
							}
						if(cust.getCustomer_Gender().equalsIgnoreCase("male"))
							{
							gender_comp=rs1.getInt(7);
						System.out.println("gender"+gender_comp);
						   }
							else
								gender_comp=rs1.getInt(8);
						
						
						
						
						System.out.println("in group");
							if(no_of_years<5)
							{
							premium_amount=sum_insured/(no_of_years*12);
							total_premium=premium_amount+((premium_amount*age_comp)/100)+((premium_amount*govt_tax)/100);
                       total_premium_1=Math.round(total_premium*1000.0)/1000.0;
							
							t_amount1.add(total_premium_1);
								System.out.println("in else of group 22"+"size"+t_amount1.size());
								
								
PreparedStatement pst5=con.prepareStatement("select * from createproposal_test1 where custid=(select cust_id from tbl_customer_hja81_2 where cust_type='group' and cust_id="+cust.getCustomer_id()+")");
								
								ResultSet rs11=pst5.executeQuery();
								
								
								
								PreparedStatement pst6=con.prepareStatement("insert into project_table_3 values(?,?,?,?,?,?,?,?,?,?)");
								
								while(rs11.next())
								{
								pst6.setInt(1, rs11.getInt("proposalId"))  ;
								  pst6.setInt(2, rs11.getInt("custid")); 
								   pst6.setString(3,rs11.getString("Insurance_Type")); 
								  pst6.setDouble(4,rs11.getDouble("sum_insured")); 
								    pst6.setInt(5,rs11.getInt("noofyears")); 
								 pst6.setString(6,rs11.getString("insuranceproduct"));
								  pst6.setString(7,rs11.getString("refered_by")); 
								  pst6.setDouble(8,total_premium_1); 
								  pst6.setString(9,"null"); 
								  pst6.setString(10,"null"); 
									pst6.executeUpdate();

								}
								
							}
							else
							{ 
								
								System.out.println("in else of group"+"size"+t_amount1.size());
								
								premium_amount=sum_insured/(no_of_years*12);
							  total_premium=premium_amount+((premium_amount*govt_tax)/100);
							  total_premium_1=Math.round(total_premium*1000.0)/1000.0;
								
								t_amount1.add(total_premium_1); 
PreparedStatement pst5=con.prepareStatement("select * from createproposal_test1 where custid=(select cust_id from tbl_customer_hja81_2 where cust_type='group' and cust_id="+cust.getCustomer_id()+")");
								
								ResultSet rs11=pst5.executeQuery();
								
								
								
								PreparedStatement pst6=con.prepareStatement("insert into project_table_3 values(?,?,?,?,?,?,?,?,?,?)");
								
								while(rs11.next())
								{
								pst6.setInt(1, rs11.getInt("proposalId"))  ;
								  pst6.setInt(2, rs11.getInt("custid")); 
								   pst6.setString(3,rs11.getString("Insurance_Type")); 
								  pst6.setDouble(4,rs11.getDouble("sum_insured")); 
								    pst6.setInt(5,rs11.getInt("noofyears")); 
								 pst6.setString(6,rs11.getString("insuranceproduct"));
								  pst6.setString(7,rs11.getString("refered_by")); 
								  pst6.setDouble(8,total_premium_1); 
								  pst6.setString(9,"null"); 
								  pst6.setString(10,"null"); 
									pst6.executeUpdate();

								}
								

							}
							
							
						}
					
					
		else if(cust.getCustomer_Type().equalsIgnoreCase("family"))
		{
			PreparedStatement pst2=con.prepareStatement("select * from createproposal_test1 where custid=(select cust_id from tbl_customer_hja81_2 where cust_type='family' and cust_id="+cust.getCustomer_id()+")");
			
			ResultSet rs3=pst2.executeQuery();
			
			while(rs3.next())
			{
				sum_insured=rs3.getDouble("sum_insured");
				no_of_years=rs3.getInt("noofyears");
			
			}
			
			if(cust.getCustomer_Occupation().equalsIgnoreCase("mining"))
				occupation_comp=rs1.getInt(9);
			
				else
				{	occupation_comp=rs1.getInt(10);
			System.out.println("oc"+occupation_comp);
				}
			if(cust.getCustomer_Gender().equalsIgnoreCase("male"))
				{
				gender_comp=rs1.getInt(7);
			System.out.println("gender"+gender_comp);
			   }
				else
					gender_comp=rs1.getInt(8);
			
			
			
			
			System.out.println("in family");
				if(no_of_years<5)
				{
				premium_amount=sum_insured/(no_of_years*12);
				total_premium=premium_amount+((premium_amount*age_comp)/100)+((premium_amount*govt_tax)/100);
				total_premium_1=Math.round(total_premium*1000.0)/1000.0;
				
				t_amount1.add(total_premium_1);
					System.out.println("in if of fam"+"size"+t_amount1.size());
					
					PreparedStatement pst5=con.prepareStatement("select * from createproposal_test1 where custid=(select cust_id from tbl_customer_hja81_2 where cust_type='family' and cust_id="+cust.getCustomer_id()+")");
					
					ResultSet rs11=pst5.executeQuery();
					
					
					
					PreparedStatement pst6=con.prepareStatement("insert into project_table_3 values(?,?,?,?,?,?,?,?,?,?)");
					
					while(rs11.next())
					{
					pst6.setInt(1, rs11.getInt("proposalId"))  ;
					  pst6.setInt(2, rs11.getInt("custid")); 
					   pst6.setString(3,rs11.getString("Insurance_Type")); 
					  pst6.setDouble(4,rs11.getDouble("sum_insured")); 
					    pst6.setInt(5,rs11.getInt("noofyears")); 
					 pst6.setString(6,rs11.getString("insuranceproduct"));
					  pst6.setString(7,rs11.getString("refered_by")); 
					  pst6.setDouble(8,total_premium_1); 
					  pst6.setString(9,"null"); 
					  pst6.setString(10,"null"); 
						pst6.executeUpdate();

					}
					


			 
				}
				else
				{ 
					
					System.out.println("in else of fam"+"size"+t_amount1.size());
					
					premium_amount=sum_insured/(no_of_years*12);
				  total_premium=premium_amount+((premium_amount*govt_tax)/100);
				  total_premium_1=Math.round(total_premium*1000.0)/1000.0;
					
					t_amount1.add(total_premium_1);	 
					PreparedStatement pst5=con.prepareStatement("select * from createproposal_test1 where custid=(select cust_id from tbl_customer_hja81_2 where cust_type='group' and cust_id="+cust.getCustomer_id()+")");
					
					ResultSet rs11=pst5.executeQuery();
					
					
					
					PreparedStatement pst6=con.prepareStatement("insert into project_table_3 values(?,?,?,?,?,?,?,?,?,?)");
					
					while(rs11.next())
					{
					pst6.setInt(1, rs11.getInt("proposalId"))  ;
					  pst6.setInt(2, rs11.getInt("custid")); 
					   pst6.setString(3,rs11.getString("Insurance_Type")); 
					  pst6.setDouble(4,rs11.getDouble("sum_insured")); 
					    pst6.setInt(5,rs11.getInt("noofyears")); 
					 pst6.setString(6,rs11.getString("insuranceproduct"));
					  pst6.setString(7,rs11.getString("refered_by")); 
					  pst6.setDouble(8,total_premium_1); 
					  pst6.setString(9,"null"); 
					  pst6.setString(10,"null"); 
						pst6.executeUpdate();

					}
					


				}
				
				
			}
		}	
					}
					
					

					
				
					
			
			
		System.out.println("Array size"+customer.size());
		
		
		
		
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
		
		return total_premium_1;
}
	
	public static void main(String[] args)   
	{
		Premium_Calculation pc=new Premium_Calculation();
		
		
		double al=0;
		al=pc.premiumCalculation(11);
		
			System.out.println(al);
		
		
	}
	
}
	
	
	


