package Backend;

public class SessionManager {
    private static SessionManager instance = new SessionManager();
    private User currentUser;

    private SessionManager() {}

    public static SessionManager getInstance() {
        return instance;
    }

    public void login(User user) {
        this.currentUser = user;
    }

    public void logout() {
        this.currentUser = null;
    }

    public User getCurrentUser() {
        return currentUser;
    }
}


