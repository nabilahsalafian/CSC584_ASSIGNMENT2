<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
	<meta charset="UTF-8" dir="ltr">
	<meta charset="ISO-8859-1">
	<title>Customer Support</title>
	<link rel="stylesheet" href="style.css">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">

</head>
<body>
		<%  // Scriplet ------------------------------------------
			
			//session.getAttribute("customerID");
			int customerID = 1;
			
		%> 
	<div class="container">
		<div class="title">Edit Report</div>
	
		<form action="updateReport" method="POST">
			<div class="form-details">
				<input type="hidden" name="reportID" value="<c:out value='${report.reportID}' />" />
				<input type="hidden" name="enquiryDate" value="${report.enquiryDate}">
				<input type="hidden" name="customerID" value="<%=customerID%>">
				
				
				 <input type="hidden"
						value="<c:out value='${animalOrder.animalOrderType}' />" class="form-control"
						name="animalOrderType">
				
				
				<div class="input-box">
					<span class="details">Full Name</span>
					<input type="text" name="clientName" placeholder="Your Name" required >
				</div>
				<div class="input-box">
					<span class="details">Phone Number</span>
					<input type="text" name="clientPhoneNumber" placeholder="+60123456789" required>
				</div>
				<div class="input-box">
					<span class="details">Email</span>
					<input type="text" name="clientEmail" placeholder="yourname@email.com" required>
				</div>
				<div class="input-box">
					<span class="details">Birth Date</span>
					<input type="text" name="clientBirthDate" placeholder="YYYY-MM-DD" required>
				</div>
				<div class="input-box">
					<span class="details">Age</span>
					<input type="number" name="clientAge" placeholder="20" required>
				</div>
				<div class="input-box">
					<span class="details">In-Game ID</span>
					<input type="number" value="<c:out value='${report.inGameID}'/>" name="inGameID">								
				</div>
				<div class="input-box">
					<span class="details">In-Game Server</span>
					<input type="text" name="inGameServer" value="<c:out value='${report.inGameServer}'/>">										
				</div>
			</div>
			<div class="category-details">
				<span class="category-title">Category</span>
				<div class="categories">
					<label class="custom-radio">
						<input type="radio" name="category" value="Bug Issues" checked>
						<span class="radio-name">Bug Issues</span>
					</label>
					<label class="custom-radio">
						<input type="radio" name="category" value="Payment Issues">
						<span class="radio-name">Payment Issues</span>
					</label>
					<label class="custom-radio">
						<input type="radio" name="category" value="Feedback/Suggestions">
						<span class="radio-name">Feedback/Suggestions</span> 
					</label>
				</div>
			</div>
			<div class="description-details">
				<div class="input-box">
					<span class="details">Description</span>
					<textarea name="description" placeholder="Enter your text here" required></textarea>
				</div>
			</div>
			<div class="button">
				<input type="submit" value="Submit">
			</div>
		</form>
	</div>
</body>
</html>
