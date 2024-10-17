package Banking_Projet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class User{
	private Scanner sc;
	private Connection con;

  
public User(Connection connection, Scanner scanner) {
	// TODO Auto-generated constructor stub
	   this.sc=sc;
			this.con=con;
		}

public void registration() {
     System.out.println("Full Name: " );
     String full_name=sc.nextLine();
     System.out.println("Email: " );
     String email=sc.nextLine();
     System.out.println("Password: " );
     String password=sc.nextLine();
     
     if (user_exist (email)) {
    	 System.out.println("User Already Exists for this Email Address");
    	 return;
     }
     String query = "INSERT INTO user (full_name,email,password) VALUES(?,?,?)";
     try {
    	 PreparedStatement preparedStatement = con.prepareStatement(query);
    	 preparedStatement.setString(1, full_name);
    	 preparedStatement.setString(2, email);
    	 preparedStatement.setString(3, password);
    	 int affectedRows = preparedStatement.executeUpdate();
    	 if(affectedRows>0){
    		 System.out.println("Registration Succesfull");
    	 }else {
    		 System.out.println("Registration Failed");
    	 }
     }catch(Exception e) {
			System.out.print(e);
		}
}
     
 public String login() {
	 System.out.println("Email: " );
     String email=sc.nextLine();
     System.out.println("Password: " );
     String password=sc.nextLine();
 String login_query = "SELECT5 * FROM User WHERE email = ? AND password = ?";
		 try {
			 PreparedStatement preparedStatement = con.prepareStatement(login_query);
	    	 preparedStatement.setString(1, email);
	    	 preparedStatement.setString(2, password);
	    	 ResultSet resultSet = preparedStatement.executeQuery();
	    	 if(resultSet.next()) {
	    		 return email;
	    	 }else {
	    		 return null;
	    	 }
		 }catch (SQLException e) {
			 e.printStackTrace();
		 }
		return null;

 }
    	
private boolean user_exist(String email) {
	
	return false;
}
}