package Order_Delivery_Management_System;

public interface IUserRepository {
	public void addUser(User user);
	public User findUserByEmail(String email);

}
