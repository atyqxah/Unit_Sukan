<jsp:include page="body.jsp" />

        
        <!-- /#page-wrapper -->
		<div id="page-wrapper"><br><!--~include all file that called-->
		<%@ page import="us.model.*, us.DAO.*, java.sql.*, java.util.*" %>
  
   
 <div class="row">
                <div class="panel panel-inverse" style="box-shadow:0px 0px 0px 0px; background-color:#94b8b8;">
                <center>
                    <h3><b><img class="logo" src="uitm.jpg" height="50px" width="50px">&nbsp;SENARAI PERALATAN UNIT SUKAN</b></h3>
                </center>
            </div><br> 
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    
                    <script>
	 function printContent(el){
		 var restorepage = document.body.innerHTML;
		 var printcontent = document.getElementById(el).innerHTML;
		 document.body.innerHTML = printcontent;
		 window.print();//entire document
		 document.body.innerHTML = restorepage;
	 }
	</script>
                    <% List<item> Litem = itemDAO.getAllItem();%>  
        <div class="panel-body" id="div1">
        <table method="POST" width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example">

                <thead>
                <tr>
    <th>Product Code</th>
    <th>Description</th>
    <th>Quantity</th>
    <th>Item Type</th>
    <th>Action</th>
  </tr>
                </thead>
                
            <tbody>
            <%String role=(String)session.getAttribute("role"); %>
           
            
            <% for(item it:Litem){%>
              <%String type=(String)it.getType();%>
  <tr>
    <td><%= it.getProductCode() %></td>
    <td><%= it.getDescription() %></td>
    <td><%= it.getQuantity() %></td>
     <td><%= it.getType() %></td>
 
              
                        <td name="error"><center>
                            <div class="dropdown">
                                <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">
                                <div class="fa fa-list"></div>&nbsp;<span class="caret"></span></button>
                                <ul class="dropdown-menu pull-right">
                                
                                <% if(type.equals("asset")){ %>
                                  <li><a href="viewAssetController?action=viewAsset&productCode=<%=it.getProductCode() %>" onclick="return confirm('View Item?')"><span class="fa fa-list"></span>&nbsp;&nbsp;Asset</a></li>
                                  
                                  <li><a href="viewUpdateItemAsset?action=updateItemAsset&productCode=<%=it.getProductCode() %>" onclick="return confirm('Update?')"><span class="fa fa-edit"></span>&nbsp;&nbsp;Update</a></li>
                                  <% } %>
                                  <% if(type.equals("nonAsset")){ %>
                                  <li><a href="viewItemController?action=viewItem&productCode=<%=it.getProductCode() %>" onclick="return confirm('View Item?')"><span class="fa fa-list"></span>&nbsp;&nbsp;NonAsset</a></li>
                                                                   
                                  <li><a href="viewUpdateItemController?action=updateItem&productCode=<%=it.getProductCode() %>" onclick="return confirm('Update?')"><span class="fa fa-edit"></span>&nbsp;&nbsp;Update</a></li>
                                  <% } %>
                                  <%if(role.equals("admin")){ %>  
                                  <li><a href="deleteItemController?action=delete&productCode=<%=it.getProductCode() %>" onclick="return confirm('delete?')"><span class="fa fa-trash"></span>&nbsp;&nbsp;Delete</a></li>
                                  <%} %>
                                  
                          
                                </ul>
                              </div></center>
                        </td>
                        <%}%>
                    </tr>
                    
            
				
                
           
            </tbody>  
                            </table>
                            <!-- /.table-responsive -->
                        </div><center><br><br>
<button onclick="printContent('div1');" class="btn btn-default" align='center'>
        <div class="fa fa-print">&nbsp;CETAK</div>
    </button></center>
                        
                        <!-- /.panel-body -->
                  
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>
		
        </div>
         <!--footer-->
            <jsp:include page="footer.jsp" />