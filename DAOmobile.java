package maven_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAOmobile {
	String path = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/jdbcprc";
	String username = "root";
	String password = "root";
	Connection con = null;
	public String saveMobile(int id, String name, String brand, String colour, double price, double ram,String manufacturer) {
		
		String query = "Insert into mobile value(?,?,?,?,?)";
		try {
			// 1.Load and register the driver
			Class.forName(path);
			// 2.Establish connection
			con = DriverManager.getConnection(url, username, password);

			// 3. prepare statement
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, id);
			ps.setString(2, name);
			ps.setString(3, brand);
			ps.setString(4, colour);
			ps.setDouble(5, price);
			ps.setDouble(6, ram);
			ps.setString(7, manufacturer );
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
	public String updateMobile(int id, String name, String brand, String colour, double price, double ram,String manufacturer) {
		String query = "update person set(name,address,phone,pincode) values(?,?,?,?) where id=?";
		try {
			Class.forName(path);
			con = DriverManager.getConnection(url, username, password);
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, id);
			ps.setString(2, name);
			ps.setString(3, brand);
			ps.setString(4, colour);
			ps.setDouble(5, price);
			ps.setDouble(6, ram);
			ps.setString(7,manufacturer );
			int row = ps.executeUpdate();
			int a = ps.executeUpdate();
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

	public String deleteMobile(int id) {
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

	public ResultSet getMobile(int id) {
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
