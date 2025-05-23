package Order_Delivery_Management_System;

import java.util.*;

public class Driver extends User implements Observer{
	private List<Order> assignOrder = new ArrayList<>();

	public Driver(String id, String name, String email, String phone, String password) {
		super(id, name, email, phone, password);
	}

	@Override
	public void viewOrders() {
		for (Order order : assignOrder) {
			System.out.println("The order: " + order.getOrderID() + " - " + order.getState());
		}
	}

	@Override
	public void update(Order order) {
		System.out.println("Driver is informed: Order " + order.getOrderID() + " has changed into state: " + order.getState());
	}
	
	public void assignOrder(Order order) {
		assignOrder.add(order);
		order.attach(this);
	}
	
	public void updateDeliveryStatus(Order order, OrderState newState) {
		order.changeState(newState);
	}

}
