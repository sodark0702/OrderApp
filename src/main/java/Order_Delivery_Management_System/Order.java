package Order_Delivery_Management_System;

import java.time.LocalDateTime;
import java.util.*;

public class Order {
	private String orderID;
	private Customer customer;
	private List<OrderItem> orderItem;
	private OrderState status;
	private Driver driver;
	private LocalDateTime createDate;
	private List<Observer> observers = new ArrayList<>();
	private DeliveryFeeStrategy strategy;

	public Order(String orderID, Customer customer, List<OrderItem> orderItem) {
		super();
		this.orderID = orderID;
		this.customer = customer;
		this.orderItem = orderItem;
		this.status = new PendingState(); // default state
		this.strategy = new StandardDelivery(); // default delivery
		this.createDate = LocalDateTime.now(); // create the date of order
	}

	public String getOrderID() {
		return orderID;
	}

	public OrderState getState() {
		return status;
	}

	public Customer getCustomer() {
		return customer;
	}

	public double getStrategy() {
		return strategy.calculateFee(this);
	}

	public void addItem(OrderItem item) {
		orderItem.add(item);
	}

	public double getTotalPrice() {
		double total = 0;
		for (OrderItem item : orderItem) {
			total += item.getSubtotal();
		}
		return total;
	}

	public void changeState(OrderState newState) {
		this.status = newState;
		notifyObservers();
	}

	private void notifyObservers() {
		for (Observer observer : observers) {
			observer.update(this);
		}
	}

	public void attach(Observer observer) {
		observers.add(observer);
	}

	public void assignDriver(Driver driver) {
		this.driver = driver;
	}

	public void setStrategy(DeliveryFeeStrategy strategy) {
		this.strategy = strategy;
	}

	public LocalDateTime getCreateDate() {
		return createDate;
	}

}
