package Backend;

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
		this.createDate = LocalDateTime.now();// create the date of order
		attach(customer);
	}

	public String getOrderID() {
		return orderID;
	}

	public Customer getCustomer() {
		return customer;
	}

	public List<OrderItem> getOrderItem() {
		return orderItem;
	}

	public OrderState getState() {
		return status;
	}

	public Driver getDriver() {
		return driver;
	}

	public LocalDateTime getCreateDate() {
		return createDate;
	}
	
	public void changeState(OrderState newState) {
		this.status = newState;
		notifyObserver();
	}
	
	public void attach(Observer observer) {
		observers.add(observer);
	}
	
	public void notifyObserver() {
		for (Observer observer : observers) {
			observer.update(this);
		}	
	}
	
	public void assignDriver(Driver driver) {
		this.driver = driver;
		driver.assignOrder(this);
		attach(driver);
	}
	
	public double getTotalPrice() {
		double total = 0;
		for (OrderItem or : orderItem) {
			total += or.getSubtotal();
		}
		return total;
	}
	
	public double getDeliveryFee() {
		return strategy.calculateFee(this);
	}
	
	public void setStrategy(DeliveryFeeStrategy strategy) {
		this.strategy = strategy;
	}
	
	public void nextState() {
		status.handle(this);
	}
	
}
