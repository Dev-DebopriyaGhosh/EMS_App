<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <c:set var="bean" value="${sessionScope.bean}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Management system | Dashboard</title>

<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
	<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
	<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
	<script src="${pageContext.request.contextPath}/app.js"></script>
	<script>function loadDashboard(){
		$.get("/user/loadDashboard", function(data, status){
			if(status =="success"){
				$('#searchContainer').empty();
		        $('#searchContainer').append(data);
			}
		});
	}</script>
</head>
<body>
	<!-- Navbar -->
	<nav data-mdb-navbar-init 
		class="navbar navbar-expand-lg">
		<!-- Container wrapper -->
		<div class="container-fluid">
			<!-- Toggle button -->
			<button data-mdb-collapse-init class="navbar-toggler" type="button"
				data-mdb-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<i class="fas fa-bars"></i>
			</button>

			<!-- Collapsible wrapper -->
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<!-- Navbar brand -->
				<a class="navbar-brand mt-2 mt-lg-0" href="#"> <img
					src="/ems-letter-logo-design-on-white-background-ems-creative-circle-letter-logo-concept-ems-letter-design-vector.jpg"
					height="70" width="70" alt="MDB Logo" loading="lazy" />
				</a>
				<!-- Left links -->
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item"><button class="nav-link" onClick="loadHome()">Home</button>
					</li>
					<li class="nav-item"><button class="nav-link" id="loadDash" onclick="loadDashboard()">My Dashboard</button></li>
					<li class="nav-item"><button class="nav-link" onClick="loadSearch()">Search</button>
					</li>
				</ul>
				<!-- Left links -->
			</div>
			<!-- Collapsible wrapper -->

			<!-- Right elements -->
			<div class="d-flex align-items-center">
				<!-- Icon -->
				<a class="link-secondary me-3" href="#"> <i
					class="fas fa-shopping-cart"></i>
				</a>

				<!-- Notifications -->
				<!-- <div class="dropdown">
					<a data-mdb-dropdown-init
						class="link-secondary me-3 dropdown-toggle hidden-arrow" href="#"
						id="navbarDropdownMenuLink" role="button" aria-expanded="false">
						<i class="fas fa-bell"></i> <span
						class="badge rounded-pill badge-notification bg-danger">1</span>
					</a>
					<ul class="dropdown-menu dropdown-menu-end"
						aria-labelledby="navbarDropdownMenuLink">
						<li><a class="dropdown-item" href="#">Some news</a></li>
						<li><a class="dropdown-item" href="#">Another news</a></li>
						<li><a class="dropdown-item" href="#">Something else here</a>
						</li>
					</ul>
				</div> -->
				<!-- Avatar -->
				<div class="dropdown">
					<a data-mdb-dropdown-init
						class="dropdown-toggle d-flex align-items-center hidden-arrow"
						id="accountBtn"
						href="/logout" id="navbarDropdownMenuAvatar" role="button"
						aria-expanded="false"> <img
						src="https://mdbcdn.b-cdn.net/img/new/avatars/2.webp"
						class="rounded-circle" height="25"
						alt="Black and White Portrait of a Man" 
						loading="lazy" />
					</a>
					<ul class="acc_optn" style="display:none">
						<li><a class="dropdown-item" href="#">My profile</a></li>
						<li><a class="dropdown-item" href="#">Settings</a></li>
						<li><a class="dropdown-item" href="#">Logout</a></li>
					</ul>
				</div>
			</div>
			<!-- Right elements -->
		</div>
		<!-- Container wrapper -->
	</nav>
	<div id="searchContainer"></div>
</body>
</html>