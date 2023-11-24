<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <c:set var="bean" value="${sessionScope.bean}"/>
    <c:set var="dashDetails" value="${bean.dashboardDTOList}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.21/css/jquery.dataTables.css">

<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.21/js/jquery.dataTables.js"></script>
<script src="${pageContext.request.contextPath}/app.js"></script>
<title>My Dashboard</title>
</head>
<body>
<c:if test="${dashDetails != null}">
<table id="table_id" class="display">
    <thead>
        <tr>
            <th>First Name</th>
            <th>Last Name</th>
        </tr>
    </thead>
    <tbody>
    <c:forEach var="dash" items="${dashDetails}">
        <tr>
            <td>${dash.firstName}</td>
            <td>${dash.lastName}</td>
        </tr>
       </c:forEach>
    </tbody>
</table>
</c:if>
</body>
</html>