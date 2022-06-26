<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
	<title>Nothing</title>
	<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: rgb(0,87,46)">
			<div>
				<a href="" class="navbar-brand"> Reports </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/reportList"
					class="nav-link">List Of Reports</a></li>
			</ul>
			<div>
				<a style="font-size: 15px" href="" class="navbar-brand"> - Name - </a>
			</div>
		</nav>
	</header>
	<br>

	<div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
			<h3 class="text-center">Current List of Reports</h3>
			<hr>
			<div class="container text-left">

	 			<a type="hidden" href="<%=request.getContextPath()%>/showForm" class="btn btn-success">Create New Report</a>
			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>ID</th>
						<th>Date</th>
						<th>In-Game ID</th>
						<th>Server</th>
						<th>Category</th>
						<th>Description</th>
						<th> </th>
					</tr>
				</thead>
				<tbody>
					
					<%-- 	For each loop, for each report item, display each item.
							var="report": Report objects, items="$": Report List 					--%>
							
					<c:forEach var="report" items="${listOfReports}">
					

						<tr>
							<td><c:out value="${report.reportID}" /></td>
							<td><c:out value="${report.enquiryDate}" /></td>
							<td><c:out value="${report.inGameID}" /></td>
							<td><c:out value="${report.inGameServer}" /></td>
							<td><c:out value="${report.category}" /></td>
							<td><c:out value="${report.description}" /></td>		
							
							<td>
								<div class="linktable">
								<a href="showEditForm?reportID=<c:out value='${report.reportID}'/>">Edit</a> 
								&emsp;&emsp;
								<a style="color: red" href="deleteReport?reportID=<c:out value='${report.reportID}'/>">Delete</a>	
								</div>
							</td>

							
						</tr>
					</c:forEach>
					<!-- } -->
				</tbody>
			</table>
		</div>
	</div>
	
</body>
</html>