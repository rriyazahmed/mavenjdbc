package maven_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.jdbc.CallableStatement;

public class TestSaveStud {

	public static void main(String[] args) {
		try {
			// 1
			Class.forName("com.mysql.cj.jdbc.Driver");
			//2
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcprc", "root", "root");
			//3
			java.sql.CallableStatement callableStatement=connection.prepareCall("call save_stud(?,?,?,?,?)");
			callableStatement.setInt(1, 50);
			callableStatement.setString(2,"basava");
			callableStatement.setLong(3, 50);
			callableStatement.setString(4, "bengaluru");
			callableStatement.setInt(5, 56788);
			
			//4
			callableStatement.execute();
			//5
			connection.close();
			System.out.println("data saved");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
