package Order_Delivery_Management_System;

public class PendingState implements OrderState{

	@Override
	public void handle(Order order) {
		System.out.println("Order: " + order.getOrderID() + " is waiting for confirmation!");
	}

	@Override
	public String getStatus() {
		return "Pending";
	}

}
