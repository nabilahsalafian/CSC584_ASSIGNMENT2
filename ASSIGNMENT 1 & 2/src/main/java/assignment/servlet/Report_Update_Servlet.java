package assignment.servlet;

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import assignment.dao.*;
import assignment.javabean.*;

@WebServlet("/updateReport") // Update Report

public class Report_Update_Servlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private ReportDAO reportDAO = null;
	
	public Report_Update_Servlet() {
		super();
		this.reportDAO = new ReportDAO();
	}
	
	// doPost Method 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		
		// Update report
		try {
			updateReport(request, response);
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} catch (ServletException e) {
			e.printStackTrace();
			
		} catch (IOException e) {
			e.printStackTrace();
			
		}
		
	}
	
	// Update Report Method ----------------------------------------------------------------------------
	public void updateReport(HttpServletRequest request, HttpServletResponse response) 
		throws SQLException, ServletException, IOException {
		
		// Get all values inserted
		int reportID = Integer.parseInt(request.getParameter("reportID"));
		String enqDate = request.getParameter("enquiryDate");
		Date enquiryDate = Date.valueOf(enqDate);
		int inGameID = Integer.parseInt(request.getParameter("inGameID"));
		String inGameServer = request.getParameter("inGameServer");
		String category = request.getParameter("category");
		String description = request.getParameter("description");
		int customerID = Integer.parseInt(request.getParameter("customerID"));
		
		// Insert all values into 1 object
		Report report = new Report(reportID, enquiryDate, inGameID, inGameServer, category, description, customerID);
		
		// Update values using SQL in DAO
		reportDAO.updateReport(report);
		
		// Redirect user to new list of reports (to /reportList Servlet)
		response.sendRedirect("reportList");
		
	}

}
