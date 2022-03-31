<jsp:include page="body.jsp" />


		<!-- /#page-wrapper -->
		<div id="page-wrapper">
			<br>
			<!--~include all file that called-->
<%@ page import="us.model.*, us.DAO.*, java.sql.*, java.util.*"%>
<% 
	String supid = (request.getParameter("supid"));	
	supplier s = supplierDAO.getSupplierById(supid);
	%>
			<div class="row">
				<div class="panel panel-inverse"
					style="box-shadow: 0px 0px 0px 0px; background-color: #94b8b8;">
					<center>
						<h3>
							<b><img class="logo" src="uitm.jpg" height="50px"
								width="50px">&nbsp;VIEW SUPPLIER</b>
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
						<div class="panel-heading">View Supplier</div>
						<div class="panel-body">

							<div class="row">
								<div class="col-lg-12">
									<form role="form">

										<div class="form-group">
											<img src='avatar.png' width='70' length='70'>
										</div>
										<div class="form-group">
											<label>Supplier ID</label> <input class="form-control"
												name='supid' value=" <%= supid %>" disabled>
										</div>

										<div class="form-group">
											<label>Supplier Name</label> <input class="form-control"
												name='supname' value=" <%= s.getSupname() %>" disabled>
										</div>
										<div class="form-group">
											<label>Supplier Email</label> <input class="form-control"
												value="<%= s.getSupemail() %>" disabled>
										</div>
										<div class="form-group">
											<label>Supplier Contact Number</label> <input
												class="form-control" type='text'
												value=" <%= s.getSupcontact() %>" disabled>
										</div>
										<div class="form-group">
											<label>Company Address</label> <input
												class="form-control" type='text'
												value=" <%= s.getSupaddress() %>" disabled>
										</div>
								</div>

								<i align='right'><a href='listSupplier.jsp'><span
										class="fa fa-edit"></span>&nbsp;&nbsp;Supplier List</a></i>
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