package Order_Delivery_Management_System;

public class ShippingState implements OrderState{

	@Override
	public void handle(Order order) {
		System.out.println("Order: " + order.getOrderID() + " is on the way to customer!");
	}

	@Override
	public String getStatus() {
		return "Shipping";
	}

}
