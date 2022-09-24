package maven_jdbc;

public class Person {
	private int id;
	private String name;
	private String address;
	private long phone;
	private int pincode;
	public int getId() {
		return id;
	}
	
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Person(int id, String name, String address, long phone, int pincode) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.pincode = pincode;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

}
