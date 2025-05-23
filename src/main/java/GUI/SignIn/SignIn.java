package GUI.SignIn;

import javax.swing.*;
import java.awt.*;

public class SignIn extends JFrame {

    public static final int WIDTH = 450;
    public static final int HEIGHT = 500;

    private final JPanel logo;
    private final JLabel appName;



    public SignIn() {
        Container container = this.getContentPane();
        container.setLayout(new BorderLayout());

        this.logo = new JPanel();
        this.appName = new JLabel("Order factory");
        this.logo.setLayout(new BorderLayout());
        this.logo.add(this.appName, BorderLayout.CENTER);
        container.add(this.logo, BorderLayout.NORTH);

        this.setSize(WIDTH, HEIGHT);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

}
