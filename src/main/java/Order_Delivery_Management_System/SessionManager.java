package Order_Delivery_Management_System;

public class SessionManager {
	public static SessionManager instance;
	private User currentUser;
	
	private SessionManager() {}
	
	public static SessionManager getInstance() {
		if (instance == null) instance = new SessionManager();
		return instance;
	}
	
	public void login(User user) {
		this.currentUser = user;
	}
	
	public void logout() {
		this.currentUser = null;
	}
	
	public User getCurrenUser() {
		return currentUser;
	}

}
