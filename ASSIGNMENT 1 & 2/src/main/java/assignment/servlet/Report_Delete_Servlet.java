package assignment.servlet;

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import assignment.dao.*;

@WebServlet("/deleteReport")

public class Report_Delete_Servlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private ReportDAO reportDAO = null;
	
	public Report_Delete_Servlet() {
		super();
		this.reportDAO = new ReportDAO();
	}
	
	// doPost Method
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		doGet(request, response);
	}
	
	// doGet Method
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		
		// Delete Report
		try {
			deleteReport(request, response);
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} catch (ServletException e) {
			e.printStackTrace();
			
		} catch (IOException e) {
			e.printStackTrace();
			
		}
		
	}
	
	// Delete Report Method -------------------------------------------------------------
	public void deleteReport(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, ServletException, IOException{
		
		// Get ID of the report that is needed to be deleted
		int reportID = Integer.parseInt(request.getParameter("reportID"));
		
		// Perform deletion in database (using SQL in DAO)
		reportDAO.deleteReport(reportID);
		
		// Redirect and update new list of reports (to /reportList Servlet)
		response.sendRedirect("reportList");
		
	}
}
