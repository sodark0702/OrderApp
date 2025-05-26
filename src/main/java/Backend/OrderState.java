package Backend;

public interface OrderState {
	public void handle(Order order);
	public String getStatus();

}
