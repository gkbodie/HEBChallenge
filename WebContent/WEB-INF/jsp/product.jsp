<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="now" class="java.util.Date" />

<!DOCTYPE html>
<html lang="en">

  <head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>HEB Code Challenge</title>

    <!-- Bootstrap core CSS-->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom fonts for this template-->
    <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

    <!-- Page level plugin CSS-->
    <link href="vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="css/sb-admin.css" rel="stylesheet">
    
    <!-- Page specific css beyond bootstrap -->
    <link href="css/product.css" rel="stylesheet">
    
  </head>

  <body id="page-top" class="sidebar-toggled">
	<form:form id="productForm" method="POST" commandName="product">
    <nav class="navbar navbar-expand navbar-dark bg-dark static-top">

      <a class="navbar-brand mr-1" href="#">Product Search</a>

      <button class="btn btn-link btn-sm text-white order-1 order-sm-0" id="sidebarToggle" href="#">
        <i class="fas fa-bars"></i>
      </button>
    </nav>

    <div id="wrapper">

      <!-- Sidebar -->
      <ul class="sidebar navbar-nav toggled">
        <li class="nav-item active">
          
        </li>
        <li class="nav-item">
         
        </li>
      </ul>

      <div id="content-wrapper">

        <div class="container-fluid">

          <!-- Product DataTable -->
          <div class="card mb-3">
            <div class="card-header">
              <i class="fas"></i>
              
              <!-- Product ID drop down -->
				<span class="marginLeft10 nowrap">Product ID: 
					<form:select path="productID">
						<form:option value=""></form:option>
						<c:forEach var="row" items="${productIDList}">
						<form:option value="${row}"></form:option>
						</c:forEach>
					</form:select>
				</span>
				
				<!-- Description drop down -->
				<span class="marginLeft10 nowrap">Description
					<form:select path="description" cssStyle="width:100px;">
						<form:option value=""></form:option>
						<c:forEach var="row" items="${descriptionList}">
						<form:option value="${row}"></form:option>
						</c:forEach>
					</form:select>
				</span>
				
				<!-- Department drop down -->
				<span class="marginLeft10 nowrap">Department:
					<form:select path="department">
						<form:option value=""></form:option>
						<c:forEach var="row" items="${departmentList}">
						<form:option value="${row}"></form:option>
						</c:forEach>
					</form:select>
				</span>
				
				<!-- Shelf Life drop down -->
				<span class="marginLeft10 nowrap">Shelf Life:
					<form:select path="shelfLife">
						<form:option value=""></form:option>
						<c:forEach var="row" items="${shelfLifeList}">
						<form:option value="${row}"></form:option>
						</c:forEach>
					</form:select>
				</span>
				
				<!-- Min Price Field -->
				<span class="marginLeft10 nowrap">Min Price: <form:input path="priceMin" size="2"/></span>
				
				<!-- Max Price Field -->
				<span class="marginLeft10 nowrap">Max Price: <form:input path="priceMax" size="2"/></span>
				
				<!-- Buttons for Filtering and reseting values -->
				<form:button id="filterButton" value="filter" name="filter" class="marginLeft10">Filter</form:button>
				<form:button id="resetButton" value="reset" name="reset" class="marginLeft10">Reset</form:button>
            </div>
            <div class="card-body">
              <div class="table-responsive">
                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                  <thead>
                    <tr>
                     	<th>Product ID</th>
						<th>Description</th>
						<th>Last Sold</th>
						<th>Shelf Life</th>
						<th>Department</th>
						<th>Price</th>
						<th>Unit</th>
						<th>x For</th>
						<th>Cost</th>
                    </tr>
                  </thead>
                  <tfoot>
                    <tr>
                     	<th>Product ID</th>
						<th>Description</th>
						<th>Last Sold</th>
						<th>Shelf Life</th>
						<th>Department</th>
						<th>Price</th>
						<th>Unit</th>
						<th>x For</th>
						<th>Cost</th>
                    </tr>
                  </tfoot>
                  <tbody>
					<c:forEach var="row" items="${product.products}" varStatus="status">
					<tr>
						<td>${row.productID}</td>
						<td>${row.description}</td>
						<td>${row.lastSold}</td>
						<td>${row.shelfLife}</td>
						<td>${row.department}</td>
						<td>$${row.price}</td>
						<td>${row.unit}</td>
						<td>${row.xFor}</td>
						<td>$${row.cost}</td>
					</tr>
					</c:forEach>
                  </tbody>
                </table>
              </div>
            </div>
            <div class="card-footer small text-muted"></div>
          </div>

        </div>
        <!-- /.container-fluid -->

        <!-- Sticky Footer -->
        <footer class="sticky-footer">
          <div class="container my-auto">
            <div class="copyright text-center my-auto">
              <span>Data last retrieved ${now}</span>
            </div>
          </div>
        </footer>

      </div>
      <!-- /.content-wrapper -->
	  
    </div>
	</form:form>
    <!-- /#wrapper -->

    <!-- Scroll to Top Button-->
    <a class="scroll-to-top rounded" href="#page-top">
      <i class="fas fa-angle-up"></i>
    </a>

    <!-- Logout Modal-->
    <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
            <button class="close" type="button" data-dismiss="modal" aria-label="Close">
              <span aria-hidden="true">×</span>
            </button>
          </div>
          <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
          <div class="modal-footer">
            <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
            <a class="btn btn-primary" href="login.html">Logout</a>
          </div>
        </div>
      </div>
    </div>

    <!-- Bootstrap core JavaScript-->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Page level plugin JavaScript-->
    <script src="vendor/chart.js/Chart.min.js"></script>
    <script src="vendor/datatables/jquery.dataTables.js"></script>
    <script src="vendor/datatables/dataTables.bootstrap4.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="js/sb-admin.min.js"></script>

    <!-- Demo scripts for this page-->
    <script src="js/demo/datatables-demo.js"></script>
  </body>

</html>
