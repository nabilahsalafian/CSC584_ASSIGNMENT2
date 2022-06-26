package assignment.servlet;

import java.io.*;
import java.util.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import assignment.dao.*;
import assignment.javabean.*;

@WebServlet("/reportList") // Refresh List of Report Servlet

public class Report_List_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ReportDAO reportDAO = null;
	
	public Report_List_Servlet() {
		super();
		this.reportDAO = new ReportDAO();
	}
	
	// doPost Method
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		
		// Update List of reports
		try {
			showReportList(request, response);
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} catch (ServletException e) {
			e.printStackTrace();
			
		} catch (IOException e) {
			e.printStackTrace();
			
		}
		
	}
	
	// List of Reports method ---------------------------------------------------------------------------
	public void showReportList(HttpServletRequest request, HttpServletResponse response)
		throws SQLException, ServletException, IOException {
		
		// Select/get all reports (using SQL in DAO) and insert them into a List object
		List<Report> listOfReports = reportDAO.selectAllReports();
		
		// Make a reference variable (to represent the list of reports) for JSP page
		request.setAttribute("listOfReports", listOfReports);
		
		// Redirect user to the JSP Page (List of Reports Page)
		RequestDispatcher toReportListPage = request.getRequestDispatcher("report-list.jsp");
		toReportListPage.forward(request, response);
		
	}
}
