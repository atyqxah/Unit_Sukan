
<jsp:include page="body.jsp" /> 
        
        <!-- /#page-wrapper -->
		<div id="page-wrapper"><br><!--~include all file that called-->
		<%@ page import="us.model.*, us.DAO.*, java.sql.*, java.util.*" %>
       <% List<staff> Lstaff = staffDAO.getAllStaff();%>
    
 <div class="row">
                <div class="panel panel-inverse" style="box-shadow:0px 0px 0px 0px; background-color:#94b8b8;">
                <center>
                    <h3><b><img class="logo" src="uitm.jpg" height="50px" width="50px">&nbsp;SENARAI STAFF</b></h3>
                </center>
            </div><br> 
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    
                 
        <div class="panel-body">
        <table method="POST" width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example">
<%String role=(String)session.getAttribute("role"); %>
                <thead>
                <tr>
    <th>STAFF ID</th>
   <%if(role.equals("admin")){ %>  <th>STAFF PASSWORD</th> <% } %>
    <th>NAME</th>
    <th>CONTACT</th>
     <th>EMAIL</th>
    <th>ROLE</th>
    <th>STATUS</th>
   <th>Actions</th>
  </tr>
                </thead>
                
            <tbody>
          
            <% for(staff it:Lstaff){%>
  <tr>
    <td><%= it.getStaffID() %></td>
    <%if(role.equals("admin")){ %> <td><%= it.getStaffPassword() %></td><% } %>
    <td><%= it.getStaffName() %></td>
    <td><%= it.getStaffContact() %></td>
    <td><%= it.getStaffEmail() %></td>
    <td><%= it.getStaffRole() %></td>
    <td><%= it.getStaffStatus() %></td>
 
              
                        <td name="error"><center>
                            <div class="dropdown">
                                <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">
                                <div class="fa fa-list"></div>&nbsp;<span class="caret"></span></button>
                                <ul class="dropdown-menu pull-right">
                                  <li><a href="viewStaffController?action=viewStaff&staffID=<%= it.getStaffID() %>"><span class="fa fa-list"></span>&nbsp;&nbsp;View</a></li>
                                  <%if(role.equals("admin")){ %> 
                                   <li><a href="viewUpdateStaffController?action=viewStaffDetail&staffID=<%= it.getStaffID() %>" onclick="return confirm('Update?')"><span class="fa fa-edit"></span>&nbsp;&nbsp;Update</a></li> 
                                                                   
                                  <li><a href="deleteStaffController?action=delete&staffID=<%= it.getStaffID() %>" onclick="return confirm('Adakah anda pasti ingin padam ini?')"><span class="fa fa-trash"></span>&nbsp;&nbsp;Delete</a></li>
                                <%} %>
                                </ul>
                              </div></center>
                        </td>
                        <%}%>
                    </tr>
                    
            
				
                
           
            </tbody>  
                            </table>
                            <!-- /.table-responsive -->
                        </div>
                        <!-- /.panel-body -->
                  
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>
		
        </div>
        
         <!--footer-->
           <jsp:include page="footer.jsp" />