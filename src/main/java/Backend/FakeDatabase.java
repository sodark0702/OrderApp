package Backend;

import java.util.*;
import java.util.stream.Collectors;

public class FakeDatabase implements IUserRepository, IOrderRepository{
	private List<Order> orders = new ArrayList<>();
	private List<User> users = new ArrayList<>();
	
	public FakeDatabase() {
		 Customer c = new Customer("C1", "Alice", "c@customer.com", "090", "customer");
	        Employee e = new Employee("E1", "Bob", "e@employee.com", "091", "employee");
	        Driver d1 = new Driver("D1", "Charlie", "d1@driver.com", "092", "driver1");
	        Driver d2 = new Driver("D2", "David", "d2@driver.com", "093", "driver2");
	        users.addAll(List.of(c, e, d1, d2));

	        Product p1 = new Product("F001", "Banh Mi Ngot", 10000, "Food");
	        Product p2 = new Product("D001", "Ca Phe Sua NesCafe", 30000, "Drink");
	        Product p3 = new Product("T001", "De tan nhiet Laptop", 200000, "Technology");
	        Product p4 = new Product("C001", "Ao so mi", 150000, "Clothes");
	        Product p5 = new Product("Dr001", "Dam da hoi", 250000, "Dresses");
	        OrderItem item1 = new OrderItem(p1, 2);
	        OrderItem item2 = new OrderItem(p2, 3);
	        OrderItem item3 = new OrderItem(p3, 3);
	        OrderItem item4 = new OrderItem(p4, 1);
	        OrderItem item5 = new OrderItem(p5, 1);
	        
	        List<OrderItem> items = new ArrayList<>();
	        items.add(item1);
	        items.add(item2);
	        items.add(item3);
	        items.add(item4);
	        items.add(item5);
	        
	        Order order1 = new Order("Or-01", c, items);
	        Order order2 = new Order("Or-02", c, List.of(item3, item4, item5));
	        order1.setStrategy(new ExpressDelivery());
	        c.placeOrder(order1);
	        orders.add(order1);
	        order2.setStrategy(new StandardDelivery());
	        c.placeOrder(order2);
	        orders.add(order2);
	}

	@Override
	public void addOrder(Order order) {
		orders.add(order);
	}

	@Override
	public Order findOrderByID(String id) {
		return orders.stream()
                .filter(order -> order.getOrderID().equals(id))
                .findFirst()
                .orElse(null);
	}

	@Override
	public List<Order> getAllOrder() {
		return orders;
	}

	@Override
	public void addUser(User user) {
		users.add(user);
	}

	@Override
	public User findUserByEmail(String email) {
		return users.stream()
                .filter(user -> user.getEmail().equals(email))
                .findFirst()
                .orElse(null);
	}
	
	public List<Driver> getAllDrivers() {
        return users.stream()
                .filter(user -> user instanceof Driver)
                .map(user -> (Driver) user)
                .collect(Collectors.toList());
    }

	@Override
	public List<User> getAllUser() {
		return users;
	}
}
