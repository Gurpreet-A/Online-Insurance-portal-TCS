

<!DOCTYPE html>
<html lang="en">
	<head>
		<meta http-equiv="content-type" content="text/html; charset=UTF-8">
		<meta charset="utf-8">
		<title>Insurance</title>
		<meta name="generator" content="Bootply" />
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
		<link href="css/bootstrap.min.css" rel="stylesheet">
		<!--[if lt IE 9]>
			<script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script>
		<![endif]-->
		<link href="css/styles.css" rel="stylesheet">
		<script type="text/javascript" src="http://code.jquery.com/jquery-1.8.2.js"></script>



<title>Add Broker</title>

<script>
function validateBroker(){
	
	var x1=document.getElementById('name').value;
	var x2=document.getElementById('address').value;
	var x3=document.getElementById('city').value;
	
    var x4=document.getElementById('state').value;
    var x5=document.getElementById('zipcode').value;
    var x6=document.getElementById('phonenumber').value;
	

	if(x1=="" || isNaN(x1)==false ||x1.length>30)
		{
		alert('Enter Name Correctly');
		
		return false;
		}
	if(x2=="" || isNaN(x2)==false || x2.length>100)
	{
	alert('Address too long');
	return false;
	}
	
	if(x3=="" ||isNaN(x3)==false || x3.length>50)
	{
	alert('Enter City correctly');
	return false;
	}
	

	

	if(x4=="" ||isNaN(x4)==false || x4.length>50)
	{
	alert('Enter State correctly');
	return false;
	}
	
	

	if(x5=="" ||isNaN(x5)==true || x5.length>10)
	{
	alert('Enter ZipCode correctly');
	return false;
	}
	
	

	if(x6=="" ||isNaN(x6)==true || x6.length>10)
	{
	alert('enter PhoneNumber correctly');
	return false;
	}
	
	
	
	
	
	
	
	
}
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
<li><a href="Admin.jsp">Home</a></li>
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
              <li><a href="AddBroker.jsp">Add Broker</a></li>
                            
            </ul>
        
        </div><!--/span-->
        

        
        <div class="col-sm-9 col-md-10 main">
          
          <!--toggle sidebar button-->
          <p class="visible-xs">
            <button type="button" class="btn btn-primary btn-xs" data-toggle="offcanvas"><i class="glyphicon glyphicon-chevron-left"></i></button>
          </p>
          
		  <h1 class="page-header">
           Admin
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



<form name="AddBroker" method="post" action="./BrokerController">
<fieldset>

<table class="tb1" border="0" align="center">
<caption>Add a Broker</caption>
<tr>
<td>Name:</td>
<td><input type="text" name="name" id="name" size=30></input></td>
</tr>

<tr>
<td>Address:</td>
<td><textarea name="address" id="address" size=100></textarea></td>
</tr>

<tr>
<td>City:</td>
<td><input type="text" name="city" id="city" size=50></input></td>
</tr>

<tr>
<td>State:</td>
<td><input type="text" name="state" id="state" size=50></input></td>
</tr>

<tr>
<td>Zipcode:</td>
<td><input type="text" name="zipcode" id="zipcode" size=10></input></td>
</tr>

<tr>
<td>Phone Number:</td>
<td><input type="text" name="phonenumber" id="phonenumber" size=10></input></td>
</tr>
<input type="hidden" value="AddBroker" name="action"></input>
<tr><td><input type="submit" value="Submit" onclick="return validateBroker()"></td></tr>
</input>
</table>
<br></br>

</fieldset>
</form>
<br></br>



<footer>
  <p class="pull-right">©2015 TCS</p>
</footer>
        
	<!-- script references -->
		<script src="//ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
		<script src="js/bootstrap.min.js"></script>
		<script src="js/scripts.js"></script>
	</body>


</body>
</html>
