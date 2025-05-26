package Backend;

public class ConveyState implements OrderState{

	@Override
	public void handle(Order order) {
		System.out.println("Order: " + order.getOrderID() + " is on the way to customer!");
	}

	@Override
	public String getStatus() {
		return "Conveying";
	}

}
