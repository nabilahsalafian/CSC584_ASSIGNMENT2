package assignment.servlet;

import java.io.*;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import assignment.dao.*;
import assignment.javabean.*;

@WebServlet("/addReport") // Add New Report Servlet

public class Report_Add_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ReportDAO reportDAO = null;
	
	public Report_Add_Servlet() {
		super();
		this.reportDAO = new ReportDAO();
	}
	
	// doPost Method
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		
		// Add New report
		try {
			addNewReport(request, response);
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} catch (ServletException e) {
			e.printStackTrace();
			
		} catch (IOException e) {
			e.printStackTrace();
			
		}
	
	}
	
	// Add/Insert method -------------------------------------------------------------------------
	public void addNewReport(HttpServletRequest request, HttpServletResponse response)
		throws SQLException, ServletException, IOException {
		
		// Get Values
		
		String enqDateStr = request.getParameter("enquiryDate");
		Date enquiryDate = Date.valueOf(enqDateStr);
		int inGameID = Integer.parseInt(request.getParameter("inGameID"));
		String inGameServer = request.getParameter("inGameServer");
		String category = request.getParameter("category");
		String description = request.getParameter("description");
		int customerID = Integer.parseInt(request.getParameter("customerID"));
		
		// Insert all values into 1 object
		Report report = new Report(enquiryDate, inGameID, inGameServer, category, description, customerID);
		
		// Insert data received into database - do SQL - in DAO
		reportDAO.insertReport(report);
		
		// Redirect to Servlet '/list' (To refresh list)
		response.sendRedirect("reportList");
	}
	

}
