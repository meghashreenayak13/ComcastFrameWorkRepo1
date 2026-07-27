package PracticeDDT;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SampleTestJDBC {

	public static void main(String[] args) throws SQLException {
// load register database driver
		Driver driverref =new Driver();
		//connection
		Connection conn = DriverManager.getConnection(
			    "jdbc:mysql://49.249.29.4:3307/ninza_hrm",
			    "root@%",
			    "root"
			);
	System.out.println("done");
	//create sql  statement
	Statement stat= conn.createStatement();
	//exceute select query and get result
	ResultSet res=stat.executeQuery("select * from Project");
	while(res.next()) {
		System.out.println(res.getString(1));
	}
	
	conn.close();
	
		

	}

}
