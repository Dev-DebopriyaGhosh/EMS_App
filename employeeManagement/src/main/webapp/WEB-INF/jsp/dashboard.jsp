<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <c:set var="bean" value="${sessionScope.bean}"/>
    <c:set var="dashDetails" value="${bean.dashboardDTOList}"/>
<!DOCTYPE html>
<html>
<head>
<title>My Dashboard</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    
    <!--Fontawesome CDN-->
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">

	<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
	<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
	<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script src="/app.js"></script>

	<!--Custom styles-->
	<link rel="stylesheet" type="text/css" href="/dashboardStyles.css">
</head>
<body>
<div style="padding-bottom: 30px"></div>
<div style="padding-left: 20px;font-weight: bold;">
<caption>
    <h2>${bean.userDetails.loginUserDetails.username}'s Dashboard</h2>
  </caption>
</div>
  <div style="padding-bottom: 50px"></div>
<c:if test="${dashDetails != null}">
<div class="table-responsive-xxl table-container">
<!-- <table class="table table-hover table-striped table-bordered header-table">
    
</table> -->
<table class="table table-hover table-striped table-bordered content-table">
<thead class="table-dark sticky-header">
        <tr>
            <th>First Name<div class="btn-group" role="group">
    <button
      id="btnGroupDrop1"
      type="button"
      class="btn btn-primary dropdown-toggle"
      aria-expanded="false"
      data-mdb-ripple-init
      data-mdb-dropdown-init
      onclick="showOptions(this)"
    >
    </button>
    <ul class="dropdown-menu" id="drop_1">
      <li><button onclick="sortAscending('firstName')">Sort Ascending</button></li>
      <li><a href="#">Sort Descending</a></li>
    </ul>
  </div></th>
            <th>Last Name<div class="btn-group" role="group">
    <button
      id="btnGroupDrop2"
      type="button"
      class="btn btn-primary dropdown-toggle"
      aria-expanded="false"
      data-mdb-ripple-init
      data-mdb-dropdown-init
      onclick="showOptions(this)"
    >
    </button>
    <ul class="dropdown-menu" id="drop_2">
      <li><button onclick="sortAscending('lastName')">Sort Ascending</button></li>
      <li><a href="#">Sort Descending</a></li>
    </ul>
  </div></th>
            <th>Contact</th>
        </tr>
    </thead>
    <tbody class="table-hover">
    <c:forEach var="dash" items="${dashDetails}">
        <tr>
            <td>${dash.firstName}</td>
            <td>${dash.lastName}</td>
            <td>Test</td>
        </tr>
       </c:forEach>
    </tbody>
</table>
</div>
<div class="table-responsive-xxl">
<table class="table table-hover table-striped table-bordered footer-table">
  <tfoot>
		<ul class="pagination paddingLeft">
			<li class="page-item disabled"><a class="page-link">Previous</a>
			</li>
			<li class="page-item"><a class="page-link" href="#">1</a></li>
			<li class="page-item active" aria-current="page"><a
				class="page-link" href="#">2 <span class="visually-hidden">(current)</span></a>
			</li>
			<li class="page-item"><a class="page-link" href="#">3</a></li>
			<li class="page-item"><a class="page-link" href="#">Next</a>
			</li>
		</ul>
	</tfoot>
</table>
</div>
</c:if>

</body>
</html>