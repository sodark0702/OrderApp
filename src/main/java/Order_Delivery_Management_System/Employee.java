package Order_Delivery_Management_System;

public class Employee extends User implements Observer{

	public Employee(String id, String name, String email, String phone, String password) {
		super(id, name, email, phone, password);
	}

	@Override
	public void viewOrders() {
		System.out.println("Employee is reviewing orders to be processed");
	}

	@Override
	public void update(Order order) {
		System.out.println("Employee is informed: Order " + order.getOrderID() + " has changed into state: " + order.getState());
	}
	
	public void approveOrder(Order order) {
		order.changeState(new ConfirmState());
	}
	
	public void assinDriver(Order order, Driver driver) {
		order.changeState(new ShippingState());
		driver.assignOrder(order);
		order.attach(driver);
	}

}
