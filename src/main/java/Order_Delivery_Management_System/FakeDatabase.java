package Order_Delivery_Management_System;

import java.util.*;

public class FakeDatabase implements IUserRepository, IOrderRepository{
	private List<Order> orders = new ArrayList<>();
	private List<User> users = new ArrayList<>();
	@Override
	public void addOrder(Order order) {
		orders.add(order);
	}
	@Override
	public Order findOrderByID(String id) {
		for (Order order : orders) {
			if(order.getOrderID().equals(id)) return order;
		}
		return null;
	}
	@Override
	public List<Order> getOrdersForToday() {
		return orders;
	}
	@Override
	public void addUser(User user) {
		users.add(user);
	}
	@Override
	public User findUserByEmail(String email) {
		for (User user : users) {
			if(user.getEmail().equals(email)) return user;
		}
		return null;
	}

}
