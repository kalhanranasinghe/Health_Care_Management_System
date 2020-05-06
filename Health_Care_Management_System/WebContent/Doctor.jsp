<%@page import="com.paf.controller.DoctorController"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="shortcut icon" href="assets/images/favicon.ico">

<link href="assets/css/bootstrap.min.css" rel="stylesheet"
	type="text/css">
<link href="assets/css/metismenu.min.css" rel="stylesheet"
	type="text/css">
<link href="assets/css/icons.css" rel="stylesheet" type="text/css">
<link href="assets/css/style.css" rel="stylesheet" type="text/css">


<%
	DoctorController doctorController=new DoctorController();
%>


<title>Health care system</title>
</head>
<body>



	<div class="wrapper">
		<div class="container-fluid">
			<!-- Page-Title -->


			<div class="row">
				<div class="col-lg-12">
					<div class="card m-b-30">
						<div class="card-body">

							<h4 class="mt-0 header-title">Doctor Details</h4>

							<form id="formdoctor" action="" method="POST">
								<div class="form-group">
									<label>Doctor Name</label> <input type="text"
										class="form-control" name="Dname" id="doctorname"
										required placeholder="Enter a doctor name" />
								</div>


								<div class="form-group">
									<label>E-Mail</label>
									<div>
										<input type="email" class="form-control" required
											parsley-type="email" name="Dmail" id="email"
											placeholder="Enter a valid e-mail" />
									</div>
								</div>
								
								<div class="form-group">
									<label>Doctor Specialization</label> <input type="text"
										class="form-control" name="Specialization"
										id="doctorspecialization" required
										placeholder="Enter a doctor specialization" />
								</div>

								<div class="form-group">
									<label>Phone Number</label> <input type="text"
										class="form-control" name="Dcontact" id="phonenumber"
										required placeholder="Enter a phone number" />
								</div>



						</div>


						<div class="form-group">
							<div>

								<button type="Save"
									class="btn btn-primary waves-effect waves-light m-l-5"
									id="btnSave" name="btnsave" value="Save">Save</button>
								<input type="hidden" id="DoctorIDSave" name="DoctorIDSave"
									value="">
								<button type="reset"
									class="btn btn-secondary waves-effect m-l-5">Cancel</button>
							</div>
						</div>
						</form>

						<div id="alertSuccess"
							class="alert alert-success alert-dismissible" role="alert">
						</div>
						<div id="alertError" class="alert alert-danger" role="alert"></div>
				</div>
			</div>
			<!-- end col -->

		</div>
		<!-- end row -->
		
		
		  <div class="row">
                <div class="col-12">
                    <div class="card m-b-30">
                        <div class="card-body">

                            <h4 class="mt-0 header-title">Doctors List</h4>

                            <div class="table-rep-plugin">
                                <div class="table-responsive b-0" data-pattern="priority-columns">
                                    <table id="DoctorTable" class="table  table-striped">
                                        <thead>
                                        <tr>
                                            <th>Doctor Id</th>
                                            <th data-priority="1">Doctor Name</th>
                                            <th data-priority="3">Doctor Email</th>
                                            <th data-priority="3">Doctor Specialization</th>
                                            <th data-priority="1">Contact Number</th>                                         
                                            <th data-priority="6">Update</th>
                                            <th data-priority="6">Remove</th>
                                        </tr>
                                        </thead>
                                        <tbody id="DoctorTableBody">
                                       <% out.print(doctorController.readDoctors()); %>
                                        </tbody>
                                    </table>
                                </div>

                            </div>

                        </div>
                    </div>
                </div> <!-- end col -->
            </div>
		
		

	</div>
	<!-- end container-fluid -->
	</div>
	<!-- end wrapper -->

	<!-- Footer -->
	<footer class="footer">
		Health Care Management System 
	</footer>

	<!-- End Footer -->






	<!-- jQuery  -->
	<script src="assets/js/jquery.min.js"></script>
	<script src="assets/js/bootstrap.bundle.min.js"></script>
	<script src="assets/js/jquery.slimscroll.js"></script>
	<script src="assets/js/waves.min.js"></script>
	<script type="text/javascript" src="Components/Doctor.js"></script>
	<!-- Parsley js -->
	<script src="../plugins/parsleyjs/parsley.min.js"></script>

	<!-- App js -->
	<script src="assets/js/app.js"></script>
	<script>
		$(document).ready(function() {
			$('form').parsley();
		});
	</script>



</body>
</html>