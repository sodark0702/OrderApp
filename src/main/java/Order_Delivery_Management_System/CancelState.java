package Order_Delivery_Management_System;

public class CancelState implements OrderState{

	@Override
	public void handle(Order order) {
		System.out.println("Order: " + order.getOrderID() + " has canceled!");
	}

	@Override
	public String getStatus() {
		return "Canceled";
	}

}
