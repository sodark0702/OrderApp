package Backend;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
    	FakeDatabase db = new FakeDatabase(); // Tạo FakeDatabase một lần duy nhất
        UserController uc = new UserController(db); // Truyền db vào UserController
        OrderController oc = new OrderController(db); // Truyền db vào OrderController
        
        SwingUtilities.invokeLater(() -> new LoginView(uc, oc).setVisible(true));
    }
}

