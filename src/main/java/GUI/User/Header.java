package GUI.User;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Header extends JPanel {


    public Header() {
        // format the header
        this.setBackground(new Color(0, 120, 255));
        this.setBorder(new EmptyBorder(15, 15, 15, 15));

        // create and init the component
        JLabel logoName = new JLabel("Order App");
        logoName.setForeground(Color.WHITE);
        JButton signOut = new JButton("Sign out");

        // format the component
        Font font = new Font("Arial", Font.BOLD, 18);
        logoName.setFont(font);

        // set layout of the header
        this.setLayout(new BorderLayout());


        // add components
        this.add(signOut, BorderLayout.EAST);
        this.add(logoName, BorderLayout.WEST);


        // action event
        signOut.addActionListener(e -> {

        });
    }
}


