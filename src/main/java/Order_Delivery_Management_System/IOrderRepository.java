package Order_Delivery_Management_System;

import java.util.*;

public interface IOrderRepository {
	public void addOrder(Order order);
	public Order findOrderByID(String id);
	public List<Order> getOrdersForToday();

}
