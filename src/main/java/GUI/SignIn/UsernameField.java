package GUI.SignIn;

import javax.swing.*;

public class UsernameField extends JPanel {

    private final JLabel usernamel;
    private final JTextField usernamef;

    public UsernameField() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.usernamel = new JLabel("Username");
        this.usernamef = new JTextField();

        this.add(this.usernamel);
        this.add(this.usernamef);
    }

}
