package StudentPackage;

import java.sql.SQLException;
import java.util.Scanner;


public class WelcomePage {
	 public static void main(String[] args) throws SQLException, ClassNotFoundException {
			Scanner scanner = new Scanner(System.in);
	        boolean f = true;
	        while (f) {
	            System.out.println();
	            System.out.println("************ WELCOME TO XYZ SCHOOL ************");
	            System.out.println();
	            System.out.println("  1. ADMIN LOGIN");
	            System.out.println("  2. EXIT PAGE");
	            System.out.println("ENTER YOUR CHOICE: ");
	            int n = scanner.nextInt();
	            scanner.nextLine();
	            if (n == 1) {
	                Admin admin=new Admin();
	                System.out.println("ENTER YOUR EMAIL ID :");
	                String aemail = scanner.nextLine();
	               System.out.println("ENTER YOUR PASSWORD");
	               String password = scanner.nextLine();
	                boolean f3=admin.log(aemail,password);
					if(f3==false)
					System.out.println("***********INCORRECT EMAIL OR PASSWORD::CHECK EMAIL AND PASWWORD*************");
					else if(f3==true){
						admin.view();
					   
	            }
	            }
	            else if(n==2) {
	            	System.out.println("***************THANKYOU****************");
	            	f=false;
	            }
	        }
	 }
}
	            

