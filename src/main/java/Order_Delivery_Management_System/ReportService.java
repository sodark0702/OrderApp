package Order_Delivery_Management_System;

import java.util.*;

public class ReportService implements IReportService{
	private IOrderRepository orderRepo;
	
	public ReportService(IOrderRepository orderRepo) {
		super();
		this.orderRepo = orderRepo;
	}

	@Override
	public void generateDailyReport() {
		List<Order> orders = orderRepo.getOrdersForToday();
		System.out.println("Report Today Orders:");
		for (Order order : orders) {
			System.out.println("Order: " + order.getOrderID() + "\n Order by: " + order.getCustomer() + "\n At date: " + order.getCreateDate() + "\n Now is in state: " + order.getState().getStatus());
		}
	}

}
