package BankingManagementSystem;


	import java.sql.*;
	import java.util.Scanner;

	import java.util.*;

	

	public class MainPage {
	    private static final String url = "jdbc:mysql://localhost:3306/banking_system";
	    private static final String username = "root";
	    private static final String password = "root";

	    public static void main(String[] args) throws ClassNotFoundException, SQLException {
	        try{
	            Class.forName("com.mysql.cj.jdbc.Driver");
	        }catch (ClassNotFoundException e){
	            System.out.println(e.getMessage());
	        }
	        try{
	            Connection connection = DriverManager.getConnection(url, username, password);
	            Scanner scanner =  new Scanner(System.in);
	            User user = new User(connection, scanner);
	            Accounts accounts = new Accounts(connection, scanner);
	            AccountManager accountManager = new AccountManager(connection, scanner);

	            String email;
	            long account_number;
	            boolean f=true;
	            while(f){
	                System.out.println("*** WELCOME TO BANKING SYSTEM ***");
	                System.out.println();
	                System.out.println("1. Register");
	                System.out.println("2. Login");
	                System.out.println("3. Exit");
	                System.out.println("Enter your choice: ");
	                int choice1 = scanner.nextInt();
	                switch (choice1){
	                    case 1:
	                        email=user.register();
	                        if(!email.equals("")) {
	                        System.out.println("Please Click Enter Button for generating Account Number");
	                        account_number = accounts.open_account(email);
                            System.out.println("Account Created Successfully");
                            System.out.println("Your Account Number is: " + account_number);
	                        }
	                        break;
	                    case 2:
	                        email = user.login();
	                        if(email!=null){
	                            System.out.println();
	                           
	                            System.out.println("User Logged In!");
	                            account_number = accounts.getAccount_number(email);
	                            boolean choice2 = true;
	                            while (choice2) {
	                                System.out.println();
	                                System.out.println("1. Debit Money");
	                                System.out.println("2. Credit Money");
	                                System.out.println("3. Check Balance");
	                                System.out.println("4. Log Out");
	                                System.out.println("Enter your choice: ");
	                               int cho = scanner.nextInt();
	                                switch (cho) {
	                                    case 1:
	                                        accountManager.debit_money(account_number);
	                                        break;
	                                    case 2:
	                                        accountManager.credit_money(account_number);
	                                        break;
	       
	                                    case 3:
	                                        accountManager.getBalance(account_number);
	                                        break;
	                                    case 4:
	                                    	choice2=false;
	                                        break;
	                                    default:
	                                        System.out.println("Enter Valid Choice!");
	                                        break;
	                                }
	                            }
	                            }
	                       
	                        else{
	                            System.out.println("Incorrect Email or Password!");
	                        }
	                    case 3:
	                        System.out.println("THANK YOU FOR USING BANKING SYSTEM!!!");
	                        System.out.println("Exiting System!");
	                        f=false;
	                        break;
	                    default:
	                        System.out.println("Enter Valid Choice");
	                        break;
	                }
	            }
	    
	        }catch (SQLException e){
	            e.printStackTrace();
	        }
	    }
	
}
