package maven_jdbc;

import java.sql.ResultSet;
import java.util.Scanner;

public class DaoDriver {


	
	
	static String address;
	static long phone;
	static int pincode;


	public static void main(String[] args) {
		DAO dao = new DAO();
		 Scanner sc = new Scanner(System.in);
		System.out.println("welcome");
		System.out.println("1.SavePerson\n2.UpdatePerson\n3.DeletePerson\n4.GetPersonDetails");
		 int a=sc.nextInt();
		if (a == 1) {
			System.out.println("enter the id");
			int id = sc.nextInt();
			System.out.println("enter the name");
			String name = sc.next();
			System.out.println("enter the address");
			String address = sc.next();
			System.out.println("enter the phone number");
			long phone = sc.nextLong();
			System.out.println("enter the pincode");
			int pincode = sc.nextInt();

			String result = dao.savePerson(id, name, address, phone, pincode);
			System.out.println(result);
		}
		if (a == 2) {
			System.out.println("enter the id");
			int id = sc.nextInt();
			System.out.println("enter the new name");
			String name = sc.next();

			String result = dao.updatePerson(id, name, address, phone, pincode);
			System.out.println(result);
		}
		if (a == 3) {
			System.out.println("enter the id");
			int id = sc.nextInt();
			String name = sc.next();
			String result = dao.deletePerson(id);
			System.out.println(result);

		}
		if (a == 4) {
			int id=sc.nextInt();
			ResultSet result = dao.getPerson(id);
			System.out.println(result);

		}
	}

}
