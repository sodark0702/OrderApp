package Order_Delivery_Management_System;

public class ProductFactory {
	public static Product createProduct(String type) {
		return switch(type.toLowerCase()) {
		case "food" -> new Product("F001", "Banh Mi Ngot", 10000, "Food");
		case "drink" -> new Product("D001", "Ca Phe Sua NesCafe", 30000, "Drink");
		case "tech" -> new Product("T001", "De tan nhiet Laptop", 200000, "Technology");
		case "cloth" -> new Product("C001", "Ao so mi", 150000, "Clothes");
		case "dress" -> new Product("Dr001", "Dam da hoi", 250000, "Dresses");
		default -> throw new IllegalAccessError("The type of product is invalid: " + type);
		};
	}

}
