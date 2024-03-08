package StudentPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBstudent {
	private static final String url="jdbc:mysql://localhost:3306/students_info";
	private static final String userName="root";
	private static final String password="root";
	
	public Connection DBconnect() throws SQLException{
	
		Connection con=DriverManager.getConnection(url,userName,password);
			return con;
	
}


}
