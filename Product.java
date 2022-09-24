package maven_jdbc;

public class Product {
	private int productid;
	private String productname;
	private double price;
	private String manufacturer;
	private String discount;
	private int warranty;
	private String dom;
	private String gst;

	public int getProductid() {
		return productid;
	}

	public Product(int productid, String productname, double price, String manufacturer, String discount, int warranty,
			String dom, String gst) {
		super();
		this.productid = productid;
		this.productname = productname;
		this.price = price;
		this.manufacturer = manufacturer;
		this.discount = discount;
		this.warranty = warranty;
		this.dom = dom;
		this.gst = gst;
	}

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getDiscount() {
		return discount;
	}

	public void setDiscount(String discount) {
		this.discount = discount;
	}

	@Override
	public String toString() {
		return "Product [productid=" + productid + ", productname=" + productname + ", price=" + price
				+ ", manufacturer=" + manufacturer + ", discount=" + discount + ", warranty=" + warranty + ", dom="
				+ dom + ", gst=" + gst + "]";
	}

	public int getWarranty() {
		return warranty;
	}

	public void setWarranty(int warranty) {
		this.warranty = warranty;
	}

	public String getDom() {
		return dom;
	}

	public void setDom(String dom) {
		this.dom = dom;
	}

	public String getGst() {
		return gst;
	}

	public void setGst(String gst) {
		this.gst = gst;
	}

}
