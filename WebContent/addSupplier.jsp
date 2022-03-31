<jsp:include page="body.jsp" />
        
        
        <!-- /#page-wrapper -->
		<div id="page-wrapper"><br><!--~include all file that called-->
    
     	<div class="row">
		<div class="panel panel-inverse"
			style="box-shadow: 0px 0px 0px 0px; background-color: #94b8b8;">
			<center>
				<h3>
					<b><img class="logo" src="uitm.jpg" height="50px" width="50px">&nbsp;PENDAFTARAN
						PEMBEKAL BARU</b>
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
				<div class="panel-heading">Pendaftaran Pembekal</div>
				<div class="panel-body">

					<div class="row">
						<div class="col-lg-12">

							<form action="addSupplierController" method="POST">

								<div class="form-group">
									<label for="productCode">Supplier ID</label> <input
										class="form-control" type="text" id="supid" name="supid" placeholder="Supplier ID.." placeholder="ProductCode.." size='100'
										maxlength='30' required>
								</div>

								<div class="form-group">
									<label for="description">Supplier Name</label> <input
										class="form-control" type="text" id="supname" name="supname" placeholder="Supplier Name.." size='100' maxlength='30' required>
								</div>


								<div class="form-group">
									<label for="brand">Supplier Email</label> <input class="form-control"
										type="email" id="supemail" name="supemail" placeholder="Supplier Email.."
										size='100' maxlength='30' required>
								</div>

								<div class="form-group">
									<label for="Model">Supplier Contact Number</label> <input class="form-control"
										type='number' id="supcontact" name="supcontact" placeholder="Supplier Contact Number.." required>
								</div>

								<div class="form-group">
									<label for="note">Supplier Address</br><input type="text" class="form-control" size='100' maxlength='30' 
									id="supaddress" name="supaddress" placeholder="Supplier Address.."
										size='100' maxlength='30' required>
								</div>
				
						</div>
						<input class="btn btn-primary btn-lg btn-block" type="submit" value="Daftar Pembekal">
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