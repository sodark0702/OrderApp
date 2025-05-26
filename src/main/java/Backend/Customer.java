package Backend;

import java.util.*;
import java.util.Observer;

public class Customer extends User implements Observer {
	private List<Order> orderHistory = new ArrayList<>();

	public Customer(String id, String name, String email, String phone, String password) {
		super(id, name, email, phone, password);
	}

	

	@Override
	public void update(Order order) {
		System.out.println("Customer is informed: Order " + order.getOrderID() + " has changed into state: "
				+ order.getState().getStatus());
	}

	public void placeOrder(Order order) {
		orderHistory.add(order);
		System.out.println("Order: " + order.getOrderID().toString() + " has order successful");
	}

	public List<Order> getOrders() {
		return orderHistory;
	}

}
