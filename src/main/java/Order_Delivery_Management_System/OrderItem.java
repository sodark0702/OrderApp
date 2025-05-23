package Order_Delivery_Management_System;

public class OrderItem {
	private Product product;
	private int quantity;
	public OrderItem(Product product, int quantity) {
		super();
		this.product = product;
		this.quantity = quantity;
	}
	public Product getProduct() {
		return product;
	}
	public int getQuantity() {
		return quantity;
	}
	public double getSubtotal(){
		return product.getPrice() * this.quantity;
	}

}
