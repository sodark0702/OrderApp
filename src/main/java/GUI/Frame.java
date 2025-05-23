package GUI;


import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {

    public static final int WIDTH = 500;
    public static final int HEIGHT = 500;
//
//    private final JPanel form;
//    private final JPanel food;
//    private final JPanel functions;

    public Frame() {
        super("Order delivery manager");

        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (Exception e) {
            System.err.println("Cannot load the UI");
        }

        Container c = getContentPane();
        c.setLayout(new BoxLayout(c, BoxLayout.Y_AXIS));



        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

}
