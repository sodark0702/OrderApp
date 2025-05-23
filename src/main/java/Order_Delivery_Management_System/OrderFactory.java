package Order_Delivery_Management_System;

import java.util.*;

public class OrderFactory {
	public static Order createOrder(Customer customer, List<OrderItem> orderItem) {
		String orderID = UUID.randomUUID().toString();
		return new Order(orderID, customer, orderItem);
	}
}
