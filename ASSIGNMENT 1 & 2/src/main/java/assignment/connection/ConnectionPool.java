package assignment.connection;

// Import java.sql & add external JAR file
import java.sql.*;

public class ConnectionPool {
	
	// Database details
		String username = "postgres";
		String password = "system";
		String dbUrl = "jdbc:postgresql://localhost:5432/CSC584";
	
		private ConnectionPool() {
			
		}
		
		// Connection reference
		private Connection connection = getConnection();
		
		// Static reference (Because Connection is static)
		private static ConnectionPool instance = null;
		
		// Get instance of ConnectionPool method
		public static ConnectionPool getInstance(){
			if (instance == null)
				instance = new ConnectionPool();
			
			return instance;
		}

		// Get Connection method
		public Connection getConnection() {

			try {
				Class.forName("org.postgresql.Driver");
				connection =  DriverManager.getConnection(dbUrl, username, password);
				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
					e.printStackTrace();
			}
			
			return connection;
		}
}
