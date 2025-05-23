package GUI.SignIn;

import javax.swing.*;
import java.awt.*;

public class UsernameField extends JPanel {

    private final JLabel usernamel;
    private final JTextField usernamef;

    public UsernameField() {
        this.setLayout(new GridLayout(2, 1));


        this.usernamel = new JLabel("Username");
        this.usernamel.setHorizontalAlignment(SwingConstants.LEFT);
        this.usernamef = new JTextField();

        this.add(this.usernamel);
        this.add(this.usernamef);
    }

}
