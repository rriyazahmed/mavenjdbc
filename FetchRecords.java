package maven_jdbc;

import java.sql.*;

public class FetchRecords {

	public static void main(String args[]) throws Exception {
		//1. load the driver an register
		Class.forName("com.mysql.cj.jdbc.Driver");
		//2.Establish connection
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcprc", "root", "root");
		//
		con.setAutoCommit(false);
		//3.Create statement
		Statement stmt = con.createStatement();
		
		//4.Add batch
		stmt.addBatch("insert into user420 values(190,'abhi',40000)");
		stmt.addBatch("insert into user420 values(191,'umesh',50000)");
		
		//5.Execute batch
		stmt.executeBatch();// executing the batch
		//
		con.commit();
		
		//6.Close
		con.close();
	}

}
