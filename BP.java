package maven_jdbc;

import java.sql.*;
import java.io.*;

public class BP {

	public static void main(String args[]) {
		try {

			Class.forName("com.mysql.cj.jdbc.Driverr");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcprc", "root", "root");

			PreparedStatement ps = con.prepareStatement("insert into user420 values(?,?,?)");

			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			while (true) {

				System.out.println("enter id");
				String s1 = br.readLine();
				int id = Integer.parseInt(s1);

				System.out.println("enter name");
				String name = br.readLine();

				System.out.println("enter salary");
				String s3 = br.readLine();
				int salary = Integer.parseInt(s3);

				ps.setInt(1, id);
				ps.setString(2, name);
				ps.setInt(3, salary);

				ps.addBatch();
				System.out.println("Want to add more records y/n");
				String ans = br.readLine();
				if (ans.equals("n")) {
					break;
				}

			}
			ps.executeBatch();// for executing the batch

			System.out.println("record successfully saved");

			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	}
}
