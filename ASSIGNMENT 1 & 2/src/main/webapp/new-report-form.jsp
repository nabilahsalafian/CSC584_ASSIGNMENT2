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
			long millis = System.currentTimeMillis();
			java.sql.Date date = new java.sql.Date(millis); // Current date
			
			//session.getAttribute("customerID");
			int customerID = 1;
			
		%> 
	<div class="container">
		<div class="title">In-Game Customer Support</div>
	
		<form action="addReport" method="POST">
			<div class="form-details">
				<input type="hidden" name="enquiryDate" value="<%=date%>">
				<input type="hidden" name="customerID" value="<%=customerID%>">
				
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
					<input type="text" name="inGameID" placeholder="803456321" required>
				</div>
				<div class="input-box">
					<span class="details">In-Game Server</span>
					<select name="inGameServer">
						<option value="EU">Europe - EU</option>
						<option value="AS">Asia - AS</option>
						<option value="NA">North America - NA</option>
						<option value="OC">Oceania - OC</option>
					</select>
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
