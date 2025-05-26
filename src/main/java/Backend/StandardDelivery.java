package Backend;

public class StandardDelivery implements DeliveryFeeStrategy{

	@Override
	public double calculateFee(Order order) {
		return 15000;
	}

}
