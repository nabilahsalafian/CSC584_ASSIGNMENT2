package assignment.javabean;
// Reference: https://www.geeksforgeeks.org/date-class-java-examples/
// https://www.javatpoint.com/java-sql-date
import java.sql.Date;

public class Customer {
	
	int customerID;
	String customerFullName;
	String customerPhoneNumber;
	String customerEmail;
	Date customerBirthDate;
	int customerAge;
	
	//constructor
	public Customer() {
		String defaultDate = "1900-01-01";
		customerID = 0;
		customerFullName = "Unknown";
		customerPhoneNumber = "Unknown";
		customerEmail = "Unknown";
		customerBirthDate = Date.valueOf(defaultDate);
		customerAge = 0;
	}
	public Customer(int ID, String name, String phoneNum, String email, String date, int a) {
		customerID = ID;
		customerFullName = name;
		customerPhoneNumber = phoneNum;
		customerEmail = email;
		customerBirthDate = Date.valueOf(date);
		customerAge = a;
	}
	public Customer(String name, String phoneNum, String email, String date, int a) {
		customerFullName = name;
		customerPhoneNumber = phoneNum;
		customerEmail = email;
		customerBirthDate = Date.valueOf(date);
		customerAge = a;
	}
	
	
	//setter
	public void setCustomerFullName(String name) {
		customerFullName = name;
	}
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	public void setCustomerPhoneNumber(String phoneNum) {
		customerPhoneNumber = phoneNum;
	}
	public void setCustomerEmail(String email) {
		customerEmail = email;
	}
	public void setCustomerBirthDate(Date date) {
		customerBirthDate = date;
	}
	public void setCustomerAge(int a) {
		customerAge = a;
	}
	
	//getter
	public int getCustomerID() {
		return customerID;
	}
	public String getCustomerFullName() {
		return customerFullName;
	}
	public String getCustomerPhoneNumber() {
		return customerPhoneNumber;
	}
	public String getCustomerEmail() {
		return customerEmail;
	}
	public Date getCustomerBirthDate() {
		return customerBirthDate;
	}
	public int getCustomerAge() {
		return customerAge;
	}
	
}
