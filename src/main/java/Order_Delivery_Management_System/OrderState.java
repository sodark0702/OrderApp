package Order_Delivery_Management_System;

public interface OrderState {
	public void handle(Order order);
	public String getStatus();

}
