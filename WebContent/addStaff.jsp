<jsp:include page="body.jsp" />

        
        <!-- /#page-wrapper -->
		<div id="page-wrapper"><br><!--~include all file that called-->
    
     	<div class="row">
		<div class="panel panel-inverse"
			style="box-shadow: 0px 0px 0px 0px; background-color: #94b8b8;">
			<center>
				<h3>
					<b><img class="logo" src="uitm.jpg" height="50px" width="50px">&nbsp;PENDAFTARAN
						STAFF BARU</b>
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
				<div class="panel-heading">Pendaftaran Staff Baru</div>
				<div class="panel-body">

					<div class="row">
						<div class="col-lg-12">

							<form action="addStaffController" method="POST">

								<div class="form-group">
									<label for="productCode">Staff ID</label> <input
										class="form-control" type="text" id="staffID"
										name="staffID" placeholder="Staff ID.." size='100' required>
								</div>

								<div class="form-group">
									<label for="staffPassword">Staff Password</label> <input
										class="form-control" type="password" id="staffPassword" name="staffPassword" placeholder="Staff Password.." size='100' maxlength='30' required>
								</div>


								<div class="form-group">
									<label for="staffName">Staff Name</label> <input class="form-control"
										type="text" id="staffName" name="staffName" placeholder="Staff Name.." size='100' maxlength='30' required>
								</div>

								<div class="form-group">
									<label for="staffContact">Staff contact  -  (<i>Number only</i>)</label> <input class="form-control"
										 id="staffContact" name="staffContact" placeholder="e.g : 1234567890" size='100' maxlength='30' required>
								</div>

								<div class="form-group">
									<label for="Email">Staff Email</i></label></br><input type="email" class="form-control" size='100' maxlength='30' 
									id="staffEmail" name="staffEmail" placeholder="e.g : amin@gmail.com"
										size='100' maxlength='30' required>
								</div>
								<script type="text/javascript">
								function ValidateEmail(staffEmail) 
								{
									var text = document.getElementById("staffEmail").value; 
									var regx =/^([a-zA-Z0-9\.-]{4,10})([@][a-zA-Z-]{3,10})([\.][a-z]{2,10})$/;
								 if (/^\w+([\.-]?\w+)*@\w+([\.com]?\w+)*(\.\w{2,3})+$/.test(myForm.staffEmail.value))
								  {
								    return (true)
								  }								 
								    alert("You have entered an invalid email address!")
								    return (false)
								}
								</script>

								<div class="form-group">
									<label for="buydate">Staff Role</label> <input
										class="form-control" type="text" id="staffRole" name="staffRole" placeholder="Staff Role.." value="staff" readonly>
								</div>

								
								<div class="form-group">
									<label for="quantity">Status</label> <input	class="form-control" type="text" id="staffStatus" name="staffStatus" placeholder="Staff Status.." maxlength='30' value="active" readonly>
								</div>
				
						</div>
						<input class="btn btn-primary btn-lg btn-block" type="submit" value="Register Staff">
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