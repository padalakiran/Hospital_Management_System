package Health;
import java.sql.DriverManager;
import java.util.Scanner;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

public class Doctor_login {
	static Connection connection = null;
    static PreparedStatement preparedStatement = null;
    static ResultSet resultSet = null;
    static ResultSet r1 = null;
	static String c="";
    public static void options() {
    	System.out.println("\nWelcome to XYZ Hospital");
        System.out.println("\n1.Show Appointments \n2.LogOut");
        
    }
    
	public static void dlogin() throws SQLException {
		
		String jdbcUrl = "jdbc:mysql://localhost:3306/healthcare";
        String username = "root";
        String password = "kiran1415@A";
        
		
		System.out.println("Doctor");
		Scanner input=new Scanner(System.in);
		System.out.print("Enter id: ");
		int id=input.nextInt();
		System.out.print("Enter Password: ");
		String dpassword=input.next();
		//System.out.println(id+" "+dpassword);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

            // Establishing a connection to the database
            connection = DriverManager.getConnection(jdbcUrl, username, password);
            String sqlu="select * from doctor where id=?;";
            if(connection!=null) {
            	//System.out.println("Done........!");
            	preparedStatement = connection.prepareStatement(sqlu);
                preparedStatement.setInt(1, id);

                // Executing the query
                resultSet = preparedStatement.executeQuery();
                //System.out.println(resultSet);
                boolean status=false;
                
                while(resultSet.next()) {
                	int id1 = resultSet.getInt("id");
                	String pass1=resultSet.getString("password");
                	String cat=resultSet.getString("spc");
                	c=c+cat;
                	
                	if(id==id1 && dpassword.equals(pass1)) {
                		status=true;
                	}
                }
                if(status) System.out.println("Login Sucuss...........!");
                while(status) {
                	
                	options();
                	System.out.print("Enter Your Option: ");
                	int op=input.nextInt();
                	switch (op) {
                    case 1:
        	        	String sqla="Select * from appointment where catgroy=?;";
        	        	preparedStatement=connection.prepareStatement(sqla);
        	        	
        	        	
        	        	preparedStatement.setString(1, c);
        	        	resultSet = preparedStatement.executeQuery();
        	        	
        	        	while(resultSet.next()) {
        	        		int id1=resultSet.getInt("id");
        	        		String pn=resultSet.getString("name");
        	        		long pnon=resultSet.getLong("phonenumber");
        	        		String m=resultSet.getString("mail");
        	        		String spec=resultSet.getString("catgroy");
        	        		Date ap_d=resultSet.getDate("ap_date");
        	        		System.out.println(id1+" "+pn+" "+pnon+" "+m+" "+spec+" "+ap_d);
        	        	}
        	        	break;
                    case 2:
                        System.out.println("Logging out......");
                        status = false;
                        break;
                        
                    default:
                        System.out.println("-----Enter Valid Option-----");
                }

                }
                
            }
			
		}catch(Exception e) {
			
		}finally{
			if (resultSet != null) resultSet.close();
            if (preparedStatement != null) preparedStatement.close();
            if (connection != null) connection.close();
		}
		
		
	}
	public static void main(String args[]) throws SQLException {
		//dlogin();
	}

}
