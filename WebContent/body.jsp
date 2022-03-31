<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
	<%
	String role="";
	String name="";
	String id="";
	if(session.getAttribute("role")!=null && session.getAttribute("role")!=null)
	{
		role = (String)session.getAttribute("role");
		name = (String)session.getAttribute("name");
		id = (String)session.getAttribute("id");
	}
	else
	{
		%>
		<script>
          alert('Invalid User!!');
          window.location='login.jsp';
        </script>
		<%
	}
	%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="style.css">
<meta charset="ISO-8859-1">
<title>U-Sports UiTM</title>
</head>



<head>

    <link rel="stylesheet" type="text/css" href="style.css">
<meta charset="ISO-8859-1">

    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <!-- Bootstrap Core CSS -->
    <link href="zzzzz/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="zzzzz/metisMenu.min.css"rel="stylesheet">

    <!-- Custom CSS -->
    <link href="zzzzz/sb-admin-2.min.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="zzzzz/font-awesome.min.css" rel="stylesheet" type="text/css">
    
    <!-- DataTables CSS -->
    <link href="zzzzz/dataTables.bootstrap.css" rel="stylesheet">


    <!-- DataTables Responsive CSS -->
    <link href="zzzzz/dataTables.responsive.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="zzzzz/sb-admin-2.min.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="zzzzz/font-awesome.min.css" rel="stylesheet" type="text/css">
	
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">

    <script type="text/javascript" language="javascript">
        $(document).ready(function(){
            $("#start_date").datepicker({
                    dateFormat: "yy-mm-dd",
                    yearRange: "-100:+100",
                    changeMonth:true,
                    changeYear:true
            });
            $("#end_date").datepicker({
                    dateFormat: "yy-mm-dd",
                    yearRange: "-100:+100",
                    changeMonth:true,
                    changeYear:true
            });
 
    });
    </script>
	</head>
	<style>
	
table {
    counter-reset: tableCount;
}
.counterCell:before {              
    content: counter(tableCount); 
    counter-increment: tableCount; 
}
th.resize {
    border: 2px solid;
    padding: 20px; 
    width: 300px;
    resize: horizontal;
    overflow: auto;
}
td{
    word-break:break-word;
}
</style>
<style>
#table1,#table2,#table3{
    font-family:"Times New Roman",Times,serif;
    text-align: center;
    font-size:11px;
}
th{
    text-align: center;
    background-color: #ffd9b3;
}
</style>
<style>
/* The message box is shown when the user clicks on the icnumber field */
#message1 {
    display:none;
    background: #f1f1f1;
    color: #000;
    position: relative;
    padding: 5px;
    margin-top: 5px;
}

#message1 p {
    padding: 5px 10px;
    font-size: 15px;
}
/* The message box is shown when the user clicks on the password field */
#message {
    display:none;
    background: #f1f1f1;
    color: #000;
    position: relative;
    padding: 5px;
    margin-top: 5px;
}

#message p {
    padding: 5px 10px;
    font-size: 15px;
}
/* Add a green text color and a checkmark when the requirements are right */
.valid {
    color: green;
}

.valid:before {
    position: relative;
    left: -5px;
    content: "✔";
}

/* Add a red text color and an "x" when the requirements are wrong */
.invalid {
    color: red;
}

.invalid:before {
    position: relative;
    left: -5px;
    content: "✖";
}

	* {padding:0; margin:0;}

a {text-decoration: none;}
li {list-style: none;}

/* Navigation STyling */

.main-nav {width: 250px; background: rgba(180,205,203,1.00);}

.main-nav a {

	text-transform: uppercase;

	letter-spacing: .2em;

	color: #FFF;

	display: block;

	padding: 10px 0 10px 20px;

	border-bottom: 1px dotted gray;

}

.main-nav a:hover {background: rgba(121,165,162,1.00);}

.main-nav-ul ul {display: none;}

.main-nav-ul li:hover ul {display: block;}



.main-nav-ul ul a:before {

	content: '\203A';

	margin-right: 20px;
}



.main-nav .sub-arrow:after {

	content: '\203A';

	float: right;

	margin-right: 20px;

	transform: rotate(90deg);

	-webkit-transform: rotate(90deg);

	-moz-transform: rotate(90deg);

}

