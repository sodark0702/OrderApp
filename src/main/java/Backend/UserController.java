package Backend;

public class UserController {
    private IUserRepository userRepo;

    public UserController(IUserRepository repo) {
        this.userRepo = repo;
    }

    public boolean login(String email, String password) {
        User user = userRepo.findUserByEmail(email);
        if (user != null && user.getPassword().equals(password)) {
            SessionManager.getInstance().login(user);
            return true;
        }
        return false;
    }
}
