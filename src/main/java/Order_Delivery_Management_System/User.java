package Order_Delivery_Management_System;

public abstract class User {
	private String id, name, email, phone, password;

	public User(String id, String name, String email, String phone, String password) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public String getEmail() {
		return email;
	}

	public abstract void viewOrders();

}
