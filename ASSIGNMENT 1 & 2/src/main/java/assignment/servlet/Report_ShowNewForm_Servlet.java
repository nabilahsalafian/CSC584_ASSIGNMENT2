package assignment.servlet;

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/showForm") // Show New Form to Add New Report

public class Report_ShowNewForm_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public Report_ShowNewForm_Servlet() {
		super();
	}
	
	// doPost Method
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		
		// Show New Form to Add New Report
		try {
			showNewForm(request, response);
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} catch (ServletException e) {
			e.printStackTrace();
			
		} catch (IOException e) {
			e.printStackTrace();
			
		}
		
	}
	
	// Show New Form method -----------------------------------------------------------------------------
	public void showNewForm(HttpServletRequest request, HttpServletResponse response)
		throws SQLException, ServletException, IOException {
		
		// Redirect user to New Report Form Page (JSP)
		RequestDispatcher toNewReportForm = request.getRequestDispatcher("report-form.jsp");
		toNewReportForm.forward(request, response);
		
	}
	
}
