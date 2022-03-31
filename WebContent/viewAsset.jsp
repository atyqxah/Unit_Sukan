<jsp:include page="body.jsp" />

        
        <!-- /#page-wrapper -->
		<div id="page-wrapper"><br><!--~include all file that called-->
		 <%@ page import="us.model.*, us.DAO.*, java.sql.*, java.util.*" %>  
<% 
	String productCode = (request.getParameter("productCode"));	
	asset s = itemDAO.getItemByPC(productCode);
	%>

<div class="row">
<div class="panel panel-inverse" style="box-shadow:0px 0px 0px 0px; background-color:#94b8b8;">
<center><h3><b><img class="logo" src="uitm.jpg" height="50px" width="50px">&nbsp;VIEW ITEM</b></h3></center>
</div><br> 
<!-- /.col-lg-12 -->
</div>
<!-- /.row -->
<div class="row">
<div class="col-lg-12">
<div class="panel panel-default">
<div class="panel-heading">View Item</div>
<div class="panel-body">

                            <div class="row">
                                <div class="col-lg-12">
                                    <form role="form">
                           				
										<div class="form-group">
                                            <img src='avatar.png' width='70' length='70' >
                                        </div>
                                        <div class="form-group">
                                            <label>Product Code</label>
                                            <input class="form-control" name='productCode'  value=" <%= productCode %>" disabled>
                                        </div>
                                  
                                        <div class="form-group">
                                            <label>Description</label>
                                            <input class="form-control" name='butiran' value=" <%= s.getDescription() %>"  disabled>
                                        </div>
                                        <div class="form-group">
                                            <label>Quantity</label>
                                            <input class="form-control" type='text' value=" <%= s.getQuantity() %>"  disabled>
                                        </div>
                                        <div class="form-group">
                                                <label>Price</label>
                                                <input class="form-control" value="<%=s.getPrice() %>"  disabled>
                                        </div>
                                         <div class="form-group">
                                                <label for="unit">Brand</label>
                                                <input class="form-control" value=" <%=s.getBrand() %>"  disabled>
                                        </div>
                                        <div class="form-group">
                                            <label>Model</label>
                                            <input class="form-control" value=" <%=s.getModel() %>"  disabled>
                                        </div>
                                        <div class="form-group">
                                            <label>Note</label>
                                            <input class="form-control" value=" <%=s.getNote() %>"  disabled>
                                        </div>
                                        <div class="form-group">
                                            <label>Purchase Date</label>
                                            <input class="form-control" value=" <%=s.getBuydate() %>"  disabled>
                                        </div>
                                        <div class="form-group">
                                            <label>Asset ID</label>
                                            <input class="form-control" value=" <%=s.getAssetID() %>"  disabled>
                                        </div>
                                        <div class="form-group">
                                            <label>Expired Date</label>
                                            <input class="form-control" value=" <%=s.getExpiredDate() %>"  disabled>
                                        </div>
                                        
                                        
										
                                        </div>
                                        
										<i align='right'><a href='listItem.jsp'><span class="fa fa-edit"></span>&nbsp;&nbsp;Item List</a></i>
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