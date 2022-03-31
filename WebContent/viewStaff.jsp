<jsp:include page="body.jsp" />

        
        <!-- /#page-wrapper -->
		<div id="page-wrapper"><br><!--~include all file that called-->
<%@ page import="us.model.*, us.DAO.*, java.sql.*, java.util.*" %>
<% 
	String staffID = (request.getParameter("staffID"));	
	staff s = staffDAO.getStaffById(staffID);
	%>

<div class="row">
<div class="panel panel-inverse" style="box-shadow:0px 0px 0px 0px; background-color:#94b8b8;">
<center><h3><b><img class="logo" src="uitm.jpg" height="50px" width="50px">&nbsp;STAFF</b></h3></center>
</div><br> 
<!-- /.col-lg-12 -->
</div>
<!-- /.row -->
<div class="row">
<div class="col-lg-12">
<div class="panel panel-default">
<div class="panel-heading">View Staff</div>
<div class="panel-body">

                            <div class="row">
                                <div class="col-lg-12">
                                    <form role="form">
                           				
										<div class="form-group">
                                            <img src='avatar.png' width='70' length='70' >
                                        </div>
                                        <div class="form-group">
                                            <label>ID</label>
                                            <input class="form-control" name='productCode'  value=" <%= staffID %>" disabled>
                                        </div>
                                  
                                        <div class="form-group">
                                            <label>Name</label>
                                            <input class="form-control" name='butiran' value=" <%= s.getStaffName() %>"  disabled>
                                        </div>
                                        <div class="form-group">
                                            <label>Contact Number</label>
                                            <input class="form-control" type='text' value=" <%= s.getStaffContact() %>"  disabled>
                                        </div>
                                        <div class="form-group">
                                                <label>Email</label>
                                                <input class="form-control" value="<%= s.getStaffEmail() %>"  disabled>
                                        </div>
                                         <div class="form-group">
                                                <label for="unit">Role</label>
                                                <input class="form-control" value=" <%= s.getStaffRole() %>"  disabled>
                                        </div>
                                        <div class="form-group">
                                            <label>Status</label>
                                            <input class="form-control" value=" <%= s.getStaffStatus() %>"  disabled>
                                        </div>
										
                                        </div>
                                        
										<i align='right'><a href='listStaff.jsp'><span class="fa fa-edit"></span>&nbsp;&nbsp;Staff List</a></i>
                                    </form>
</div>
     <!-- /.col-lg-6 (nested) -->                       
        </div>
                            <!-- /.row (nested) -->
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
		
        </div>
         <!--footer-->
           <jsp:include page="footer.jsp" />