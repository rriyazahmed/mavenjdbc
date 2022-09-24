package maven_jdbc;

import java.util.List;
import java.util.Scanner;

public class ProductDriver {

	public static void main(String[] args) {
		ProductDAO pd = new ProductDAO();

		Scanner sc = new Scanner(System.in);
		
		System.out.println("********W E L C O M E********** ");

		System.out.println("enter your choice\n1.InsertData\n2.UpdateData\n3.DeleteData\n4.GetData\n5.GetProductsData: ");
		int input = sc.nextInt();
		if (input == 1) {
			System.out.println("enter the details of the product: ");
			System.out.println("************************************* ");
			System.out.println("enter the id: ");
			int id = sc.nextInt();

			System.out.println("enter the product name: ");
			String name = sc.next();

			System.out.println("enter the price: ");
			double price = sc.nextDouble();

			System.out.println("enter the manufacturer ");
			String manufacturer = sc.next();

			System.out.println("enter the discount: ");
			String discount = sc.next();

			System.out.println("enter the warranty: ");
			int warranty = sc.nextInt();

			System.out.println("enter the date of manufacture: ");
			String dom = sc.next();

			System.out.println("enter the G.S.T: ");
			String gst = sc.next();
			String result = pd.saveProduct(id, name, price, manufacturer, discount, warranty, dom, gst);

			System.out.println(result);
		}
		if (input == 2) {
			System.out.println("enter the id: ");
			int id = sc.nextInt();
			String result2 = pd.updateProduct(id);
			System.out.println(result2);
		}
		if (input == 3) {
			System.out.println("enter the id: ");
			int id = sc.nextInt();
			String result3 = pd.deleteProduct(id);
			System.out.println(result3);
		}
		if(input==4)
		{
			System.out.println("enter the id: ");
			int id = sc.nextInt();
			Product p = pd.getProduct(id);
			System.out.println(p);
		}
		if(input==5)
		{
			List<Product> p=pd.getAllProduct();
			System.out.println(p);
		}

	}

}
