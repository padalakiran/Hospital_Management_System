package Health;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Patient_Signup {
    static Connection connection = null;
    static PreparedStatement preparedStatement = null;
    
    public static int id_generator() {
    	
         int minRange = 100000;
         int maxRange = 10000000;
         int id = (int) (Math.random() * (maxRange - minRange + 1)) + minRange;
         return id;
    	
    }

    
    public static void patient_sign() {
        String jdbcUrl = "jdbc:mysql://localhost:3306/healthcare";
        String username = "root";
        String password = "MySQL Password";
        Scanner input = new Scanner(System.in);
        ResultSet resultSet = null;
        try {
            // Registering the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establishing a connection to the database
            connection = DriverManager.getConnection(jdbcUrl, username, password);

            if (connection != null) {
                System.out.println("Connected to the database!");
                
                String sqlQuery1 = "SELECT * FROM patient WHERE id = ?";
                preparedStatement = connection.prepareStatement(sqlQuery1);
                preparedStatement.setInt(1, id_generator());

                // Executing the query
                resultSet = preparedStatement.executeQuery();
                
                if (resultSet.next()) {
                	int j=0;
                	
                    System.out.println("ID " + id_generator() + " is present in the table.");
                    int id=id_generator();
                	
                }else {

                // Taking user input for signup
	                System.out.println("Enter your details for signup:");
	                int id=id_generator();
	                System.out.print("Name: ");
	                String name = input.nextLine();
	                System.out.print("Phone Number: ");
	                long phoneNumber = input.nextLong();
	                System.out.print("Password: ");
	                String passwordInput = input.next();
	
	                // Inserting the new user into the patient table
	                String sqlQuery = "INSERT INTO patient (id, name, phonenumber, password) VALUES (?, ?, ?, ?)";
	                preparedStatement = connection.prepareStatement(sqlQuery);
	                preparedStatement.setInt(1, id);
	                preparedStatement.setString(2, name);
	                preparedStatement.setLong(3, phoneNumber);
	                preparedStatement.setString(4, passwordInput);
	
	                int rowsAffected = preparedStatement.executeUpdate();
	
	                if (rowsAffected > 0) {
	                    System.out.println("Signup Successful!");
	                } else {
	                    System.out.println("Signup Failed. Please try again.");
	                }
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            // Close resources in finally block
            try {
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
    }

    public static void main(String[] args) {
    	//patient_sign();
    }
}
//github:- padalakiran
