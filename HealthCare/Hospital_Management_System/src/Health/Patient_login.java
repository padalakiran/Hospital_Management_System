package Health;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Patient_login {
    static Connection connection = null;
    static PreparedStatement preparedStatement = null;
    static ResultSet resultSet = null;

    public static int Pfun() {
        System.out.println("\nWelcome to XYZ Hospital");
        System.out.println("\n1.Book Appointment \n2.Show Appointments \n3.LogOut");
        Scanner a = new Scanner(System.in);
        System.out.print("Please Select An Option: ");
        int ab = a.nextInt();
        return ab;
    }

    static void plogin() {
        String jdbcUrl = "jdbc:mysql://localhost:3306/healthcare";
        String username = "root";
        String password = "MySQL Password";
        Scanner input = new Scanner(System.in);
        Scanner ab = new Scanner(System.in);

        try {
            // Registering the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establishing a connection to the database
            connection = DriverManager.getConnection(jdbcUrl, username, password);

            if (connection != null) {
                System.out.println("Connected to the database!");
                String sqlQuery = "SELECT * FROM patient";
                boolean to=true;
                while (to) {
                    // Creating a prepared statement
                    preparedStatement = connection.prepareStatement(sqlQuery);
                    // Executing the query and obtaining the result set
                    resultSet = preparedStatement.executeQuery();

                    System.out.print("Enter ID: ");
                    int Givenid = input.nextInt();
                    System.out.print("Enter Password: ");
                    String Givenpassword = input.next();

                    boolean loginSuccessful = false;

                    // Processing the result set
                    while (resultSet.next()) {
                        // Retrieve data by column index or column name
                        int Uid = resultSet.getInt("id");
                        String UPassword = resultSet.getString("password");

                        int Userid = Uid;
                        String UserPassword = UPassword;

                        if (Givenid == Userid && UserPassword.equals(Givenpassword)) {
                            loginSuccessful = true;
                            break;
                        }else{
                            to=false;
                        }
                    }

                    if (loginSuccessful) {
                        System.out.println("Login Success......");

                        int option;
                        do {
                            option = Pfun();
                            switch (option) {
                                case 1:
                                	BookAppointment.Book_app(Givenid);
                                    break;
                                case 2:
                                    String show = "SELECT * FROM appointment WHERE id = ?;";
                                    preparedStatement = connection.prepareStatement(show);
                                    preparedStatement.setInt(1, Givenid);
                                    resultSet = preparedStatement.executeQuery();

                                    while (resultSet.next()) {
                                        int id = resultSet.getInt("id");
                                        String name = resultSet.getString("name");
                                        long phoneNumber = resultSet.getLong("phonenumber");
                                        String mail = resultSet.getString("mail");
                                        Date apDate = resultSet.getDate("ap_date");
                                        String category = resultSet.getString("catgroy");

                                        System.out.println(id + "  " + name + "  " + phoneNumber + "  " + mail + "  " + apDate + "  " + category);
                                    }
                                    System.out.println("-----------------------------------");
                                    break;
                                case 3:
                                    System.out.println("Logging out...");
                                    break;
                                default:
                                    System.out.println("Invalid option. Please try again.");
                            }
                        } while (option != 3);

                        break; // Exit the loop after successful login
                    } else {
                        System.out.println("Incorrect ID or Password");
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            // Close resources in finally block
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
    }

    public static void main(String[] args) {
 //       plogin();
    }
}
//github:- padalakiran
