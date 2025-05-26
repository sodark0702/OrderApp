package Backend;

import java.util.*;

public class Driver extends User implements Observer{
	private List<Order> assignOrder = new ArrayList<>();

	public Driver(String id, String name, String email, String phone, String password) {
		super(id, name, email, phone, password);
	}


	@Override
	public void update(Order order) {
		System.out.println("Driver is informed: Order " + order.getOrderID() + " has changed into state: " + order.getState().getStatus());
	}
	
	public void assignOrder(Order order) {
		assignOrder.add(order);
	}
	
	public List<Order> getAssignedOrders(){
		return assignOrder;
	}
}
