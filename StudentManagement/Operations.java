package StudentPackage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Operations {
	DBstudent connect=new DBstudent();
	Connection connection;
	Scanner scanner= new Scanner (System.in);
	public Operations() throws SQLException{
		
		 this.connection=connect.DBconnect();
	}
	public int Add() throws SQLException {
		// TODO Auto-generated method stub
		System.out.println("ENTER YOUR NAME :");
		String name=scanner.nextLine();
		System.out.println("GRADE ALONG WITH SECTION :");
		String grade=scanner.nextLine();
		System.out.println("ENTER YOUR DOB : eg(YYYY-MM-DD)");
		String dob=scanner.nextLine();
		System.out.println("ENTER YOUR AGE :");
		int age=scanner.nextInt();
		System.out.println("ENTER YOUR GENDER :");
		scanner.nextLine();
		String gender=scanner.nextLine();
		System.out.println("ENTER YOUR PHONENO :");
		String phone=scanner.nextLine();
		System.out.println("ENTER YOUR ADDRESS :");
		String add=scanner.nextLine();
		System.out.println("ENTER YOUR PINCODE :");
		String pin=scanner.nextLine();
		String query1=("INSERT INTO studinfo (name,Grade,DOB,Age,Gender,Phone_no,Address,pincode) VALUES(?,?,?,?,?,?,?,?)");
		PreparedStatement ps=connection.prepareStatement(query1);
		ps.setNString(1, name);
		ps.setNString(2, grade);
		ps.setNString(3, dob);
		ps.setInt(4, age);
		ps.setNString(5, gender);
		ps.setNString(6, phone);
		ps.setNString(7, add);
		ps.setNString(8, pin);
		int rows=ps.executeUpdate();
		return rows;
	}

	public int Remove(int reg) throws SQLException {
		// TODO Auto-generated method stub
		String q = "DELETE FROM studinfo WHERE Reg_no=?";
		PreparedStatement ps=connection.prepareStatement(q);
		ps.setInt(1, reg);
		int row=ps.executeUpdate();
		return row;
		
	}

	public void Search(int reg1) throws SQLException {
		// TODO Auto-generated method stub
		String q = "SELECT * FROM studinfo WHERE Reg_no=?";
		PreparedStatement ps=connection.prepareStatement(q);
		ps.setInt(1, reg1);
		ResultSet rs=ps.executeQuery();
		System.out.println("+--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
		System.out.printf("| %15s | %25s | %15s | %23s | %10s | %15s | %15s | %40s | %10s |","RegNo","Student Name","Grade","DOB (YYYY-MM-DD)","Age" ,"Gender","Phone_no","Address","Pincode");
		System.out.println();
		System.out.println("+--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
		while(rs.next()) {
		System.out.printf("| %15s | %25s | %15s | %23s | %10s | %15s | %15s | %40s | %10s |\n", rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9));
//			System.out.println();
		System.out.println("+--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
		}
	
		
	}

	public void ViewAll() throws SQLException {
		// TODO Auto-generated method stub
		String q = "SELECT * FROM studinfo ";
		PreparedStatement ps=connection.prepareStatement(q);
		ResultSet rs=ps.executeQuery();
		System.out.println("+--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
		System.out.printf("| %15s | %25s | %15s | %23s | %10s | %15s | %15s | %40s | %10s |","RegNo","Student Name","Grade","DOB (YYYY-MM-DD)","Age" ,"Gender","Phone_no","Address","Pincode");
		System.out.println();
		System.out.println("+--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
		while(rs.next()) {
		System.out.printf("| %15s | %25s | %15s | %23s | %10s | %15s | %15s | %40s | %10s |\n", rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9));
//			System.out.println();
		System.out.println("+--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
		}
	}

}
