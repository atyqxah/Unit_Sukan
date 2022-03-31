<jsp:include page="body.jsp" />

        
        <!-- /#page-wrapper -->
		<div id="page-wrapper"><br><!--~include all file that called-->
		<%@ page import="us.model.*, us.DAO.*, java.sql.*, java.util.*" %>
    <% List<supplier> Lsup = supplierDAO.getAllSupplier();%>
    <% List<item> Litem = itemDAO.getAllItem();%> 
     	<div class="row">
		<div class="panel panel-inverse"
			style="box-shadow: 0px 0px 0px 0px; background-color: #94b8b8;">
			<center>
				<h3>
					<b><img class="logo" src="uitm.jpg" height="50px" width="50px">&nbsp;INVENTORYLOG</b>
				</h3>
			</center>
		</div>
		<br>
		<!-- /.col-lg-12 -->
	</div>
	<!-- /.row -->
	<div class="row">
		<div class="col-lg-12">
			<div class="panel panel-default">
				<div class="panel-heading">Inventory Log</div>
				<div class="panel-body">

					<div class="row">
						<div class="col-lg-12">

							<form method="POST" action="addInventoryController">
							<% 
							String id="";
							id = (String)session.getAttribute("id"); %>
								<div class="form-group">
									<label for="productCode">Staff ID</label> <input
										class="form-control" type="text" id="staffID"
										name="staffID" size='100' value=<%=id%>
										maxlength='30' readonly>
								</div>

								<label for="Item">Product Code :</label> 
											<select id="productCode" name="productCode" class='breadcrumb'>
											<% for(item i:Litem){%>
											<option value="<%=i.getProductCode()%>"><%=i.getProductCode()%></option>
												<% } %>
											</select> <br>
								
								<label for="supplier">Supplier :</label> 
											<select id="supplier" name="supID" class='breadcrumb'>
											<% for(supplier it:Lsup){%>
											<option value="<%=it.getSupid()%>"><%=it.getSupname()%></option>
												<% } %>
											</select> <br>
								<div class="form-group">
									<label for="latestDate">Latest Date</label> <input
										class="form-control" type="date" id="lastDate"
										name="latestDate" size='100' maxlength='30'>
								</div>
				
						</div>
						<input class="btn btn-primary btn-lg btn-block" type="submit" value="Daftar Barang">
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
           