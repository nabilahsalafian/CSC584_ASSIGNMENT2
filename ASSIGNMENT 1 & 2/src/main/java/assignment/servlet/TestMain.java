package assignment.servlet;

import assignment.connection.*;
import java.sql.*;

public class TestMain {

	public static void main(String[] args) {
		
		Connection connection =  ConnectionPool.getInstance().getConnection();
		

		if (connection!=null) {
			System.out.println("Connection to postgresql successful.");
		}
		else {
			System.out.println("Connection failed.");
		}

	}

}
