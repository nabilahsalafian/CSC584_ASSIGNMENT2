package assignment.javabean;
import java.sql.Date;

public class Report {
	int reportID;
	Date enquiryDate;
	int inGameID;
	String inGameServer;
	String category;
	String description;
	int customerID;
	
	// constructor
	public Report() {
		String defaultDate = "1900-01-01";
		
		reportID = 0;
		enquiryDate = Date.valueOf(defaultDate);
		inGameID = 0;
		inGameServer = "Unknown";
		category = "Unknown";
		description = "Unknown";
		customerID = 0;
	}
	public Report(Date date, int ID, String server, String cat, String desc, int cID) {
		enquiryDate = date;
		inGameServer = server;
		category = cat;
		description = desc;
		customerID = cID;
	}
	
	public Report(int rID, Date date, int ID, String server, String cat, String desc, int cID) {
		reportID = rID;
		enquiryDate = date;
		inGameID = ID;
		inGameServer = server;
		category = cat;
		description = desc;
		customerID = cID;
	}
	
	// Setter
	public void setReportID(int reportID) {
		this.reportID = reportID;
	}
	public void setEnquiryDate(Date date) {
		enquiryDate = date;
	}
	public void setInGameID(int ID) {
		inGameID = ID;
	}
	public void setInGameServer(String server) {
		inGameServer = server;
	}
	public void setCategory(String cat) {
		category = cat;
	}
	public void setDescription(String desc) {
		description = desc;
	}
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	// Getter
	
	public int getReportID() {
		return reportID;
	}
	public Date getEnquiryDate() {
		 return enquiryDate;
	}
	public int getInGameID() {
		return inGameID;
	}
	public String getInGameServer() {
		return inGameServer;
	}
	public String getCategory() {
		return category;
	}
	public String getDescription() {
		return description;
	}
	public int getCustomerID() {
		return customerID;
	}
	
}
