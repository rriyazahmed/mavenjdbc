package maven_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {

	public String saveProduct(int productid, String productname, double price, String manufacturer, String discount,
			int warranty, String dom, String gst) {

		String path = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/jdbcprc";
		String username = "root";
		String password = "root";
		Connection con = null;
		String query = "Insert into product value(?,?,?,?,?,?,?,?)";
		try {
			// 1.Load and register the driver
			Class.forName(path);
			// 2.Establish connection
			con = DriverManager.getConnection(url, username, password);

			// 3. prepare statement
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, productid);
			ps.setString(2, productname);
			ps.setDouble(3, price);
			ps.setString(4, manufacturer);
			ps.setString(5, discount);
			ps.setInt(6, warranty);
			ps.setString(7, dom);
			ps.setString(8, gst);

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

	public String updateProduct(int productid) {

		String path = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/jdbcprc";
		String username = "root";
		String password = "root";
		Connection con = null;
		String query = "Update product set productid=? where productname='washingmachine'";
		try {
			// 1.Load and register the driver
			Class.forName(path);
			// 2.Establish connection
			con = DriverManager.getConnection(url, username, password);

			// 3. prepare statement
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, productid);

			int row = ps.executeUpdate();
			if (row == 1) {
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

	public String deleteProduct(int productid) {

		String path = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/jdbcprc";
		String username = "root";
		String password = "root";
		Connection con = null;
		String query = "Delete from product where productid=?";
		try {
			// 1.Load and register the driver
			Class.forName(path);
			// 2.Establish connection
			con = DriverManager.getConnection(url, username, password);

			// 3. prepare statement
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, productid);

			int row = ps.executeUpdate();
			if (row == 1) {
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

	public Product getProduct(int productid) {

		String path = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/jdbcprc";
		String username = "root";
		String password = "root";
		Connection con = null;
		String query = "Select * from product where productid=?";
		try {
			// 1.Load and register the driver
			Class.forName(path);
			// 2.Establish connection
			con = DriverManager.getConnection(url, username, password);

			// 3. prepare statement
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, productid);
			
			
			ResultSet resultSet = ps.executeQuery();
			Product p = new Product();
			while (resultSet.next()) {
				p.setProductid(resultSet.getInt(1));
				p.setProductname(resultSet.getString(2));
				p.setPrice(resultSet.getDouble(3));
				p.setManufacturer(resultSet.getString(4));
				p.setDiscount(resultSet.getString(5));
				p.setWarranty(resultSet.getInt(6));
				p.setDom(resultSet.getString(7));
				p.setGst(resultSet.getString(8));
			}

			return p;

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
		return null;
		}
	public List<Product> getAllProduct() {

		String path = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/jdbcprc";
		String username = "root";
		String password = "root";
		Connection con = null;
		
		
		String query = "Select * from product where productid=?";
		try {
			// 1.Load and register the driver
			Class.forName(path);
			// 2.Establish connection
			con = DriverManager.getConnection(url, username, password);

			// 3. prepare statement
			PreparedStatement ps = con.prepareStatement(query);
			
			List<Product> list=new ArrayList();
			ResultSet resultSet = ps.executeQuery();
			Product p = new Product();
			while (resultSet.next()) {
				p.setProductid(resultSet.getInt(1));
				p.setProductname(resultSet.getString(2));
				p.setPrice(resultSet.getDouble(3));
				p.setManufacturer(resultSet.getString(4));
				p.setDiscount(resultSet.getString(5));
				p.setWarranty(resultSet.getInt(6));
				p.setDom(resultSet.getString(7));
				p.setGst(resultSet.getString(8));
				list.add(p);
			}

			return (List<Product>) p;

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
		return null;

	}
	
}
