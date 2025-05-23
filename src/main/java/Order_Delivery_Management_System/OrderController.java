package Order_Delivery_Management_System;

import java.util.*;

public class OrderController{
	private IOrderRepository orderRepo;

	public OrderController(IOrderRepository orderRepo) {
		super();
		this.orderRepo = orderRepo;
	}
	
	public Order createOrder(Customer customer, List<OrderItem> items) {
		Order order = OrderFactory.createOrder(customer, items);
		customer.placeOrder(order);
		return order;
	}
	public void cancelOrder(Order order) {
		order.changeState(new CancelState());
	}
	public void approveOrder(Employee employee, Order order) {
		employee.approveOrder(order);
	}
	public void completeOrder(Driver driver,Order order) {
		driver.updateDeliveryStatus(order, new DeliveredState());
	}
	public void assignDriver(Employee employee, Order order, Driver drriver) {
		employee.assinDriver(order, drriver);
	}
	public Order findOrderByID(String id) {
		return orderRepo.findOrderByID(id);
	}

}
