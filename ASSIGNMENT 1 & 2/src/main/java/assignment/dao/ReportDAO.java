package assignment.dao;

import java.util.*;					// List<>
import java.sql.*;					// Connect to database
import java.sql.Date;

import assignment.connection.*;		// Connect to database
import assignment.javabean.*;		// Java bean reference

// This DAO class provides CRUD database operations for Report table in the database
public class ReportDAO {
	
	Connection connection = null;
	
	// Static SQL Statements ############################################################################
	
	// Insert
	private static final String INSERT_REPORT = 
	"INSERT INTO report(enquiryDate, inGameID, inGameServer, category, description, customerID) VALUES" +
	"(?, ?, ?, ?, ?, ?);";
	
	// Update
	private static final String UPDATE_REPORT = 
	"UPDATE report " + 
	"SET inGameID = ?, inGameServer = ?, category = ?, description = ? " +
	"WHERE reportID = ?;";
	
	// Delete
	private static final String DELETE_REPORT = 
	"DELETE FROM report " +
	"WHERE reportID = ?;";
	
	// Select one by id
	private static final String SELECT_REPORT_BY_ID = 
	"SELECT reportID, enquiryDate, inGameID, inGameServer, category, description, customerID" +
	"FROM report " +
	"WHERE reportID = ?;";
	
	// Select all reports
	private static final String SELECT_ALL_REPORTS = 
	"SELECT * " +
	"FROM report " +
	"ORDER BY reportID;";
	
	// CRUD functions/methods #############################################################################
	
	// 1. Create/Insert report -----------------------------------------------------------------------------
	public void insertReport(Report report) {
		
		try (	// Connect to database
				Connection connection = ConnectionPool.getInstance().getConnection();
				// PreparedStatement SQL
				PreparedStatement insertSQL = connection.prepareStatement(INSERT_REPORT);
			)
		{
			// Set ? Values
			insertSQL.setDate(1, report.getEnquiryDate());
			insertSQL.setInt(2, report.getInGameID());
			insertSQL.setString(3, report.getInGameServer());
			insertSQL.setString(4, report.getCategory());
			insertSQL.setString(5, report.getDescription());
			insertSQL.setInt(6, report.getCustomerID());
			
			// Execute SQL
			insertSQL.executeUpdate();
			
			// Check execution
			System.out.println(insertSQL);
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	} // -------------------------------------------------------------------------------------- Insert ----
	
	// 2. Update report ------------------------------------------------------------------------------------
	public void updateReport(Report report) {
		
		try (	// Connect to database
				Connection connection = ConnectionPool.getInstance().getConnection();
				// PreparedStatement SQL
				PreparedStatement updateSQL = connection.prepareStatement(UPDATE_REPORT);
			)
		{	
			// Set ? values
			updateSQL.setInt(1, report.getInGameID());
			updateSQL.setString(2, report.getInGameServer());
			updateSQL.setString(3, report.getCategory());
			updateSQL.setString(4, report.getDescription());
			
			// Execute SQL
			updateSQL.executeUpdate();
			
			// Check execution
			System.out.println(updateSQL);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	} // -------------------------------------------------------------------------------------------- Update
	
	// 3. Delete Report -----------------------------------------------------------------------------------
	public void deleteReport(int reportID) {
		
		try (	// Connect to database
				Connection connection = ConnectionPool.getInstance().getConnection();
				// PreparedStatement SQL
				PreparedStatement deleteSQL = connection.prepareStatement(DELETE_REPORT);
			)
		{
			// Set ? values
			deleteSQL.setInt(1, reportID);
			
			// Execute SQL
			deleteSQL.executeUpdate();
			
			// Check execution
			System.out.println(deleteSQL);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	} // ------------------------------------------------------------------------------------------- Delete
	
	// 4. Select 1 report by reportID - returns 1 report
	public Report selectReport(int reportID) {
		Report report = null;
		
		try (	// Connect to database
				Connection connection = ConnectionPool.getInstance().getConnection();
				// PreparedStatement SQL
				PreparedStatement selectSQL = connection.prepareStatement(SELECT_REPORT_BY_ID);	
			)
		{
			// Set ? Values
			selectSQL.setInt(1, reportID);
			
			// Execute SQL
			ResultSet result = selectSQL.executeQuery();
			
			// Check execution
			System.out.println(selectSQL);
			
			// Process result object
			while(result.next()) {
				Date enquiryDate = result.getDate("enquiryDate"); // Converted from String to date in java bean
				int inGameID = result.getInt("inGameID");
				String inGameServer = result.getString("inGameServer");
				String category = result.getString("category");
				String description = result.getString("description");
				int customerID = result.getInt("customerID");
					
				report = new Report(reportID, enquiryDate, inGameID, inGameServer, category, description, customerID);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return report;
	} // ------------------------------------------------------------------------------------------------- Select 1
	
	// 5. Select All Reports (List) -------------------------------------------------------------------------------
	public List<Report> selectAllReports(){
		
		List<Report> reportList = new ArrayList<>();
		
		try (	// Connect to database
				Connection connection = ConnectionPool.getInstance().getConnection();
				// PreparedStatement SQL
				PreparedStatement selectAllSQL = connection.prepareStatement(SELECT_ALL_REPORTS);	
			)
		{
			// Execute SQL
			ResultSet result = selectAllSQL.executeQuery();
			
			// Check execution
			System.out.println(selectAllSQL);
			
			// Process result
			while(result.next()) {
				int reportID = result.getInt("reportID");
				Date enquiryDate = result.getDate("enquiryDate"); // Converted from String to date in java bean
				int inGameID = result.getInt("inGameID");
				String inGameServer = result.getString("inGameServer");
				String category = result.getString("category");
				String description = result.getString("description");
				int customerID = result.getInt("customerID");
				
				// Add to List
				reportList.add(new Report(reportID, enquiryDate, inGameID, inGameServer, category, description, customerID));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return reportList;
	} // ----------------------------------------------------------------------------------------- List of Reports

}
