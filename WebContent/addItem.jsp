<jsp:include page="body.jsp" />

        
        <!-- /#page-wrapper -->
		<div id="page-wrapper"><br><!--~include all file that called-->
		<%@ page import="us.model.*, us.DAO.*, java.sql.*, java.util.*" %>
    <% List<supplier> Lsup = supplierDAO.getAllSupplier();%>
     	<div class="row">
		<div class="panel panel-inverse"
			style="box-shadow: 0px 0px 0px 0px; background-color: #94b8b8;">
			<center>
				<h3>
					<b><img class="logo" src="uitm.jpg" height="50px" width="50px">&nbsp;PENDAFTARAN
						BARANGAN BARU</b>
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
				<div class="panel-heading">Pendaftaran Barangan</div>
				<div class="panel-body">

					<div class="row">
						<div class="col-lg-12">

							<form action="additemController" method="POST">

								<div class="form-group">
									<label for="productCode">ProductCode</label> <input
										class="form-control" type="text" id="productCode"
										name="productCode" placeholder="ProductCode.." size='100'
										maxlength='30' placeholder='Product Number' required>
								</div>

								<div class="form-group">
									<label for="description">Description</label> <input
										class="form-control" type="text" id="description"
										name="description" placeholder="Description.." size='100' maxlength='30' required>
								</div>


								<div class="form-group">
									<label for="brand">Brand</label> <input class="form-control"
										type="text" id="brand" name="brand" placeholder="Brand.."
										size='100' maxlength='30' required>
								</div>

								<div class="form-group">
									<label for="Model">Model</label> <input class="form-control"
										type='text' name='model' size='100' maxlength='30'
										placeholder='Model' required>
								</div>

								<div class="form-group">
									<label for="note">Note/<i>catatan</i></label></br><input type="text" class="form-control" size='100' maxlength='30' 
									id="note" name="note" placeholder="Note.."
										size='100' maxlength='30' required>
								</div>

								<div class="form-group">
									<label for="buydate">Buy Date</label> <input
										class="breadcrumb" type="date" id="buydate" name="buydate"
										placeholder="Buy date.." required>
								</div>

								<div class="form-group">
									<label for="quantity">Quantity</label> <input
										class="form-control" type="number" id="quantity" name="quantity"
										placeholder="Quantity.." maxlength='30'>
								</div>

								<div class="form-group">
									<label for="price">Price</label>  <input class="form-control" type="number" id="price" name="price" placeholder="Price.." maxlength='30' required>
								</div>
								
								<label for="supplier">Supplier :</label> 
											<select id="supplier" name="supplier" class='breadcrumb'>
											<% for(supplier it:Lsup){%>
											<option value="<%=it.getSupid()%>"><%=it.getSupname()%></option>
												<% } %>
											</select> <br>
								<div class="form-group">
											<label for="type">Item Type:</label> 
											<select id="type" name="type" onchange="showHide();" class='form-control'>
											<option value="nonAsset">Non Asset</option>
												<option value="asset">Asset</option>
												
											</select> <br>

											<div id="asset" style="display: none;">
											
												<div class="form-group">
												<label for="assetID">Asset ID</label> 
												<input  class="form-control" type="text" name="assetID" id="assetID" 
												 maxlength='30' placeholder="Asset ID..." />
												 </div>
												 
												<div class="form-group">
												<label for="expiredDate">Expired Date</label>  <input class="form-control" type="date"
													name="expiredDate" id="expiredDate" placeholder="Expired Date..." />
											</div>
											</div>

											<div id="nonAsset" style="display: none;">
											
											<div class="form-group">
												<label for="nonAssetID">Non Asset ID</label>  	<input  class="form-control" type="text" 
												name="nonAssetID" id="NonAssetID" maxlength='30' placeholder="Non Asset ID..." />
												 </div>
												 
											<div class="form-group">
												<label for="locations">Locations</label> <input  class="form-control" type="text" 
												name="locations" id="locations" maxlength='30' placeholder="Locations..." />
												 </div>
												 
											<div class="form-group">
												<label for="conditions">Conditions</label> <input  class="form-control" type="text" 
												name="conditions" id="conditions" maxlength='30' placeholder="Conditions..." />
												 </div>
												 
											</div>
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
           <script type="text/javascript">
	function showHide() {
		if(document.getElementById('type').value == "asset") {
			document.getElementById('asset').style.display = 'block';	
		} else {
			document.getElementById('asset').style.display = 'none';
		}
		
		if(document.getElementById('type').value == "nonAsset") {
			document.getElementById('nonAsset').style.display = 'block';	
		} else {
			document.getElementById('nonAsset').style.display = 'none';
		}
	}
</script>