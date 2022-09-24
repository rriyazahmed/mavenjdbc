package maven_jdbc;

import java.sql.ResultSet;
import java.util.Scanner;

public class MobileDriver {
	static String address;
	static String brand;
	static String manufacturer;
	static String colour;
	static double price;
	static double ram;
	static Scanner sc=new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("1.SaveMobile\n2.UpdateMobile\n3.DeleteMobile\n4.GetMobileDetails");
			DAOmobile dao = new DAOmobile();
		
			 int a=sc.nextInt();
			if (a == 1) {
				System.out.println("enter the id");
				int id = sc.nextInt();
				System.out.println("enter the name");
				String name = sc.next();
				System.out.println("enter the brand");
				String brand = sc.next();
				System.out.println("enter the colour");
				String colour = sc.next();
				System.out.println("enter the price ");
				double price = sc.nextDouble();
				System.out.println("enter the ram size");
				double ram = sc.nextDouble();
				System.out.println("enter the manufacturer");
				String manufacturer = sc.next();

				String result = dao.saveMobile(id, name, brand, colour, price, ram, manufacturer);
				System.out.println(result);
			}
			if (a == 2) {
				System.out.println("enter the id");
				int id = sc.nextInt();
				System.out.println("enter the new brand");
				String name = sc.next();

				String result = dao.updateMobile(id, name, brand, colour, price, ram, manufacturer);
				System.out.println(result);
			}
			if (a == 3) {
				System.out.println("enter the id");
				int id = sc.nextInt();
				String name = sc.next();
				String result = dao.deleteMobile(id);
				System.out.println(result);

			}
			if (a == 4) {
				int id=sc.nextInt();
				ResultSet result = dao.getMobile(id);
				System.out.println(result);

			}
		}


	}

