package maven_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BatchExecution {

	public static void main(String[] args) {

		String path = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/jdbcprc";
		String username = "root";
		String password = "root";
		Connection con = null;
		String query = "Insert into person values(?,?,?,?,?)";

		List<Person> list = new ArrayList<Person>();
		Person person = new Person(23, "brijesh", "bellary", 56l, 45);
		Person person1 = new Person(24, "nag", "raichur", 546l, 89);
		Person person2 = new Person(25, "raghu", "shimoga", 78l, 45632);
		Person person3 = new Person(26, "madhu", "bidar", 54l, 365);
		Person person4 = new Person(27, "prabhas", "hyd", 9797l, 321);

		list.add(person);
		list.add(person1);
		list.add(person2);
		list.add(person3);
		list.add(person4);
		System.out.println(list);

		try {
			Class.forName(path);
			con = DriverManager.getConnection(url, username, password);
			PreparedStatement ps = con.prepareStatement(query);
			for (Person p : list) {
				ps.setInt(1, p.getId());
				ps.setString(2, p.getName());
				ps.setString(3, p.getAddress());
				ps.setLong(4, p.getPhone());
				ps.setInt(5, p.getPincode());
				ps.addBatch();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
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

	}
}
