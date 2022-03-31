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
<center><h3><b><img class="logo" src="uitm.jpg" height="50px" width="50px">&nbsp;UPDATE ITEM ASSET</b></h3></center>
</div><br> 
<!-- /.col-lg-12 -->
</div>
<!-- /.row -->
<div class="row">
<div class="col-lg-12">
<div class="panel panel-default">
<div class="panel-heading">Update Item</div>
<div class="panel-body">

                            <div class="row">
                                <div class="col-lg-12">
                                    <form role="form" method="POST" action="updateItemController">
                           				
										<div class="form-group">
                                            <img src='avatar.png' width='70' length='70' >
                                        </div>
                                        <div class="form-group">
                                            <label>Product Code</label>
                                            <input class="form-control" type='text' name='productCode'  value="<%=productCode%>" readonly>
                                        </div>
                                  
                                        <div class="form-group">
                                            <label>Description</label>
                                            <input class="form-control" type='text' name='description' value="<%=s.getDescription()%>"  readonly>
                                        </div>
                                        <div class="form-group">
                                            <label>Quantity</label>
                                            <input class="form-control" type='number' name="quantity" value="<%=s.getQuantity()%>">
                                        </div>
                                        <div class="form-group">
                                                <label>Price</label>
                                                <input class="form-control" type='number' name="price" value="<%=s.getPrice()%>"  readonly>
                                        </div>
                                         <div class="form-group">
                                                <label for="unit">Brand</label>
                                                <input class="form-control" type='text' name="brand" value="<%=s.getBrand()%>"  readonly>
                                        </div>
                                        <div class="form-group">
                                            <label>Model</label>
                                            <input class="form-control" type='text' name="model" value="<%=s.getModel()%>"  readonly>
                                        </div>
                                        <div class="form-group">
                                            <label>Note</label>
                                            <input class="form-control" type='text' name="note" value="<%=s.getNote()%>">
                                        </div>
                                        <div class="form-group">
                                            <label>Purchase Date</label>
                                            <input class="form-control" type='text' name="buydate" value="<%=s.getBuydate()%>"  readonly>
                                        </div>                                        
                                       <div class="form-group">
                                            <label>Asset ID</label>
                                            <input class="form-control" value="<%=s.getAssetID()%>"  disabled>
                                        </div>
                                        <div class="form-group">
                                            <label>Expired Date</label>
                                            <input class="form-control" value=" <%=s.getExpiredDate() %>"  disabled>
                                        </div>
										<input class="btn btn-primary btn-lg btn-block" type="submit" value="Update Item" onclick="return confirm('Update this item?')">
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