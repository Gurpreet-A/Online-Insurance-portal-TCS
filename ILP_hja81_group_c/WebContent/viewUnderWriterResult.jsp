<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
<div class="success">Done Successfully
 </div>

<div class="warning">Premium Updated Successfully</div>
<script>
$(document).ready(function(){
if($("#1").val()=="genPrem")
{	
  $(".success").show();
 
  $(".warning").hide();
  $(".error").hide();
}

if($("#1").val()=="genQuote")
{	
  $(".success").show();

  $(".warning").hide();
  $(".error").hide();
}
if($("#1").val()=="UpdatePrem")
{	
  $(".success").hide();

  $(".warning").show();
  $(".error").hide();
}   
    
   
    
});

</script>

	</head>
	<body>
	<%String result=request.getAttribute("res").toString();
	
	%>
	<input type="hidden" name="result" value="<%=result %>" id="1">
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

            <table class="">
              <thead>
                <tr>
                  <th></th>
                  <th></th>
                  <th></th>
                  <th></th>
                  <th></th>
                </tr>
              </thead>
              <tbody>
                <tr>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                </tr>
                <tr>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                </tr>
                <tr>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                </tr>
              </tbody>
            </table>
          </div>

     
          
      </div><!--/row-->
	</div>
	
	
	
	
</div><!--/.container-->

<footer>
  <p class="pull-right">©2015 TCS</p>
</footer>
        
	<!-- script references -->
		<script src="//ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
		<script src="js/bootstrap.min.js"></script>
		<script src="js/scripts.js"></script>
	</body>
</html>