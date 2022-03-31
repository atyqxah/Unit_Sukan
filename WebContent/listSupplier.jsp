<jsp:include page="body.jsp" />

        
        <!-- /#page-wrapper -->
		<div id="page-wrapper"><br><!--~include all file that called-->
    <%@ page import="us.model.*, us.DAO.*, java.sql.*, java.util.*" %>
        <% List<supplier> Lsup = supplierDAO.getAllSupplier();%>
        
 <div class="row">
                <div class="panel panel-inverse" style="box-shadow:0px 0px 0px 0px; background-color:#94b8b8;">
                <center>
                    <h3><b><img class="logo" src="uitm.jpg" height="50px" width="50px">&nbsp;SENARAI PEMBEKAL</b></h3>
                </center>
            </div><br> 
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    
                    
        <div class="panel-body">
        <table method="POST" width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example">

                <thead>
                <tr>
    <th>SUPPLIER ID</th>
    <th>SUPPLIER NAME</th>
    <th>EMAIL</th>
    <th>CONTACT NUMBER</th>
     <th>COMPANY ADDRESS</th>
     <th>Actions</th> 
  </tr>
                </thead>
                
            <tbody>
            <%String role=(String)session.getAttribute("role"); %>
            
            <% for(supplier it:Lsup){%>
  <tr>
    <td><%= it.getSupid() %></td>
    <td><%= it.getSupname() %></td>
    <td><%= it.getSupemail() %></td>
    <td><%= it.getSupcontact() %></td>
    <td><%= it.getSupaddress() %></td>
 
              
                        <td name="error"><center>
                            <div class="dropdown">
                                <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">
                                <div class="fa fa-list"></div>&nbsp;<span class="caret"></span></button>
                                <ul class="dropdown-menu pull-right">
                                  <li><a href="viewSupplierController?action=viewSupplier&supid=<%=it.getSupid()%>"><span class="fa fa-list"></span>&nbsp;&nbsp;View</a></li>
                                  <li><a href="viewUpdateSupplierController?action=viewUpdateSupplier&supid=<%=it.getSupid()%>" onclick="return confirm('Update?')"><span class="fa fa-edit"></span>&nbsp;&nbsp;Update</a></li>
                                  <%if(role.equals("admin")){ %>  
                                  <li><a href="deleteSupplierController?action=delete&supid=<%=it.getSupid()%>" onclick="return confirm('Adakah anda pasti ingin padam ini?')"><span class="fa fa-trash"></span>&nbsp;&nbsp;Delete</a></li>
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