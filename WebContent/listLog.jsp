
<jsp:include page="body.jsp" /> 
        
        <!-- /#page-wrapper -->
		<div id="page-wrapper"><br><!--~include all file that called-->
		<%@ page import="us.model.*, us.DAO.*, java.sql.*, java.util.*" %>
       <% List<inventory> Linventory = inventoryDAO.getAllInventory();%>
    
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
                <thead>
                <tr>
 
    <th>STAFF ID</th>
    <th>PRODUCT CODE</th>
     <th>SUPPLIER ID</th>
    <th>DATE</th>
  </tr>
                </thead>
                
            <tbody>
          
            <% for(inventory it:Linventory){%>
  <tr>
    <td><%= it.getStaffID() %></td>
    <td><%= it.getProductCode() %></td>
    <td><%= it.getSupID() %></td>
    <td><%= it.getLatestDate() %></td>
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