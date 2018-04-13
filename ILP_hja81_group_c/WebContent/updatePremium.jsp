<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
         <%@ page import="java.io.*,java.util.*,java.sql.*"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insurance</title>
		<meta name="generator" content="Bootply" />
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
		<link href="css/bootstrap.min.css" rel="stylesheet">
		<!--[if lt IE 9]>
			<script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script>
		<![endif]-->
		<link href="css/styles.css" rel="stylesheet">
		<script type="text/javascript" src="http://code.jquery.com/jquery-1.8.2.js"></script>
<script type="text/javascript">


$(function() {
	$(".menu").hover(
	function() { $(".sub").slideToggle(400); },
	function() { $(".sub").hide(); }
	);
	});
	</script>

	</head>
	<body>
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
      <div class="container-fluid">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">Insurance</a>
        </div>
        <div class="navbar-collapse collapse">
          <ul class="nav navbar-nav navbar-right">
<li><a href="ViewProposalsUnderWriter1.jsp">Home</a></li>
            <li><a href="#">Logout</a></li>
                        
          </ul>
          <form class="navbar-form navbar-right">
            <input type="text" class="form-control" placeholder="Search...">
          </form>
        </div>
      </div>
</nav>

<div class="container-fluid">
      
      <div class="row row-offcanvas row-offcanvas-left">
        
         <div class="col-sm-3 col-md-2 sidebar-offcanvas" id="sidebar" role="navigation">
           
            <ul class="nav nav-sidebar">
              <li class="active"><a>Overview</a></li>
              <li><a href="#">Create Customer</a></li>
              <li><a href="#">Create Proposal</a></li>
              <li><a href="#">Add Claim details</a></li>
           
             <li><a href="viewPropWithoutPrem.jsp">Generate Premium</a></li>
              <li><a href="updatePremium.jsp">Update Premium</a></li>
              <li><a href="ViewProposalWithStatus.jsp">Generate Quote</a></li>
              <li><a href="ViewPolicy.jsp">Generate Policy</a></li>
            </ul>
        
        </div><!--/span-->
        

        
        <div class="col-sm-9 col-md-10 main">
          
          <!--toggle sidebar button-->
          <p class="visible-xs">
            <button type="button" class="btn btn-primary btn-xs" data-toggle="offcanvas"><i class="glyphicon glyphicon-chevron-left"></i></button>
          </p>
          
		  <h1 class="page-header">
         UnderWriter
          </h1>



<div class="proposalTable">
<form name="ViewProposalWithStatus" method="post" action="./UnderWriterController">

<table border="2">
<tr>
<td>Proposal Id</td>
<td>Customer Id</td>
<td>Insurance type</td>
<td>Sum Insured</td>
<td>Number of Years</td>
<td>Insurance Product</td>
<td>Referred By</td>
<td>Premium</td>
<td>Status</td>

</tr>
<%
Connection conn=null;
try
{
Class.forName("oracle.jdbc.OracleDriver");
String url="jdbc:oracle:thin:@172.25.192.71:1521:javadb";
String username="HJA81ORAUSER3D";
String password="tcshyd";

 conn=DriverManager.getConnection(url,username,password);
PreparedStatement pst=conn.prepareStatement("select * from project_table_3 where status='Rejected'");
ResultSet rs=pst.executeQuery();
while(rs.next())
{

%>
    <tr>
    <td><%=rs.getInt("proposalId") %> </td>
    <td><%=rs.getString("custid") %></td>
    <td><%=rs.getString("Insurance_Type") %></td>
    <td><%=rs.getDouble("sum_insured") %></td>
    <td><%=rs.getInt("noofyears") %></td>
    <td><%=rs.getString("insuranceproduct") %></td>
    <td><%=rs.getString("refered_by") %></td>
     <td><%=rs.getDouble("premium_amount") %></td>
     <td><%=rs.getString("status") %></td>
    </tr>
   
        <%

}
%>
    </table>
    <%
   
    }
catch(Exception e)
{
    e.printStackTrace();
    }

finally
{
	if(conn!=null){
		try{
			conn.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}	


%>




<table>
<tr>
<td>Enter ID</td>
<td><input type="text" name="propID" /></td>
</tr>
<tr>
<td></td>
<td><input type="submit" value="UpdatePremium" /></td>
<td><input type="hidden" value="UpdatePremium" name="action"/></td>


</tr>
	
	</table>
	</form>
	</div>
	</div>
	</div>
	</body>
	</html>