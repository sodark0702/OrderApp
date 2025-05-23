package Order_Delivery_Management_System;

import java.util.*;

public class Customer extends User implements Observer {
	private List<Order> orderHistory = new ArrayList<>();

	public Customer(String id, String name, String email, String phone, String password) {
		super(id, name, email, phone, password);
	}

	@Override
	public void viewOrders() {
		for (Order order : orderHistory) {
			System.out.println("Order: " + order.getOrderID() + " - State: " + order.getState());
		}

	}

	@Override
	public void update(Order order) {
		System.out.println("Customers are informed: Order " + order.getOrderID() + " has changed into state: "
				+ order.getState());
	}

	public void placeOrder(Order order) {
		orderHistory.add(order);
		order.attach(this);
		System.out.println("Order: " + order.getOrderID() + " has order successful");
	}

	public List<Order> getOrders() {
		return orderHistory;
	}

}
