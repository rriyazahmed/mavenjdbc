package maven_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestSaveStud3 {

	public static void main(String[] args) {
		try {
			//1
			Class.forName("com.mysql.cj.jdbc.Driver");
			//2
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcprc", "root", "root");
			//3
			java.sql.CallableStatement callableStatement=connection.prepareCall("call fetchdata(?)");
			//4
			callableStatement.setInt(1, 2);
			ResultSet rs=callableStatement.executeQuery();
			
			while(rs.next())
			{
			System.out.println(rs.getInt(1));
			System.out.println(rs.getString(2));
			System.out.println(rs.getLong(3));
			System.out.println(rs.getString(4));
			System.out.println(rs.getInt(5));
			}
			//5
			
			System.out.println("all the data saved");
			connection.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

	}


