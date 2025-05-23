package Order_Delivery_Management_System;

public class ConfirmState implements OrderState{

	@Override
	public void handle(Order order) {
		System.out.println("Order: " + order.getOrderID() + " has comfirmed!");
	}

	@Override
	public String getStatus() {
		return "Confirmed";
	}

}
