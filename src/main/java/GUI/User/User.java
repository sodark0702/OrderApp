package GUI.Home;

import javax.swing.*;
import java.awt.*;

public class Home extends JFrame {
    public static final int WIDTH = 720;
    public static final int HEIGHT = 480;

    

    public Home() {
        super("Order App");

        Container container = this.getContentPane();
        container.setLayout(new BorderLayout());



        this.setSize(WIDTH, HEIGHT);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