.main-nav li:hover .sub-arrow:after {

	content: '\2039';

}
	
	.button 
{
    background-color: darkblue;
    border: darkblue;
    border-radius: 8px;
    color: white;
    padding: 5px 40px;
    text-align: left;
    text-decoration: none;
    display:inline-table;
    font-size: 13px;
    margin: 3px 9px;
    cursor: pointer;
    -webkit- transition-duration: 0.4s; /* Safari */
    transition-duration: 0.4s;
}
	
	.button1 
{
    background-color: whitesmoke; 
    color: black; 
    border: 2px solid whitesmoke;
    width: 100%;
    
}

.button1:hover 
{
    background-color: lightblue;
    color: darkblue;
    box-shadow: 0 12px 16px 0 rgba(0,0,0,0.24),0 17px 50px 0 rgba(0,0,0,0.19); 
    width: 100%; 
    
}
</style>

<body>
	
	<div id="wrapper">

        <!-- Navigation -->
        <nav class="navbar navbar-static-top" role="navigation" style="margin-bottom: 0;">
            <div class="navbar-header">
               <div class="pull-left">
                      &nbsp;&nbsp;<img class="logo" src="u-sports2.png" height="50px" width="250px">
                </div>
               <a class="navbar-brand" href="#">U-Sports <i>Inventory </i> Uitm </a>
            </div>
            <!-- /.navbar-header -->

            <ul class="nav navbar-top-links navbar-right">
                <li class="dropdown">
                     <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                    <div class="fa fa-user">&nbsp;
                    <% out.println(name); %>
                    <i class="fa fa-caret-down"></i>
                    </div></a>
                    <ul class="dropdown-menu dropdown-user">
                       
                       <li><a href="viewUpdateProfile?action=viewProfile&staffID=<%out.println(id);%>"><i class="fa fa-gear fa-fw"></i> Edit Profile</a></li>
                      <li><a href="listStaff.jsp"><i class="fa fa-list fa-fw"></i> <%out.println(role);%></a></li>
							
                        <li><a href="logout.jsp"><i class="fa fa-sign-out fa-fw"></i>Log Keluar</a>
                        </li>
                    </ul>
                    <!-- /.dropdown-user -->
                </li>
                <!-- /.dropdown -->
            </ul>
            <!-- /.navbar-top-links -->

            <div class="navbar-default sidebar" role="navigation">
                <div class="sidebar-nav navbar-collapse">
                    <ul class="main-nav-ul">
                    
						<li>
                            <a class="button button1"><span class="fa fa-list fa-fw"></span>&nbsp;Barangan<span class="sub-arrow"></span></a>                            
                                <ul class="nav nav-list">
                                   <li>
                                    <a href="listItem.jsp">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</i>&nbsp;Senarai Barang</a>
                                    </li>
                                    <li>
                                        <a href="addItem.jsp">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</i>&nbsp;Daftar Barang</a>
                                    </li>
                                </ul>                            
                        </li>
                        <li>
                            <a class="button button1"><span class="fa fa-list fa-fw"></span>&nbsp;Pembekal<span class="sub-arrow"></span></a>                            
                                <ul class="nav nav-list">
                                    <li>
                                        <a href="listSupplier.jsp">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</i>&nbsp;Senarai supplier</a>
                                    </li>
                                    <%if(role.equals("admin")){ %>
                                     <li>
                                        <a href="addSupplier.jsp">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</i>&nbsp;Daftar supplier</a>
                                    </li>
                                    <%} %>
                                </ul>                            
                        </li>
                        <li>
                            <a class="button button1"><span class="fa fa-list fa-fw"></span>&nbsp;Staff<span class="sub-arrow"></span></a>                            
                                <ul class="nav nav-list">
                                    <li>
                                    <a href="listStaff.jsp">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</i>&nbsp;Senarai Staff</a>
                                    </li>
                                    <%if(role.equals("admin")){ %>
                                    <li>
                                    <a href="addStaff.jsp">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</i>&nbsp;Daftar Staff</a>
                                    </li>
                                    <%} %>
                                    </ul></li>
                              <li>
                            <a class="button button1"><span class="fa fa-list fa-fw"></span>&nbsp;Inventory Log<span class="sub-arrow"></span></a>                            
                                <ul class="nav nav-list">
                                    <li>
                                    <a href="inventoryLog.jsp">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</i>&nbsp;Add Log</a>
                                    </li>
                                    <li>
                                    <a href="listLog.jsp">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</i>&nbsp;View Log</a>
                                    </li>
                            
                                    </ul></li>
                                    
						
						
                    </ul>
                </div>
                <!-- /.sidebar-collapse -->
            </div>
            <!-- /.navbar-static-side -->
        </nav>