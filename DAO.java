package maven_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAO {
	String path = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/jdbcprc";
	String username = "root";
	String password = "root";
	Connection con = null;

	public String savePerson(int id, String name, String address, long phone, int pin) {

		String query = "Insert into person value(?,?,?,?,?)";
		try {
			// 1.Load and register the driver
			Class.forName(path);
			// 2.Establish connection
			con = DriverManager.getConnection(url, username, password);

			// 3. prepare statement
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, id);
			ps.setString(2, name);
			ps.setString(3, address);
			ps.setLong(4, phone);
			ps.setInt(5, pin);
			int row = ps.executeUpdate();
			if (row == 1) {
				return "saved";
			}
			return "not saved";
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return "not saved";

	}

	public String updatePerson(int id, String name, String address, long phone, int pincode) {
		String query = "update person set(name,address,phone,pincode) values(?,?,?,?) where id=?";
		try {
			Class.forName(path);
			con = DriverManager.getConnection(url, username, password);
			PreparedStatement preparedStatement = con.prepareStatement(query);
			preparedStatement.setInt(5, id);
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, address);
			preparedStatement.setLong(3, phone);
			preparedStatement.setInt(4, pincode);
			int a = preparedStatement.executeUpdate();
			if (a == 1) {
				return "updated";
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return "not updated";

	}

	public String deletePerson(int id) {
		String query = "delete from person where id=?";
		try {
			Class.forName(path);
			con = DriverManager.getConnection(url, username, password);
			PreparedStatement preparedStatement = con.prepareStatement(query);
			preparedStatement.setInt(1, id);
			int a = preparedStatement.executeUpdate();
			if (a == 1) {
				return "deleted";
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return "not deleted";
	}

	public ResultSet getPerson(int id) {
		String query = "select * from person where id=?";
		ResultSet resultSet = null;

		try {
			Class.forName(path);
			con = DriverManager.getConnection(url, username, password);
			PreparedStatement preparedStatement = con.prepareCall(query);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return resultSet;
	}
}
