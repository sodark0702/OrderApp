package Order_Delivery_Management_System;

public class UserController {
	private IUserRepository userRepo;

	public UserController(IUserRepository userRepo) {
		super();
		this.userRepo = userRepo;
	}
	public boolean login(String email, String password) {
		User user = userRepo.findUserByEmail(email);
		if (user != null && user.getPassword().equals(password)) {
			SessionManager.getInstance().login(user);
			return true;
		}
		return false;
	}
	public void logout() {
		SessionManager.getInstance().logout();
	}

}
