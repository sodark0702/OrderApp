package Backend;

public class Product {
	private String productID, name;
	private double price;
	private String category;
	public Product(String productID, String name, double price, String category) {
		super();
		this.productID = productID;
		this.name = name;
		this.price = price;
		this.category = category;
	}
	public String getName() {
		return name;
	}
	public double getPrice() {
		return price;
	}
	public String getCategory() {
		return category;
	}
	public String getProductID() {
		return productID;
	}
	
	

}
