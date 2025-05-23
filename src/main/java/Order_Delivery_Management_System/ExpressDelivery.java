package Order_Delivery_Management_System;

public class ExpressDelivery implements DeliveryFeeStrategy{

	@Override
	public double calculateFee(Order order) {
		return 30000 + (order.getTotalPrice() * 0.05); //surcharge 5%
	}

}
