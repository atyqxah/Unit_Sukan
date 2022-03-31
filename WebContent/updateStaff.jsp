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
<center><h3><b><img class="logo" src="uitm.jpg" height="50px" width="50px">&nbsp;UPDATE STAFF</b></h3></center>
</div><br> 
<!-- /.col-lg-12 -->
</div>






<!-- /.row -->
<div class="row">
<div class="col-lg-12">
<div class="panel panel-default">
<div class="panel-heading">Update Staff</div>
<div class="panel-body">

                            <div class="row">
                                <div class="col-lg-12">
                                    <form role="form" action="updateStaffController" method="post">
                           				
										<div class="form-group">
                                            <img src='avatar.png' width='70' length='70' >
                                        </div>
                                        <div class="form-group">
                                            <label>ID</label>
                                            <input class="form-control" name='staffID'  value="<%=staffID %>" readonly>
                                        </div>
                                  		<div class="form-group">
                                            <label>Password</label>
                                            <input class="form-control" name='staffPassword' value="<%=s.getStaffPassword()%>" readonly>
                                        </div>
                                        <div class="form-group">
                                            <label>Name</label>
                                            <input class="form-control" name='staffName' value="<%=s.getStaffName()%>"  readonly>
                                        </div>
                                        <div class="form-group">
                                            <label>Contact Number</label>
                                            <input class="form-control" type='text' name='staffContact' value="<%=s.getStaffContact()%>" readonly>
                                        </div>
                                        <div class="form-group">
                                                <label>Email</label>
                                                <input class="form-control" type='email' name='staffEmail' value="<%=s.getStaffEmail()%>" readonly>
                                        </div>
                                         <div class="form-group">
                                                <label>Role</label>
                                                <input class="form-control" name='staffRole' value="<%=s.getStaffRole()%>" readonly>
                                        </div>
                                        <div class="form-group">
                                        <%String status="";
                                        status=s.getStaffStatus();
                                        %>                                        
                                        <label>Status</label>
                                        <select id="type" name="staffStatus" class='form-control'>
                                        <option value="active" <%if(status.equals("active")){ %>selected<% }%>>active</option>
												<option value="unactive" <%if(status.equals("unactive")){ %>selected<% }%>>unactive</option>
                                        </select>
                                            
                                            
                                        </div>
                                        
                                  
                                        <input class="btn btn-primary btn-lg btn-block" type="submit" value="Update Staff" onclick="return confirm('Update this staff?')">
										
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