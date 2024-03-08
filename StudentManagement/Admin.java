package StudentPackage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;


public class Admin {
	DBstudent connect=new DBstudent();
	Connection connection;
	Scanner scanner= new Scanner (System.in);
	public Admin() throws SQLException{
		
		 this.connection=connect.DBconnect();
	}
	public boolean log(String aemail, String password) throws SQLException {
		// TODO Auto-generated method stub
		String query=("SELECT emailId,password,name FROM adminlog");
		Statement st;
	
		
			st = connection.createStatement();
		String cusname="";
		ResultSet rs=st.executeQuery(query);
		while(rs.next()) {
			if(aemail.equals(rs.getString(1)) && password.equals(rs.getString(2))) {
				cusname=rs.getString(3);
				System.out.println("WELCOME  "+cusname+" YOU HAVE SUCCESFULLY LOGGED IN ");
				
				return true;
			}
		}
		return false;
	}

	public void view() throws SQLException {
		// TODO Auto-generated method stub
		boolean f3=true;
		while(f3==true) {
			System.out.println();
			System.out.println(" ****************************");
			System.out.println(" * WELCOME TO THE DASHBOARD *");
			System.out.println(" ****************************");
			System.out.println();
			System.out.println("  1. ADD A STUDENT" );
			System.out.println("  2. REMOVE A STUDENT");
			System.out.println("  3. SEARCH FOR A STUDENT");
			System.out.println("  4. VIEW AlL STUDENTS");
			System.out.println("  5. EXIT");
			System.out.println("**********************");
			System.out.println("*  ENTER YOUR OPTION *");
			System.out.println("**********************");
			int n3=scanner.nextInt();
			Operations oper=new Operations();
			switch(n3) {
			case 1:
				int n4=oper.Add();	
				if(n4==1)
					System.out.println("SUCCESSFULLY UPDATED STUDENT INFORMATION");
				else
					System.out.println("ERROR WHILE EXECUTING");
				break;
			case 2:
				System.out.println("ENTER THE REGISTRATION NUMBER :");
				int reg=scanner.nextInt();
				int n5=oper.Remove(reg);
				if(n5==1)
					System.out.println("SUCCESSFULLY REMOVED STUDENT INFORMSTION");
				else
					System.out.println("ERROR WHILE EXECUTING");
				break;
			case 3:
				System.out.println("ENTER THE REGISTRATION NUMBER :");
				int reg1=scanner.nextInt();
				oper.Search(reg1);
				break;
			case 4:
				oper.ViewAll();
				break;
			case 5:
				f3=false;
				System.out.println("EXITING...............");
		}
    	}
		
	}

	

}
