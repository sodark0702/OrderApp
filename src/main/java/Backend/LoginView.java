package Backend;

import javax.swing.*;
import java.awt.*;

public class LoginView extends JFrame {
    private JTextField emailField;
    private JPasswordField passwordField;
    private JButton loginButton, exitButton;
    private UserController userController;
    private OrderController orderController; // Thêm OrderController

    public LoginView(UserController userController, OrderController orderController) { // Thêm tham số orderController
        this.userController = userController;
        this.orderController = orderController; // Gán orderController
        setTitle("Login");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(350, 200);
        setLocationRelativeTo(null);

        emailField = new JTextField(20);
        passwordField = new JPasswordField(20);
        loginButton = new JButton("Login");
        exitButton = new JButton("Exit");

        JPanel panel = new JPanel(new GridLayout(3, 2));
        panel.add(new JLabel("Email:"));
        panel.add(emailField);
        panel.add(new JLabel("Password:"));
        panel.add(passwordField);
        panel.add(exitButton);
        panel.add(loginButton);

        add(panel);

        loginButton.addActionListener(e -> {
            String email = emailField.getText();
            String pass = new String(passwordField.getPassword());
            if (userController.login(email, pass)) {
                User user = SessionManager.getInstance().getCurrentUser();
                if (user instanceof Customer) new CustomerView(orderController).setVisible(true); // Truyền orderController
                else if (user instanceof Employee) new EmployeeView(orderController).setVisible(true); // Truyền orderController
                else if (user instanceof Driver) new DriverView(orderController).setVisible(true); // Truyền orderController
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Wrong email or password! Please try again");
            }
        });

        exitButton.addActionListener(e -> System.exit(0));
    }
}
