package assignment.servlet;

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import assignment.dao.*;
import assignment.javabean.*;

@WebServlet("/showEditForm") // Show Edit Form to Update Report 

public class Report_ShowEditForm_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ReportDAO reportDAO = null;
	
	public Report_ShowEditForm_Servlet() {
		super();
		this.reportDAO = new ReportDAO();
	}
	
	// doPost Method
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		
		// Show Edit Form to Update Report 
		try {
			showEditForm(request, response);
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} catch (ServletException e) {
			e.printStackTrace();
			
		} catch (IOException e) {
			e.printStackTrace();
			
		}
		
	}
	
	// Show Edit Form method ----------------------------------------------------------------------
	public void showEditForm(HttpServletRequest request, HttpServletResponse response)
		throws SQLException, ServletException, IOException {
		
		// Get Report ID
		int reportID = Integer.parseInt(request.getParameter("reportID"));
		
		// Select which report to be updated (using the reportID, using DAO), insert into 1 Report object
		Report existingReport = reportDAO.selectReport(reportID);
		
		// Set an attribute for JSP reference
		request.setAttribute("report", existingReport);
		
		// Redirect to Edit Form Page (JSP)
		RequestDispatcher toEditForm = request.getRequestDispatcher("report-form.jsp");
		toEditForm.forward(request, response);
	
	}
	
}
