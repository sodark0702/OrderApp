package Backend;

import java.util.List;

public interface IUserRepository {
	public void addUser(User user);
	public User findUserByEmail(String email);
	public List<User> getAllUser();

}
