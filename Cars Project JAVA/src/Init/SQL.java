 package Init;


import Core.Worker;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Core.Customer;


public class SQL {

	/**
	 * method to connect to sql DB 
	 */
	public static void connectTo() 
	{
		try {
	        String url = "jdbc:mysql://localhost/test1";
	        String username = "user";
	        String password = "1234";

	        Connection connection = DriverManager.getConnection(url, username, password);
	        System.out.println("Connected to the database");

	        
	        connection.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	}



	/**
	 * Sql Method To Add New Worker To SQL DB
	 */
	public static void sqlAddWorker(Worker w)
	{
		String query = "INSERT INTO employee (workerNum, fullName, startWorkingDate, city, email) VALUES (?, ?, ?, ?, ?)";

	    try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/test1", "user", "1234");
	         PreparedStatement statement = connection.prepareStatement(query)) {
	        statement.setInt(1, w.getWorkerNum());
	        statement.setString(2, w.getFullName());
	        statement.setDate(3, new java.sql.Date(w.getStartWorkingDate().getTime()));
	        statement.setString(4, w.getCity());
	        statement.setString(5, w.getEmail());
	        statement.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
		
	}
	
	
	/**
	 * Sql Method That Get Customer's Details From SQL DB 
	 */
	public static Customer getCustomerFromSQLDB(String idNumber)
	{
		Customer customer = null;

	    try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "your-username", "your-password")) {
	        String query = "SELECT * FROM customer WHERE idNumber = ?";
	        try (PreparedStatement statement = connection.prepareStatement(query)) {
	            statement.setString(1, idNumber);
	            ResultSet resultSet = statement.executeQuery();

	            if (resultSet.next()) {
	                String fName = resultSet.getString("fName");
	                String lName = resultSet.getString("lName");
	                String city = resultSet.getString("city");
	                String email = resultSet.getString("email");

	                customer = new Customer(idNumber, fName, lName, city, email);
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return customer;
	}


}
