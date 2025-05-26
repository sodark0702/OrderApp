package Backend;

public class DeliveredState implements OrderState{

	@Override
	public void handle(Order order) {
		System.out.println("Order: " + order.getOrderID() + " successfully delivered!");
	}

	@Override
	public String getStatus() {
		return "Delivered";
	}

}
